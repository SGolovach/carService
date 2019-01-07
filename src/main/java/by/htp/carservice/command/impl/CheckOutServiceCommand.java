package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import by.htp.carservice.entity.impl.Car;
import by.htp.carservice.entity.impl.Department;
import by.htp.carservice.entity.impl.Order;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.service.ServiceFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CheckOutServiceCommand extends AbstractCommand {
    private static Logger logger = LogManager.getLogger();
    private static final String METHOD_POST = "post";
    private static final String PARAM_SERVICE_ID = "serviceId";
    private static final String PARAM_DESCRIPTION = "description";
    private static final String PARAM_TIME_REGISTER = "timeregister";
    private static final String PARAM_DEPARTMENT_ID = "departmentId";
    private static final String PARAM_CAR_ID = "carId";
    private static final String SESSION_USER = "user";
    private static final String SESSION_CAR_LIST = "carListForOrder";
    private static final String SESSION_DEPARTMENT = "department";
    private static final String STATUS_ORDER_NEW = "new";
    private static final String PATTERN_DATE = "yyyy-MM-dd HH:mm";
    private static final String REPLACE_DATE = "T";

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = ((User) session.getAttribute(SESSION_USER));
        if (user == null) {
            return new SignupCommand().getPathJsp();
        }
        ServiceFactory factory = ServiceFactory.getInstance();
        long userId = user.getIdUser();
        if (request.getMethod().equalsIgnoreCase(METHOD_POST)) {
            String description = request.getParameter(PARAM_DESCRIPTION);
            String timeRegisterStr = request.getParameter(PARAM_TIME_REGISTER);
            boolean descriptionValid = factory.getValidationData().validateDescription(description);
            if (descriptionValid && !timeRegisterStr.isEmpty()) {
                DateTimeFormatter formater = DateTimeFormatter.ofPattern(PATTERN_DATE);
                long departmentId = Long.parseLong(request.getParameter(PARAM_DEPARTMENT_ID));
                long carId = Long.parseLong(request.getParameter(PARAM_CAR_ID));
                LocalDateTime localDateTime =
                        LocalDateTime.parse(timeRegisterStr.replace(REPLACE_DATE, " "), formater);
                Timestamp timeRegister = Timestamp.valueOf(localDateTime);

                Order order = new Order();
                order.setTimeRegister(timeRegister);
                order.setDescription(description);
                order.setStatus(STATUS_ORDER_NEW);
                order.setUserId(userId);
                order.setDepartmentId(departmentId);
                order.setCarId(carId);

                try {
                    factory.getOrderQueryService().saveQuery(order);
                } catch (CommandException e) {
                    logger.log(Level.ERROR, "Error in CheckOutServiceCommand", e);
                    return new ErrorCommand().getCommandName();
                }

                return new ServiceCommand().getCommandName();
            } else {
                return new MainCommand().getCommandName();
            }
        }
        List<Car> carListForOrder;
        Department department;
        long serviceId = Long.parseLong(request.getParameter(PARAM_SERVICE_ID));
        try {
            carListForOrder = factory.getCarQueryService().takeAllByUserIdQuery(userId);
            department = factory.getDepartmentQueryService().takeQuery(serviceId);
        } catch (CommandException e) {
            logger.log(Level.ERROR, "Error in CheckOutServiceCommand", e);
            return new ErrorCommand().getCommandName();
        }
        if (carListForOrder.isEmpty()) {
            return new CreateCarCommand().getPathJsp();
        }
        session.setAttribute(SESSION_CAR_LIST, carListForOrder);
        session.setAttribute(SESSION_DEPARTMENT, department);

        return new CheckOutServiceCommand().getPathJsp();
    }
}
