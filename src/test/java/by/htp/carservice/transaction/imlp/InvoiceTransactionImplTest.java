package by.htp.carservice.transaction.imlp;

import by.htp.carservice.entity.impl.Invoice;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.transaction.TransactionFactory;
import by.htp.carservice.transaction.TransactionInvoice;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class InvoiceTransactionImplTest {
    Invoice invoice;
    TransactionInvoice factory;

    @BeforeMethod
    public void setUp() {
        invoice = new Invoice();
        factory = TransactionFactory.getInstance().getTransactionInvoice();
    }

    @AfterMethod
    public void tearDown() {
        invoice = null;
        factory = null;
    }

    @Test
    public void testTakeTransaction() throws ServiceException {
        invoice = factory.takeTransaction(1);
        assertEquals(invoice.getIdInvoice(),0);
    }

    @Test
    public void testTakeAllQuery() throws ServiceException {
        List<Invoice> invoiceList = factory.takeAllQuery();
        assertEquals(invoiceList.size(),0);
    }

    @Test
    public void testCountRecordTransaction() throws ServiceException {
        int count = factory.countRecordTransaction();
        assertEquals(count,0);
    }

    @Test
    public void testCountRecordByIdTransaction() throws ServiceException {
        int count = factory.countRecordByIdTransaction(1);
        assertEquals(count,0);
    }
}