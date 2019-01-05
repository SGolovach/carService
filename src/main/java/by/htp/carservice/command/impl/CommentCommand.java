package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import by.htp.carservice.entity.impl.Comment;
import by.htp.carservice.entity.impl.UserDetail;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class CommentCommand extends AbstractCommand {
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
            e.printStackTrace();
        }
        request.getSession().setAttribute("commentList",commentList);
        request.getSession().setAttribute("userList",userList);
        return new CommentCommand().getPathJsp();
    }
}
