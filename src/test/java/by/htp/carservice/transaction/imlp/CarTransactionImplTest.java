package by.htp.carservice.transaction.imlp;

import by.htp.carservice.entity.impl.Car;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.transaction.TransactionFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class CarTransactionImplTest {
    Car car;
    TransactionFactory factory;

    @BeforeMethod
    public void setUp() {
        factory = TransactionFactory.getInstance();
        car = new Car();
    }

    @AfterMethod
    public void tearDown() {
        factory = null;
        car = null;
    }

    @Test
    public void testTakeTransaction() throws ServiceException {
        Car actual = factory.getTransactionCar().takeTransaction(1);
        assertEquals(actual.getIdCar(),0 );
    }

    @Test
    public void testTakeAllQuery() throws ServiceException {
        List<Car> carList = factory.getTransactionCar().takeAllQuery();
        assertEquals(carList.size(), 0);
    }

    @Test
    public void testCountRecordTransaction() throws ServiceException {
        int count = factory.getTransactionCar().countRecordTransaction();
        assertEquals(count, 0);
    }

    @Test
    public void testCountRecordByIdTransaction() throws ServiceException {
        int count = factory.getTransactionCar().countRecordByIdTransaction(1);
        assertEquals(count, 0);
    }
}