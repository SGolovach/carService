package by.htp.carservice.service.impl;

import by.htp.carservice.dao.BaseDao;
import by.htp.carservice.dao.DaoFactory;
import by.htp.carservice.entity.impl.Comment;
import by.htp.carservice.service.DaoService;

import java.util.List;

public class CommentDaoService implements DaoService<Comment> {
    private final BaseDao<Comment> dao = DaoFactory.getInstance().getCommentDao();

    @Override
    public boolean save(Comment entity) {
        return dao.save(entity);
    }

    @Override
    public boolean update(Comment entity) {
        return dao.update(entity);
    }

    @Override
    public boolean delete(Comment entity) {
        return dao.delete(entity);
    }

    @Override
    public Comment take(long id) {
        return dao.take(id);
    }

    @Override
    public List<Comment> takeAll(String condition) {
        return dao.takeAll(condition);
    }
}
