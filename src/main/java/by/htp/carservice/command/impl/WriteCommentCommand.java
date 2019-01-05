package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import by.htp.carservice.entity.impl.Comment;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class WriteCommentCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ServiceFactory factory = ServiceFactory.getInstance();
        if (request.getMethod().equalsIgnoreCase("post")) {
            String description = request.getParameter("description");
            User user = (User) session.getAttribute("user");
            long userId = user.getIdUser();
            Comment comment = new Comment();
            comment.setDescription(description);
            comment.setUserId(userId);
            try {
                factory.getCommentQueryReceiverService().saveQuery(comment);
            } catch (CommandException e) {
                e.printStackTrace();
            }
            return new CommentCommand().getCommandName();
        }
        return new WriteCommentCommand().getPathJsp();
    }
}
