package by.htp.carservice.dao.impl;

import by.htp.carservice.dao.AbstractDao;
import by.htp.carservice.dao.DaoCar;
import by.htp.carservice.entity.impl.Car;
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

public class CarDao extends AbstractDao<Car> implements DaoCar {
    private static Logger logger = LogManager.getLogger();
    private static final String SQL_SAVE =
            "INSERT INTO cars(idCars, brand, model, year, codeVIN, fuel, Users_id)" +
                    " VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE =
            "UPDATE cars SET brand = ?, model = ?, year = ?, codeVIN = ?," +
                    " fuel = ?, Users_id = ? WHERE idCars = ?";
    private static final String SQL_DELETE = "DELETE FROM cars WHERE idCars = ?";
    private static final String SQL_TAKE = " WHERE idCars = ?";
    private static final String SQL_TAKE_ALL = "SELECT * FROM cars";
    private static final String SQL_USER_ID = " WHERE Users_id = ?";
    private static final String SQL_COUNT_RECORD = "SELECT COUNT(*) FROM cars";
    private static final String SQL_COUNT_RECORD_ID = "SELECT COUNT(*) FROM cars WHERE Users_id = ?";
    private static final String SQL_CHECK_ALL_RECORD = "SELECT * FROM cars LIMIT ? OFFSET ?";
    private static final String SQL_CHECK_RECORD_ID = "SELECT * FROM cars WHERE Users_id = ? LIMIT ? OFFSET ?";
    private static final String ID_CAR = "idCars";
    private static final String BRAND = "brand";
    private static final String MODEL = "model";
    private static final String YEAR = "year";
    private static final String CODE_VIN = "codeVIN";
    private static final String FUEL = "fuel";
    private static final String USER_ID = "Users_id";

    @Override
    public boolean save(Car entity) throws DaoException {
        logger.log(Level.INFO, "Start save entity: " + entity);
        PreparedStatement statement = null;
        int flagResult;
        try {
            statement = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, entity.getIdCar());
            statement.setString(2, entity.getBrand());
            statement.setString(3, entity.getModel());
            statement.setInt(4, entity.getYear());
            statement.setString(5, entity.getCodeVIN());
            statement.setString(6, entity.getFuel());
            statement.setLong(7, entity.getUserId());
            flagResult = statement.executeUpdate();
            ResultSet generateId = statement.getGeneratedKeys();
            if (generateId.next()) {
                entity.setIdCar(generateId.getLong(1));
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
    public boolean update(Car entity) throws DaoException {
        logger.log(Level.INFO, "Start update entity: " + entity);
        PreparedStatement statement = null;
        int flagResult;
        try {
            statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, entity.getBrand());
            statement.setString(2, entity.getModel());
            statement.setInt(3, entity.getYear());
            statement.setString(4, entity.getCodeVIN());
            statement.setString(5, entity.getFuel());
            statement.setLong(6, entity.getUserId());
            statement.setLong(7, entity.getIdCar());
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
    public boolean delete(Car entity) throws DaoException {
        logger.log(Level.INFO, "Start delete entity: " + entity);
        PreparedStatement statement = null;
        int flagResult;
        try {
            statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1, entity.getIdCar());
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
    public Car take(long id) throws DaoException {
        logger.log(Level.INFO, "Start take entity by id: " + id);
        Car car = new Car();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_TAKE_ALL + SQL_TAKE);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                car.setIdCar(resultSet.getLong(ID_CAR));
                car.setBrand(resultSet.getString(BRAND));
                car.setModel(resultSet.getString(MODEL));
                car.setYear(resultSet.getInt(YEAR));
                car.setCodeVIN(resultSet.getString(CODE_VIN));
                car.setFuel(resultSet.getString(FUEL));
                car.setUserId(resultSet.getLong(USER_ID));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish take entity: " + car);
        return car;
    }

    @Override
    public List<Car> takeAll() throws DaoException {
        logger.log(Level.INFO, "Start takeAll");
        List<Car> listCar = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_TAKE_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listCar.add(new Car(
                        resultSet.getLong(ID_CAR),
                        resultSet.getString(BRAND),
                        resultSet.getString(MODEL),
                        resultSet.getInt(YEAR),
                        resultSet.getString(CODE_VIN),
                        resultSet.getString(FUEL),
                        resultSet.getLong(USER_ID)
                ));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish takeAll. listCar: " + listCar);
        return listCar;
    }

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

    @Override
    public List<Car> checkAllRecord(int limit, int offset) throws DaoException {
        logger.log(Level.INFO, "Start checkAllRecord");
        List<Car> listCar = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_CHECK_ALL_RECORD);
            statement.setInt(1,limit);
            statement.setInt(2,offset);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listCar.add(new Car(
                        resultSet.getLong(ID_CAR),
                        resultSet.getString(BRAND),
                        resultSet.getString(MODEL),
                        resultSet.getInt(YEAR),
                        resultSet.getString(CODE_VIN),
                        resultSet.getString(FUEL),
                        resultSet.getLong(USER_ID)
                ));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish checkAllRecord. listCar: " + listCar);
        return listCar;
    }

    @Override
    public List<Car> checkRecordById(long id, int limit, int offset) throws DaoException {
        logger.log(Level.INFO, "Start checkRecordById");
        List<Car> listCar = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_CHECK_RECORD_ID);
            statement.setLong(1,id);
            statement.setInt(2,limit);
            statement.setInt(3,offset);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listCar.add(new Car(
                        resultSet.getLong(ID_CAR),
                        resultSet.getString(BRAND),
                        resultSet.getString(MODEL),
                        resultSet.getInt(YEAR),
                        resultSet.getString(CODE_VIN),
                        resultSet.getString(FUEL),
                        resultSet.getLong(USER_ID)
                ));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish checkRecordById. listCar: " + listCar);
        return listCar;
    }

    @Override
    public List<Car> takeAllByUserId(long userId) throws DaoException {
        logger.log(Level.INFO, "Start takeAllByUserId");
        List<Car> listCar = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_TAKE_ALL + SQL_USER_ID);
            statement.setLong(1,userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listCar.add(new Car(
                        resultSet.getLong(ID_CAR),
                        resultSet.getString(BRAND),
                        resultSet.getString(MODEL),
                        resultSet.getInt(YEAR),
                        resultSet.getString(CODE_VIN),
                        resultSet.getString(FUEL),
                        resultSet.getLong(USER_ID)
                ));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish takeAllByUserId. listCar: " + listCar);
        return listCar;
    }


}
