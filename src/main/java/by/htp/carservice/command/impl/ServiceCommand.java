package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import by.htp.carservice.entity.impl.Department;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.service.ServiceFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ServiceCommand extends AbstractCommand {
    private static Logger logger = LogManager.getLogger();
    private static final String SESSION_DEPART = "departmentList";

    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        List<Department> departmentList;
        try {
            departmentList = factory.getDepartmentQueryService().takeAllQuery();
            session.setAttribute(SESSION_DEPART, departmentList);
        } catch (CommandException e) {
            logger.log(Level.ERROR, "Error in ServiceCommand", e);
            return new ErrorCommand().getCommandName();
        }
        return new ServiceCommand().getPathJsp();
    }
}
