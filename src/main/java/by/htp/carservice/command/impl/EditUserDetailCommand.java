package by.htp.carservice.command.impl;

import by.htp.carservice.command.Command;
import by.htp.carservice.command.NamePage;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.entity.impl.UserDetail;
import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.selector.SelectorFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EditUserDetailCommand implements Command {
    private static Logger logger = LogManager.getLogger();
    private static final String METHOD_POST = "post";
    private static final String PARAM_NAME = "name";
    private static final String PARAM_PHONE = "phone";
    private static final String PARAM_EMAIL = "email";
    private static final String SESSION_USER = "user";
    private static final String SESSION_USER_DETAIL = "userDetail";
    private static final String PARAM_ID_USER_DETAIL = "idUserDetail";


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
                    factory.getUserDetailSelector().update(userDetail);
                    return NamePage.EDIT_USER_DETAIL_PAGE.getRedirectPage();
                } catch (SelectorException e) {
                    logger.log(Level.ERROR, "Error in UserDetailCommand", e);
                    return NamePage.ERROR_PAGE.getRedirectPage();
                }
            } else {
                return NamePage.INFO_USER_DETAIL_VALID_PAGE.getRedirectPage();
            }
        }
        if (user == null) {
            return NamePage.SESSION_USER_INVALIDATE_PAGE.getForwardPage();
        }
        long userId = user.getIdUser();
        UserDetail userDetail;
        try {
            userDetail = factory.getUserDetailSelector().take(userId);
        } catch (SelectorException e) {
            logger.log(Level.ERROR, "Error in UserDetailCommand", e);
            return NamePage.ERROR_PAGE.getForwardPage();
        }
        session.setAttribute(SESSION_USER_DETAIL, userDetail);
        return NamePage.EDIT_USER_DETAIL_PAGE.getForwardPage();
    }
}
