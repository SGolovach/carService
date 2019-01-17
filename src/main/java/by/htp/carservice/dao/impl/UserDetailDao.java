package by.htp.carservice.dao.impl;

import by.htp.carservice.dao.AbstractDao;
import by.htp.carservice.dao.DaoUserDetail;
import by.htp.carservice.entity.impl.UserDetail;
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
 * The Class UserDetailDao.
 */
public class UserDetailDao extends AbstractDao<UserDetail> implements DaoUserDetail {

    /**
     * The logger.
     */
    private static Logger logger = LogManager.getLogger();

    /**
     * The Constant SQL_SAVE.
     */
    private static final String SQL_SAVE =
            "INSERT INTO userdetails(idUserDetail, name, phone, email, Users_id) VALUES(? ,? ,? ,? ,?)";

    /**
     * The Constant SQL_UPDATE.
     */
    private static final String SQL_UPDATE =
            "UPDATE userdetails SET name = ?, phone = ?, email = ?, Users_id = ? WHERE idUserDetail = ?";

    /**
     * The Constant SQL_DELETE.
     */
    private static final String SQL_DELETE = "DELETE FROM userdetails WHERE idUserDetail = ?";

    /**
     * The Constant SQL_TAKE.
     */
    private static final String SQL_TAKE = " WHERE Users_id = ?";

    /**
     * The Constant SQL_CHECK_RECORD.
     */
    private static final String SQL_CHECK_RECORD = " WHERE Users_id = ?";

    /**
     * The Constant SQL_TAKE_ALL.
     */
    private static final String SQL_TAKE_ALL =
            "SELECT idUserDetail, name, phone, email, Users_id FROM userdetails";

    /**
     * The Constant SQL_COUNT_RECORD.
     */
    private static final String SQL_COUNT_RECORD = "SELECT COUNT(*) FROM userdetails";

    /**
     * The Constant SQL_COUNT_RECORD_ID.
     */
    private static final String SQL_COUNT_RECORD_ID = "SELECT COUNT(*) FROM userdetails WHERE Users_id = ?";

    /**
     * The Constant SQL_CHECK_ALL_RECORD.
     */
    private static final String SQL_CHECK_ALL_RECORD =
            "SELECT idUserDetail, name, phone, email, Users_id FROM userdetails LIMIT ? OFFSET ?";

    /**
     * The Constant SQL_CHECK_RECORD_ID.
     */
    private static final String SQL_CHECK_RECORD_ID =
            "SELECT idUserDetail, name, phone, email, Users_id FROM userdetails WHERE Users_id = ? LIMIT ? OFFSET ?";

    /**
     * The Constant ID_USER_DETAIL.
     */
    private static final String ID_USER_DETAIL = "idUserDetail";

    /**
     * The Constant NAME.
     */
    private static final String NAME = "name";

    /**
     * The Constant PHONE.
     */
    private static final String PHONE = "phone";

    /**
     * The Constant EMAIL.
     */
    private static final String EMAIL = "email";

    /**
     * The Constant USER_ID.
     */
    private static final String USER_ID = "Users_id";

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#save(java.lang.Object)
     */
    @Override
    public boolean save(UserDetail entity) throws DaoException {
        PreparedStatement statement = null;
        int flagResult;
        try {
            statement = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, entity.getIdUserDetail());
            statement.setString(2, entity.getName());
            statement.setString(3, entity.getPhone());
            statement.setString(4, entity.getEmail());
            statement.setLong(5, entity.getUserId());
            flagResult = statement.executeUpdate();
            ResultSet generateId = statement.getGeneratedKeys();
            if (generateId.next()) {
                entity.setIdUserDetail(generateId.getLong(1));
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
    public boolean update(UserDetail entity) throws DaoException {
        PreparedStatement statement = null;
        int flagResult;
        try {
            statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getPhone());
            statement.setString(3, entity.getEmail());
            statement.setLong(4, entity.getUserId());
            statement.setLong(5, entity.getIdUserDetail());
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
    public boolean delete(UserDetail entity) throws DaoException {
        PreparedStatement statement = null;
        int flagResult;
        try {
            statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1, entity.getIdUserDetail());
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
    public UserDetail take(long id) throws DaoException {
        UserDetail userDetail = new UserDetail();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_TAKE_ALL + SQL_TAKE);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                userDetail.setIdUserDetail(resultSet.getLong(ID_USER_DETAIL));
                userDetail.setName(resultSet.getString(NAME));
                userDetail.setPhone(resultSet.getString(PHONE));
                userDetail.setEmail(resultSet.getString(EMAIL));
                userDetail.setUserId(resultSet.getLong(USER_ID));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish take entity: " + userDetail);
        return userDetail;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#takeAll()
     */
    @Override
    public List<UserDetail> takeAll() throws DaoException {
        List<UserDetail> listUserDetail = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_TAKE_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listUserDetail.add(new UserDetail(
                        resultSet.getLong(ID_USER_DETAIL),
                        resultSet.getString(NAME),
                        resultSet.getString(PHONE),
                        resultSet.getString(EMAIL),
                        resultSet.getLong(USER_ID)
                ));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish takeAll. listCar: " + listUserDetail);
        return listUserDetail;
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
    public List<UserDetail> checkAllRecord(int limit, int offset) throws DaoException {
        List<UserDetail> listUserDetail = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_CHECK_ALL_RECORD);
            statement.setInt(1, limit);
            statement.setInt(2, offset);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listUserDetail.add(new UserDetail(
                        resultSet.getLong(ID_USER_DETAIL),
                        resultSet.getString(NAME),
                        resultSet.getString(PHONE),
                        resultSet.getString(EMAIL),
                        resultSet.getLong(USER_ID)
                ));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish checkAllRecord. listUserDetail: " + listUserDetail);
        return listUserDetail;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#checkRecordById(long, int, int)
     */
    @Override
    public List<UserDetail> checkRecordById(long id, int limit, int offset) throws DaoException {
        List<UserDetail> listUserDetail = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_CHECK_RECORD_ID);
            statement.setLong(1, id);
            statement.setInt(2, limit);
            statement.setInt(3, offset);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listUserDetail.add(new UserDetail(
                        resultSet.getLong(ID_USER_DETAIL),
                        resultSet.getString(NAME),
                        resultSet.getString(PHONE),
                        resultSet.getString(EMAIL),
                        resultSet.getLong(USER_ID)
                ));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish checkAllRecord. listUserDetail: " + listUserDetail);
        return listUserDetail;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.DaoUserDetail#checkRecord(long)
     */
    @Override
    public boolean checkRecord(long userId) throws DaoException {
        boolean result;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_TAKE_ALL + SQL_CHECK_RECORD);
            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();
            result = resultSet.next();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish checkRecord result: " + result);
        return result;
    }
}
