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
import java.util.List;

public class EditCarCommand extends AbstractCommand {
    private static Logger logger = LogManager.getLogger();
    private static final String SESSION_CAR_LIST = "carList";
    private static final String SESSION_USER = "user";

    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        long userId = ((User) session.getAttribute(SESSION_USER)).getIdUser();
        List<Car> carList;

        try {
            carList = factory.getCarQueryReceiverService().takeAllByUserIdQuery(userId);
        } catch (CommandException e) {
            logger.log(Level.ERROR, "Error in EditCarCommand", e);
            return new ErrorCommand().getCommandName();
        }

        session.setAttribute(SESSION_CAR_LIST, carList);
        return new EditCarCommand().getPathJsp();
    }
}
