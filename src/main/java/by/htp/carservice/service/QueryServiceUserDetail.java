package by.htp.carservice.service;

import by.htp.carservice.entity.impl.UserDetail;
import by.htp.carservice.exception.CommandException;

public interface QueryServiceUserDetail extends QueryService<UserDetail> {
    boolean checkRecordQuery(long userId) throws CommandException;
}
