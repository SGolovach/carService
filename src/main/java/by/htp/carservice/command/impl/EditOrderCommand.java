package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import by.htp.carservice.entity.impl.Order;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.service.ServiceFactory;
import by.htp.carservice.util.SplitRequestParam;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public class EditOrderCommand extends AbstractCommand {
    private static Logger logger = LogManager.getLogger();
    private static final String METHOD_POST = "post";
    private static final String PARAM_ORDER_ID = "idOrder";
    private static final String SESSION_USER = "user";
    private static final String SESSION_ORDER_LIST = "orderList";
    private static final String PARAM_DELETE = "delete";
    private static final String SESSION_USER_INVALIDATE = "/WEB-INF/jsp/info/sessionInvalidate.jsp";

    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        SplitRequestParam splitRequestParam = new SplitRequestParam();
        User user = (User) session.getAttribute(SESSION_USER);
        long userId = user.getIdUser();
        if (request.getMethod().equalsIgnoreCase(METHOD_POST)) {
            long orderId = Long.parseLong(request.getParameter(PARAM_ORDER_ID));
            if (user == null) {
                return new InfoSessionInvalidateCommand().getCommandName();
            }
            try {
                if (request.getParameter(PARAM_DELETE) != null) {
                    Order order = factory.getOrderQueryService().takeQuery(orderId);
                    factory.getOrderQueryService().deleteQuery(order);
                    return new EditOrderCommand().getCommandName();
                }
            } catch (CommandException e) {
                logger.log(Level.ERROR, "Error in CheckOutServiceCommand", e);
                return new ErrorCommand().getCommandName();
            }

            return new InfoCreateOrderCommand().getCommandName();
        }

        if (user == null) {
            return SESSION_USER_INVALIDATE;
        }

        Map<String, String> resultSplit = splitRequestParam.splitRequest(request);
        List<Order> orderList;
        try {
            orderList = factory.getOrderPaginationDataService().paginateById(resultSplit, userId);
        } catch (CommandException e) {
            logger.log(Level.ERROR, "Error in EditCarCommand", e);
            return new ErrorCommand().getPathJsp();
        }

        splitRequestParam.splitRequestBack(request, resultSplit);
        session.setAttribute(SESSION_ORDER_LIST, orderList);
        return new EditOrderCommand().getPathJsp();
    }
}
