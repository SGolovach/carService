package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import by.htp.carservice.entity.impl.Comment;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.service.ServiceFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class WriteCommentCommand extends AbstractCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ServiceFactory factory = ServiceFactory.getInstance();
        if (request.getMethod().equalsIgnoreCase("post")) {
            String description = request.getParameter("description");
            User user = (User) session.getAttribute("user");
            if(user==null){
                return new InfoSessionInvalidateCommand().getCommandName();
            }
            long userId = user.getIdUser();
            Comment comment = new Comment();
            comment.setDescription(description);
            comment.setUserId(userId);
            try {
                factory.getCommentQueryService().saveQuery(comment);
            } catch (CommandException e) {
                logger.log(Level.ERROR, "Error in check login", e);
                return new ErrorCommand().getCommandName();
            }
            return new CommentCommand().getCommandName();
        }
        return new WriteCommentCommand().getPathJsp();
    }
}
