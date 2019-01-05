package by.htp.carservice.transaction;

import by.htp.carservice.entity.impl.UserDetail;
import by.htp.carservice.exception.ServiceException;

public interface QueryReceiverUserDetail extends QueryReceiver<UserDetail> {
    boolean checkRecordQuery(long userId) throws ServiceException;
}
