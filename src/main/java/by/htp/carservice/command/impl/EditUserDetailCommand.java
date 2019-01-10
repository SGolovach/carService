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

public class EditUserDetailCommand extends AbstractCommand {
    private static Logger logger = LogManager.getLogger();
    private static final String METHOD_POST = "post";
    private static final String PARAM_NAME = "name";
    private static final String PARAM_PHONE = "phone";
    private static final String PARAM_EMAIL = "email";
    private static final String SESSION_USER = "user";
    private static final String SESSION_USER_DETAIL = "userDetail";
    private static final String PARAM_ID_USER_DETAIL = "idUserDetail";
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
            long idUserDetail = Long.parseLong(request.getParameter(PARAM_ID_USER_DETAIL));
            String name = request.getParameter(PARAM_NAME);
            String phone = request.getParameter(PARAM_PHONE);
            String email = request.getParameter(PARAM_EMAIL);
            boolean validName = factory.getValidationData().validateName(name);
            boolean validPhone = factory.getValidationData().validatePhone(phone);
            boolean validEmail = factory.getValidationData().validateEmail(email);
            if (validName && validPhone && validEmail) {
                try {
                    UserDetail userDetail = new UserDetail();
                    userDetail.setIdUserDetail(idUserDetail);
                    userDetail.setName(name);
                    userDetail.setPhone(phone);
                    userDetail.setEmail(email);
                    userDetail.setUserId(userId);
                    factory.getUserDetailQueryService().updateQuery(userDetail);
                    return new EditUserDetailCommand().getCommandName();
                } catch (CommandException e) {
                    logger.log(Level.ERROR, "Error in UserDetailCommand", e);
                    return new ErrorCommand().getCommandName();
                }
            } else {
                return new InfoUserDetailValidCommand().getCommandName();
            }
        }
        if (user == null) {
            return SESSION_USER_INVALIDATE;
        }
        UserDetail userDetail;
        try {
            userDetail = factory.getUserDetailQueryService().takeQuery(userId);
        } catch (CommandException e) {
            logger.log(Level.ERROR, "Error in UserDetailCommand", e);
            return new ErrorCommand().getCommandName();
        }
        session.setAttribute(SESSION_USER_DETAIL, userDetail);
        return new EditUserDetailCommand().getPathJsp();
    }
}
