package by.htp.carservice.selector;

import by.htp.carservice.entity.impl.UserDetail;
import by.htp.carservice.exception.SelectorException;

/**
 * The Interface SelectorUserDetail.
 */
public interface SelectorUserDetail extends Selector<UserDetail> {
    
    /**
     * Check record.
     *
     * @param userId the user id
     * @return true, if successful
     * @throws SelectorException the selector exception
     */
    boolean checkRecord(long userId) throws SelectorException;
}
