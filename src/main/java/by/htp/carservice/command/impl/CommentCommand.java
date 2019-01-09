package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import by.htp.carservice.entity.impl.Comment;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.service.ServiceFactory;
import by.htp.carservice.util.SplitRequestParam;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class CommentCommand extends AbstractCommand {
    private static Logger logger = LogManager.getLogger();
    private static final String SESSION_COMMENT = "commentList";

    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        SplitRequestParam splitRequestParam = new SplitRequestParam();
        Map<String, String> resultSplit = splitRequestParam.splitRequest(request);
        List<Comment> commentList;
        try {
            commentList=factory.getCommentPaginationDataService().paginate(resultSplit);
        } catch (CommandException e) {
            logger.log(Level.ERROR, "Error in check login", e);
            return new ErrorCommand().getPathJsp();
        }
        splitRequestParam.splitRequestBack(request, resultSplit);
        request.getSession().setAttribute(SESSION_COMMENT, commentList);
        return new CommentCommand().getPathJsp();
    }
}
