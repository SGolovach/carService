package by.htp.carservice.command.impl;

import by.htp.carservice.command.Command;
import by.htp.carservice.command.NamePage;
import by.htp.carservice.command.RequestSpliter;
import by.htp.carservice.entity.impl.Order;
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
 * The Class EditOrderCommand.
 */
public class EditOrderCommand implements Command {
    
    /** The logger. */
    private static Logger logger = LogManager.getLogger();
    
    /** The Constant METHOD_POST. */
    private static final String METHOD_POST = "post";
    
    /** The Constant PARAM_ORDER_ID. */
    private static final String PARAM_ORDER_ID = "idOrder";
    
    /** The Constant SESSION_USER. */
    private static final String SESSION_USER = "user";
    
    /** The Constant SESSION_ORDER_LIST. */
    private static final String SESSION_ORDER_LIST = "orderList";
    
    /** The Constant PARAM_DELETE. */
    private static final String PARAM_DELETE = "delete";

    /* (non-Javadoc)
     * @see by.htp.carservice.command.Command#execute(javax.servlet.http.HttpServletRequest)
     */
    @Override
    public String execute(HttpServletRequest request) {
        SelectorFactory factory = SelectorFactory.getInstance();
        HttpSession session = request.getSession();
        RequestSpliter requestSpliter = new RequestSpliter();
        User user = (User) session.getAttribute(SESSION_USER);
        if (request.getMethod().equalsIgnoreCase(METHOD_POST)) {
            long orderId = Long.parseLong(request.getParameter(PARAM_ORDER_ID));
            if (user == null) {
                return NamePage.INFO_SESSION_INVALIDATE_PAGE.getRedirectPage();
            }
            try {
                if (request.getParameter(PARAM_DELETE) != null) {
                    Order order = factory.getOrderSelector().take(orderId);
                    factory.getOrderSelector().delete(order);
                    return NamePage.EDIT_ORDER_PAGE.getRedirectPage();
                }
            } catch (SelectorException e) {
                logger.log(Level.ERROR, "Error in CheckOutServiceCommand", e);
                return NamePage.ERROR_PAGE.getRedirectPage();
            }

            return NamePage.INFO_CREATE_ORDER_PAGE.getRedirectPage();
        }

        if (user == null) {
            return NamePage.SESSION_USER_INVALIDATE_PAGE.getForwardPage();
        }
        long userId = user.getIdUser();
        Map<String, String> resultSplit = requestSpliter.splitRequest(request);
        List<Order> orderList;
        try {
            orderList = factory.getOrderPaginationDataSelector().paginateById(resultSplit, userId);
        } catch (SelectorException e) {
            logger.log(Level.ERROR, "Error in EditCarCommand", e);
            return NamePage.ERROR_PAGE.getForwardPage();
        }

        requestSpliter.splitRequestBack(request, resultSplit);
        session.setAttribute(SESSION_ORDER_LIST, orderList);
        return NamePage.EDIT_ORDER_PAGE.getForwardPage();
    }
}
