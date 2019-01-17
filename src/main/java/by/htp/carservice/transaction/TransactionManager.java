package by.htp.carservice.transaction;


import by.htp.carservice.connectionpool.ConnectionPool;
import by.htp.carservice.dao.AbstractDao;
import by.htp.carservice.exception.ConnectionPoolException;
import by.htp.carservice.exception.TransactionException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * The Class TransactionManager.
 */
public class TransactionManager {
    
    /** The logger. */
    private static Logger logger = LogManager.getLogger();
    
    /** The connection. */
    protected Connection connection = ConnectionPool.getInstance().takeConnection();

    /**
     * Instantiates a new transaction manager.
     *
     * @throws ConnectionPoolException the connection pool exception
     */
    public TransactionManager() throws ConnectionPoolException {

    }

    /**
     * Begin transaction.
     *
     * @param dao the dao
     * @param daos the daos
     * @throws ConnectionPoolException the connection pool exception
     */
    public void beginTransaction(AbstractDao dao, AbstractDao... daos) throws ConnectionPoolException {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new ConnectionPoolException(e);
        }
        dao.setConnection(connection);
        for (AbstractDao daoNext : daos) {
            daoNext.setConnection(connection);
        }
        logger.log(Level.INFO, "Finish method beginTransaction");
    }

    /**
     * Begin.
     *
     * @param dao the dao
     * @throws TransactionException the transaction exception
     */
    public void begin(AbstractDao dao) throws TransactionException {
        try {
            if (!connection.getAutoCommit()) {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            throw new TransactionException(connection.getClass() + " can not setAutoCommit in true", e);
        }
        dao.setConnection(connection);
        logger.log(Level.INFO, "Finish method beginTransactionWithoutCommit");
    }

    /**
     * End transaction.
     */
    public void endTransaction() {
        try {
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.ERROR, connection.getClass() + " does not close", e);
        }
        logger.log(Level.INFO, "Finish method endTransaction");
    }

    /**
     * Commit.
     *
     * @throws ConnectionPoolException the connection pool exception
     */
    public void commit() throws ConnectionPoolException {
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new ConnectionPoolException(e);
        }
        logger.log(Level.INFO, "Finish method commit");
    }

    /**
     * Rollback.
     */
    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Error rollback", e);
        }
        logger.log(Level.INFO, "Finish method rollback");
    }
}
