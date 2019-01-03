package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.exception.ProjectException;
import by.htp.carservice.hashpass.PasswordHash;
import by.htp.carservice.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class LoginCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        if (request.getMethod().equalsIgnoreCase("post")) {
            PasswordHash hash = new PasswordHash();
            String login = request.getParameter("login");
            String password = hash.getHashPAss(request.getParameter("password"));
            String where = String.format("WHERE login='%s' AND password='%s'", login, password);
            ServiceFactory factory = ServiceFactory.getInstance();
            User user;
            List<User> users = new ArrayList<>();
            try {
                users = factory.getUserQueryReceiverService().takeAllQuery(where);
            } catch (ProjectException e) {
                e.printStackTrace();
            }

            if(users.size()>0){
                user = users.get(0);
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
                session.setAttribute("userName",user.getLogin());
                session.setAttribute("roleId",user.getRoleId());
                session.setMaxInactiveInterval(120);
                return new MainCommand().getCommandName();
            }

            return new LoginCommand().getCommandName();
        }
        return new LoginCommand().getPathJsp();
    }
}
