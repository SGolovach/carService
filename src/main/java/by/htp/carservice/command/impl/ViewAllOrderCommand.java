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

public class ViewAllOrderCommand implements Command {
    private static Logger logger = LogManager.getLogger();
    private static final String SESSION_USER = "user";
    private static final String SESSION_ALL_ORDER_LIST = "viewOrderList";

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
        List<Order> orderList;

        try {
            orderList = factory.getOrderPaginationDataSelector().paginate(resultSplit);
        } catch (SelectorException e) {
            logger.log(Level.ERROR, "Error in ViewAllOrderCommand", e);
            return NamePage.ERROR_PAGE.getForwardPage();
        }

        requestSpliter.splitRequestBack(request, resultSplit);
        session.setAttribute(SESSION_ALL_ORDER_LIST, orderList);
        return NamePage.VIEW_ALL_ORDER_PAGE.getForwardPage();
    }
}
