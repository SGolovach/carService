package by.htp.carservice.dao;

import by.htp.carservice.entity.Entity;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The Class AbstractDao.
 *
 * @param <T> the generic type
 */
public abstract class AbstractDao<T extends Entity> {

    /**
     * The logger.
     */
    private static Logger logger = LogManager.getLogger();

    /**
     * The connection.
     */
    protected Connection connection;

    /**
     * Close.
     *
     * @param statement the statement
     */
    protected void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Can not close statement", e);
        }
    }

    /**
     * Sets the connection.
     *
     * @param connection the new connection
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
