package by.htp.carservice.command.impl;

import by.htp.carservice.command.Command;
import by.htp.carservice.command.NamePage;
import by.htp.carservice.entity.impl.Car;
import by.htp.carservice.entity.impl.Order;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.selector.SelectorFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * The Class ShowOrderUserCommand.
 */
public class ShowOrderUserCommand implements Command {
    
    /** The logger. */
    private static Logger logger = LogManager.getLogger();
    
    /** The Constant SESSION_CAR_MODEL. */
    private static final String SESSION_CAR_MODEL = "carModel";
    
    /** The Constant SESSION_ORDER_USER. */
    private static final String SESSION_ORDER_USER = "orderUser";
    
    /** The Constant SESSION_USER. */
    private static final String SESSION_USER = "user";
    
    /** The Constant PARAM_ORDER_ID. */
    private static final String PARAM_ORDER_ID = "orderId";

    /* (non-Javadoc)
     * @see by.htp.carservice.command.Command#execute(javax.servlet.http.HttpServletRequest)
     */
    @Override
    public String execute(HttpServletRequest request) {
        SelectorFactory factory = SelectorFactory.getInstance();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SESSION_USER);
        if (user == null) {
            return NamePage.INFO_SESSION_INVALIDATE_PAGE.getForwardPage();
        }
        long orderId = Long.parseLong(request.getParameter(PARAM_ORDER_ID));
        Car car;
        Order order;
        try {
            order = factory.getOrderSelector().take(orderId);
            long carId = order.getCarId();
            car = factory.getCarSelector().take(carId);
        } catch (SelectorException e) {
            logger.log(Level.ERROR, "Error in check login", e);
            return NamePage.ERROR_PAGE.getForwardPage();
        }

        session.setAttribute(SESSION_CAR_MODEL, car);
        session.setAttribute(SESSION_ORDER_USER, order);
        return NamePage.SHOW_ORDER_USER_PAGE.getForwardPage();
    }
}
