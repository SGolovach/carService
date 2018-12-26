package by.htp.carservice.transaction.imlpreceiver;

import by.htp.carservice.dao.AbstractDao;
import by.htp.carservice.dao.DaoFactory;
import by.htp.carservice.transaction.EntityTransaction;
import by.htp.carservice.transaction.QueryReceiver;
import by.htp.carservice.entity.impl.Comment;
import by.htp.carservice.exception.ConnectionPoolException;
import by.htp.carservice.exception.DaoException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.exception.TransactionException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CommentReceiver implements QueryReceiver<Comment> {
    private static Logger logger = LogManager.getLogger();

    @Override
    public boolean saveQuery(Comment entity) throws ServiceException {
        logger.log(Level.INFO,"Start method saveQuery entity:" + entity);
        AbstractDao<Comment> commentDao = DaoFactory.getInstance().getCommentDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction(commentDao);
            flagResult = commentDao.save(entity);
            transaction.commit();
        } catch (DaoException | ConnectionPoolException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO,"Finish method saveQuery result:" + flagResult);
        return flagResult;
    }

    @Override
    public boolean updateQuery(Comment entity) throws ServiceException {
        logger.log(Level.INFO,"Start method updateQuery entity:" + entity);
        AbstractDao<Comment> commentDao = DaoFactory.getInstance().getCommentDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction(commentDao);
            flagResult = commentDao.update(entity);
            transaction.commit();
        } catch (DaoException | ConnectionPoolException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO,"Finish method updateQuery result:" + flagResult);
        return flagResult;
    }

    @Override
    public boolean deleteQuery(Comment entity) throws ServiceException {
        logger.log(Level.INFO,"Start method deleteQuery entity:" + entity);
        AbstractDao<Comment> commentDao = DaoFactory.getInstance().getCommentDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction(commentDao);
            flagResult = commentDao.delete(entity);
            transaction.commit();
        } catch (DaoException | ConnectionPoolException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO,"Finish method deleteQuery result:" + flagResult);
        return flagResult;
    }

    @Override
    public Comment takeQuery(long id) throws ServiceException {
        logger.log(Level.INFO,"Start method takeQuery entity by id:" + id);
        AbstractDao<Comment> commentDao = DaoFactory.getInstance().getCommentDao();
        Comment comment;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin(commentDao);
            comment = commentDao.take(id);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO,"Finish method takeQuery result:" + comment);
        return comment;
    }

    @Override
    public List<Comment> takeAllQuery(String condition) throws ServiceException {
        logger.log(Level.INFO,"Start method takeAllQuery");
        AbstractDao<Comment> commentDao = DaoFactory.getInstance().getCommentDao();
        List<Comment> commentList;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin(commentDao);
            commentList = commentDao.takeAll(condition);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO,"Finish method takeAllQuery result:" + commentList);
        return commentList;
    }
}
