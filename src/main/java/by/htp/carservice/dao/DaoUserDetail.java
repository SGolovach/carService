package by.htp.carservice.dao;

import by.htp.carservice.entity.impl.UserDetail;
import by.htp.carservice.exception.DaoException;

public interface DaoUserDetail extends BaseDao<UserDetail> {
    boolean checkRecord(long userId) throws DaoException;
}
