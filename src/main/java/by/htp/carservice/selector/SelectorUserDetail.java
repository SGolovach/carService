package by.htp.carservice.selector;

import by.htp.carservice.entity.impl.UserDetail;
import by.htp.carservice.exception.SelectorException;

public interface SelectorUserDetail extends Selector<UserDetail> {
    boolean checkRecord(long userId) throws SelectorException;
}
