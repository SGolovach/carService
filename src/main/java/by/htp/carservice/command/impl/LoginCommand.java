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
import javax.servlet.http.HttpSession;
import java.util.List;

public class LoginCommand implements Command {
    private static Logger logger = LogManager.getLogger();
    private static final String METHOD_POST = "post";
    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_PASS = "password";
    private static final String SESSION_USER = "user";
    private static final String SESSION_USER_NAME = "userName";
    private static final String SESSION_ROLE_ID = "roleId";
    private static final int SESSION_INACTIVE_INTERVAL = 120;

    @Override
    public String execute(HttpServletRequest request) {
        if (request.getMethod().equalsIgnoreCase(METHOD_POST)) {
            PasswordHash hash = new PasswordHash();
            SelectorFactory factory = SelectorFactory.getInstance();
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
                    users = factory.getUserSelector().checkLogin(login, password);
                } catch (SelectorException e) {
                    logger.log(Level.ERROR, "Error in check login", e);
                    return NamePage.ERROR_PAGE.getRedirectPage();
                }

                if (!users.isEmpty()) {
                    user = users.get(0);
                    session.setAttribute(SESSION_USER, user);
                    session.setAttribute(SESSION_USER_NAME, user.getLogin());
                    session.setAttribute(SESSION_ROLE_ID, user.getRoleId());
                    session.setMaxInactiveInterval(SESSION_INACTIVE_INTERVAL);
                    return NamePage.USER_DETAIL_PAGE.getRedirectPage();
                }
                return NamePage.LOGIN_PAGE.getRedirectPage();
            } else {
                return NamePage.INFO_LOGIN_VALID_PAGE.getRedirectPage();
            }

        }
        return NamePage.LOGIN_PAGE.getForwardPage();
    }
}
