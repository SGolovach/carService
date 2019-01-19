package by.htp.carservice.transaction.imlp;

import by.htp.carservice.entity.impl.Order;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.transaction.TransactionFactory;
import by.htp.carservice.transaction.TransactionOrder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class OrderTransactionImplTest {
    Order order;
    TransactionOrder factory;

    @BeforeMethod
    public void setUp() {
        order = new Order();
        factory = TransactionFactory.getInstance().getTransactionOrder();
    }

    @AfterMethod
    public void tearDown() {
        order = null;
        factory = null;
    }

    @Test
    public void testTakeTransaction() throws ServiceException {
        order = factory.takeTransaction(1);
        assertEquals(order.getIdOrder(), 0);
    }

    @Test
    public void testTakeAllQuery() throws ServiceException {
        List<Order> orderList = factory.takeAllQuery();
        assertEquals(orderList.size(), 0);
    }

    @Test
    public void testCountRecordTransaction() throws ServiceException {
        int count = factory.countRecordTransaction();
        assertEquals(count, 0);
    }

    @Test
    public void testCountRecordByIdTransaction() throws ServiceException {
        int count = factory.countRecordByIdTransaction(1);
        assertEquals(count, 0);
    }
}