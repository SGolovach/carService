package by.htp.carservice.dao.impl;

import by.htp.carservice.dao.AbstractDao;
import by.htp.carservice.dao.DaoComment;
import by.htp.carservice.entity.impl.Comment;
import by.htp.carservice.exception.DaoException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class CommentDao.
 */
public class CommentDao extends AbstractDao<Comment> implements DaoComment {

    /**
     * The logger.
     */
    private static Logger logger = LogManager.getLogger();

    /**
     * The Constant SQL_SAVE.
     */
    private static final String SQL_SAVE =
            "INSERT INTO comments(idComment, description, Users_id)" +
                    " VALUES(?, ?, ?)";

    /**
     * The Constant SQL_UPDATE.
     */
    private static final String SQL_UPDATE =
            "UPDATE comments SET description = ?, Users_id = ? WHERE idComment = ?";

    /**
     * The Constant SQL_DELETE.
     */
    private static final String SQL_DELETE = "DELETE FROM comments WHERE idComment = ?";

    /**
     * The Constant SQL_TAKE.
     */
    private static final String SQL_TAKE = " WHERE idComment = ?";

    /**
     * The Constant SQL_TAKE_ALL.
     */
    private static final String SQL_TAKE_ALL = "SELECT idComment, description, Users_id FROM comments";

    /**
     * The Constant SQL_COUNT_RECORD.
     */
    private static final String SQL_COUNT_RECORD = "SELECT COUNT(*) FROM comments";

    /**
     * The Constant SQL_COUNT_RECORD_ID.
     */
    private static final String SQL_COUNT_RECORD_ID = "SELECT COUNT(*) FROM comments WHERE Users_id = ?";

    /**
     * The Constant SQL_CHECK_ALL_RECORD.
     */
    private static final String SQL_CHECK_ALL_RECORD =
            "SELECT idComment, description, Users_id FROM comments LIMIT ? OFFSET ?";

    /**
     * The Constant SQL_CHECK_RECORD_ID.
     */
    private static final String SQL_CHECK_RECORD_ID =
            "SELECT idComment, description, Users_id FROM comments WHERE Users_id = ? LIMIT ? OFFSET ?";

    /**
     * The Constant ID_COMMENT.
     */
    private static final String ID_COMMENT = "idComment";

    /**
     * The Constant DESCRIPTION.
     */
    private static final String DESCRIPTION = "description";

    /**
     * The Constant USER_ID.
     */
    private static final String USER_ID = "Users_id";

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#save(java.lang.Object)
     */
    @Override
    public boolean save(Comment entity) throws DaoException {
        PreparedStatement statement = null;
        int flagResult;
        try {
            statement = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, entity.getIdComment());
            statement.setString(2, entity.getDescription());
            statement.setLong(3, entity.getUserId());
            flagResult = statement.executeUpdate();
            ResultSet generateId = statement.getGeneratedKeys();
            if (generateId.next()) {
                entity.setIdComment(generateId.getLong(1));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Result: " + (flagResult >= 1));
        return (flagResult >= 1);
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#update(java.lang.Object)
     */
    @Override
    public boolean update(Comment entity) throws DaoException {
        PreparedStatement statement = null;
        int flagResult;
        try {
            statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, entity.getDescription());
            statement.setLong(2, entity.getUserId());
            statement.setLong(3, entity.getIdComment());
            flagResult = statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Result: " + (flagResult >= 1));
        return (flagResult >= 1);
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#delete(java.lang.Object)
     */
    @Override
    public boolean delete(Comment entity) throws DaoException {
        PreparedStatement statement = null;
        int flagResult;
        try {
            statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1, entity.getIdComment());
            flagResult = statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Result: " + (flagResult >= 1));
        return (flagResult >= 1);
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#take(long)
     */
    @Override
    public Comment take(long id) throws DaoException {
        Comment comment = new Comment();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_TAKE_ALL + SQL_TAKE);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                comment.setIdComment(resultSet.getLong(ID_COMMENT));
                comment.setDescription(resultSet.getString(DESCRIPTION));
                comment.setUserId(resultSet.getLong(USER_ID));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        return comment;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#takeAll()
     */
    @Override
    public List<Comment> takeAll() throws DaoException {
        List<Comment> listComment = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_TAKE_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listComment.add(new Comment(
                        resultSet.getLong(ID_COMMENT),
                        resultSet.getString(DESCRIPTION),
                        resultSet.getLong(USER_ID)
                ));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish takeAll. listComment: " + listComment);
        return listComment;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#countRecord()
     */
    @Override
    public int countRecord() throws DaoException {
        PreparedStatement statement = null;
        int resultCount = 0;
        try {
            statement = connection.prepareStatement(SQL_COUNT_RECORD);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                resultCount = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish countRecord , result: " + resultCount);
        return resultCount;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#countRecordById(long)
     */
    @Override
    public int countRecordById(long id) throws DaoException {
        PreparedStatement statement = null;
        int resultCount = 0;
        try {
            statement = connection.prepareStatement(SQL_COUNT_RECORD_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                resultCount = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish countRecordById , result: " + resultCount);
        return resultCount;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#checkAllRecord(int, int)
     */
    @Override
    public List<Comment> checkAllRecord(int limit, int offset) throws DaoException {
        List<Comment> listComment = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_CHECK_ALL_RECORD);
            statement.setInt(1, limit);
            statement.setInt(2, offset);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listComment.add(new Comment(
                        resultSet.getLong(ID_COMMENT),
                        resultSet.getString(DESCRIPTION),
                        resultSet.getLong(USER_ID)
                ));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish checkAllRecord. listComment: " + listComment);
        return listComment;
    }

    /* (non-Javadoc)
     * @see by.htp.carservice.dao.BaseDao#checkRecordById(long, int, int)
     */
    @Override
    public List<Comment> checkRecordById(long id, int limit, int offset) throws DaoException {
        List<Comment> listComment = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_CHECK_RECORD_ID);
            statement.setLong(1, id);
            statement.setInt(2, limit);
            statement.setInt(3, offset);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listComment.add(new Comment(
                        resultSet.getLong(ID_COMMENT),
                        resultSet.getString(DESCRIPTION),
                        resultSet.getLong(USER_ID)
                ));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        logger.log(Level.INFO, "Finish checkRecordById. listComment: " + listComment);
        return listComment;
    }
}
