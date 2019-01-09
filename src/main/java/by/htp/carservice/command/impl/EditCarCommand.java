package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import by.htp.carservice.entity.impl.Car;
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

public class EditCarCommand extends AbstractCommand {
    private static Logger logger = LogManager.getLogger();
    private static final String SESSION_CAR_LIST = "carList";
    private static final String METHOD_POST = "post";
    private static final String PARAM_ID_CAR = "idCars";
    private static final String PARAM_BRAND = "brand";
    private static final String PARAM_MODEL = "model";
    private static final String PARAM_YEAR = "year";
    private static final String PARAM_CODE_VIN = "codeVIN";
    private static final String PARAM_FUEL = "fuel";
    private static final String PARAM_UPDATE = "update";
    private static final String PARAM_DELETE = "delete";
    private static final String SESSION_USER = "user";
    private static final String SESSION_USER_INVALIDATE = "/WEB-INF/jsp/info/sessionInvalidate.jsp";

    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        SplitRequestParam splitRequestParam = new SplitRequestParam();
        User user = (User) session.getAttribute(SESSION_USER);
        long userId = user.getIdUser();
        if (request.getMethod().equalsIgnoreCase(METHOD_POST)) {
            if (user == null) {
                return new InfoSessionInvalidateCommand().getCommandName();
            }
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
                        factory.getCarQueryService().updateQuery(car);
                        return new EditCarCommand().getCommandName();
                    } else if (request.getParameter(PARAM_DELETE) != null) {
                        factory.getCarQueryService().deleteQuery(car);
                        return new EditCarCommand().getCommandName();
                    }
                } catch (CommandException e) {
                    logger.log(Level.ERROR, "Error in check login", e);
                    return new ErrorCommand().getCommandName();
                }
            } else {
                return new InfoCreateCarValidCommand().getCommandName();
            }
        }
        if (user == null) {
            return SESSION_USER_INVALIDATE;
        }
        Map<String, String> resultSplit = splitRequestParam.splitRequest(request);
        List<Car> carList;
        try {
            carList = factory.getCarPaginationDataService().paginateById(resultSplit, userId);
        } catch (CommandException e) {
            logger.log(Level.ERROR, "Error in EditCarCommand", e);
            return new ErrorCommand().getPathJsp();
        }

        splitRequestParam.splitRequestBack(request, resultSplit);
        session.setAttribute(SESSION_CAR_LIST, carList);
        return new EditCarCommand().getPathJsp();
    }
}
