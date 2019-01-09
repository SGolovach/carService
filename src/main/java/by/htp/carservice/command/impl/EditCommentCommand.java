package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import by.htp.carservice.entity.impl.Comment;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.service.ServiceFactory;
import by.htp.carservice.util.SplitRequestParam;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public class EditCommentCommand extends AbstractCommand {
    private static Logger logger = LogManager.getLogger();
    private static final String SESSION_COMMENT_LIST = "commentList";
    private static final String METHOD_POST = "post";
    private static final String PARAM_DESCRIPTION = "description";
    private static final String PARAM_ID_COMMENT = "idComment";
    private static final String PARAM_UPDATE = "update";
    private static final String PARAM_DELETE = "delete";
    private static final String SESSION_USER = "user";
    private static final String SESSION_USER_INVALIDATE = "/WEB-INF/jsp/info/sessionInvalidate.jsp";

    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        SplitRequestParam splitRequestParam = new SplitRequestParam();
        User user = (User) session.getAttribute(SESSION_USER);
        long userId = user.getIdUser();
        if (request.getMethod().equalsIgnoreCase(METHOD_POST)) {
            if (user == null) {
                return new InfoSessionInvalidateCommand().getCommandName();
            }
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
                        factory.getCommentQueryService().updateQuery(comment);
                        return new EditCommentCommand().getCommandName();
                    } else if (request.getParameter(PARAM_DELETE) != null) {
                        factory.getCommentQueryService().deleteQuery(comment);
                        return new EditCommentCommand().getCommandName();
                    }
                } catch (CommandException e) {
                    logger.log(Level.ERROR, "Error in check login", e);
                    return new ErrorCommand().getCommandName();
                }

            } else {
                return new InfoCommentValidCommand().getCommandName();
            }
        }


        if (user == null) {
            return SESSION_USER_INVALIDATE;
        }
        Map<String, String> resultSplit = splitRequestParam.splitRequest(request);
        List<Comment> commentList;
        try {
            commentList = factory.getCommentPaginationDataService().paginateById(resultSplit, userId);
        } catch (CommandException e) {
            logger.log(Level.ERROR, "Error in EditCarCommand", e);
            return new ErrorCommand().getCommandName();
        }
        splitRequestParam.splitRequestBack(request, resultSplit);
        session.setAttribute(SESSION_COMMENT_LIST, commentList);
        return new EditCommentCommand().getPathJsp();
    }
}
