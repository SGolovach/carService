package by.htp.carservice.transaction.imlp;

import by.htp.carservice.dao.AbstractDao;
import by.htp.carservice.dao.DaoComment;
import by.htp.carservice.dao.DaoFactory;
import by.htp.carservice.transaction.EntityTransaction;
import by.htp.carservice.exception.ConnectionPoolException;
import by.htp.carservice.exception.DaoException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.exception.TransactionException;
import by.htp.carservice.transaction.QueryComment;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CommentTransaction implements QueryComment {
    private static Logger logger = LogManager.getLogger();

    @Override
    public boolean saveQuery(by.htp.carservice.entity.impl.Comment entity) throws ServiceException {
        logger.log(Level.INFO, "Start method saveQuery entity:" + entity);
        DaoComment commentDao = DaoFactory.getInstance().getCommentDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction((AbstractDao) commentDao);
            flagResult = commentDao.save(entity);
            transaction.commit();
        } catch (DaoException | ConnectionPoolException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method saveQuery result:" + flagResult);
        return flagResult;
    }

    @Override
    public boolean updateQuery(by.htp.carservice.entity.impl.Comment entity) throws ServiceException {
        logger.log(Level.INFO, "Start method updateQuery entity:" + entity);
        DaoComment commentDao = DaoFactory.getInstance().getCommentDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction((AbstractDao) commentDao);
            flagResult = commentDao.update(entity);
            transaction.commit();
        } catch (DaoException | ConnectionPoolException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method updateQuery result:" + flagResult);
        return flagResult;
    }

    @Override
    public boolean deleteQuery(by.htp.carservice.entity.impl.Comment entity) throws ServiceException {
        logger.log(Level.INFO, "Start method deleteQuery entity:" + entity);
        DaoComment commentDao = DaoFactory.getInstance().getCommentDao();
        boolean flagResult;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.beginTransaction((AbstractDao) commentDao);
            flagResult = commentDao.delete(entity);
            transaction.commit();
        } catch (DaoException | ConnectionPoolException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method deleteQuery result:" + flagResult);
        return flagResult;
    }

    @Override
    public by.htp.carservice.entity.impl.Comment takeQuery(long id) throws ServiceException {
        logger.log(Level.INFO, "Start method takeQuery entity by id:" + id);
        DaoComment commentDao = DaoFactory.getInstance().getCommentDao();
        by.htp.carservice.entity.impl.Comment comment;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) commentDao);
            comment = commentDao.take(id);
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method takeQuery result:" + comment);
        return comment;
    }

    @Override
    public List<by.htp.carservice.entity.impl.Comment> takeAllQuery() throws ServiceException {
        logger.log(Level.INFO, "Start method takeAllQuery");
        DaoComment commentDao = DaoFactory.getInstance().getCommentDao();
        List<by.htp.carservice.entity.impl.Comment> commentList;
        EntityTransaction transaction;
        try {
            transaction = new EntityTransaction();
        } catch (ConnectionPoolException e) {
            throw new ServiceException(e);
        }
        try {
            transaction.begin((AbstractDao) commentDao);
            commentList = commentDao.takeAll();
        } catch (TransactionException | DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        logger.log(Level.INFO, "Finish method takeAllQuery result:" + commentList);
        return commentList;
    }
}