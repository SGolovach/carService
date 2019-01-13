package by.htp.carservice.selector.impl;

import by.htp.carservice.entity.impl.Comment;
import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.pagination.PaginationData;
import by.htp.carservice.pagination.PaginationDataFactory;
import by.htp.carservice.selector.PaginationDataSelector;

import java.util.List;
import java.util.Map;

public class CommentPaginateSelector implements PaginationDataSelector<Comment> {
    private final PaginationData pagination = PaginationDataFactory.getInstance().getCommentPagination();

    @Override
    public List<Comment> paginate(Map<String, String> requestParam) throws SelectorException {
        List<Comment> commentList;
        try {
            commentList = pagination.paginate(requestParam);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return commentList;
    }

    @Override
    public List<Comment> paginateById(Map<String, String> requestParam, long id) throws SelectorException {
        List<Comment> commentList;
        try {
            commentList = pagination.paginateById(requestParam, id);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return commentList;
    }
}
