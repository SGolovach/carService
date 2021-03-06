package by.htp.carservice.command.impl;

import by.htp.carservice.command.Command;
import by.htp.carservice.command.NamePage;
import by.htp.carservice.entity.impl.Car;
import by.htp.carservice.entity.impl.Department;
import by.htp.carservice.entity.impl.Order;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.selector.SelectorFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * The Class CheckOutServiceCommand.
 */
public class CheckOutServiceCommand implements Command {
    
    /** The logger. */
    private static Logger logger = LogManager.getLogger();
    
    /** The Constant METHOD_POST. */
    private static final String METHOD_POST = "post";
    
    /** The Constant PARAM_SERVICE_ID. */
    private static final String PARAM_SERVICE_ID = "serviceId";
    
    /** The Constant PARAM_DESCRIPTION. */
    private static final String PARAM_DESCRIPTION = "description";
    
    /** The Constant PARAM_TIME_REGISTER. */
    private static final String PARAM_TIME_REGISTER = "timeregister";
    
    /** The Constant PARAM_DEPARTMENT_ID. */
    private static final String PARAM_DEPARTMENT_ID = "departmentId";
    
    /** The Constant PARAM_CAR_ID. */
    private static final String PARAM_CAR_ID = "carId";
    
    /** The Constant SESSION_USER. */
    private static final String SESSION_USER = "user";
    
    /** The Constant SESSION_CAR_LIST. */
    private static final String SESSION_CAR_LIST = "carListForOrder";
    
    /** The Constant SESSION_DEPARTMENT. */
    private static final String SESSION_DEPARTMENT = "department";
    
    /** The Constant STATUS_ORDER_NEW. */
    private static final String STATUS_ORDER_NEW = "new";
    
    /** The Constant PATTERN_DATE. */
    private static final String PATTERN_DATE = "yyyy-MM-dd HH:mm";
    
    /** The Constant REPLACE_DATE. */
    private static final String REPLACE_DATE = "T";

    /* (non-Javadoc)
     * @see by.htp.carservice.command.Command#execute(javax.servlet.http.HttpServletRequest)
     */
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = ((User) session.getAttribute(SESSION_USER));
        SelectorFactory factory = SelectorFactory.getInstance();
        if (request.getMethod().equalsIgnoreCase(METHOD_POST)) {
            String description = request.getParameter(PARAM_DESCRIPTION);
            String timeRegisterStr = request.getParameter(PARAM_TIME_REGISTER);
            boolean descriptionValid = factory.getValidationData().validateDescription(description);
            if (descriptionValid && !timeRegisterStr.isEmpty()) {
                if(user==null){
                    return NamePage.INFO_SESSION_INVALIDATE_PAGE.getRedirectPage();
                }
                long userId = user.getIdUser();
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
                    factory.getOrderSelector().save(order);
                } catch (SelectorException e) {
                    logger.log(Level.ERROR, "Error in CheckOutServiceCommand", e);
                    return NamePage.ERROR_PAGE.getRedirectPage();
                }

                return NamePage.INFO_CREATE_ORDER_PAGE.getRedirectPage();
            } else {
                return NamePage.MAIN_PAGE.getRedirectPage();
            }
        }
        if(user==null){
            return NamePage.SESSION_USER_INVALIDATE_PAGE.getForwardPage();
        }
        List<Car> carListForOrder;
        Department department;
        long serviceId = Long.parseLong(request.getParameter(PARAM_SERVICE_ID));
        long userId = user.getIdUser();
        try {
            carListForOrder = factory.getCarSelector().takeAllByUserId(userId);
            department = factory.getDepartmentSelector().take(serviceId);
        } catch (SelectorException e) {
            logger.log(Level.ERROR, "Error in CheckOutServiceCommand", e);
            return NamePage.ERROR_PAGE.getForwardPage();
        }
        if (carListForOrder.isEmpty()) {
            return NamePage.CREATE_CAR_PAGE.getForwardPage();
        }
        session.setAttribute(SESSION_CAR_LIST, carListForOrder);
        session.setAttribute(SESSION_DEPARTMENT, department);

        return NamePage.CHECK_OUT_SERVICE_PAGE.getForwardPage();
    }
}
