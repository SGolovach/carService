package by.htp.carservice.pagination.impl;

import by.htp.carservice.command.RequestSpliter;
import by.htp.carservice.entity.impl.Invoice;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.pagination.PaginationDataFactory;
import org.mockito.Mockito;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class InvoicePaginateTest {

    RequestSpliter spliter;
    PaginationDataFactory factory;
    HttpServletRequest request;
    HttpSession session;
    static final String PARAM_CHECK_ILLUSTRATE = "checkIllustreta";
    static final String PARAM_CURRENT_PAGE = "currentPage";
    Map<String, String> paginate;

    @BeforeMethod
    public void setUp() {
        spliter = new RequestSpliter();
        factory = PaginationDataFactory.getInstance();
        request = Mockito.mock(HttpServletRequest.class);
        session = Mockito.mock(HttpSession.class);
        Mockito.when(request.getSession()).thenReturn(session);
        Mockito.when(request.getParameter(PARAM_CHECK_ILLUSTRATE)).thenReturn(null);
        Mockito.when(request.getParameter(PARAM_CURRENT_PAGE)).thenReturn(null);
        paginate = spliter.splitRequest(request);
    }

    @AfterMethod
    public void tearDown() {
        spliter = null;
        factory = null;
        request = null;
        session = null;
        paginate = null;
    }


    @Test
    public void testPaginate() throws ServiceException {
        List<Invoice> carList = factory.getInvoicePagination().paginate(paginate);
        assertEquals(carList.size(), 0);
    }

    @Test
    public void testPaginateById() throws ServiceException {
        List<Invoice> carList = factory.getInvoicePagination().paginateById(paginate,1);
        assertEquals(carList.size(), 0);
    }
}