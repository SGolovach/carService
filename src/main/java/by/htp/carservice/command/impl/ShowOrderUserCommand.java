package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import by.htp.carservice.entity.impl.Car;
import by.htp.carservice.entity.impl.Order;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.service.ServiceFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ShowOrderUserCommand extends AbstractCommand {
    private static Logger logger = LogManager.getLogger();
    private static final String SESSION_CAR_MODEL = "carModel";
    private static final String SESSION_ORDER_USER = "orderUser";
    private static final String SESSION_USER = "user";
    private static final String PARAM_ORDER_ID = "orderId";

    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SESSION_USER);
        if (user == null) {
            return new InfoSessionInvalidateCommand().getCommandName();
        }
        long orderId = Long.parseLong(request.getParameter(PARAM_ORDER_ID));
        Car car = new Car();
        Order order = new Order();

        try {
            order = factory.getOrderQueryService().takeQuery(orderId);
            long carId = order.getCarId();
            car = factory.getCarQueryService().takeQuery(carId);
        } catch (CommandException e) {
            logger.log(Level.ERROR, "Error in check login", e);
            return new ErrorCommand().getPathJsp();
        }

        session.setAttribute(SESSION_CAR_MODEL, car);
        session.setAttribute(SESSION_ORDER_USER, order);
        return new ShowOrderUserCommand().getPathJsp();
    }
}
