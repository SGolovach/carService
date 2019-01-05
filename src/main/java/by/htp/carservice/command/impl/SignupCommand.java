package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.hashpass.PasswordHash;
import by.htp.carservice.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SignupCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (request.getMethod().equalsIgnoreCase("post")) {
            PasswordHash hash = new PasswordHash();
            String login = request.getParameter("login");
            String password = hash.getHashPAss(request.getParameter("password"));
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setRoleId(2);
            ServiceFactory factory = ServiceFactory.getInstance();
            try {
                factory.getUserQueryReceiverService().saveQuery(user);
            } catch (CommandException e) {
                e.printStackTrace();
            }

            return new LoginCommand().getCommandName();
        }
        return new SignupCommand().getPathJsp();
    }
}
