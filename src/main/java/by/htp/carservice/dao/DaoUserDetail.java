package by.htp.carservice.dao;

import by.htp.carservice.entity.impl.UserDetail;
import by.htp.carservice.exception.DaoException;

/**
 * The Interface DaoUserDetail.
 */
public interface DaoUserDetail extends BaseDao<UserDetail> {
    
    /**
     * Check record.
     *
     * @param userId the user id
     * @return true, if successful
     * @throws DaoException the dao exception
     */
    boolean checkRecord(long userId) throws DaoException;
}
