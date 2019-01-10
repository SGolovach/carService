package by.htp.carservice.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * The Class SplitRequestParam.
 */
public class SplitRequestParam {
    
    /** The logger. */
    private static Logger logger = LogManager.getLogger();
    
    /** The Constant PARAM_CHECK_ILLUSTRATE. */
    private static final String PARAM_CHECK_ILLUSTRATE = "checkIllustreta";
    
    /** The Constant PARAM_CURRENT_PAGE. */
    private static final String PARAM_CURRENT_PAGE = "currentPage";
    
    /** The Constant SESSION_CHECK_ILLUSTRATE. */
    private static final String SESSION_CHECK_ILLUSTRATE = "checkIllustretaSession";
    
    /** The Constant SESSION_COUNT_PAGE_COMMENT. */
    private static final String SESSION_COUNT_PAGE_COMMENT = "countPageSessionComment";
    
    /** The Constant SESSION_COUNT_PAGE_COMMENT_ALL. */
    private static final String SESSION_COUNT_PAGE_COMMENT_ALL = "countPageSessionCommentAll";
    
    /** The Constant SESSION_COUNT_PAGE_EDIT_CAR. */
    private static final String SESSION_COUNT_PAGE_EDIT_CAR = "countPageSessionEditCar";
    
    /** The Constant SESSION_COUNT_PAGE_EDIT_ALL_CAR. */
    private static final String SESSION_COUNT_PAGE_EDIT_ALL_CAR = "countPageSessionEditAllCar";
    
    /** The Constant SESSION_COUNT_PAGE_EDIT_DEPARTMENT. */
    private static final String SESSION_COUNT_PAGE_EDIT_DEPARTMENT = "countPageSessionEditDepartment";
    
    /** The Constant SESSION_COUNT_PAGE_EDIT_ROLE. */
    private static final String SESSION_COUNT_PAGE_EDIT_ROLE = "countPageSessionEditRole";
    
    /** The Constant SESSION_COUNT_PAGE_EDIT_INVOICE. */
    private static final String SESSION_COUNT_PAGE_EDIT_INVOICE = "countPageSessionEditInvoice";
    
    /** The Constant SESSION_COUNT_PAGE_EDIT_ALL_INVOICE. */
    private static final String SESSION_COUNT_PAGE_EDIT_ALL_INVOICE = "countPageSessionEditAllInvoice";
    
    /** The Constant SESSION_COUNT_PAGE_EDIT_ORDER. */
    private static final String SESSION_COUNT_PAGE_EDIT_ORDER = "countPageSessionEditOrder";
    
    /** The Constant SESSION_COUNT_PAGE_EDIT_ALL_ORDER. */
    private static final String SESSION_COUNT_PAGE_EDIT_ALL_ORDER = "countPageSessionEditAllOrder";
    
    /** The Constant SESSION_COUNT_PAGE_EDIT_USER. */
    private static final String SESSION_COUNT_PAGE_EDIT_USER = "countPageSessionEditUser";
    
    /** The Constant SESSION_COUNT_PAGE_EDIT_ALL_USER. */
    private static final String SESSION_COUNT_PAGE_EDIT_ALL_USER = "countPageSessionEditAllUser";
    
    /** The Constant SESSION_COUNT_PAGE_EDIT_USER_DETAIL. */
    private static final String SESSION_COUNT_PAGE_EDIT_USER_DETAIL = "countPageSessionEditUserDetail";
    
    /** The Constant SESSION_COUNT_PAGE_EDIT_ALL_USER_DETAIL. */
    private static final String SESSION_COUNT_PAGE_EDIT_ALL_USER_DETAIL = "countPageSessionEditAllUserDetail";


    /**
     * Split request.
     *
     * @param request the request
     * @return the map
     */
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

    /**
     * Split request back.
     *
     * @param request the request
     * @param resultSplit the result split
     */
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
