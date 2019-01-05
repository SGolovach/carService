package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.hashpass.PasswordHash;
import by.htp.carservice.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class LoginCommand extends AbstractCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        PasswordHash hash = new PasswordHash();
        if (request.getMethod().equalsIgnoreCase("post")) {
            String login = request.getParameter("login");
            String password = hash.getHashPAss(request.getParameter("password"));
            ServiceFactory factory = ServiceFactory.getInstance();
            User user;
            List<User> users = new ArrayList<>();
            try {
                users = factory.getUserQueryReceiverService().checkLoginQuery(login,password);
            } catch (CommandException e) {
                e.printStackTrace();
            }

            if(users.size()>0){
                user = users.get(0);
                session.setAttribute("user",user);
                session.setAttribute("userName",user.getLogin());
                session.setAttribute("roleId",user.getRoleId());
                session.setMaxInactiveInterval(120);
                return new UserDetailCommand().getCommandName();
            }

            return new LoginCommand().getCommandName();
        }
        return new LoginCommand().getPathJsp();
    }
}
