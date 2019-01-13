package by.htp.carservice.dao.impl;

import by.htp.carservice.dao.AbstractDao;
import by.htp.carservice.dao.DaoUser;
import by.htp.carservice.entity.impl.User;
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
 * The Class UserDao.
 */
public class UserDao extends AbstractDao<User> implements DaoUser {

    /**
     * The logger.
     */
    private static Logger logger = LogManager.getLogger();

    /**
     * The Constant SQL_SAVE.
     */
    private static final String SQL_SAVE =
            "INSERT INTO users(idUsers, login, password, Roles_id) VALUES(? ,?, ?, ?)";

    /**
     * The Constant SQL_UPDATE.
     */
    private static final String SQL_UPDATE =
            "UPDATE users SET login = ?, password = ?, Roles_id = ? WHERE idUsers = ?";

    /**
     * The Constant SQL_DELETE.
     */
    private static final String SQL_DELETE = "DELETE FROM users WHERE idUsers = ?";

    /**
     * The Constant SQL_TAKE.
     */
    private static final String SQL_TAKE = " WHERE idUsers = ?";

    /**
     * The Constant SQL_CHECK_LOGIN.
     */
    private static final String SQL_CHECK_LOGIN = " WHERE login = ? AND password = ?";

    /**
     * The Constant SQL_EXIST_LOGIN.
     */
    private static final String SQL_EXIST_LOGIN = " WHERE login = ?";

    /**
     * The Constant SQL_TAKE_ALL.
     */
    private static final String SQL_TAKE_ALL = "SELECT idUsers, login, password, Roles_id FROM users";

    /**
     * The Constant SQL_COUNT_RECORD.
     */
    private static final String SQL_COUNT_RECORD = "SELECT COUNT(*) FROM users";

    /**
     * The Constant SQL_COUNT_RECORD_ID.
     */
    private static final String SQL_COUNT_RECORD_ID = "SELECT COUNT(*) FROM users WHERE idUsers = ?";

    /**
     * The Constant SQL_CHECK_ALL_RECORD.
     */
    private static final String SQL_CHECK_ALL_RECORD =
            "SELECT idUsers, login, password, Roles_id FROM users LIMIT ? OFFSET ?";

    /**
     * The Constant SQL_CHECK_RECORD_ID.
     */
    private static final String SQL_CHECK_RECORD_ID =
            "SELECT idUsers, login, password, Roles_id FROM users WHERE idUsers = ? LIMIT ? OFFSET ?";

    /**
     * The Constant ID_USER.
     */
    private static final String ID_USER = "idUsers";

    /**
     * The Constant LOGIN.
     */
    private static final String LOGIN = "login";

    /**
     * The Constant PASSWORD.
     */
    private static final String PASSWORD = "password";

    /**
     * The Constant ROLE_ID.
     */
    private static final String ROLE_ID = "Roles_id";


    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#save(java.lang.Object)
     */
    @Override
    public boolean save(User entity) throws DaoException {
        logger.log(Level.INFO, "Start save entity: " + entity);
        PreparedStatement statement = null;
        int flagResult;
        try {
            statement = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, entity.getIdUser());
            statement.setString(2, entity.getLogin());
            statement.setString(3, entity.getPassword());
            statement.setLong(4, entity.getRoleId());
            flagResult = statement.executeUpdate();
            ResultSet generateId = statement.getGeneratedKeys();
            if (generateId.next()) {
                entity.setIdUser(generateId.getLong(1));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish save entity, result: " + (flagResult >= 1));
        return (flagResult >= 1);
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#update(java.lang.Object)
     */
    @Override
    public boolean update(User entity) throws DaoException {
        logger.log(Level.INFO, "Start update entity: " + entity);
        PreparedStatement statement = null;
        int flagResult;
        try {
            statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, entity.getLogin());
            statement.setString(2, entity.getPassword());
            statement.setLong(3, entity.getRoleId());
            statement.setLong(4, entity.getIdUser());
            flagResult = statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish update entity, result: " + (flagResult >= 1));
        return (flagResult >= 1);
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#delete(java.lang.Object)
     */
    @Override
    public boolean delete(User entity) throws DaoException {
        logger.log(Level.INFO, "Start delete entity: " + entity);
        PreparedStatement statement = null;
        int flagResult;
        try {
            statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1, entity.getIdUser());
            flagResult = statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish delete entity, result: " + (flagResult >= 1));
        return (flagResult >= 1);
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#take(long)
     */
    @Override
    public User take(long id) throws DaoException {
        logger.log(Level.INFO, "Start take entity by id: " + id);
        User user = new User();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_TAKE_ALL + SQL_TAKE);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user.setIdUser(resultSet.getLong(ID_USER));
                user.setLogin(resultSet.getString(LOGIN));
                user.setPassword(resultSet.getString(PASSWORD));
                user.setRoleId(resultSet.getLong(ROLE_ID));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish take entity: " + user);
        return user;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#takeAll()
     */
    @Override
    public List<User> takeAll() throws DaoException {
        logger.log(Level.INFO, "Start takeAll");
        List<User> listUser = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_TAKE_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listUser.add(new User(
                        resultSet.getLong(ID_USER),
                        resultSet.getString(LOGIN),
                        resultSet.getString(PASSWORD),
                        resultSet.getLong(ROLE_ID)
                ));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish takeAll. listUser: " + listUser);
        return listUser;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#countRecord()
     */
    @Override
    public int countRecord() throws DaoException {
        logger.log(Level.INFO, "Start countRecord");
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
        logger.log(Level.INFO, "Start countRecordById");
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
    public List<User> checkAllRecord(int limit, int offset) throws DaoException {
        logger.log(Level.INFO, "Start checkAllRecord");
        List<User> listUser = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_CHECK_ALL_RECORD);
            statement.setInt(1, limit);
            statement.setInt(2, offset);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listUser.add(new User(
                        resultSet.getLong(ID_USER),
                        resultSet.getString(LOGIN),
                        resultSet.getString(PASSWORD),
                        resultSet.getLong(ROLE_ID)
                ));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish checkAllRecord. listUser: " + listUser);
        return listUser;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#checkRecordById(long, int, int)
     */
    @Override
    public List<User> checkRecordById(long id, int limit, int offset) throws DaoException {
        logger.log(Level.INFO, "Start checkRecordById");
        List<User> listUser = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_CHECK_RECORD_ID);
            statement.setLong(1, id);
            statement.setInt(2, limit);
            statement.setInt(3, offset);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listUser.add(new User(
                        resultSet.getLong(ID_USER),
                        resultSet.getString(LOGIN),
                        resultSet.getString(PASSWORD),
                        resultSet.getLong(ROLE_ID)
                ));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish checkRecordById. listUser: " + listUser);
        return listUser;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.DaoUser#checkLogin(java.lang.String, java.lang.String)
     */
    @Override
    public List<User> checkLogin(String login, String password) throws DaoException {
        logger.log(Level.INFO, "Start checkLogin");
        List<User> listUser = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_TAKE_ALL + SQL_CHECK_LOGIN);
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listUser.add(new User(
                        resultSet.getLong(ID_USER),
                        resultSet.getString(LOGIN),
                        resultSet.getString(PASSWORD),
                        resultSet.getLong(ROLE_ID)
                ));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish checkLogin. listUser: " + listUser);
        return listUser;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.DaoUser#existLogin(java.lang.String)
     */
    @Override
    public boolean existLogin(String login) throws DaoException {
        logger.log(Level.INFO, "Start existLogin by login: " + login);
        boolean result;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_TAKE_ALL + SQL_EXIST_LOGIN);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            result = resultSet.next();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish existLogin result: " + result);
        return result;
    }
}
