package by.htp.carservice.transaction.imlp;

import by.htp.carservice.entity.impl.Department;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.transaction.TransactionDepartment;
import by.htp.carservice.transaction.TransactionFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class DepartmentTransactionImplTest {
    Department department;
    TransactionDepartment factory;

    @BeforeMethod
    public void setUp() {
        department = new Department();
        factory = TransactionFactory.getInstance().getTransactionDepartment();
    }

    @AfterMethod
    public void tearDown() {
        department = null;
        factory = null;
    }

    @Test
    public void testTakeTransaction() throws ServiceException {
        department = factory.takeTransaction(1);
        assertEquals(department.getIdDepartment(),1);
    }

    @Test
    public void testTakeAllQuery() throws ServiceException {
        List<Department> departmentList = factory.takeAllQuery();
        assertEquals(departmentList.size(),12);
    }

    @Test
    public void testCountRecordTransaction() throws ServiceException {
       int count = factory.countRecordTransaction();
       assertEquals(count,12);
    }

}