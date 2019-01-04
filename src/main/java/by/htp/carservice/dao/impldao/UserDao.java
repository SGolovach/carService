package by.htp.carservice.dao.impldao;

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

public class UserDao extends AbstractDao<User> implements DaoUser {
    private static Logger logger = LogManager.getLogger();
    private static final String SQL_SAVE =
            "INSERT INTO users(idUsers, login, password, Roles_id) VALUES(? ,?, ?, ?)";
    private static final String SQL_UPDATE =
            "UPDATE users SET login = ?, password = ?, Roles_id = ? WHERE idUsers = ?";
    private static final String SQL_DELETE = "DELETE FROM users WHERE idUsers = ?";
    private static final String SQL_TAKE = " WHERE idUsers = ?";
    private static final String SQL_CHECK_LOGIN = " WHERE login = ? AND password = ?";
    private static final String SQL_TAKE_ALL = "SELECT * FROM users";
    private static final String ID_USER = "idUsers";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String ROLE_ID = "Roles_id";


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

    @Override
    public List<User> takeAll() throws DaoException {
        logger.log(Level.INFO, "Start takeAll");
        List<User> listUser = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_TAKE_ALL );
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

    @Override
    public List<User> checkLogin(String login,String password) throws DaoException {
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
}
