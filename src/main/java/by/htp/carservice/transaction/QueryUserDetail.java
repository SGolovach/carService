package by.htp.carservice.transaction;

import by.htp.carservice.entity.impl.UserDetail;
import by.htp.carservice.exception.ServiceException;

public interface QueryUserDetail extends Query<UserDetail> {
    boolean checkRecordQuery(long userId) throws ServiceException;
}
