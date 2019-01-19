package by.htp.carservice.transaction.imlp;

import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.transaction.TransactionFactory;
import by.htp.carservice.transaction.TransactionUser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class UserTransactionImplTest {
    User user;
    TransactionUser factory;

    @BeforeMethod
    public void setUp() {
        user = new User();
        factory = TransactionFactory.getInstance().getTransactionUser();
    }

    @AfterMethod
    public void tearDown() {
        factory = null;
        user = null;
    }

    @Test
    public void testTakeTransaction() throws ServiceException {
        user = factory.takeTransaction(1);
        assertEquals(user.getIdUser(),1);
    }

    @Test
    public void testTakeAllQuery() throws ServiceException {
        List<User> userList = factory.takeAllQuery();
        assertEquals(userList.size(),2);
    }

    @Test
    public void testCountRecordTransaction() throws ServiceException {
        int count = factory.countRecordTransaction();
        assertEquals(count,2);
    }

    @Test
    public void testCountRecordByIdTransaction() throws ServiceException {
        int count = factory.countRecordByIdTransaction(2);
        assertEquals(count,1);
    }
}