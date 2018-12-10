package by.htp.carservice.dao.impl;

import by.htp.carservice.dao.BaseDao;
import by.htp.carservice.entity.impl.Comment;

import java.util.List;

public class CommentDao implements BaseDao<Comment> {
    @Override
    public boolean save(Comment entity) {
        return false;
    }

    @Override
    public boolean update(Comment entity) {
        return false;
    }

    @Override
    public boolean delete(Comment entity) {
        return false;
    }

    @Override
    public Comment take(long id) {
        return null;
    }

    @Override
    public List<Comment> takeAll(String condition) {
        return null;
    }
}
