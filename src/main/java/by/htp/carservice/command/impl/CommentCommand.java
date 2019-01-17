package by.htp.carservice.command.impl;

import by.htp.carservice.command.Command;
import by.htp.carservice.command.NamePage;
import by.htp.carservice.command.RequestSpliter;
import by.htp.carservice.entity.impl.Comment;
import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.selector.SelectorFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * The Class CommentCommand.
 */
public class CommentCommand implements Command {
    
    /** The logger. */
    private static Logger logger = LogManager.getLogger();
    
    /** The Constant SESSION_COMMENT. */
    private static final String SESSION_COMMENT = "commentList";

    /* (non-Javadoc)
     * @see by.htp.carservice.command.Command#execute(javax.servlet.http.HttpServletRequest)
     */
    @Override
    public String execute(HttpServletRequest request) {
        SelectorFactory factory = SelectorFactory.getInstance();
        RequestSpliter requestSpliter = new RequestSpliter();
        Map<String, String> resultSplit = requestSpliter.splitRequest(request);
        List<Comment> commentList;
        try {
            commentList=factory.getCommentPaginationDataSelector().paginate(resultSplit);
        } catch (SelectorException e) {
            logger.log(Level.ERROR, "Error in check login", e);
            return NamePage.ERROR_PAGE.getForwardPage();
        }
        requestSpliter.splitRequestBack(request, resultSplit);
        request.getSession().setAttribute(SESSION_COMMENT, commentList);
        return NamePage.COMMENT_PAGE.getForwardPage();
    }
}
