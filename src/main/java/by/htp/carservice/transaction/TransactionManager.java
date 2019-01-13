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

public class TransactionManager {
    private static Logger logger = LogManager.getLogger();
    protected Connection connection = ConnectionPool.getInstance().takeConnection();

    public TransactionManager() throws ConnectionPoolException {

    }

    public void beginTransaction(AbstractDao dao, AbstractDao... daos) throws ConnectionPoolException {
        logger.log(Level.INFO, "Start method beginTransaction");
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

    public void begin(AbstractDao dao) throws TransactionException {
        logger.log(Level.INFO, "Start method beginTransactionWithoutCommit");
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

    public void endTransaction() {
        logger.log(Level.INFO, "Start method endTransaction");
        try {
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.ERROR, connection.getClass() + " does not close", e);
        }
        logger.log(Level.INFO, "Finish method endTransaction");
    }

    public void commit() throws ConnectionPoolException {
        logger.log(Level.INFO, "Start method commit");
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new ConnectionPoolException(e);
        }
        logger.log(Level.INFO, "Finish method commit");
    }

    public void rollback() {
        logger.log(Level.INFO, "Start method rollback");
        try {
            connection.rollback();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Error rollback", e);
        }
        logger.log(Level.INFO, "Finish method rollback");
    }
}
