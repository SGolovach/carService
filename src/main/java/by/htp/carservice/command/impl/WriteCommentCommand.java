package by.htp.carservice.command.impl;

import by.htp.carservice.command.Command;
import by.htp.carservice.command.NamePage;
import by.htp.carservice.entity.impl.Comment;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.selector.SelectorFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * The Class WriteCommentCommand.
 */
public class WriteCommentCommand implements Command {
    
    /** The logger. */
    private static Logger logger = LogManager.getLogger();
    
    /** The Constant METHOD_POST. */
    private static final String METHOD_POST = "post";
    
    /** The Constant PARAM_DESCRIPTION. */
    private static final String PARAM_DESCRIPTION = "description";
    
    /** The Constant SESSION_USER. */
    private static final String SESSION_USER = "user";

    /* (non-Javadoc)
     * @see by.htp.carservice.command.Command#execute(javax.servlet.http.HttpServletRequest)
     */
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        SelectorFactory factory = SelectorFactory.getInstance();
        User user = (User) session.getAttribute(SESSION_USER);
        if (request.getMethod().equalsIgnoreCase(METHOD_POST)) {
            if (user == null) {
                return NamePage.INFO_SESSION_INVALIDATE_PAGE.getRedirectPage();
            }
            String description = request.getParameter(PARAM_DESCRIPTION);
            boolean descriptionValid = factory.getValidationData().validateDescription(description);
            if (descriptionValid) {
                long userId = user.getIdUser();
                Comment comment = new Comment();
                comment.setDescription(description);
                comment.setUserId(userId);
                try {
                    factory.getCommentSelector().save(comment);
                } catch (SelectorException e) {
                    logger.log(Level.ERROR, "Error in check login", e);
                    return NamePage.ERROR_PAGE.getRedirectPage();
                }
                return NamePage.COMMENT_PAGE.getRedirectPage();
            } else {
                return NamePage.COMMENT_VALID_PAGE.getRedirectPage();
            }

        }
        if (user == null) {
            return NamePage.SESSION_USER_INVALIDATE_PAGE.getForwardPage();
        }
        return NamePage.WRITE_COMMENT_PAGE.getForwardPage();
    }
}
