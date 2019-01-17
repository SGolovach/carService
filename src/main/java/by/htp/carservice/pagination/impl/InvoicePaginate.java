package by.htp.carservice.pagination.impl;

import by.htp.carservice.entity.impl.Invoice;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.pagination.PaginationData;
import by.htp.carservice.transaction.TransactionFactory;
import by.htp.carservice.transaction.TransactionInvoice;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * The Class InvoicePaginate.
 */
public class InvoicePaginate implements PaginationData<Invoice> {
    
    /** The logger. */
    private static Logger logger = LogManager.getLogger();
    
    /** The Constant PARAM_CHECK_ILLUSTRATE. */
    private static final String PARAM_CHECK_ILLUSTRATE = "checkIllustreta";
    
    /** The Constant PARAM_CURRENT_PAGE. */
    private static final String PARAM_CURRENT_PAGE = "currentPage";
    
    /** The Constant SESSION_CHECK_ILLUSTRATE. */
    private static final String SESSION_CHECK_ILLUSTRATE = "checkIllustretaSession";
    
    /** The Constant SESSION_COUNT_PAGE_EDIT_INVOICE. */
    private static final String SESSION_COUNT_PAGE_EDIT_INVOICE = "countPageSessionEditInvoice";
    
    /** The Constant SESSION_COUNT_PAGE_EDIT_ALL_INVOICE. */
    private static final String SESSION_COUNT_PAGE_EDIT_ALL_INVOICE = "countPageSessionEditAllInvoice";
    
    /** The Constant STANDARD_CHECK_ILLUSTRATE. */
    private static final int STANDARD_CHECK_ILLUSTRATE = 10;
    
    /** The Constant MINUS_CURRENT_PAGE. */
    private static final int MINUS_CURRENT_PAGE = 1;
    
    /** The Constant CHECK_DATA. */
    private static final String CHECK_DATA = "0";
    
    /** The transaction invoice. */
    private final TransactionInvoice transactionInvoice =
            TransactionFactory.getInstance().getTransactionInvoice();

    /* (non-Javadoc)
     * @see by.htp.carservice.pagination.PaginationData#paginate(java.util.Map)
     */
    @Override
    public List<Invoice> paginate(Map<String, String> requestParam) throws ServiceException {
        int checkIllustreta = Integer.parseInt(checkData(requestParam.get(PARAM_CHECK_ILLUSTRATE)));
        int currentPage = Integer.parseInt(checkData(requestParam.get(PARAM_CURRENT_PAGE)));
        int checkIllustretaSession = Integer.parseInt(checkData(requestParam.get(SESSION_CHECK_ILLUSTRATE)));
        int countPageSession = Integer.parseInt(checkData(requestParam.get(SESSION_COUNT_PAGE_EDIT_ALL_INVOICE)));
        List<Invoice> invoiceList;
        boolean flagCountPage = false;
            if (checkIllustreta == 0 && checkIllustretaSession == 0) {
                checkIllustretaSession = STANDARD_CHECK_ILLUSTRATE;
            }
            if (checkIllustreta != 0 && checkIllustretaSession != 0) {
                checkIllustretaSession = checkIllustreta;
                flagCountPage = true;
            }
            if (countPageSession == 0 || flagCountPage) {
                int countRecord = transactionInvoice.countRecordTransaction();
                int modCountrecord = countRecord % checkIllustretaSession;
                countPageSession = countRecord / checkIllustretaSession;
                if (modCountrecord > 0) {
                    countPageSession++;
                }
            }
            if (currentPage == 0) {
                currentPage++;
            }
            int offset = (currentPage - MINUS_CURRENT_PAGE) * checkIllustretaSession;
            int limit = checkIllustretaSession;
            invoiceList = transactionInvoice.checkAllRecordTransaction(limit, offset);
            requestParam.put(SESSION_CHECK_ILLUSTRATE, String.valueOf(checkIllustretaSession));
            requestParam.put(SESSION_COUNT_PAGE_EDIT_ALL_INVOICE, String.valueOf(countPageSession));
        logger.log(Level.INFO, "Finish method paginate class InvoicePaginate, result = " + invoiceList);
        return invoiceList;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.pagination.PaginationData#paginateById(java.util.Map, long)
     */
    @Override
    public List<Invoice> paginateById(Map<String, String> requestParam, long id) throws ServiceException {
        int checkIllustreta = Integer.parseInt(checkData(requestParam.get(PARAM_CHECK_ILLUSTRATE)));
        int currentPage = Integer.parseInt(checkData(requestParam.get(PARAM_CURRENT_PAGE)));
        int checkIllustretaSession = Integer.parseInt(checkData(requestParam.get(SESSION_CHECK_ILLUSTRATE)));
        int countPageSession = Integer.parseInt(checkData(requestParam.get(SESSION_COUNT_PAGE_EDIT_INVOICE)));
        List<Invoice> invoiceList;
        boolean flagCountPage = false;
            if (checkIllustreta == 0 && checkIllustretaSession == 0) {
                checkIllustretaSession = STANDARD_CHECK_ILLUSTRATE;
            }
            if (checkIllustreta != 0 && checkIllustretaSession != 0) {
                checkIllustretaSession = checkIllustreta;
                flagCountPage = true;
            }
            if (countPageSession == 0 || flagCountPage) {
                int countRecord = transactionInvoice.countRecordByIdTransaction(id);
                int modCountrecord = countRecord % checkIllustretaSession;
                countPageSession = countRecord / checkIllustretaSession;
                if (modCountrecord > 0) {
                    countPageSession++;
                }
            }
            if (currentPage == 0) {
                currentPage++;
            }
            int offset = (currentPage - MINUS_CURRENT_PAGE) * checkIllustretaSession;
            int limit = checkIllustretaSession;
            invoiceList = transactionInvoice.checkRecordByIdTransaction(id,limit, offset);
            requestParam.put(SESSION_CHECK_ILLUSTRATE, String.valueOf(checkIllustretaSession));
            requestParam.put(SESSION_COUNT_PAGE_EDIT_INVOICE, String.valueOf(countPageSession));
        logger.log(Level.INFO, "Finish method paginate class InvoicePaginate, result = " + invoiceList);
        return invoiceList;
    }

    /**
     * Check data.
     *
     * @param data the data
     * @return the string
     */
    private String checkData(String data) {
        if (data == null) {
            data = CHECK_DATA;
        }
        return data;
    }
}
