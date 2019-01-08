package by.htp.carservice.dao.impl;

import by.htp.carservice.dao.AbstractDao;
import by.htp.carservice.dao.DaoInvoice;
import by.htp.carservice.entity.impl.Invoice;
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

public class InvoiceDao extends AbstractDao<Invoice> implements DaoInvoice {
    private static Logger logger = LogManager.getLogger();
    private static final String SQL_SAVE =
            "INSERT INTO invoices(idInvoice, numberInvoice, cost, Orders_id)" +
                    " VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE =
            "UPDATE invoices SET numberInvoice = ?, cost = ?, Orders_id = ? WHERE idInvoice = ?";
    private static final String SQL_DELETE = "DELETE FROM invoices WHERE idInvoice = ?";
    private static final String SQL_TAKE = " WHERE idInvoice = ?";
    private static final String SQL_TAKE_ALL = "SELECT * FROM invoices";
    private static final String SQL_COUNT_RECORD = "SELECT COUNT(*) FROM invoices";
    private static final String SQL_COUNT_RECORD_ID =
            "SELECT COUNT(*) FROM invoices " +
                    "JOIN orders ON invoices.Orders_id=orders.idOrder " +
                    "WHERE orders.idOrder IN(SELECT idOrder FROM orders WHERE Users_id = ?)";
    private static final String SQL_CHECK_ALL_RECORD = "SELECT * FROM invoices LIMIT ? OFFSET ?";
    private static final String SQL_CHECK_RECORD_ID = "SELECT idInvoice,numberInvoice,cost,Orders_id FROM invoices " +
            "JOIN orders ON invoices.Orders_id=orders.idOrder " +
            "WHERE orders.idOrder IN(SELECT idOrder FROM orders WHERE Users_id = ?) LIMIT ? OFFSET ?";
    private static final String ID_INVOICE = "idInvoice";
    private static final String NUMBER_INVOICE = "numberInvoice";
    private static final String COST = "cost";
    private static final String ORDER_ID = "Orders_id";

    @Override
    public boolean save(Invoice entity) throws DaoException {
        logger.log(Level.INFO, "Start save entity: " + entity);
        PreparedStatement statement = null;
        int flagResult;
        try {
            statement = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, entity.getIdInvoice());
            statement.setLong(2, entity.getNumberInvoice());
            statement.setBigDecimal(3, entity.getCost());
            statement.setLong(4, entity.getOrderId());
            flagResult = statement.executeUpdate();
            ResultSet generateId = statement.getGeneratedKeys();
            if (generateId.next()) {
                entity.setIdInvoice(generateId.getLong(1));
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
    public boolean update(Invoice entity) throws DaoException {
        logger.log(Level.INFO, "Start update entity: " + entity);
        PreparedStatement statement = null;
        int flagResult;
        try {
            statement = connection.prepareStatement(SQL_UPDATE);
            statement.setLong(1, entity.getNumberInvoice());
            statement.setBigDecimal(2, entity.getCost());
            statement.setLong(3, entity.getOrderId());
            statement.setLong(4, entity.getIdInvoice());
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
    public boolean delete(Invoice entity) throws DaoException {
        logger.log(Level.INFO, "Start delete entity: " + entity);
        PreparedStatement statement = null;
        int flagResult;
        try {
            statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1, entity.getIdInvoice());
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
    public Invoice take(long id) throws DaoException {
        logger.log(Level.INFO, "Start take entity by id: " + id);
        Invoice invoice = new Invoice();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_TAKE_ALL + SQL_TAKE);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                invoice.setIdInvoice(resultSet.getLong(ID_INVOICE));
                invoice.setNumberInvoice(resultSet.getLong(NUMBER_INVOICE));
                invoice.setCost(resultSet.getBigDecimal(COST));
                invoice.setOrderId(resultSet.getLong(ORDER_ID));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish take entity: " + invoice);
        return invoice;
    }

    @Override
    public List<Invoice> takeAll() throws DaoException {
        logger.log(Level.INFO, "Start takeAll");
        List<Invoice> listInvoice = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_TAKE_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listInvoice.add(new Invoice(
                        resultSet.getLong(ID_INVOICE),
                        resultSet.getLong(NUMBER_INVOICE),
                        resultSet.getBigDecimal(COST),
                        resultSet.getLong(ORDER_ID)
                ));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish takeAll. listCar: " + listInvoice);
        return listInvoice;
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
    public List<Invoice> checkAllRecord(int limit, int offset) throws DaoException {
        logger.log(Level.INFO, "Start checkAllRecord");
        List<Invoice> listInvoice = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_CHECK_ALL_RECORD);
            statement.setInt(1,limit);
            statement.setInt(2,offset);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listInvoice.add(new Invoice(
                        resultSet.getLong(ID_INVOICE),
                        resultSet.getLong(NUMBER_INVOICE),
                        resultSet.getBigDecimal(COST),
                        resultSet.getLong(ORDER_ID)
                ));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish checkAllRecord. listInvoice: " + listInvoice);
        return listInvoice;
    }

    @Override
    public List<Invoice> checkRecordById(long id, int limit, int offset) throws DaoException {
        logger.log(Level.INFO, "Start checkRecordById");
        List<Invoice> listInvoice = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_CHECK_RECORD_ID);
            statement.setLong(1,id);
            statement.setInt(2,limit);
            statement.setInt(3,offset);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listInvoice.add(new Invoice(
                        resultSet.getLong(ID_INVOICE),
                        resultSet.getLong(NUMBER_INVOICE),
                        resultSet.getBigDecimal(COST),
                        resultSet.getLong(ORDER_ID)
                ));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish checkRecordById. listInvoice: " + listInvoice);
        return listInvoice;
    }
}
