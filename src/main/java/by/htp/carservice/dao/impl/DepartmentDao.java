package by.htp.carservice.dao.impl;

import by.htp.carservice.dao.AbstractDao;
import by.htp.carservice.dao.DaoDepartment;
import by.htp.carservice.entity.impl.Department;
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

public class DepartmentDao extends AbstractDao<Department> implements DaoDepartment {
    private static Logger logger = LogManager.getLogger();
    private static final String SQL_SAVE =
            "INSERT INTO departments(idDepartment, nameDepartment) VALUES(? ,?)";
    private static final String SQL_UPDATE =
            "UPDATE departments SET nameDepartment = ? WHERE idDepartment = ?";
    private static final String SQL_DELETE = "DELETE FROM departments WHERE idDepartment = ?";
    private static final String SQL_TAKE = " WHERE idDepartment = ?";
    private static final String SQL_TAKE_ALL = "SELECT * FROM departments";
    private static final String ID_DEPARTMENT = "idDepartment";
    private static final String NAME_DEPARTMENT = "nameDepartment";

    @Override
    public boolean save(Department entity) throws DaoException {
        logger.log(Level.INFO, "Start save entity: " + entity);
        PreparedStatement statement = null;
        int flagResult;
        try {
            statement = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, entity.getIdDepartment());
            statement.setString(2, entity.getNameDepartment());
            flagResult = statement.executeUpdate();
            ResultSet generateId = statement.getGeneratedKeys();
            if (generateId.next()) {
                entity.setIdDepartment(generateId.getLong(1));
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
    public boolean update(Department entity) throws DaoException {
        logger.log(Level.INFO, "Start update entity: " + entity);
        PreparedStatement statement = null;
        int flagResult;
        try {
            statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, entity.getNameDepartment());
            statement.setLong(2, entity.getIdDepartment());
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
    public boolean delete(Department entity) throws DaoException {
        logger.log(Level.INFO, "Start delete entity: " + entity);
        PreparedStatement statement = null;
        int flagResult;
        try {
            statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1, entity.getIdDepartment());
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
    public Department take(long id) throws DaoException {
        logger.log(Level.INFO, "Start take entity by id: " + id);
        Department department = new Department();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_TAKE_ALL + SQL_TAKE);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                department.setIdDepartment(resultSet.getLong(ID_DEPARTMENT));
                department.setNameDepartment(resultSet.getString(NAME_DEPARTMENT));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish take entity: " + department);
        return department;
    }

    @Override
    public List<Department> takeAll() throws DaoException {
        logger.log(Level.INFO, "Start takeAll");
        List<Department> listDepartment = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_TAKE_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listDepartment.add(new Department(
                        resultSet.getLong(ID_DEPARTMENT),
                        resultSet.getString(NAME_DEPARTMENT)
                ));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish takeAll. listCar: " + listDepartment);
        return listDepartment;
    }
}
