package by.htp.carservice.command.impl;

import by.htp.carservice.command.Command;
import by.htp.carservice.command.NamePage;
import by.htp.carservice.command.RequestSpliter;
import by.htp.carservice.entity.impl.Department;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.selector.SelectorFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public class EditServiceCommand implements Command {
    private static Logger logger = LogManager.getLogger();
    private static final String SESSION_DEPARTMENT_LIST = "departmentList";
    private static final String METHOD_POST = "post";
    private static final String PARAM_UPDATE = "update";
    private static final String SESSION_USER = "user";
    private static final String PARAM_ID_DEPARTMENT = "idDepartment";
    private static final String PARAM_NAME_DEPARTMENT = "namedepartment";


    @Override
    public String execute(HttpServletRequest request) {
        SelectorFactory factory = SelectorFactory.getInstance();
        HttpSession session = request.getSession();
        RequestSpliter requestSpliter = new RequestSpliter();
        User user = (User) session.getAttribute(SESSION_USER);
        if (request.getMethod().equalsIgnoreCase(METHOD_POST)) {
            if (user == null) {
                return NamePage.INFO_SESSION_INVALIDATE_PAGE.getRedirectPage();
            }
            long idDepartment = Long.parseLong(request.getParameter(PARAM_ID_DEPARTMENT));
            String nameDepartment = request.getParameter(PARAM_NAME_DEPARTMENT);

            Department department = new Department();
            department.setNameDepartment(nameDepartment);
            department.setIdDepartment(idDepartment);
            try {
                if (request.getParameter(PARAM_UPDATE) != null) {
                    factory.getDepartmentSelector().update(department);
                    return NamePage.EDIT_SERVICE_PAGE.getRedirectPage();
                }
            } catch (SelectorException e) {
                logger.log(Level.ERROR, "Error in EditServiceCommand", e);
                return NamePage.ERROR_PAGE.getRedirectPage();
            }

        }
        if (user == null) {
            return NamePage.SESSION_USER_INVALIDATE_PAGE.getForwardPage();
        }

        Map<String, String> resultSplit = requestSpliter.splitRequest(request);
        List<Department> departmentList;

        try {
            departmentList = factory.getDepartmentPaginationDataSelector().paginate(resultSplit);
        } catch (SelectorException e) {
            logger.log(Level.ERROR, "Error in EditServiceCommand", e);
            return NamePage.ERROR_PAGE.getForwardPage();
        }
        requestSpliter.splitRequestBack(request, resultSplit);
        session.setAttribute(SESSION_DEPARTMENT_LIST, departmentList);
        return NamePage.EDIT_SERVICE_PAGE.getForwardPage();
    }
}
