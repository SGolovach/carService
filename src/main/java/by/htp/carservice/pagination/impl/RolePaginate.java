package by.htp.carservice.pagination.impl;

import by.htp.carservice.entity.impl.Role;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.pagination.PaginationData;
import by.htp.carservice.service.ServiceFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class RolePaginate implements PaginationData<Role> {
    private static Logger logger = LogManager.getLogger();
    private static final String PARAM_CHECK_ILLUSTRATE = "checkIllustreta";
    private static final String PARAM_CURRENT_PAGE = "currentPage";
    private static final String SESSION_CHECK_ILLUSTRATE = "checkIllustretaSession";
    private static final String SESSION_COUNT_PAGE_EDIT_ROLE = "countPageSessionEditRole";
    private static final int STANDARD_CHECK_ILLUSTRATE = 10;
    private static final int MINUS_CURRENT_PAGE = 1;
    private static final String CHECK_DATA = "0";

    @Override
    public List<Role> paginate(Map<String, String> requestParam) throws ServiceException {
        logger.log(Level.INFO, "Start method paginate class RolePaginate");
        ServiceFactory factory = ServiceFactory.getInstance();
        int checkIllustreta = Integer.parseInt(checkData(requestParam.get(PARAM_CHECK_ILLUSTRATE)));
        int currentPage = Integer.parseInt(checkData(requestParam.get(PARAM_CURRENT_PAGE)));
        int checkIllustretaSession = Integer.parseInt(checkData(requestParam.get(SESSION_CHECK_ILLUSTRATE)));
        int countPageSession = Integer.parseInt(checkData(requestParam.get(SESSION_COUNT_PAGE_EDIT_ROLE)));
        List<Role> roleList;
        boolean flagCountPage = false;
        try {
            if (checkIllustreta == 0 && checkIllustretaSession == 0) {
                checkIllustretaSession = STANDARD_CHECK_ILLUSTRATE;
            }
            if (checkIllustreta != 0 && checkIllustretaSession != 0) {
                checkIllustretaSession = checkIllustreta;
                flagCountPage = true;
            }
            if (countPageSession == 0 || flagCountPage) {
                int countRecord = factory.getRoleQueryService().countRecordQuery();
                int modCountrecord = countRecord % checkIllustretaSession;
                countPageSession = countRecord / checkIllustretaSession;
                if (modCountrecord > 0) {
                    countPageSession++;
                }
            }
            if (currentPage == 0) {
                currentPage++;
            }
            int offset = (currentPage - MINUS_CURRENT_PAGE) * checkIllustretaSession;
            int limit = checkIllustretaSession;
            roleList = factory.getRoleQueryService().checkAllRecordQuery(limit, offset);
            requestParam.put(SESSION_CHECK_ILLUSTRATE, String.valueOf(checkIllustretaSession));
            requestParam.put(SESSION_COUNT_PAGE_EDIT_ROLE, String.valueOf(countPageSession));
        } catch (CommandException e) {
            throw new ServiceException(e);
        }
        logger.log(Level.INFO, "Finish method paginate class RolePaginate, result = " + roleList);
        return roleList;
    }

    @Override
    public List<Role> paginateById(Map<String, String> requestParam, long id) throws ServiceException {
        return paginate(requestParam);
    }

    private String checkData(String data) {
        if (data == null) {
            data = CHECK_DATA;
        }
        return data;
    }
}
