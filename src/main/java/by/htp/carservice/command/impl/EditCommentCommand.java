package by.htp.carservice.command.impl;

import by.htp.carservice.command.Command;
import by.htp.carservice.command.NamePage;
import by.htp.carservice.entity.impl.Comment;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.selector.SelectorFactory;
import by.htp.carservice.command.RequestSpliter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public class EditCommentCommand implements Command {
    private static Logger logger = LogManager.getLogger();
    private static final String SESSION_COMMENT_LIST = "commentList";
    private static final String METHOD_POST = "post";
    private static final String PARAM_DESCRIPTION = "description";
    private static final String PARAM_ID_COMMENT = "idComment";
    private static final String PARAM_UPDATE = "update";
    private static final String PARAM_DELETE = "delete";
    private static final String SESSION_USER = "user";

    @Override
    public String execute(HttpServletRequest request) {
        SelectorFactory factory = SelectorFactory.getInstance();
        HttpSession session = request.getSession();
        RequestSpliter requestSpliter = new RequestSpliter();
        User user = (User) session.getAttribute(SESSION_USER);
        if (request.getMethod().equalsIgnoreCase(METHOD_POST)) {
            if (user == null) {
                return NamePage.INFO_SESSION_INVALIDATE_PAGE.getRedirectPage();
            }
            long userId = user.getIdUser();
            String description = request.getParameter(PARAM_DESCRIPTION);
            boolean validDescription = factory.getValidationData().validateDescription(description);
            if (validDescription) {
                Comment comment = new Comment();
                long idComment = Long.parseLong(request.getParameter(PARAM_ID_COMMENT));
                comment.setIdComment(idComment);
                comment.setDescription(description);
                comment.setUserId(userId);
                try {
                    if (request.getParameter(PARAM_UPDATE) != null) {
                        factory.getCommentSelector().update(comment);
                        return NamePage.EDIT_COMMENT_PAGE.getRedirectPage();
                    } else if (request.getParameter(PARAM_DELETE) != null) {
                        factory.getCommentSelector().delete(comment);
                        return NamePage.EDIT_COMMENT_PAGE.getRedirectPage();
                    }
                } catch (SelectorException e) {
                    logger.log(Level.ERROR, "Error in check login", e);
                    return NamePage.ERROR_PAGE.getRedirectPage();
                }

            } else {
                return NamePage.INFO_COMMENT_VALID_PAGE.getRedirectPage();
            }
        }


        if (user == null) {
            return NamePage.SESSION_USER_INVALIDATE_PAGE.getForwardPage();
        }
        long userId = user.getIdUser();
        Map<String, String> resultSplit = requestSpliter.splitRequest(request);
        List<Comment> commentList;
        try {
            commentList = factory.getCommentPaginationDataSelector().paginateById(resultSplit, userId);
        } catch (SelectorException e) {
            logger.log(Level.ERROR, "Error in EditCarCommand", e);
            return NamePage.ERROR_PAGE.getForwardPage();
        }
        requestSpliter.splitRequestBack(request, resultSplit);
        session.setAttribute(SESSION_COMMENT_LIST, commentList);
        return NamePage.EDIT_COMMENT_PAGE.getForwardPage();
    }
}
