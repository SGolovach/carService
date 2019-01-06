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

public class SignupCommand extends AbstractCommand {
    private static Logger logger = LogManager.getLogger();
    private static final String METHOD_POST = "post";
    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_PASS = "password";
    private static final long STANDARD_ID_USER = 2;

    @Override
    public String execute(HttpServletRequest request) {
        if (request.getMethod().equalsIgnoreCase(METHOD_POST)) {
            ServiceFactory factory = ServiceFactory.getInstance();
            PasswordHash hash = new PasswordHash();
            String login = request.getParameter(PARAM_LOGIN);
            String passwordClean = request.getParameter(PARAM_PASS);
            boolean validLogin = factory.getValidationData().validateLogin(login);
            boolean validPassword = factory.getValidationData().validatePassword(passwordClean);
            if (validLogin && validPassword) {
                try {
                    if (factory.getUserQueryReceiverService().existLoginQuery(login)) {
                        return new InfoSignUpExistCommand().getCommandName();
                    }
                    String password = hash.getHashPAss(passwordClean);
                    User user = new User();
                    user.setLogin(login);
                    user.setPassword(password);
                    user.setRoleId(STANDARD_ID_USER);
                    factory.getUserQueryReceiverService().saveQuery(user);
                } catch (CommandException e) {
                    logger.log(Level.ERROR,"Error in save data",e);
                    return new ErrorCommand().getCommandName();
                }
                return new LoginCommand().getCommandName();
            } else {
                return new InfoSignUpValidCommand().getCommandName();
            }
        }
        return new SignupCommand().getPathJsp();
    }
}
