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

/**
 * The Class InvoiceDao.
 */
public class InvoiceDao extends AbstractDao<Invoice> implements DaoInvoice {

    /**
     * The logger.
     */
    private static Logger logger = LogManager.getLogger();

    /**
     * The Constant SQL_SAVE.
     */
    private static final String SQL_SAVE =
            "INSERT INTO invoices(idInvoice, numberInvoice, cost, Orders_id)" +
                    " VALUES(?, ?, ?, ?)";

    /**
     * The Constant SQL_UPDATE.
     */
    private static final String SQL_UPDATE =
            "UPDATE invoices SET numberInvoice = ?, cost = ?, Orders_id = ? WHERE idInvoice = ?";

    /**
     * The Constant SQL_DELETE.
     */
    private static final String SQL_DELETE = "DELETE FROM invoices WHERE idInvoice = ?";

    /**
     * The Constant SQL_TAKE.
     */
    private static final String SQL_TAKE = " WHERE idInvoice = ?";

    /**
     * The Constant SQL_TAKE_ALL.
     */
    private static final String SQL_TAKE_ALL =
            "SELECT idInvoice, numberInvoice, cost, Orders_id FROM invoices";

    /**
     * The Constant SQL_COUNT_RECORD.
     */
    private static final String SQL_COUNT_RECORD = "SELECT COUNT(*) FROM invoices";

    /**
     * The Constant SQL_COUNT_RECORD_ID.
     */
    private static final String SQL_COUNT_RECORD_ID =
            "SELECT COUNT(*) FROM invoices " +
                    "JOIN orders ON invoices.Orders_id=orders.idOrder " +
                    "WHERE orders.idOrder IN(SELECT idOrder FROM orders WHERE Users_id = ?)";

    /**
     * The Constant SQL_CHECK_ALL_RECORD.
     */
    private static final String SQL_CHECK_ALL_RECORD =
            "SELECT idInvoice, numberInvoice, cost, Orders_id FROM invoices LIMIT ? OFFSET ?";

    /**
     * The Constant SQL_CHECK_RECORD_ID.
     */
    private static final String SQL_CHECK_RECORD_ID = "SELECT idInvoice,numberInvoice,cost,Orders_id FROM invoices " +
            "JOIN orders ON invoices.Orders_id=orders.idOrder " +
            "WHERE orders.idOrder IN(SELECT idOrder FROM orders WHERE Users_id = ?) LIMIT ? OFFSET ?";

    /**
     * The Constant ID_INVOICE.
     */
    private static final String ID_INVOICE = "idInvoice";

    /**
     * The Constant NUMBER_INVOICE.
     */
    private static final String NUMBER_INVOICE = "numberInvoice";

    /**
     * The Constant COST.
     */
    private static final String COST = "cost";

    /**
     * The Constant ORDER_ID.
     */
    private static final String ORDER_ID = "Orders_id";

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#save(java.lang.Object)
     */
    @Override
    public boolean save(Invoice entity) throws DaoException {
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
        logger.log(Level.INFO, "Result: " + (flagResult >= 1));
        return (flagResult >= 1);
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#update(java.lang.Object)
     */
    @Override
    public boolean update(Invoice entity) throws DaoException {
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
        logger.log(Level.INFO, "Result: " + (flagResult >= 1));
        return (flagResult >= 1);
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#delete(java.lang.Object)
     */
    @Override
    public boolean delete(Invoice entity) throws DaoException {
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
        logger.log(Level.INFO, "Result: " + (flagResult >= 1));
        return (flagResult >= 1);
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#take(long)
     */
    @Override
    public Invoice take(long id) throws DaoException {
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

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#takeAll()
     */
    @Override
    public List<Invoice> takeAll() throws DaoException {
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
        logger.log(Level.INFO, "Finish countRecordById , result: " + resultCount);
        return resultCount;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#checkAllRecord(int, int)
     */
    @Override
    public List<Invoice> checkAllRecord(int limit, int offset) throws DaoException {
        List<Invoice> listInvoice = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_CHECK_ALL_RECORD);
            statement.setInt(1, limit);
            statement.setInt(2, offset);
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

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#checkRecordById(long, int, int)
     */
    @Override
    public List<Invoice> checkRecordById(long id, int limit, int offset) throws DaoException {
        List<Invoice> listInvoice = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_CHECK_RECORD_ID);
            statement.setLong(1, id);
            statement.setInt(2, limit);
            statement.setInt(3, offset);
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
