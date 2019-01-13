package by.htp.carservice.connectionpool;

import by.htp.carservice.exception.ConnectionPoolException;
import by.htp.carservice.exception.SelectorException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The Class ConnectionPool.
 */
public class ConnectionPool {
    
    /** The logger. */
    private static Logger logger = LogManager.getLogger();
    
    /** The instance. */
    private static ConnectionPool instance;
    
    /** The available connections. */
    private BlockingQueue<ProxyConnection> availableConnections;
    
    /** The used connections. */
    private BlockingQueue<ProxyConnection> usedConnections;
    
    /** The lock connection pool. */
    private static ReentrantLock lockConnectionPool = new ReentrantLock();
    
    /** The create connection pool. */
    private static AtomicBoolean createConnectionPool = new AtomicBoolean(false);
    
    /** The Constant USER. */
    private static final String USER = "user";
    
    /** The Constant PASSWORD. */
    private static final String PASSWORD = "password";
    
    /** The Constant AUTO_RECONNECT. */
    private static final String AUTO_RECONNECT = "autoReconnect";
    
    /** The Constant CHARACTER_ENCODING. */
    private static final String CHARACTER_ENCODING = "characterEncoding";
    
    /** The Constant USE_UNICODE. */
    private static final String USE_UNICODE = "useUnicode";
    
    /** The Constant USE_SSL. */
    private static final String USE_SSL = "useSSL";
    
    /** The Constant STANDARD_POOLSIZE. */
    private static final int STANDARD_POOLSIZE = 5;

    /**
     * Instantiates a new connection pool.
     */
    private ConnectionPool() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            logger.log(Level.FATAL,"Application can not register Driver");
            throw new RuntimeException("Can not register Driver in DriverManager", e);
        }
        initConnectionPool();
    }

    /**
     * Gets the single instance of ConnectionPool.
     *
     * @return single instance of ConnectionPool
     */
    public static ConnectionPool getInstance() {
        if (!createConnectionPool.get()) {
            try {
                lockConnectionPool.lock();
                if (instance == null) {
                    instance = new ConnectionPool();
                    createConnectionPool.set(true);
                }
            } finally {
                lockConnectionPool.unlock();
            }
        }
        return instance;
    }

    /**
     * Inits the connection pool.
     */
    private void initConnectionPool() {
        Locale.setDefault(Locale.ENGLISH);
        DbResourceManager dbResourceManager = DbResourceManager.getInstance();
        Properties properties = new Properties();
        int poolSize;
        String url = getDataDb(properties);
        try {
            poolSize = Integer.parseInt(dbResourceManager.getValue(DbParameter.DB_POOLSIZE));
        } catch (NumberFormatException e) {
            poolSize = STANDARD_POOLSIZE;
        }
        availableConnections = new LinkedBlockingQueue<>(poolSize);
        usedConnections = new LinkedBlockingQueue<>(poolSize);
        try {
            for (int i = 0; i < poolSize; i++) {
                Connection connection = DriverManager.getConnection(url, properties);
                ProxyConnection proxyConnection = new ProxyConnection(connection);
                availableConnections.offer(proxyConnection);
            }
        } catch (SQLException e) {
            logger.log(Level.FATAL,"Application can not create pool connection");
            throw new RuntimeException("Can not getConnection in DriverManager", e);
        }
    }

    /**
     * Gets the data db.
     *
     * @param properties the properties
     * @return the data db
     */
    private String getDataDb(Properties properties) {
        Locale.setDefault(Locale.ENGLISH);
        DbResourceManager dbResourceManager = DbResourceManager.getInstance();
        properties.put(USER, dbResourceManager.getValue(DbParameter.DB_USER));
        properties.put(PASSWORD, dbResourceManager.getValue(DbParameter.DB_PASSWORD));
        properties.put(AUTO_RECONNECT, dbResourceManager.getValue(DbParameter.DB_AUTORECONNECT));
        properties.put(CHARACTER_ENCODING, dbResourceManager.getValue(DbParameter.DB_CHARACTERENCODING));
        properties.put(USE_UNICODE, dbResourceManager.getValue(DbParameter.DB_USEUNICODE));
        properties.put(USE_SSL, dbResourceManager.getValue(DbParameter.DB_USESSL));
        return dbResourceManager.getValue(DbParameter.DB_URL);
    }

    /**
     * Restore connection.
     *
     * @return the connection
     * @throws ConnectionPoolException the connection pool exception
     */
    private Connection restoreConnection() throws ConnectionPoolException {
        Connection connection;
        Properties properties = new Properties();
        String url = getDataDb(properties);
        try {
            connection = DriverManager.getConnection(url, properties);
        } catch (SQLException e) {
            throw new ConnectionPoolException(e);
        }
        return connection;
    }

    /**
     * Take connection.
     *
     * @return the connection
     * @throws ConnectionPoolException the connection pool exception
     */
    public Connection takeConnection() throws ConnectionPoolException {
        ProxyConnection connection;
        try {
            connection = availableConnections.take();
            usedConnections.put(connection);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ConnectionPoolException("Error connecting to the data base", e);
        }
        return connection;
    }

    /**
     * Release connection.
     *
     * @param connection the connection
     */
    void releaseConnection(Connection connection) {
        if (connection instanceof ProxyConnection) {
            usedConnections.remove(connection);
            try {
                if (!connection.getAutoCommit()) {
                    connection.setAutoCommit(true);
                }
            } catch (SQLException e) {
                logger.log(Level.ERROR, connection.getClass() + " does not setAutoCommit(true)");
                try {
                    ((ProxyConnection) connection).realClose();
                } catch (SQLException excepSQL) {
                    logger.log(Level.ERROR, connection.getClass() + " does not close", excepSQL);
                }
                try {
                    connection = restoreConnection();
                } catch (ConnectionPoolException excepPool) {
                    logger.log(Level.ERROR, "does not restorConnection", excepPool);
                }
            }
            availableConnections.offer((ProxyConnection) connection);
        } else {
            logger.log(Level.ERROR, connection.getClass() + " this is not our connection");
            try {
                connection.close();
            } catch (SQLException e) {
                logger.log(Level.ERROR, connection.getClass() + " does not close", e);
            }
        }
    }

    /**
     * Close connection pool.
     *
     * @throws SelectorException the command exception
     */
    public void closeConnectionPool() throws SelectorException {
        logger.log(Level.INFO,"Start closeConnectionPool");
        try {
            Enumeration<Driver> drivers = DriverManager.getDrivers();
            while (drivers.hasMoreElements()) {
                Driver driver = drivers.nextElement();
                DriverManager.deregisterDriver(driver);
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Can not deregister driver DriverManager");
        }
        try {
            closeConnectionQueue(availableConnections);
            closeConnectionQueue(usedConnections);
        } catch (ConnectionPoolException e) {
            throw new SelectorException("Error in close ConnectionPool", e);
        }
    }

    /**
     * Close connection queue.
     *
     * @param queue the queue
     * @throws ConnectionPoolException the connection pool exception
     */
    private void closeConnectionQueue(BlockingQueue<ProxyConnection> queue) throws ConnectionPoolException {
        Connection connection;
        while (queue.size() != 0) {
            try {
                connection = queue.take();
                ((ProxyConnection) connection).realClose();
            } catch (InterruptedException e) {
                throw new ConnectionPoolException("Can not take connection in queue", e);
            } catch (SQLException e) {
                throw new ConnectionPoolException("Can not close connection", e);
            }
        }
    }

}
