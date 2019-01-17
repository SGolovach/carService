package by.htp.carservice.selector.impl;

import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.selector.SelectorComment;
import by.htp.carservice.transaction.TransactionComment;
import by.htp.carservice.transaction.TransactionFactory;
import by.htp.carservice.entity.impl.Comment;
import by.htp.carservice.exception.ServiceException;

import java.util.List;

/**
 * The Class CommentSelector.
 */
public class CommentSelector implements SelectorComment {
    
    /** The transaction comment. */
    private final TransactionComment transactionComment =
            TransactionFactory.getInstance().getTransactionComment();

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#save(by.htp.carservice.entity.Entity)
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#update(by.htp.carservice.entity.Entity)
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#delete(by.htp.carservice.entity.Entity)
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#take(long)
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#takeAll()
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#countRecord()
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#countRecordById(long)
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#checkAllRecord(int, int)
     */
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

    /* (non-Javadoc)
     * @see by.htp.carservice.selector.Selector#checkRecordById(long, int, int)
     */
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
