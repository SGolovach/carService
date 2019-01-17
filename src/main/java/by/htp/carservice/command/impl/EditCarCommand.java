package by.htp.carservice.command.impl;

import by.htp.carservice.command.Command;
import by.htp.carservice.command.NamePage;
import by.htp.carservice.entity.impl.Car;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.selector.SelectorFactory;
import by.htp.carservice.command.RequestSpliter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * The Class EditCarCommand.
 */
public class EditCarCommand implements Command {
    
    /** The logger. */
    private static Logger logger = LogManager.getLogger();
    
    /** The Constant SESSION_CAR_LIST. */
    private static final String SESSION_CAR_LIST = "carList";
    
    /** The Constant METHOD_POST. */
    private static final String METHOD_POST = "post";
    
    /** The Constant PARAM_ID_CAR. */
    private static final String PARAM_ID_CAR = "idCars";
    
    /** The Constant PARAM_BRAND. */
    private static final String PARAM_BRAND = "brand";
    
    /** The Constant PARAM_MODEL. */
    private static final String PARAM_MODEL = "model";
    
    /** The Constant PARAM_YEAR. */
    private static final String PARAM_YEAR = "year";
    
    /** The Constant PARAM_CODE_VIN. */
    private static final String PARAM_CODE_VIN = "codeVIN";
    
    /** The Constant PARAM_FUEL. */
    private static final String PARAM_FUEL = "fuel";
    
    /** The Constant PARAM_UPDATE. */
    private static final String PARAM_UPDATE = "update";
    
    /** The Constant PARAM_DELETE. */
    private static final String PARAM_DELETE = "delete";
    
    /** The Constant SESSION_USER. */
    private static final String SESSION_USER = "user";

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
            if (user == null) {
                return NamePage.INFO_SESSION_INVALIDATE_PAGE.getRedirectPage();
            }
            long userId = user.getIdUser();
            String brand = request.getParameter(PARAM_BRAND);
            String model = request.getParameter(PARAM_MODEL);
            String yearStr = request.getParameter(PARAM_YEAR);
            String codeVin = request.getParameter(PARAM_CODE_VIN);
            String fuel = request.getParameter(PARAM_FUEL);

            boolean validBrand = factory.getValidationData().validateBrand(brand);
            boolean validModel = factory.getValidationData().validateModel(model);
            boolean validYear = factory.getValidationData().validateYear(yearStr);
            boolean validCodeVin = factory.getValidationData().validateCodeVin(codeVin);
            boolean validFuel = factory.getValidationData().validateFuel(fuel);

            if (validBrand && validModel && validYear && validCodeVin && validFuel) {
                long idCar = Long.parseLong(request.getParameter(PARAM_ID_CAR));
                int year = Integer.parseInt(yearStr);
                Car car = new Car();
                car.setIdCar(idCar);
                car.setBrand(brand);
                car.setModel(model);
                car.setYear(year);
                car.setCodeVIN(codeVin);
                car.setFuel(fuel);
                car.setUserId(userId);
                try {
                    if (request.getParameter(PARAM_UPDATE) != null) {
                        factory.getCarSelector().update(car);
                        return NamePage.EDIT_CAR_PAGE.getRedirectPage();
                    } else if (request.getParameter(PARAM_DELETE) != null) {
                        factory.getCarSelector().delete(car);
                        return NamePage.EDIT_CAR_PAGE.getRedirectPage();
                    }
                } catch (SelectorException e) {
                    logger.log(Level.ERROR, "Error in check login", e);
                    return NamePage.ERROR_PAGE.getRedirectPage();
                }
            } else {
                return NamePage.INFO_CREATE_CAR_VALID_PAGE.getRedirectPage();
            }
        }
        if (user == null) {
            return NamePage.SESSION_USER_INVALIDATE_PAGE.getForwardPage();
        }
        long userId = user.getIdUser();
        Map<String, String> resultSplit = requestSpliter.splitRequest(request);
        List<Car> carList;
        try {
            carList = factory.getCarPaginationDataSelector().paginateById(resultSplit, userId);
        } catch (SelectorException e) {
            logger.log(Level.ERROR, "Error in EditCarCommand", e);
            return NamePage.ERROR_PAGE.getForwardPage();
        }

        requestSpliter.splitRequestBack(request, resultSplit);
        session.setAttribute(SESSION_CAR_LIST, carList);
        return NamePage.EDIT_CAR_PAGE.getForwardPage();
    }
}
