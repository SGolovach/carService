package by.htp.carservice.transaction;

import by.htp.carservice.entity.impl.UserDetail;
import by.htp.carservice.exception.ServiceException;

public interface TransactionUserDetail extends Transaction<UserDetail> {
    boolean checkRecordTransaction(long userId) throws ServiceException;
}
