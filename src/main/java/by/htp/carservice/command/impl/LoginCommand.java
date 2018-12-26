package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import by.htp.carservice.command.CommandType;
import by.htp.carservice.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        if (request.getMethod().equalsIgnoreCase("post")) {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            ServiceFactory factory = ServiceFactory.getInstance();

            return new MainCommand().getCommandName();
        }
        return new LoginCommand().getPathJsp();
    }
}
