package by.htp.carservice.dao.impldao;

import by.htp.carservice.dao.AbstractDao;
import by.htp.carservice.entity.impl.Order;
import by.htp.carservice.exception.DaoException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDao extends AbstractDao<Order> {
    private static Logger logger = LogManager.getLogger();
    private static final String SQL_SAVE =
            "INSERT INTO orders(idOrder, timeRegister, Description, status, Users_id, Departments_id, Cars_id)" +
                    " VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE =
            "UPDATE orders SET timeRegister = ?, Description = ?, status = ?, Users_id = ?," +
                    " Departments_id = ?, Cars_id = ? WHERE idOrder = ?";
    private static final String SQL_DELETE = "DELETE FROM orders WHERE idOrder = ?";
    private static final String SQL_TAKE = " WHERE idOrder = ?";
    private static final String SQL_TAKE_ALL = "SELECT * FROM orders";
    private static final String ID_ORDER = "idOrder";
    private static final String TIME_REGISTER = "timeRegister";
    private static final String DESCRIPTION = "Description";
    private static final String STATUS = "status";
    private static final String USER_ID = "Users_id";
    private static final String DEPARTMENT_ID = "Departments_id";
    private static final String CAR_ID = "Cars_id";

    @Override
    public boolean save(Order entity) throws DaoException {
        logger.log(Level.INFO, "Start save entity: " + entity);
        PreparedStatement statement = null;
        int flagResult;
        try {
            statement = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, entity.getIdOrder());
            statement.setTimestamp(2, entity.getTimeRegister());
            statement.setString(3, entity.getDescription());
            statement.setString(4, entity.getStatus());
            statement.setLong(5, entity.getUserId());
            statement.setLong(6, entity.getDepartmentId());
            statement.setLong(7, entity.getCarId());
            flagResult = statement.executeUpdate();
            ResultSet generateId = statement.getGeneratedKeys();
            if (generateId.next()) {
                entity.setIdOrder(generateId.getLong(1));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish save entity, result: " + (flagResult >= 1));
        return (flagResult >= 1);
    }

    @Override
    public boolean update(Order entity) throws DaoException {
        logger.log(Level.INFO, "Start update entity: " + entity);
        PreparedStatement statement = null;
        int flagResult;
        try {
            statement = connection.prepareStatement(SQL_UPDATE);
            statement.setTimestamp(1, entity.getTimeRegister());
            statement.setString(2, entity.getDescription());
            statement.setString(3, entity.getStatus());
            statement.setLong(4, entity.getUserId());
            statement.setLong(5, entity.getDepartmentId());
            statement.setLong(6, entity.getCarId());
            statement.setLong(7, entity.getIdOrder());
            flagResult = statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish update entity, result: " + (flagResult >= 1));
        return (flagResult >= 1);
    }

    @Override
    public boolean delete(Order entity) throws DaoException {
        logger.log(Level.INFO, "Start delete entity: " + entity);
        PreparedStatement statement = null;
        int flagResult;
        try {
            statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1, entity.getIdOrder());
            flagResult = statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish delete entity, result: " + (flagResult >= 1));
        return (flagResult >= 1);
    }

    @Override
    public Order take(long id) throws DaoException {
        logger.log(Level.INFO, "Start take entity by id: " + id);
        Order order = new Order();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_TAKE_ALL + SQL_TAKE);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                order.setIdOrder(resultSet.getLong(ID_ORDER));
                order.setTimeRegister(resultSet.getTimestamp(TIME_REGISTER));
                order.setDescription(resultSet.getString(DESCRIPTION));
                order.setStatus(resultSet.getString(STATUS));
                order.setUserId(resultSet.getLong(USER_ID));
                order.setDepartmentId(resultSet.getLong(DEPARTMENT_ID));
                order.setCarId(resultSet.getLong(CAR_ID));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish take entity: " + order);
        return order;
    }

    @Override
    public List<Order> takeAll() throws DaoException {
        logger.log(Level.INFO, "Start takeAll");
        List<Order> listOrder = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_TAKE_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listOrder.add(new Order(
                        resultSet.getLong(ID_ORDER),
                        resultSet.getTimestamp(TIME_REGISTER),
                        resultSet.getString(DESCRIPTION),
                        resultSet.getString(STATUS),
                        resultSet.getLong(USER_ID),
                        resultSet.getLong(DEPARTMENT_ID),
                        resultSet.getLong(CAR_ID)
                ));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish takeAll. listCar: " + listOrder);
        return listOrder;
    }
}
