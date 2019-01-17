package by.htp.carservice.command.impl;

import by.htp.carservice.command.Command;
import by.htp.carservice.command.NamePage;
import by.htp.carservice.entity.impl.Department;
import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.selector.SelectorFactory;
import by.htp.carservice.command.RequestSpliter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * The Class ServiceCommand.
 */
public class ServiceCommand implements Command {
    
    /** The logger. */
    private static Logger logger = LogManager.getLogger();
    
    /** The Constant SESSION_DEPART. */
    private static final String SESSION_DEPART = "departmentList";

    /* (non-Javadoc)
     * @see by.htp.carservice.command.Command#execute(javax.servlet.http.HttpServletRequest)
     */
    @Override
    public String execute(HttpServletRequest request) {
        SelectorFactory factory = SelectorFactory.getInstance();
        HttpSession session = request.getSession();
        RequestSpliter requestSpliter = new RequestSpliter();
        Map<String, String> resultSplit = requestSpliter.splitRequest(request);
        List<Department> departmentList;
        try {
            departmentList = factory.getDepartmentPaginationDataSelector().paginate(resultSplit);
        } catch (SelectorException e) {
            logger.log(Level.ERROR, "Error in ServiceCommand", e);
            return NamePage.ERROR_PAGE.getForwardPage();
        }
        requestSpliter.splitRequestBack(request, resultSplit);
        session.setAttribute(SESSION_DEPART, departmentList);
        return NamePage.SERVICE_PAGE.getForwardPage();
    }
}
