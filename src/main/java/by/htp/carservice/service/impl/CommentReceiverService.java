package by.htp.carservice.service.impl;

import by.htp.carservice.exception.CommandException;
import by.htp.carservice.service.QueryReceiverServiceComment;
import by.htp.carservice.transaction.QueryReceiverComment;
import by.htp.carservice.transaction.QueryReceiverFactory;
import by.htp.carservice.entity.impl.Comment;
import by.htp.carservice.exception.ServiceException;

import java.util.List;

public class CommentReceiverService implements QueryReceiverServiceComment {
    private final QueryReceiverComment receiver =
            QueryReceiverFactory.getInstance().getCommentQueryReceiver();

    @Override
    public boolean saveQuery(Comment entity) throws CommandException {
        boolean flagResult;
        try {
            flagResult = receiver.saveQuery(entity);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return flagResult;
    }

    @Override
    public boolean updateQuery(Comment entity) throws CommandException {
        boolean flagResult;
        try {
            flagResult = receiver.updateQuery(entity);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return flagResult;
    }

    @Override
    public boolean deleteQuery(Comment entity) throws CommandException {
        boolean flagResult;
        try {
            flagResult = receiver.deleteQuery(entity);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return flagResult;
    }

    @Override
    public Comment takeQuery(long id) throws CommandException {
        Comment comment;
        try {
            comment = receiver.takeQuery(id);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return comment;
    }

    @Override
    public List<Comment> takeAllQuery() throws CommandException {
        List<Comment> listComment;
        try {
            listComment = receiver.takeAllQuery();
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return listComment;
    }
}
