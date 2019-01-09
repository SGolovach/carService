package by.htp.carservice.service.impl;

import by.htp.carservice.entity.impl.Comment;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.pagination.PaginationData;
import by.htp.carservice.pagination.PaginationDataFactory;
import by.htp.carservice.service.PaginationDataService;

import java.util.List;
import java.util.Map;

public class CommentPaginateService implements PaginationDataService<Comment> {
    private final PaginationData pagination = PaginationDataFactory.getInstance().getCommentPagination();

    @Override
    public List<Comment> paginate(Map<String, String> requestParam) throws CommandException {
        List<Comment> commentList;
        try {
            commentList = pagination.paginate(requestParam);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return commentList;
    }

    @Override
    public List<Comment> paginateById(Map<String, String> requestParam, long id) throws CommandException {
        List<Comment> commentList;
        try {
            commentList = pagination.paginateById(requestParam, id);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return commentList;
    }
}
