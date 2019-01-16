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

/**
 * The Class CarDao.
 */
public class CarDao extends AbstractDao<Car> implements DaoCar {

    /**
     * The logger.
     */
    private static Logger logger = LogManager.getLogger();

    /**
     * The Constant SQL_SAVE.
     */
    private static final String SQL_SAVE =
            "INSERT INTO cars(idCars, brand, model, year, codeVIN, fuel, Users_id)" +
                    " VALUES(?, ?, ?, ?, ?, ?, ?)";

    /**
     * The Constant SQL_UPDATE.
     */
    private static final String SQL_UPDATE =
            "UPDATE cars SET brand = ?, model = ?, year = ?, codeVIN = ?," +
                    " fuel = ?, Users_id = ? WHERE idCars = ?";

    /**
     * The Constant SQL_DELETE.
     */
    private static final String SQL_DELETE = "DELETE FROM cars WHERE idCars = ?";

    /**
     * The Constant SQL_TAKE.
     */
    private static final String SQL_TAKE = " WHERE idCars = ?";

    /**
     * The Constant SQL_TAKE_ALL.
     */
    private static final String SQL_TAKE_ALL =
            "SELECT idCars, brand, model, year, codeVIN, fuel, Users_id FROM cars";

    /**
     * The Constant SQL_USER_ID.
     */
    private static final String SQL_USER_ID = " WHERE Users_id = ?";

    /**
     * The Constant SQL_COUNT_RECORD.
     */
    private static final String SQL_COUNT_RECORD = "SELECT COUNT(*) FROM cars";

    /**
     * The Constant SQL_COUNT_RECORD_ID.
     */
    private static final String SQL_COUNT_RECORD_ID = "SELECT COUNT(*) FROM cars WHERE Users_id = ?";

    /**
     * The Constant SQL_CHECK_ALL_RECORD.
     */
    private static final String SQL_CHECK_ALL_RECORD =
            "SELECT idCars, brand, model, year, codeVIN, fuel, Users_id FROM cars LIMIT ? OFFSET ?";

    /**
     * The Constant SQL_CHECK_RECORD_ID.
     */
    private static final String SQL_CHECK_RECORD_ID =
            "SELECT idCars, brand, model, year, codeVIN, fuel, Users_id FROM cars WHERE Users_id = ? LIMIT ? OFFSET ?";

    /**
     * The Constant ID_CAR.
     */
    private static final String ID_CAR = "idCars";

    /**
     * The Constant BRAND.
     */
    private static final String BRAND = "brand";

    /**
     * The Constant MODEL.
     */
    private static final String MODEL = "model";

    /**
     * The Constant YEAR.
     */
    private static final String YEAR = "year";

    /**
     * The Constant CODE_VIN.
     */
    private static final String CODE_VIN = "codeVIN";

    /**
     * The Constant FUEL.
     */
    private static final String FUEL = "fuel";

    /**
     * The Constant USER_ID.
     */
    private static final String USER_ID = "Users_id";

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#save(java.lang.Object)
     */
    @Override
    public boolean save(Car entity) throws DaoException {
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
        return (flagResult >= 1);
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#update(java.lang.Object)
     */
    @Override
    public boolean update(Car entity) throws DaoException {
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
        return (flagResult >= 1);
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#delete(java.lang.Object)
     */
    @Override
    public boolean delete(Car entity) throws DaoException {
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
        return (flagResult >= 1);
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#take(long)
     */
    @Override
    public Car take(long id) throws DaoException {
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
        return car;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#takeAll()
     */
    @Override
    public List<Car> takeAll() throws DaoException {
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
        return listCar;
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
        return resultCount;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#checkAllRecord(int, int)
     */
    @Override
    public List<Car> checkAllRecord(int limit, int offset) throws DaoException {
        List<Car> listCar = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_CHECK_ALL_RECORD);
            statement.setInt(1, limit);
            statement.setInt(2, offset);
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
        return listCar;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#checkRecordById(long, int, int)
     */
    @Override
    public List<Car> checkRecordById(long id, int limit, int offset) throws DaoException {
        List<Car> listCar = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_CHECK_RECORD_ID);
            statement.setLong(1, id);
            statement.setInt(2, limit);
            statement.setInt(3, offset);
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
        return listCar;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.DaoCar#takeAllByUserId(long)
     */
    @Override
    public List<Car> takeAllByUserId(long userId) throws DaoException {
        List<Car> listCar = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_TAKE_ALL + SQL_USER_ID);
            statement.setLong(1, userId);
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
        return listCar;
    }


}
