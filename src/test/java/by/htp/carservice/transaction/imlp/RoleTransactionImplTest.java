package by.htp.carservice.transaction.imlp;

import by.htp.carservice.entity.impl.Role;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.transaction.TransactionFactory;
import by.htp.carservice.transaction.TransactionRole;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class RoleTransactionImplTest {
    Role role;
    TransactionRole factory;

    @BeforeMethod
    public void setUp() {
        role = new Role();
        factory = TransactionFactory.getInstance().getTransactionRole();
    }

    @AfterMethod
    public void tearDown() {
        role = null;
        factory = null;
    }

    @Test
    public void testTakeTransaction() throws ServiceException {
        role = factory.takeTransaction(1);
        assertEquals(role.getIdRole(), 1);
    }

    @Test
    public void testTakeAllQuery() throws ServiceException {
        List<Role> roleList = factory.takeAllQuery();
        assertEquals(roleList.size(), 2);
    }

    @Test
    public void testCountRecordTransaction() throws ServiceException {
        int count = factory.countRecordTransaction();
        assertEquals(count, 2);
    }
}