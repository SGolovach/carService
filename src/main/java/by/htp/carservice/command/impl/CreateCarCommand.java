package by.htp.carservice.command.impl;

import by.htp.carservice.command.Command;
import by.htp.carservice.command.NamePage;
import by.htp.carservice.entity.impl.Car;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.selector.SelectorFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CreateCarCommand implements Command {
    private static Logger logger = LogManager.getLogger();
    private static final String METHOD_POST = "post";
    private static final String PARAM_BRAND = "brand";
    private static final String PARAM_MODEL = "model";
    private static final String PARAM_YEAR = "year";
    private static final String PARAM_CODE_VIN = "codeVIN";
    private static final String PARAM_FUEL = "fuel";
    private static final String SESSION_USER = "user";

    @Override
    public String execute(HttpServletRequest request) {
        if (request.getMethod().equalsIgnoreCase(METHOD_POST)) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute(SESSION_USER);
            if (user == null) {
                return NamePage.INFO_SESSION_INVALIDATE_PAGE.getRedirectPage();
            }
            SelectorFactory factory = SelectorFactory.getInstance();
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
                int year = Integer.parseInt(yearStr);
                long userId = user.getIdUser();
                Car car = new Car();
                car.setBrand(brand);
                car.setModel(model);
                car.setYear(year);
                car.setCodeVIN(codeVin);
                car.setFuel(fuel);
                car.setUserId(userId);
                try {
                    factory.getCarSelector().save(car);
                } catch (SelectorException e) {
                    logger.log(Level.ERROR, "Error in check login", e);
                    return NamePage.ERROR_PAGE.getRedirectPage();
                }
                return NamePage.EDIT_CAR_PAGE.getRedirectPage();
            } else {
                return NamePage.INFO_CREATE_CAR_VALID_PAGE.getRedirectPage();
            }
        }
        return NamePage.CREATE_CAR_PAGE.getForwardPage();
    }
}
