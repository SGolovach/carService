package by.htp.carservice.pagination.impl;

import by.htp.carservice.entity.impl.Car;
import by.htp.carservice.exception.ServiceException;
import by.htp.carservice.pagination.PaginationData;
import by.htp.carservice.transaction.TransactionCar;
import by.htp.carservice.transaction.TransactionFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class CarPaginate implements PaginationData<Car> {
    private static Logger logger = LogManager.getLogger();
    private static final String PARAM_CHECK_ILLUSTRATE = "checkIllustreta";
    private static final String PARAM_CURRENT_PAGE = "currentPage";
    private static final String SESSION_CHECK_ILLUSTRATE = "checkIllustretaSession";
    private static final String SESSION_COUNT_PAGE_EDIT_CAR = "countPageSessionEditCar";
    private static final String SESSION_COUNT_PAGE_EDIT_ALL_CAR = "countPageSessionEditAllCar";
    private static final int STANDARD_CHECK_ILLUSTRATE = 10;
    private static final int MINUS_CURRENT_PAGE = 1;
    private static final String CHECK_DATA = "0";
    private final TransactionCar transactionCar = TransactionFactory.getInstance().getTransactionCar();

    @Override
    public List<Car> paginate(Map<String, String> requestParam) throws ServiceException {
        logger.log(Level.INFO, "Start method paginate class CommentPaginate");
        int checkIllustreta = Integer.parseInt(checkData(requestParam.get(PARAM_CHECK_ILLUSTRATE)));
        int currentPage = Integer.parseInt(checkData(requestParam.get(PARAM_CURRENT_PAGE)));
        int checkIllustretaSession = Integer.parseInt(checkData(requestParam.get(SESSION_CHECK_ILLUSTRATE)));
        int countPageSession = Integer.parseInt(checkData(requestParam.get(SESSION_COUNT_PAGE_EDIT_ALL_CAR)));
        List<Car> carList;
        boolean flagCountPage = false;
        if (checkIllustreta == 0 && checkIllustretaSession == 0) {
            checkIllustretaSession = STANDARD_CHECK_ILLUSTRATE;
        }
        if (checkIllustreta != 0 && checkIllustretaSession != 0) {
            checkIllustretaSession = checkIllustreta;
            flagCountPage = true;
        }
        if (countPageSession == 0 || flagCountPage) {
            int countRecord = transactionCar.countRecordTransaction();
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
        carList = transactionCar.checkAllRecordTransaction(limit, offset);
        requestParam.put(SESSION_CHECK_ILLUSTRATE, String.valueOf(checkIllustretaSession));
        requestParam.put(SESSION_COUNT_PAGE_EDIT_ALL_CAR, String.valueOf(countPageSession));
        logger.log(Level.INFO, "Finish method paginate class CommentPaginate, result = " + carList);
        return carList;
    }

    @Override
    public List<Car> paginateById(Map<String, String> requestParam, long id) throws ServiceException {
        logger.log(Level.INFO, "Start method paginateById class CommentPaginate");
        int checkIllustreta = Integer.parseInt(checkData(requestParam.get(PARAM_CHECK_ILLUSTRATE)));
        int currentPage = Integer.parseInt(checkData(requestParam.get(PARAM_CURRENT_PAGE)));
        int checkIllustretaSession = Integer.parseInt(checkData(requestParam.get(SESSION_CHECK_ILLUSTRATE)));
        int countPageSession = Integer.parseInt(checkData(requestParam.get(SESSION_COUNT_PAGE_EDIT_CAR)));
        List<Car> carList;
        boolean flagCountPage = false;
        if (checkIllustreta == 0 && checkIllustretaSession == 0) {
            checkIllustretaSession = STANDARD_CHECK_ILLUSTRATE;
        }
        if (checkIllustreta != 0 && checkIllustretaSession != 0) {
            checkIllustretaSession = checkIllustreta;
            flagCountPage = true;
        }
        if (countPageSession == 0 || flagCountPage) {
            int countRecord = transactionCar.countRecordByIdTransaction(id);
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
        carList = transactionCar.checkRecordByIdTransaction(id, limit, offset);
        requestParam.put(SESSION_CHECK_ILLUSTRATE, String.valueOf(checkIllustretaSession));
        requestParam.put(SESSION_COUNT_PAGE_EDIT_CAR, String.valueOf(countPageSession));
        logger.log(Level.INFO, "Finish method paginateById class CommentPaginate, result = " + carList);
        return carList;
    }

    private String checkData(String data) {
        if (data == null) {
            data = CHECK_DATA;
        }
        return data;
    }

}
