package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import by.htp.carservice.entity.impl.Car;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.service.ServiceFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CreateCarCommand extends AbstractCommand {
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
            ServiceFactory factory = ServiceFactory.getInstance();
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
                HttpSession session = request.getSession();
                int year = Integer.parseInt(yearStr);
                long userId = ((User) session.getAttribute(SESSION_USER)).getIdUser();
                Car car = new Car();
                car.setBrand(brand);
                car.setModel(model);
                car.setYear(year);
                car.setCodeVIN(codeVin);
                car.setFuel(fuel);
                car.setUserId(userId);
                try {
                    factory.getCarQueryReceiverService().saveQuery(car);
                } catch (CommandException e) {
                    logger.log(Level.ERROR, "Error in check login", e);
                    return new ErrorCommand().getCommandName();
                }
                return new EditCarCommand().getCommandName();
            } else {
                return new InfoCreateCarValidCommand().getCommandName();
            }
        }
        return new CreateCarCommand().getPathJsp();
    }
}
