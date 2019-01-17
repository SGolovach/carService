package by.htp.carservice.transaction;

import by.htp.carservice.entity.impl.UserDetail;
import by.htp.carservice.exception.ServiceException;

/**
 * The Interface TransactionUserDetail.
 */
public interface TransactionUserDetail extends Transaction<UserDetail> {
    
    /**
     * Check record transaction.
     *
     * @param userId the user id
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean checkRecordTransaction(long userId) throws ServiceException;
}
