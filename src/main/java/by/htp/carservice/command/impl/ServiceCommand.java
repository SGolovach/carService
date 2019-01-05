package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import by.htp.carservice.entity.impl.Department;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ServiceCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        List<Department> departmentList;
        try {
            departmentList = factory.getDepartmentQueryReceiverService().takeAllQuery();
            session.setAttribute("departmentList",departmentList);
        } catch (CommandException e) {
            e.printStackTrace();
        }
        return new ServiceCommand().getPathJsp();
    }
}
