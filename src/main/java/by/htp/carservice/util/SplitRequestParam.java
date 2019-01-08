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
    private static final String SESSION_COUNT_PAGE = "countPageSession";

    public Map<String,String> splitRequest(HttpServletRequest request){
        logger.log(Level.INFO,"Start method splitRequest");
        HttpSession session = request.getSession();
        String checkIllustrateSession = (String) session.getAttribute(SESSION_CHECK_ILLUSTRATE);
        String checkIllustrate = request.getParameter(PARAM_CHECK_ILLUSTRATE);
        String currentPage = request.getParameter(PARAM_CURRENT_PAGE);
        String countPage = (String) session.getAttribute(SESSION_COUNT_PAGE);
        Map<String,String> result = new HashMap<>();
        result.put(PARAM_CHECK_ILLUSTRATE,checkIllustrate);
        result.put(SESSION_CHECK_ILLUSTRATE,checkIllustrateSession);
        result.put(PARAM_CURRENT_PAGE,currentPage);
        result.put(SESSION_COUNT_PAGE,countPage);
        logger.log(Level.INFO,"Finish method splitRequest:" + result);
        return result;
    }

    public void splitRequestBack(HttpServletRequest request,Map<String,String> resultSplit){
        logger.log(Level.INFO,"Start method splitRequestBack");
        HttpSession session = request.getSession();
        String checkIllustrateSession = resultSplit.get(SESSION_CHECK_ILLUSTRATE);
        String countPageSession = resultSplit.get(SESSION_COUNT_PAGE);
        session.setAttribute(SESSION_CHECK_ILLUSTRATE,checkIllustrateSession);
        session.setAttribute(SESSION_COUNT_PAGE,countPageSession);
        logger.log(Level.INFO,"Finish method splitRequestBack");
    }
}
