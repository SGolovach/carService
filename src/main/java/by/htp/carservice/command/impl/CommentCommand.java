package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import by.htp.carservice.entity.impl.Comment;
import by.htp.carservice.entity.impl.UserDetail;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.service.ServiceFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class CommentCommand extends AbstractCommand {
    private static Logger logger = LogManager.getLogger();
    private static final String SESSION_COMMENT = "commentList";
    private static final String SESSION_USER_LIST = "userList";

    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        List<UserDetail> userList =new ArrayList<>();
        List<Comment> commentList = null;
        try {
            commentList = factory.getCommentQueryReceiverService().takeAllQuery();
            for (Comment comment : commentList) {
                userList.add(factory.getUserDetailQueryReceiverService().takeQuery(comment.getUserId()));
            }
        } catch (CommandException e) {
            logger.log(Level.ERROR, "Error in check login", e);
            return new ErrorCommand().getCommandName();
        }
        request.getSession().setAttribute(SESSION_COMMENT,commentList);
        request.getSession().setAttribute(SESSION_USER_LIST,userList);
        return new CommentCommand().getPathJsp();
    }
}
