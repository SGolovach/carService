package by.htp.carservice.dao;

import by.htp.carservice.exception.ConnectionPoolException;
import by.htp.carservice.exception.ProjectException;

import java.sql.*;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    private BlockingQueue<ProxyConnection> availableConnections;
    private BlockingQueue<ProxyConnection> usedConnections;
    private String driverName;
    private String url;
    private String user;
    private String password;
    private int poolSize;
    private static final int STANDARD_POOLSIZE = 5;

    private ConnectionPool() {
        try {
            initConnectionPool();
        } catch (ConnectionPoolException e) {
            //TODO ask about RuntimeException
            throw new RuntimeException("Can not create ConnectionPool", e);
        }
    }

    private static class ConnectionPoolHolder {
        private static final ConnectionPool INSTANCE = new ConnectionPool();
    }

    public static ConnectionPool getInstance() {
        return ConnectionPoolHolder.INSTANCE;
    }

    public int sizeQueue(){
       return availableConnections.size();
    }

    private void initConnectionPool() throws ConnectionPoolException {
        Locale.setDefault(Locale.ENGLISH);
        DbResourceManager dbResourceManager = DbResourceManager.getInstance();
        this.driverName = dbResourceManager.getValue(DbParameter.DB_DRIVER);
        this.url = dbResourceManager.getValue(DbParameter.DB_URL);
        this.user = dbResourceManager.getValue(DbParameter.DB_USER);
        this.password = dbResourceManager.getValue(DbParameter.DB_PASSWORD);
        try {
            this.poolSize = Integer.parseInt(dbResourceManager.getValue(DbParameter.DB_POOLSIZE));
        } catch (NumberFormatException e) {
            this.poolSize = STANDARD_POOLSIZE;
        }

        try {
            Class.forName(driverName);
            availableConnections = new LinkedBlockingQueue<>(poolSize);
            usedConnections = new LinkedBlockingQueue<>(poolSize);
            for (int i = 0; i < poolSize; i++) {
                Connection connection = DriverManager.getConnection(url, user, password);
                ProxyConnection proxyConnection = new ProxyConnection(connection);
                //TODO offer or add
                availableConnections.offer(proxyConnection);
            }
        } catch (ClassNotFoundException e) {
            throw new ConnectionPoolException("Can not find database driver class", e);
        } catch (SQLException e) {
            //TODO reapete create connection?
            throw new ConnectionPoolException("Can not getConnection in DriverManager", e);
        }

    }

    public Connection takeConnection() throws ConnectionPoolException {
        ProxyConnection connection;
        try {
            connection = availableConnections.take();
            usedConnections.put(connection);
        } catch (InterruptedException e) {
            throw new ConnectionPoolException("Error connecting to the data base", e);
        }
        return connection;
    }

    public void releaseConnection(Connection connection) throws ConnectionPoolException {
        if (connection instanceof ProxyConnection) {
            usedConnections.remove(connection);
            availableConnections.offer((ProxyConnection) connection);
        } else {
            //TODO logic throw ConnectionPoolException right?
            throw new ConnectionPoolException("This is not our connection");
        }
    }

    public void closeConnectionPool() throws ProjectException {
        try {
            closeConnectionQueue(availableConnections);
            closeConnectionQueue(usedConnections);
        } catch (ConnectionPoolException e) {
            //TODO can throw ProjectException here?
            throw new ProjectException("Error in close ConnectionPool", e);
        }
    }

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

    public void closeConnection(Connection connection, Statement statement, ResultSet resultSet) {
        closeConnection(connection, statement);
        try {
            resultSet.close();
        } catch (SQLException e) {
            //TODO Exception
            e.printStackTrace();
        }

    }

    public void closeConnection(Connection connection, Statement statement) {
        try {
            connection.close();
        } catch (SQLException e) {
            //TODO Exception
            e.printStackTrace();
        }

        try {
            statement.close();
        } catch (SQLException e) {
            //TODO Exception
            e.printStackTrace();
        }


    }

}
