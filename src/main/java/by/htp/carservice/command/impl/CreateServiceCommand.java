package by.htp.carservice.command.impl;

import by.htp.carservice.command.Command;
import by.htp.carservice.command.NamePage;
import by.htp.carservice.entity.impl.Department;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.SelectorException;
import by.htp.carservice.selector.SelectorFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * The Class CreateServiceCommand.
 */
public class CreateServiceCommand implements Command {
    
    /** The logger. */
    private static Logger logger = LogManager.getLogger();
    
    /** The Constant METHOD_POST. */
    private static final String METHOD_POST = "post";
    
    /** The Constant PARAM_NAME_DEPARTMENT. */
    private static final String PARAM_NAME_DEPARTMENT = "namedepartment";
    
    /** The Constant SESSION_USER. */
    private static final String SESSION_USER = "user";


    /* (non-Javadoc)
     * @see by.htp.carservice.command.Command#execute(javax.servlet.http.HttpServletRequest)
     */
    @Override
    public String execute(HttpServletRequest request) {
        if (request.getMethod().equalsIgnoreCase(METHOD_POST)) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute(SESSION_USER);
            if (user == null) {
                return NamePage.INFO_SESSION_INVALIDATE_PAGE.getRedirectPage();
            }
            SelectorFactory factory = SelectorFactory.getInstance();
            String nameDepartment = request.getParameter(PARAM_NAME_DEPARTMENT);
            boolean validNameDepartment = factory.getValidationData().validateName(nameDepartment);

            if (validNameDepartment) {
                Department department = new Department();
                department.setNameDepartment(nameDepartment);
                try {
                    factory.getDepartmentSelector().save(department);
                } catch (SelectorException e) {
                    logger.log(Level.ERROR, "Error in create department", e);
                    return NamePage.ERROR_PAGE.getRedirectPage();
                }
                return NamePage.SERVICE_PAGE.getRedirectPage();
            } else {
                return NamePage.INFO_CREATE_SERVICE_VALID_PAGE.getRedirectPage();
            }

        }
        return NamePage.CREATE_SERVICE_PAGE.getForwardPage();
    }
}
