package by.htp.carservice.controller;

import by.htp.carservice.command.ActionFactory;
import by.htp.carservice.command.Command;
import by.htp.carservice.dao.ConnectionPool;
import by.htp.carservice.exception.ProjectException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Command command = ActionFactory.defineCommand(req.getParameter("command"));
        String page = command.execute(req);

        if(page!=null){
            RequestDispatcher dispatcher = req.getRequestDispatcher(page);
            dispatcher.forward(req,resp);
        } else {
            resp.sendRedirect("/index.jsp");
        }

        super.doPost(req, resp);
    }

    @Override
    public void destroy() {
        try {
            ConnectionPool.getInstance().closeConnectionPool();
        } catch (ProjectException e) {
            e.printStackTrace();
        }

        super.destroy();
    }
}
