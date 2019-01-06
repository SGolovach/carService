package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.hashpass.PasswordHash;
import by.htp.carservice.service.ServiceFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class LoginCommand extends AbstractCommand {
    private static Logger logger = LogManager.getLogger();
    private static final String METHOD_POST = "post";
    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_PASS = "password";
    private static final String SESSION_USER = "user";
    private static final String SESSION_USER_NAME = "userName";
    private static final String SESSION_ROLE_ID = "roleId";

    @Override
    public String execute(HttpServletRequest request) {
        if (request.getMethod().equalsIgnoreCase(METHOD_POST)) {
            PasswordHash hash = new PasswordHash();
            ServiceFactory factory = ServiceFactory.getInstance();
            String login = request.getParameter(PARAM_LOGIN);
            String passwordClean = request.getParameter(PARAM_PASS);
            boolean validLogin = factory.getValidationData().validateLogin(login);
            boolean validPassword = factory.getValidationData().validatePassword(passwordClean);
            if (validLogin && validPassword) {
                HttpSession session = request.getSession();
                User user;
                List<User> users;
                String password = hash.getHashPAss(passwordClean);
                try {
                    users = factory.getUserQueryReceiverService().checkLoginQuery(login, password);
                } catch (CommandException e) {
                    logger.log(Level.ERROR, "Error in check login", e);
                    return new ErrorCommand().getCommandName();
                }

                if (!users.isEmpty()) {
                    user = users.get(0);
                    session.setAttribute(SESSION_USER, user);
                    session.setAttribute(SESSION_USER_NAME, user.getLogin());
                    session.setAttribute(SESSION_ROLE_ID, user.getRoleId());
                    session.setMaxInactiveInterval(120);
                    return new UserDetailCommand().getCommandName();
                }
                return new LoginCommand().getCommandName();
            } else {
                return new InfoLoginValidCommand().getCommandName();
            }

        }
        return new LoginCommand().getPathJsp();
    }
}
