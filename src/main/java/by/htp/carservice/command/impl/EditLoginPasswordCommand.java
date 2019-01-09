package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.service.ServiceFactory;
import by.htp.carservice.util.PasswordHash;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EditLoginPasswordCommand extends AbstractCommand {
    private static Logger logger = LogManager.getLogger();
    private static final String METHOD_POST = "post";
    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_NEW_PASS = "newpassword";
    private static final String PARAM_OLD_PASS = "oldpassword";
    private static final String SESSION_USER = "user";
    private static final String SESSION_ROLE_ID = "roleId";
    private static final String SESSION_USER_INVALIDATE = "/WEB-INF/jsp/info/sessionInvalidate.jsp";


    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SESSION_USER);
        long userId = user.getIdUser();
        if (request.getMethod().equalsIgnoreCase(METHOD_POST)) {
            if (user == null) {
                return new InfoSessionInvalidateCommand().getCommandName();
            }
            PasswordHash hash = new PasswordHash();
            String login = request.getParameter(PARAM_LOGIN);
            String passwordCleanNew = request.getParameter(PARAM_NEW_PASS);
            String passwordCleanOld = request.getParameter(PARAM_OLD_PASS);

            String passwordClean = "";
            if (passwordCleanOld == null) {
                return new EditLoginPasswordCommand().getCommandName();
            }
            String checkPasswordOld = hash.getHashPAss(passwordCleanOld);
            User userCheckPassword;
            try {
                userCheckPassword = factory.getUserQueryService().takeQuery(userId);
                System.out.println(checkPasswordOld);
                System.out.println(userCheckPassword.getPassword());
                System.out.println(checkPasswordOld.equals(userCheckPassword.getPassword()));
                if (!checkPasswordOld.equals(userCheckPassword.getPassword())) {
                    return new EditLoginPasswordCommand().getCommandName();
                }
            } catch (CommandException e) {
                logger.log(Level.ERROR, "Error in check login", e);
                return new ErrorCommand().getCommandName();
            }


            if (passwordCleanNew == null) {
                passwordClean = passwordCleanOld;
            } else {
                passwordClean = passwordCleanNew;
            }
            boolean validLogin = factory.getValidationData().validateLogin(login);
            boolean validPassword = factory.getValidationData().validatePassword(passwordClean);
            if (validLogin && validPassword) {
                long roleId = (Long)session.getAttribute(SESSION_ROLE_ID);
                String password = hash.getHashPAss(passwordClean);
                User userUpdate = new User();
                userUpdate.setRoleId(roleId);
                userUpdate.setLogin(login);
                userUpdate.setPassword(password);
                userUpdate.setIdUser(userId);
                try {
                    factory.getUserQueryService().updateQuery(userUpdate);
                } catch (CommandException e) {
                    logger.log(Level.ERROR, "Error in check login", e);
                    return new ErrorCommand().getCommandName();
                }
                return new LogOutCommand().getCommandName();
            } else {
                return new InfoLoginValidCommand().getCommandName();
            }

        }
        if (user == null) {
            return SESSION_USER_INVALIDATE;
        }
        return new EditLoginPasswordCommand().getPathJsp();
    }
}
