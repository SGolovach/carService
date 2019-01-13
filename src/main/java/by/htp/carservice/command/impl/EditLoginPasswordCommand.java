package by.htp.carservice.command.impl;

import by.htp.carservice.command.Command;
import by.htp.carservice.command.NamePage;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.selector.SelectorFactory;
import by.htp.carservice.util.PasswordHash;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EditLoginPasswordCommand implements Command {
    private static Logger logger = LogManager.getLogger();
    private static final String METHOD_POST = "post";
    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_NEW_PASS = "newpassword";
    private static final String PARAM_OLD_PASS = "oldpassword";
    private static final String SESSION_USER = "user";
    private static final String SESSION_ROLE_ID = "roleId";

    @Override
    public String execute(HttpServletRequest request) {
        SelectorFactory factory = SelectorFactory.getInstance();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SESSION_USER);
        if (request.getMethod().equalsIgnoreCase(METHOD_POST)) {
            if (user == null) {
                return NamePage.INFO_SESSION_INVALIDATE_PAGE.getRedirectPage();
            }
            long userId = user.getIdUser();
            PasswordHash hash = new PasswordHash();
            String login = request.getParameter(PARAM_LOGIN);
            String passwordCleanNew = request.getParameter(PARAM_NEW_PASS);
            String passwordCleanOld = request.getParameter(PARAM_OLD_PASS);

            String passwordClean;
            if (passwordCleanOld == null) {
                return NamePage.EDIT_LOGIN_PASSWORD_PAGE.getRedirectPage();
            }
            String checkPasswordOld = hash.getHashPAss(passwordCleanOld);
            User userCheckPassword;
            try {
                userCheckPassword = factory.getUserSelector().take(userId);
                if (!checkPasswordOld.equals(userCheckPassword.getPassword())) {
                    return NamePage.EDIT_LOGIN_PASSWORD_PAGE.getRedirectPage();
                }
            } catch (SelectorException e) {
                logger.log(Level.ERROR, "Error in check login", e);
                return NamePage.ERROR_PAGE.getRedirectPage();
            }


            if (passwordCleanNew == null) {
                passwordClean = passwordCleanOld;
            } else {
                passwordClean = passwordCleanNew;
            }
            boolean validLogin = factory.getValidationData().validateLogin(login);
            boolean validPassword = factory.getValidationData().validatePassword(passwordClean);
            if (validLogin && validPassword) {
                long roleId = (Long) session.getAttribute(SESSION_ROLE_ID);
                String password = hash.getHashPAss(passwordClean);
                User userUpdate = new User();
                userUpdate.setRoleId(roleId);
                userUpdate.setLogin(login);
                userUpdate.setPassword(password);
                userUpdate.setIdUser(userId);
                try {
                    factory.getUserSelector().update(userUpdate);
                } catch (SelectorException e) {
                    logger.log(Level.ERROR, "Error in check login", e);
                    return NamePage.ERROR_PAGE.getRedirectPage();
                }
                return NamePage.LOG_OUT_PAGE.getRedirectPage();
            } else {
                return NamePage.INFO_LOGIN_PASSWORD_PAGE.getRedirectPage();
            }

        }
        if (user == null) {
            return NamePage.SESSION_USER_INVALIDATE_PAGE.getForwardPage();
        }
        return NamePage.EDIT_LOGIN_PASSWORD_PAGE.getForwardPage();
    }
}
