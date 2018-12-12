package by.htp.carservice.dao.impl;

import by.htp.carservice.dao.BaseDao;
import by.htp.carservice.dao.ConnectionPool;
import by.htp.carservice.entity.impl.Role;
import by.htp.carservice.exception.ConnectionPoolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDao implements BaseDao<Role> {
    private static Logger logger = LogManager.getLogger();
    private static final String SQL_SAVE = "INSERT INTO roles(idRole, role) VALUES(? ,?)";
    private static final String SQL_UPDATE = "UPDATE roles SET role = ? WHERE idRole = ?";
    private static final String SQL_DELETE = "DELETE FROM roles WHERE idRole = ?";
    private static final String SQL_TAKE = " WHERE idRole = ?";
    private static final String SQL_TAKE_ALL = "SELECT * FROM roles";
    private static final String ID_ROLE = "idRole";
    private static final String ROLE = "role";

    @Override
    public boolean save(Role entity) {
        try {
            Connection connection = ConnectionPool.getInstance().takeConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_SAVE,Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, entity.getIdRole());
            statement.setString(2, entity.getRole());
            boolean status = statement.execute();
            ResultSet generateId = statement.getGeneratedKeys();
            if (generateId.next()) {
                entity.setIdRole(generateId.getLong(1));
            }
            ConnectionPool.getInstance().closeConnection(connection, statement,generateId);
            if(status){
                return true;
            }
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Role entity) {
        try {
            Connection connection = ConnectionPool.getInstance().takeConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1,entity.getRole());
            statement.setLong(2,entity.getIdRole());
            boolean status = statement.execute();
            ConnectionPool.getInstance().closeConnection(connection,statement);
            if(status){
                return true;
            }
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Role entity) {
        try {
            Connection connection = ConnectionPool.getInstance().takeConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1,entity.getIdRole());
            boolean status = statement.execute();
            ConnectionPool.getInstance().closeConnection(connection,statement);
            if(status){
                return true;
            }
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Role take(long id) {
        List<Role> listRole = takeAll(SQL_TAKE);
        if(listRole.size()==1){
            return listRole.get(0);
        }
        return null;
    }

    @Override
    public List<Role> takeAll(String condition) {
        List<Role> listRole = new ArrayList<>();
        try {
            Connection connection = ConnectionPool.getInstance().takeConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_TAKE_ALL + condition);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                listRole.add(new Role(
                        resultSet.getLong(ID_ROLE),
                        resultSet.getString(ROLE)
                ));
            }

            ConnectionPool.getInstance().closeConnection(connection, statement,resultSet);

        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listRole;
    }
}
