package by.htp.carservice.command.impl;

import by.htp.carservice.command.Command;
import by.htp.carservice.command.NamePage;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.util.PasswordHash;
import by.htp.carservice.selector.SelectorFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class SignupCommand implements Command {
    private static Logger logger = LogManager.getLogger();
    private static final String METHOD_POST = "post";
    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_PASS = "password";
    private static final long STANDARD_ID_USER = 2;

    @Override
    public String execute(HttpServletRequest request) {
        if (request.getMethod().equalsIgnoreCase(METHOD_POST)) {
            SelectorFactory factory = SelectorFactory.getInstance();
            PasswordHash hash = new PasswordHash();
            String login = request.getParameter(PARAM_LOGIN);
            String passwordClean = request.getParameter(PARAM_PASS);
            boolean validLogin = factory.getValidationData().validateLogin(login);
            boolean validPassword = factory.getValidationData().validatePassword(passwordClean);
            if (validLogin && validPassword) {
                try {
                    if (factory.getUserSelector().existLogin(login)) {
                        return NamePage.INFO_SIGN_UP_EXIST_PAGE.getRedirectPage();
                    }
                    String password = hash.getHashPAss(passwordClean);
                    User user = new User();
                    user.setLogin(login);
                    user.setPassword(password);
                    user.setRoleId(STANDARD_ID_USER);
                    factory.getUserSelector().save(user);
                } catch (SelectorException e) {
                    logger.log(Level.ERROR, "Error in save data", e);
                    return NamePage.ERROR_PAGE.getRedirectPage();
                }
                return NamePage.LOGIN_PAGE.getRedirectPage();
            } else {
                return NamePage.INFO_SIGN_UP_VALID_PAGE.getRedirectPage();
            }
        }
        return NamePage.SIGN_UP_PAGE.getForwardPage();
    }
}
