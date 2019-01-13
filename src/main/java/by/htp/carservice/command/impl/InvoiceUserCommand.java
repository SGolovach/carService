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

public class InvoiceUserCommand implements Command {
    private static Logger logger = LogManager.getLogger();
    private static final String SESSION_INVOICE = "invoiceList";
    private static final String SESSION_USER = "user";

    @Override
    public String execute(HttpServletRequest request) {
        SelectorFactory factory = SelectorFactory.getInstance();
        HttpSession session = request.getSession();
        User user = ((User) session.getAttribute(SESSION_USER));
        if (user == null) {
            return NamePage.SESSION_USER_INVALIDATE_PAGE.getForwardPage();
        }
        long userId = user.getIdUser();
        RequestSpliter requestSpliter = new RequestSpliter();
        Map<String, String> resultSplit = requestSpliter.splitRequest(request);
        List<Invoice> invoiceList;
        try {
            invoiceList = factory.getInvoicePaginationDataSelector().paginateById(resultSplit,userId);
        } catch (SelectorException e) {
            logger.log(Level.ERROR, "Error in check login", e);
            return NamePage.ERROR_PAGE.getForwardPage();
        }
        requestSpliter.splitRequestBack(request, resultSplit);
        request.getSession().setAttribute(SESSION_INVOICE, invoiceList);
        return NamePage.INVOICE_USER_PAGE.getForwardPage();
    }
}
