package by.htp.carservice.dao.impl;

import by.htp.carservice.dao.AbstractDao;
import by.htp.carservice.dao.DaoOrder;
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

/**
 * The Class OrderDao.
 */
public class OrderDao extends AbstractDao<Order> implements DaoOrder {

    /**
     * The logger.
     */
    private static Logger logger = LogManager.getLogger();

    /**
     * The Constant SQL_SAVE.
     */
    private static final String SQL_SAVE =
            "INSERT INTO orders(idOrder, timeRegister, Description, status, Users_id, Departments_id, Cars_id)" +
                    " VALUES(?, ?, ?, ?, ?, ?, ?)";

    /**
     * The Constant SQL_UPDATE.
     */
    private static final String SQL_UPDATE =
            "UPDATE orders SET timeRegister = ?, Description = ?, status = ?, Users_id = ?," +
                    " Departments_id = ?, Cars_id = ? WHERE idOrder = ?";

    /**
     * The Constant SQL_UPDATE_STATUS.
     */
    private static final String SQL_UPDATE_STATUS =
            "UPDATE orders SET status = ? WHERE idOrder = ?";

    /**
     * The Constant SQL_DELETE.
     */
    private static final String SQL_DELETE = "DELETE FROM orders WHERE idOrder = ?";

    /**
     * The Constant SQL_TAKE.
     */
    private static final String SQL_TAKE = " WHERE idOrder = ?";

    /**
     * The Constant SQL_TAKE_ALL.
     */
    private static final String SQL_TAKE_ALL =
            "SELECT idOrder, timeRegister, Description, status, Users_id, Departments_id, Cars_id FROM orders";

    /**
     * The Constant SQL_COUNT_RECORD.
     */
    private static final String SQL_COUNT_RECORD = "SELECT COUNT(*) FROM orders";

    /**
     * The Constant SQL_COUNT_RECORD_ID.
     */
    private static final String SQL_COUNT_RECORD_ID = "SELECT COUNT(*) FROM orders WHERE Users_id = ?";

    /**
     * The Constant SQL_CHECK_ALL_RECORD.
     */
    private static final String SQL_CHECK_ALL_RECORD =
            "SELECT idOrder, timeRegister, Description, status, Users_id, Departments_id, Cars_id " +
                    "FROM orders LIMIT ? OFFSET ?";

    /**
     * The Constant SQL_CHECK_RECORD_ID.
     */
    private static final String SQL_CHECK_RECORD_ID =
            "SELECT idOrder, timeRegister, Description, status, Users_id, Departments_id, Cars_id " +
                    "FROM orders WHERE Users_id = ? LIMIT ? OFFSET ?";

    /**
     * The Constant ID_ORDER.
     */
    private static final String ID_ORDER = "idOrder";

    /**
     * The Constant TIME_REGISTER.
     */
    private static final String TIME_REGISTER = "timeRegister";

    /**
     * The Constant DESCRIPTION.
     */
    private static final String DESCRIPTION = "Description";

    /**
     * The Constant STATUS.
     */
    private static final String STATUS = "status";

    /**
     * The Constant USER_ID.
     */
    private static final String USER_ID = "Users_id";

    /**
     * The Constant DEPARTMENT_ID.
     */
    private static final String DEPARTMENT_ID = "Departments_id";

    /**
     * The Constant CAR_ID.
     */
    private static final String CAR_ID = "Cars_id";

    /**
     * The Constant BILL_STATUS.
     */
    private static final String BILL_STATUS = "bill";

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#save(java.lang.Object)
     */
    @Override
    public boolean save(Order entity) throws DaoException {
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
        logger.log(Level.INFO, "Result: " + (flagResult >= 1));
        return (flagResult >= 1);
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#update(java.lang.Object)
     */
    @Override
    public boolean update(Order entity) throws DaoException {
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
        logger.log(Level.INFO, "Result: " + (flagResult >= 1));
        return (flagResult >= 1);
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#delete(java.lang.Object)
     */
    @Override
    public boolean delete(Order entity) throws DaoException {
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
        logger.log(Level.INFO, "Result: " + (flagResult >= 1));
        return (flagResult >= 1);
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#take(long)
     */
    @Override
    public Order take(long id) throws DaoException {
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

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#takeAll()
     */
    @Override
    public List<Order> takeAll() throws DaoException {
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

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#countRecord()
     */
    @Override
    public int countRecord() throws DaoException {
        PreparedStatement statement = null;
        int resultCount = 0;
        try {
            statement = connection.prepareStatement(SQL_COUNT_RECORD);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                resultCount = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish countRecord , result: " + resultCount);
        return resultCount;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#countRecordById(long)
     */
    @Override
    public int countRecordById(long id) throws DaoException {
        PreparedStatement statement = null;
        int resultCount = 0;
        try {
            statement = connection.prepareStatement(SQL_COUNT_RECORD_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                resultCount = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish countRecordById , result: " + resultCount);
        return resultCount;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#checkAllRecord(int, int)
     */
    @Override
    public List<Order> checkAllRecord(int limit, int offset) throws DaoException {
        List<Order> listOrder = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_CHECK_ALL_RECORD);
            statement.setInt(1, limit);
            statement.setInt(2, offset);
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
        logger.log(Level.INFO, "Finish checkAllRecord. listOrder: " + listOrder);
        return listOrder;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#checkRecordById(long, int, int)
     */
    @Override
    public List<Order> checkRecordById(long id, int limit, int offset) throws DaoException {
        List<Order> listOrder = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_CHECK_RECORD_ID);
            statement.setLong(1, id);
            statement.setInt(2, limit);
            statement.setInt(3, offset);
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
        logger.log(Level.INFO, "Finish checkRecordById. listOrder: " + listOrder);
        return listOrder;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.DaoOrder#updateStatus(long)
     */
    @Override
    public boolean updateStatus(long orderId) throws DaoException {
        PreparedStatement statement = null;
        int flagResult;
        try {
            statement = connection.prepareStatement(SQL_UPDATE_STATUS);
            statement.setString(1, BILL_STATUS);
            statement.setLong(2, orderId);
            flagResult = statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish updateStatus entity, result: " + (flagResult >= 1));
        return (flagResult >= 1);
    }
}
