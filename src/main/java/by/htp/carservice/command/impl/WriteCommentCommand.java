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

public class WriteCommentCommand implements Command {
    private static Logger logger = LogManager.getLogger();
    private static final String METHOD_POST = "post";
    private static final String PARAM_DESCRIPTION = "description";
    private static final String SESSION_USER = "user";

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
