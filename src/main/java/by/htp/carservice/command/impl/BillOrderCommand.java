package by.htp.carservice.command.impl;

import by.htp.carservice.command.Command;
import by.htp.carservice.command.NamePage;
import by.htp.carservice.entity.impl.Invoice;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.selector.SelectorFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

public class BillOrderCommand implements Command {
    private static Logger logger = LogManager.getLogger();
    private static final String METHOD_POST = "post";
    private static final String PARAM_NUMBER_INVOICE = "numberInvoice";
    private static final String PARAM_COST = "cost";
    private static final String PARAM_ORDER_ID = "orderId";
    private static final String SESSION_ORDER_ID = "idOrder";
    private static final String SESSION_USER = "user";

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = ((User) session.getAttribute(SESSION_USER));
        SelectorFactory factory = SelectorFactory.getInstance();
        long orderId = Long.parseLong(request.getParameter(PARAM_ORDER_ID));
        if (request.getMethod().equalsIgnoreCase(METHOD_POST)) {
            String numberInvoice = request.getParameter(PARAM_NUMBER_INVOICE);
            String cost = request.getParameter(PARAM_COST);
            boolean numberInvoiceValid = factory.getValidationData().validateNumberInvoice(numberInvoice);
            boolean costValid = factory.getValidationData().validateCost(cost);
            if (numberInvoiceValid && costValid) {
                if (user == null) {
                    return NamePage.INFO_SESSION_INVALIDATE_PAGE.getRedirectPage();
                }
                Invoice invoice = new Invoice();
                invoice.setNumberInvoice(Long.parseLong(numberInvoice));
                invoice.setCost(BigDecimal.valueOf(Double.parseDouble(cost)));
                invoice.setOrderId(orderId);

                try {
                    factory.getInvoiceSelector().save(invoice);
                    factory.getOrderSelector().updateStatus(orderId);
                } catch (SelectorException e) {
                    logger.log(Level.ERROR, "Error in BillOrderCommand", e);
                    return NamePage.ERROR_PAGE.getRedirectPage();
                }
                return NamePage.BILL_PAGE.getRedirectPage();
            } else {
                return NamePage.INFO_BILL_ORDER_VALID_PAGE.getRedirectPage();
            }
        }
        if (user == null) {
            return NamePage.SESSION_USER_INVALIDATE_PAGE.getForwardPage();
        }
        session.setAttribute(SESSION_ORDER_ID,orderId);
        return NamePage.BILL_ORDER_PAGE.getForwardPage();
    }
}
