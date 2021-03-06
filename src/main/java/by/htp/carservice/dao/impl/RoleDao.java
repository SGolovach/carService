package by.htp.carservice.dao.impl;

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

/**
 * The Class RoleDao.
 */
public class RoleDao extends AbstractDao<Role> implements DaoRole {

    /**
     * The logger.
     */
    private static Logger logger = LogManager.getLogger();

    /**
     * The Constant SQL_SAVE.
     */
    private static final String SQL_SAVE = "INSERT INTO roles(idRole, role) VALUES(? ,?)";

    /**
     * The Constant SQL_UPDATE.
     */
    private static final String SQL_UPDATE = "UPDATE roles SET role = ? WHERE idRole = ?";

    /**
     * The Constant SQL_DELETE.
     */
    private static final String SQL_DELETE = "DELETE FROM roles WHERE idRole = ?";

    /**
     * The Constant SQL_TAKE.
     */
    private static final String SQL_TAKE = " WHERE idRole = ?";

    /**
     * The Constant SQL_TAKE_ALL.
     */
    private static final String SQL_TAKE_ALL = "SELECT idRole, role FROM roles";

    /**
     * The Constant SQL_COUNT_RECORD.
     */
    private static final String SQL_COUNT_RECORD = "SELECT COUNT(*) FROM roles";

    /**
     * The Constant SQL_CHECK_ALL_RECORD.
     */
    private static final String SQL_CHECK_ALL_RECORD = "SELECT idRole, role FROM roles LIMIT ? OFFSET ?";

    /**
     * The Constant ID_ROLE.
     */
    private static final String ID_ROLE = "idRole";

    /**
     * The Constant ROLE.
     */
    private static final String ROLE = "role";

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#save(java.lang.Object)
     */
    @Override
    public boolean save(Role entity) throws DaoException {
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
        logger.log(Level.INFO, "Result: " + (flagResult >= 1));
        return (flagResult >= 1);
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#update(java.lang.Object)
     */
    @Override
    public boolean update(Role entity) throws DaoException {
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
        logger.log(Level.INFO, "Result: " + (flagResult >= 1));
        return (flagResult >= 1);
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#delete(java.lang.Object)
     */
    @Override
    public boolean delete(Role entity) throws DaoException {
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
        logger.log(Level.INFO, "Result: " + (flagResult >= 1));
        return (flagResult >= 1);
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#take(long)
     */
    @Override
    public Role take(long id) throws DaoException {
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

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#takeAll()
     */
    @Override
    public List<Role> takeAll() throws DaoException {
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
    public int countRecordById(long id) {
        throw new UnsupportedOperationException("Operation do not realese");
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#checkAllRecord(int, int)
     */
    @Override
    public List<Role> checkAllRecord(int limit, int offset) throws DaoException {
        List<Role> listRole = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_CHECK_ALL_RECORD);
            statement.setInt(1, limit);
            statement.setInt(2, offset);
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
        logger.log(Level.INFO, "Finish checkAllRecord. listRole: " + listRole);
        return listRole;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#checkRecordById(long, int, int)
     */
    @Override
    public List<Role> checkRecordById(long id, int limit, int offset) {
        throw new UnsupportedOperationException("Operation do not realese");
    }
}
