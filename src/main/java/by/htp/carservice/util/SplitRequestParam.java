package by.htp.carservice.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class SplitRequestParam {
    private static Logger logger = LogManager.getLogger();
    private static final String PARAM_CHECK_ILLUSTRATE = "checkIllustreta";
    private static final String PARAM_CURRENT_PAGE = "currentPage";
    private static final String SESSION_CHECK_ILLUSTRATE = "checkIllustretaSession";
    private static final String SESSION_COUNT_PAGE_COMMENT = "countPageSessionComment";
    private static final String SESSION_COUNT_PAGE_COMMENT_ALL = "countPageSessionCommentAll";
    private static final String SESSION_COUNT_PAGE_EDIT_CAR = "countPageSessionEditCar";
    private static final String SESSION_COUNT_PAGE_EDIT_ALL_CAR = "countPageSessionEditAllCar";
    private static final String SESSION_COUNT_PAGE_EDIT_DEPARTMENT = "countPageSessionEditDepartment";
    private static final String SESSION_COUNT_PAGE_EDIT_ROLE = "countPageSessionEditRole";
    private static final String SESSION_COUNT_PAGE_EDIT_INVOICE = "countPageSessionEditInvoice";
    private static final String SESSION_COUNT_PAGE_EDIT_ALL_INVOICE = "countPageSessionEditAllInvoice";
    private static final String SESSION_COUNT_PAGE_EDIT_ORDER = "countPageSessionEditOrder";
    private static final String SESSION_COUNT_PAGE_EDIT_ALL_ORDER = "countPageSessionEditAllOrder";
    private static final String SESSION_COUNT_PAGE_EDIT_USER = "countPageSessionEditUser";
    private static final String SESSION_COUNT_PAGE_EDIT_ALL_USER = "countPageSessionEditAllUser";
    private static final String SESSION_COUNT_PAGE_EDIT_USER_DETAIL = "countPageSessionEditUserDetail";
    private static final String SESSION_COUNT_PAGE_EDIT_ALL_USER_DETAIL = "countPageSessionEditAllUserDetail";


    public Map<String,String> splitRequest(HttpServletRequest request){
        logger.log(Level.INFO,"Start method splitRequest");
        HttpSession session = request.getSession();
        String checkIllustrateSession = (String) session.getAttribute(SESSION_CHECK_ILLUSTRATE);
        String checkIllustrate = request.getParameter(PARAM_CHECK_ILLUSTRATE);
        String currentPage = request.getParameter(PARAM_CURRENT_PAGE);
        String countPageComment = (String) session.getAttribute(SESSION_COUNT_PAGE_COMMENT);
        String countPageCommentAll = (String) session.getAttribute(SESSION_COUNT_PAGE_COMMENT_ALL);
        String countPageEditCar = (String) session.getAttribute(SESSION_COUNT_PAGE_EDIT_CAR);
        String countPageEditAllCar = (String) session.getAttribute(SESSION_COUNT_PAGE_EDIT_ALL_CAR);
        String countPageEditDepartment = (String) session.getAttribute(SESSION_COUNT_PAGE_EDIT_DEPARTMENT);
        String countPageEditRole = (String) session.getAttribute(SESSION_COUNT_PAGE_EDIT_ROLE);
        String countPageEditInvoice = (String) session.getAttribute(SESSION_COUNT_PAGE_EDIT_INVOICE);
        String countPageEditAllInvoice = (String) session.getAttribute(SESSION_COUNT_PAGE_EDIT_ALL_INVOICE);
        String countPageEditOrder = (String) session.getAttribute(SESSION_COUNT_PAGE_EDIT_ORDER);
        String countPageEditAllOrder = (String) session.getAttribute(SESSION_COUNT_PAGE_EDIT_ALL_ORDER);
        String countPageEditUser = (String) session.getAttribute(SESSION_COUNT_PAGE_EDIT_USER);
        String countPageEditAllUser = (String) session.getAttribute(SESSION_COUNT_PAGE_EDIT_ALL_USER);
        String countPageEditUserDetail = (String) session.getAttribute(SESSION_COUNT_PAGE_EDIT_USER_DETAIL);
        String countPageEditAllUserDetail = (String) session.getAttribute(SESSION_COUNT_PAGE_EDIT_ALL_USER_DETAIL);
        Map<String,String> result = new HashMap<>();
        result.put(PARAM_CHECK_ILLUSTRATE,checkIllustrate);
        result.put(SESSION_CHECK_ILLUSTRATE,checkIllustrateSession);
        result.put(PARAM_CURRENT_PAGE,currentPage);
        result.put(SESSION_COUNT_PAGE_COMMENT,countPageComment);
        result.put(SESSION_COUNT_PAGE_COMMENT_ALL,countPageCommentAll);
        result.put(SESSION_COUNT_PAGE_EDIT_CAR,countPageEditCar);
        result.put(SESSION_COUNT_PAGE_EDIT_ALL_CAR,countPageEditAllCar);
        result.put(SESSION_COUNT_PAGE_EDIT_DEPARTMENT,countPageEditDepartment);
        result.put(SESSION_COUNT_PAGE_EDIT_ROLE,countPageEditRole);
        result.put(SESSION_COUNT_PAGE_EDIT_INVOICE,countPageEditInvoice);
        result.put(SESSION_COUNT_PAGE_EDIT_ALL_INVOICE,countPageEditAllInvoice);
        result.put(SESSION_COUNT_PAGE_EDIT_ORDER,countPageEditOrder);
        result.put(SESSION_COUNT_PAGE_EDIT_ALL_ORDER,countPageEditAllOrder);
        result.put(SESSION_COUNT_PAGE_EDIT_USER,countPageEditUser);
        result.put(SESSION_COUNT_PAGE_EDIT_ALL_USER,countPageEditAllUser);
        result.put(SESSION_COUNT_PAGE_EDIT_USER_DETAIL,countPageEditUserDetail);
        result.put(SESSION_COUNT_PAGE_EDIT_ALL_USER_DETAIL,countPageEditAllUserDetail);
        logger.log(Level.INFO,"Finish method splitRequest:" + result);
        return result;
    }

    public void splitRequestBack(HttpServletRequest request,Map<String,String> resultSplit){
        logger.log(Level.INFO,"Start method splitRequestBack");
        HttpSession session = request.getSession();
        String checkIllustrateSession = resultSplit.get(SESSION_CHECK_ILLUSTRATE);
        String countPageSessionComment = resultSplit.get(SESSION_COUNT_PAGE_COMMENT);
        String countPageSessionCommentAll = resultSplit.get(SESSION_COUNT_PAGE_COMMENT_ALL);
        String countPageSessionEditCar = resultSplit.get(SESSION_COUNT_PAGE_EDIT_CAR);
        String countPageSessionEditAllCar = resultSplit.get(SESSION_COUNT_PAGE_EDIT_ALL_CAR);
        String countPageSessionEditDepartment = resultSplit.get(SESSION_COUNT_PAGE_EDIT_DEPARTMENT);
        String countPageSessionEditRole = resultSplit.get(SESSION_COUNT_PAGE_EDIT_ROLE);
        String countPageSessionEditInvoice = resultSplit.get(SESSION_COUNT_PAGE_EDIT_INVOICE);
        String countPageSessionEditAllInvoice = resultSplit.get(SESSION_COUNT_PAGE_EDIT_ALL_INVOICE);
        String countPageSessionEditOrder = resultSplit.get(SESSION_COUNT_PAGE_EDIT_ORDER);
        String countPageSessionEditAllOrder = resultSplit.get(SESSION_COUNT_PAGE_EDIT_ALL_ORDER);
        String countPageSessionEditUser = resultSplit.get(SESSION_COUNT_PAGE_EDIT_USER);
        String countPageSessionEditAllUser = resultSplit.get(SESSION_COUNT_PAGE_EDIT_ALL_USER);
        String countPageSessionEditUserDetail = resultSplit.get(SESSION_COUNT_PAGE_EDIT_USER_DETAIL);
        String countPageSessionEditAllUserDetail = resultSplit.get(SESSION_COUNT_PAGE_EDIT_ALL_USER_DETAIL);


        session.setAttribute(SESSION_CHECK_ILLUSTRATE,checkIllustrateSession);
        session.setAttribute(SESSION_COUNT_PAGE_COMMENT,countPageSessionComment);
        session.setAttribute(SESSION_COUNT_PAGE_COMMENT_ALL,countPageSessionCommentAll);
        session.setAttribute(SESSION_COUNT_PAGE_EDIT_CAR,countPageSessionEditCar);
        session.setAttribute(SESSION_COUNT_PAGE_EDIT_ALL_CAR,countPageSessionEditAllCar);
        session.setAttribute(SESSION_COUNT_PAGE_EDIT_DEPARTMENT,countPageSessionEditDepartment);
        session.setAttribute(SESSION_COUNT_PAGE_EDIT_ROLE,countPageSessionEditRole);
        session.setAttribute(SESSION_COUNT_PAGE_EDIT_INVOICE,countPageSessionEditInvoice);
        session.setAttribute(SESSION_COUNT_PAGE_EDIT_ALL_INVOICE,countPageSessionEditAllInvoice);
        session.setAttribute(SESSION_COUNT_PAGE_EDIT_ORDER,countPageSessionEditOrder);
        session.setAttribute(SESSION_COUNT_PAGE_EDIT_ALL_ORDER,countPageSessionEditAllOrder);
        session.setAttribute(SESSION_COUNT_PAGE_EDIT_USER,countPageSessionEditUser);
        session.setAttribute(SESSION_COUNT_PAGE_EDIT_ALL_USER,countPageSessionEditAllUser);
        session.setAttribute(SESSION_COUNT_PAGE_EDIT_USER_DETAIL,countPageSessionEditUserDetail);
        session.setAttribute(SESSION_COUNT_PAGE_EDIT_ALL_USER_DETAIL,countPageSessionEditAllUserDetail);
        logger.log(Level.INFO,"Finish method splitRequestBack");
    }
}
