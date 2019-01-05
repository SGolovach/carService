package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import by.htp.carservice.entity.impl.User;
import by.htp.carservice.entity.impl.UserDetail;
import by.htp.carservice.exception.CommandException;
import by.htp.carservice.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserDetailCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        long userId = ((User) session.getAttribute("user")).getIdUser();
        if (request.getMethod().equalsIgnoreCase("post")) {
            try {
                String name = request.getParameter("name");
                String phone = request.getParameter("phone");
                String email = request.getParameter("email");
                UserDetail userDetail = new UserDetail();
                userDetail.setName(name);
                userDetail.setPhone(phone);
                userDetail.setEmail(email);
                userDetail.setUserId(userId);
                factory.getUserDetailQueryReceiverService().saveQuery(userDetail);
                return new MainCommand().getCommandName();
            } catch (CommandException e) {
                e.printStackTrace();
            }
        }
        try {
            if (factory.getUserDetailQueryReceiverService().checkRecordQuery(userId)) {
                return new MainCommand().getPathJsp();
            }
        } catch (CommandException e) {
            e.printStackTrace();
        }
        return new UserDetailCommand().getPathJsp();
    }
}
