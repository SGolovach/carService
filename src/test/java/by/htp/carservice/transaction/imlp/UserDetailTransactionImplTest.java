package by.htp.carservice.transaction.imlp;

import by.htp.carservice.entity.impl.UserDetail;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.transaction.TransactionFactory;
import by.htp.carservice.transaction.TransactionUserDetail;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class UserDetailTransactionImplTest {
    UserDetail userDetail;
    TransactionUserDetail factory;

    @BeforeMethod
    public void setUp() {
        userDetail = new UserDetail();
        factory = TransactionFactory.getInstance().getTransactionUserDetail();
    }

    @AfterMethod
    public void tearDown() {
        userDetail = null;
        factory = null;
    }

    @Test
    public void testTakeTransaction() throws ServiceException {
        userDetail = factory.takeTransaction(2);
        assertEquals(userDetail.getIdUserDetail(), 2);
    }

    @Test
    public void testTakeAllQuery() throws ServiceException {
        List<UserDetail> userDetailList = factory.takeAllQuery();
        assertEquals(userDetailList.size(), 2);
    }

    @Test
    public void testCountRecordTransaction() throws ServiceException {
        int count = factory.countRecordTransaction();
        assertEquals(count, 2);
    }

    @Test
    public void testCountRecordByIdTransaction() throws ServiceException {
        int count = factory.countRecordByIdTransaction(2);
        assertEquals(count, 1);
    }
}