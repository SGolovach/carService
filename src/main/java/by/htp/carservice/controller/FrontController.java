package by.htp.carservice.controller;

import by.htp.carservice.command.ActionFactory;
import by.htp.carservice.command.Command;
import by.htp.carservice.command.impl.ErrorCommand;
import by.htp.carservice.connectiondb.ConnectionPool;
import by.htp.carservice.exception.CommandException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {
    private static Logger logger = LogManager.getLogger();
    private static final String COMMAND_NAME = "command";

    @Override
    public void init() throws ServletException {
        ConnectionPool.getInstance();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        String commandName = doProcess(request);
        RequestDispatcher dispatcher = request.getRequestDispatcher(commandName);
            dispatcher.forward(request, response);
        } catch (Exception e) {
            logger.log(Level.ERROR, "Error in frontController", e);
            RequestDispatcher dispatcherError =
                    request.getRequestDispatcher(new ErrorCommand().getPathJsp());
            dispatcherError.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        String commandName = doProcess(request);
            response.sendRedirect(commandName);
        } catch (Exception e) {
            logger.log(Level.ERROR, "Error in frontController", e);
            RequestDispatcher dispatcherError =
                    request.getRequestDispatcher(new ErrorCommand().getPathJsp());
            dispatcherError.forward(request, response);
        }
    }

    private String doProcess(HttpServletRequest request) {
        Command command =
                ActionFactory.defineCommand(request.getParameter(COMMAND_NAME));
        return command.execute(request);
    }

    @Override
    public void destroy() {
        try {
            ConnectionPool.getInstance().closeConnectionPool();
        } catch (CommandException e) {
            logger.log(Level.ERROR, "ConnectionPool doesn't close", e);
        }
        super.destroy();
    }
}
