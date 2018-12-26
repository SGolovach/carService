package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.ProjectException;
import by.htp.carservice.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;

public class SignupCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        if (request.getMethod().equalsIgnoreCase("post")) {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setRoleId(2);
            ServiceFactory factory = ServiceFactory.getInstance();
            boolean flag = false;
            try {
                flag = factory.getUserQueryReceiverService().saveQuery(user);
            } catch (ProjectException e) {
                e.printStackTrace();
            }

            return new LoginCommand().getCommandName();
        }
        return new SignupCommand().getPathJsp();
    }
}
