package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import by.htp.carservice.entity.impl.Department;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.service.ServiceFactory;
import by.htp.carservice.util.SplitRequestParam;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public class ServiceCommand extends AbstractCommand {
    private static Logger logger = LogManager.getLogger();
    private static final String SESSION_DEPART = "departmentList";

    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        SplitRequestParam splitRequestParam = new SplitRequestParam();
        Map<String, String> resultSplit = splitRequestParam.splitRequest(request);
        List<Department> departmentList;
        try {
            departmentList = factory.getDepartmentPaginationDataService().paginate(resultSplit);
        } catch (CommandException e) {
            logger.log(Level.ERROR, "Error in ServiceCommand", e);
            return new ErrorCommand().getPathJsp();
        }
        splitRequestParam.splitRequestBack(request, resultSplit);
        session.setAttribute(SESSION_DEPART, departmentList);
        return new ServiceCommand().getPathJsp();
    }
}
