package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.entity.impl.UserDetail;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.service.ServiceFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserDetailCommand extends AbstractCommand {
    private static Logger logger = LogManager.getLogger();
    private static final String METHOD_POST = "post";
    private static final String PARAM_NAME = "name";
    private static final String PARAM_PHONE = "phone";
    private static final String PARAM_EMAIL = "email";
    private static final String SESSION_USER = "user";

    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        long userId = ((User) session.getAttribute(SESSION_USER)).getIdUser();
        if (request.getMethod().equalsIgnoreCase(METHOD_POST)) {
            String name = request.getParameter(PARAM_NAME);
            String phone = request.getParameter(PARAM_PHONE);
            String email = request.getParameter(PARAM_EMAIL);
            boolean validName = factory.getValidationData().validateName(name);
            boolean validPhone = factory.getValidationData().validatePhone(phone);
            boolean validEmail = factory.getValidationData().validateEmail(email);
            if (validName && validPhone && validEmail) {
                try {
                    UserDetail userDetail = new UserDetail();
                    userDetail.setName(name);
                    userDetail.setPhone(phone);
                    userDetail.setEmail(email);
                    userDetail.setUserId(userId);
                    factory.getUserDetailQueryReceiverService().saveQuery(userDetail);
                    return new MainCommand().getCommandName();
                } catch (CommandException e) {
                    logger.log(Level.ERROR, "Error in UserDetailCommand", e);
                    return new ErrorCommand().getCommandName();
                }
            } else {
                return new InfoUserDetailValidCommand().getCommandName();
            }
        }
        try {
            if (factory.getUserDetailQueryReceiverService().checkRecordQuery(userId)) {
                return new MainCommand().getPathJsp();
            }
        } catch (CommandException e) {
            logger.log(Level.ERROR, "Error in UserDetailCommand", e);
            return new ErrorCommand().getCommandName();
        }
        return new UserDetailCommand().getPathJsp();
    }
}
