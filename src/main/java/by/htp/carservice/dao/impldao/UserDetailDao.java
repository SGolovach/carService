package by.htp.carservice.dao.impldao;

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

public class UserDetailDao extends AbstractDao<UserDetail> implements DaoUserDetail {
    private static Logger logger = LogManager.getLogger();
    private static final String SQL_SAVE =
            "INSERT INTO userdetails(idUserDetail, name, phone, email, Users_id) VALUES(? ,? ,? ,? ,?)";
    private static final String SQL_UPDATE =
            "UPDATE userdetails SET name = ?, phone = ?, email = ?, Users_id = ? WHERE idUserDetail = ?";
    private static final String SQL_DELETE = "DELETE FROM userdetails WHERE idUserDetail = ?";
    private static final String SQL_TAKE = " WHERE idUserDetail = ?";
    private static final String SQL_CHECK_RECORD = " WHERE Users_id = ?";
    private static final String SQL_TAKE_ALL = "SELECT * FROM userdetails";
    private static final String ID_USER_DETAIL = "idUserDetail";
    private static final String NAME = "name";
    private static final String PHONE = "phone";
    private static final String EMAIL = "email";
    private static final String USER_ID = "Users_id";

    @Override
    public boolean save(UserDetail entity) throws DaoException {
        logger.log(Level.INFO, "Start save entity: " + entity);
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
        logger.log(Level.INFO, "Finish save entity, result: " + (flagResult >= 1));
        return (flagResult >= 1);
    }

    @Override
    public boolean update(UserDetail entity) throws DaoException {
        logger.log(Level.INFO, "Start update entity: " + entity);
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
        logger.log(Level.INFO, "Finish update entity, result: " + (flagResult >= 1));
        return (flagResult >= 1);
    }

    @Override
    public boolean delete(UserDetail entity) throws DaoException {
        logger.log(Level.INFO, "Start delete entity: " + entity);
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
        logger.log(Level.INFO, "Finish delete entity, result: " + (flagResult >= 1));
        return (flagResult >= 1);
    }

    @Override
    public UserDetail take(long id) throws DaoException {
        logger.log(Level.INFO, "Start take entity by id: " + id);
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

    @Override
    public List<UserDetail> takeAll() throws DaoException {
        logger.log(Level.INFO, "Start takeAll");
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

    @Override
    public boolean checkRecord(long userId) throws DaoException {
        logger.log(Level.INFO, "Start checkRecord by userId: " + userId);
        boolean result;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_TAKE_ALL + SQL_CHECK_RECORD);
            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();
            result=resultSet.next();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish checkRecord result: " + result);
        return result;
    }
}
