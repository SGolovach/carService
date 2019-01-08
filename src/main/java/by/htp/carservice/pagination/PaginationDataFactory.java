package by.htp.carservice.pagination;

import by.htp.carservice.entity.impl.Comment;
import by.htp.carservice.pagination.impl.CommentPaginate;

public class PaginationDataFactory {

    PaginationData<Comment> commentPagination = new CommentPaginate();

    private static class PaginationDataFactoryHolder {
        private static final PaginationDataFactory INSTANCE = new PaginationDataFactory();
    }

    public static PaginationDataFactory getInstance() {
        return PaginationDataFactoryHolder.INSTANCE;
    }

    public PaginationData<Comment> getCommentPagination() {
        return commentPagination;
    }
}
