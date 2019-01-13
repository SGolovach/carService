package by.htp.carservice.selector.impl;

import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.selector.SelectorComment;
import by.htp.carservice.transaction.TransactionComment;
import by.htp.carservice.transaction.TransactionFactory;
import by.htp.carservice.entity.impl.Comment;
import by.htp.carservice.exception.ServiceException;

import java.util.List;

public class CommentSelector implements SelectorComment {
    private final TransactionComment transactionComment =
            TransactionFactory.getInstance().getTransactionComment();

    @Override
    public boolean save(Comment entity) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionComment.saveTransaction(entity);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }

    @Override
    public boolean update(Comment entity) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionComment.updateTransaction(entity);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }

    @Override
    public boolean delete(Comment entity) throws SelectorException {
        boolean flagResult;
        try {
            flagResult = transactionComment.deleteTransaction(entity);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return flagResult;
    }

    @Override
    public Comment take(long id) throws SelectorException {
        Comment comment;
        try {
            comment = transactionComment.takeTransaction(id);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return comment;
    }

    @Override
    public List<Comment> takeAll() throws SelectorException {
        List<Comment> listComment;
        try {
            listComment = transactionComment.takeAllQuery();
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return listComment;
    }

    @Override
    public int countRecord() throws SelectorException {
        int result;
        try {
            result = transactionComment.countRecordTransaction();
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return result;
    }

    @Override
    public int countRecordById(long id) throws SelectorException {
        int result;
        try {
            result = transactionComment.countRecordByIdTransaction(id);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return result;
    }

    @Override
    public List<Comment> checkAllRecord(int limit, int offset) throws SelectorException {
        List<Comment> listComment;
        try {
            listComment = transactionComment.checkAllRecordTransaction(limit, offset);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return listComment;
    }

    @Override
    public List<Comment> checkRecordById(long id, int limit, int offset) throws SelectorException {
        List<Comment> listComment;
        try {
            listComment = transactionComment.checkRecordByIdTransaction(id, limit, offset);
        } catch (ServiceException e) {
            throw new SelectorException(e);
        }
        return listComment;
    }
}
