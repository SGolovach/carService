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

/**
 * The Class UserDetailCommand.
 */
public class UserDetailCommand implements Command {
    
    /** The logger. */
    private static Logger logger = LogManager.getLogger();
    
    /** The Constant METHOD_POST. */
    private static final String METHOD_POST = "post";
    
    /** The Constant PARAM_NAME. */
    private static final String PARAM_NAME = "name";
    
    /** The Constant PARAM_PHONE. */
    private static final String PARAM_PHONE = "phone";
    
    /** The Constant PARAM_EMAIL. */
    private static final String PARAM_EMAIL = "email";
    
    /** The Constant SESSION_USER. */
    private static final String SESSION_USER = "user";

    /* (non-Javadoc)
     * @see by.htp.carservice.command.Command#execute(javax.servlet.http.HttpServletRequest)
     */
    @Override
    public String execute(HttpServletRequest request) {
        SelectorFactory factory = SelectorFactory.getInstance();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SESSION_USER);
        if (request.getMethod().equalsIgnoreCase(METHOD_POST)) {
            if(user==null){
                return NamePage.INFO_SESSION_INVALIDATE_PAGE.getRedirectPage();
            }
            long userId = user.getIdUser();
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
                    factory.getUserDetailSelector().save(userDetail);
                    return NamePage.MAIN_PAGE.getRedirectPage();
                } catch (SelectorException e) {
                    logger.log(Level.ERROR, "Error in UserDetailCommand", e);
                    return NamePage.ERROR_PAGE.getRedirectPage();
                }
            } else {
                return NamePage.INFO_USER_DETAIL_VALID_PAGE.getRedirectPage();
            }
        }
        if(user==null){
            return NamePage.SESSION_USER_INVALIDATE_PAGE.getForwardPage();
        }
        long userId = user.getIdUser();
        try {
            if (factory.getUserDetailSelector().checkRecord(userId)) {
                return NamePage.MAIN_PAGE.getForwardPage();
            }
        } catch (SelectorException e) {
            logger.log(Level.ERROR, "Error in UserDetailCommand", e);
            return NamePage.ERROR_PAGE.getForwardPage();
        }
        return NamePage.USER_DETAIL_PAGE.getForwardPage();
    }
}
