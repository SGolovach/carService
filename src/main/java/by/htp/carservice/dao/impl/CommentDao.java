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

public class CommentDao extends AbstractDao<Comment> implements DaoComment {
    private static Logger logger = LogManager.getLogger();
    private static final String SQL_SAVE =
            "INSERT INTO comments(idComment, description, Users_id)" +
                    " VALUES(?, ?, ?)";
    private static final String SQL_UPDATE =
            "UPDATE comments SET description = ?, Users_id = ? WHERE idComment = ?";
    private static final String SQL_DELETE = "DELETE FROM comments WHERE idComment = ?";
    private static final String SQL_TAKE = " WHERE idComment = ?";
    private static final String SQL_TAKE_ALL = "SELECT * FROM comments";
    private static final String ID_COMMENT = "idComment";
    private static final String DESCRIPTION = "description";
    private static final String USER_ID = "Users_id";

    @Override
    public boolean save(Comment entity) throws DaoException {
        logger.log(Level.INFO, "Start save entity: " + entity);
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
        logger.log(Level.INFO, "Finish save entity, result: " + (flagResult >= 1));
        return (flagResult >= 1);
    }

    @Override
    public boolean update(Comment entity) throws DaoException {
        logger.log(Level.INFO, "Start update entity: " + entity);
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
        logger.log(Level.INFO, "Finish update entity, result: " + (flagResult >= 1));
        return (flagResult >= 1);
    }

    @Override
    public boolean delete(Comment entity) throws DaoException {
        logger.log(Level.INFO, "Start delete entity: " + entity);
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
        logger.log(Level.INFO, "Finish delete entity, result: " + (flagResult >= 1));
        return (flagResult >= 1);
    }

    @Override
    public Comment take(long id) throws DaoException {
        logger.log(Level.INFO, "Start take entity by id: " + id);
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
        logger.log(Level.INFO, "Finish take entity: " + comment);
        return comment;
    }

    @Override
    public List<Comment> takeAll() throws DaoException {
        logger.log(Level.INFO, "Start takeAll");
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
        logger.log(Level.INFO, "Finish takeAll. listCar: " + listComment);
        return listComment;
    }
}
