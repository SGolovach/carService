package by.htp.carservice.service;

import by.htp.carservice.entity.impl.UserDetail;
import by.htp.carservice.exception.CommandException;

public interface QueryReceiverServiceUserDetail extends QueryReceiverService<UserDetail> {
    boolean checkRecordQuery(long userId) throws CommandException;
}
