package by.htp.carservice.service.impl;

import by.htp.carservice.dao.QueryReceiver;
import by.htp.carservice.dao.QueryReceiverFactory;
import by.htp.carservice.entity.impl.Comment;
import by.htp.carservice.exception.ProjectException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.service.QueryReceiverService;

import java.util.List;

public class CommentReceiverService implements QueryReceiverService<Comment> {
    private final QueryReceiver<Comment> receiver =
            QueryReceiverFactory.getInstance().getCommentQueryReceiver();

    @Override
    public boolean saveQuery(Comment entity) throws ProjectException {
        boolean flagResult;
        try {
            flagResult = receiver.saveQuery(entity);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return flagResult;
    }

    @Override
    public boolean updateQuery(Comment entity) throws ProjectException {
        boolean flagResult;
        try {
            flagResult = receiver.updateQuery(entity);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return flagResult;
    }

    @Override
    public boolean deleteQuery(Comment entity) throws ProjectException {
        boolean flagResult;
        try {
            flagResult = receiver.deleteQuery(entity);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return flagResult;
    }

    @Override
    public Comment takeQuery(long id) throws ProjectException {
        Comment comment;
        try {
            comment = receiver.takeQuery(id);
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return comment;
    }

    @Override
    public List<Comment> takeAllQuery() throws ProjectException {
        List<Comment> listComment;
        try {
            listComment = receiver.takeAllQuery();
        } catch (ServiceException e) {
            throw new ProjectException(e);
        }
        return listComment;
    }
}
