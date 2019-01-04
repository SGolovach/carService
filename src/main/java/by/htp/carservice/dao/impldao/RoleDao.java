package by.htp.carservice.dao.impldao;

import by.htp.carservice.dao.AbstractDao;
import by.htp.carservice.dao.DaoRole;
import by.htp.carservice.entity.impl.Role;
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

public class RoleDao extends AbstractDao<Role> implements DaoRole {
    private static Logger logger = LogManager.getLogger();
    private static final String SQL_SAVE = "INSERT INTO roles(idRole, role) VALUES(? ,?)";
    private static final String SQL_UPDATE = "UPDATE roles SET role = ? WHERE idRole = ?";
    private static final String SQL_DELETE = "DELETE FROM roles WHERE idRole = ?";
    private static final String SQL_TAKE = " WHERE idRole = ?";
    private static final String SQL_TAKE_ALL = "SELECT * FROM roles";
    private static final String ID_ROLE = "idRole";
    private static final String ROLE = "role";

    @Override
    public boolean save(Role entity) throws DaoException {
        logger.log(Level.INFO, "Start save entity: " + entity);
        PreparedStatement statement = null;
        int flagResult;
        try {
            statement = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, entity.getIdRole());
            statement.setString(2, entity.getRole());
            flagResult = statement.executeUpdate();
            ResultSet generateId = statement.getGeneratedKeys();
            if (generateId.next()) {
                entity.setIdRole(generateId.getLong(1));
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
    public boolean update(Role entity) throws DaoException {
        logger.log(Level.INFO, "Start update entity: " + entity);
        PreparedStatement statement = null;
        int flagResult;
        try {
            statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, entity.getRole());
            statement.setLong(2, entity.getIdRole());
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
    public boolean delete(Role entity) throws DaoException {
        logger.log(Level.INFO, "Start delete entity: " + entity);
        PreparedStatement statement = null;
        int flagResult;
        try {
            statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1, entity.getIdRole());
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
    public Role take(long id) throws DaoException {
        logger.log(Level.INFO, "Start take entity by id: " + id);
        Role role = new Role();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_TAKE_ALL + SQL_TAKE);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                role.setIdRole(resultSet.getLong(ID_ROLE));
                role.setRole(resultSet.getString(ROLE));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish take entity: " + role);
        return role;
    }

    @Override
    public List<Role> takeAll() throws DaoException {
        logger.log(Level.INFO, "Start takeAll");
        List<Role> listRole = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_TAKE_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listRole.add(new Role(
                        resultSet.getLong(ID_ROLE),
                        resultSet.getString(ROLE)
                ));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish takeAll. listCar: " + listRole);
        return listRole;
    }
}
