package by.htp.carservice.dao;

import by.htp.carservice.entity.Entity;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDao<T extends Entity> implements BaseDao<T> {
    private static Logger logger = LogManager.getLogger();
    protected Connection connection;

    protected void close(Statement statement) {
        logger.log(Level.INFO,"Start method close statement");
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR,"Can not close statement",e);
        }
        logger.log(Level.INFO,"Finish method close statement");
    }

    public void setConnection(Connection connection){
        logger.log(Level.INFO,"Start method setConnection class AbstractDao");
        this.connection = connection;
    }
}
