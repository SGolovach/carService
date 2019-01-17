package by.htp.carservice.command.impl;

import by.htp.carservice.command.Command;
import by.htp.carservice.command.NamePage;
import by.htp.carservice.command.RequestSpliter;
import by.htp.carservice.entity.impl.Invoice;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.selector.SelectorFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * The Class ViewAllInvoiceCommand.
 */
public class ViewAllInvoiceCommand implements Command {
    
    /** The logger. */
    private static Logger logger = LogManager.getLogger();
    
    /** The Constant SESSION_USER. */
    private static final String SESSION_USER = "user";
    
    /** The Constant SESSION_ALL_INVOICE_LIST. */
    private static final String SESSION_ALL_INVOICE_LIST = "viewInvoiceList";

    /* (non-Javadoc)
     * @see by.htp.carservice.command.Command#execute(javax.servlet.http.HttpServletRequest)
     */
    @Override
    public String execute(HttpServletRequest request) {
        SelectorFactory factory = SelectorFactory.getInstance();
        HttpSession session = request.getSession();
        RequestSpliter requestSpliter = new RequestSpliter();
        User user = (User) session.getAttribute(SESSION_USER);
        if (user == null) {
            return NamePage.SESSION_USER_INVALIDATE_PAGE.getForwardPage();
        }

        Map<String, String> resultSplit = requestSpliter.splitRequest(request);
        List<Invoice> invoiceList;

        try {
            invoiceList = factory.getInvoicePaginationDataSelector().paginate(resultSplit);
        } catch (SelectorException e) {
            logger.log(Level.ERROR, "Error in ViewAllInvoiceCommand", e);
            return NamePage.ERROR_PAGE.getForwardPage();
        }
        requestSpliter.splitRequestBack(request, resultSplit);
        session.setAttribute(SESSION_ALL_INVOICE_LIST, invoiceList);
        return NamePage.VIEW_ALL_INVOICE_PAGE.getForwardPage();
    }
}
