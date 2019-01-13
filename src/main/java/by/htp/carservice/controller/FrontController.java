package by.htp.carservice.controller;

import by.htp.carservice.command.ActionFactory;
import by.htp.carservice.command.Command;
import by.htp.carservice.command.NamePage;
import by.htp.carservice.command.impl.ErrorCommand;
import by.htp.carservice.connectionpool.ConnectionPool;
import by.htp.carservice.exception.SelectorException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The Class FrontController.
 */
public class FrontController extends HttpServlet {

    /**
     * The logger.
     */
    private static Logger logger = LogManager.getLogger();

    /**
     * The Constant COMMAND_NAME.
     */
    private static final String COMMAND_NAME = "command";


    /* (non-Javadoc)
     * @see javax.servlet.GenericServlet#init()
     */
    @Override
    public void init() throws ServletException {
        ConnectionPool.getInstance();
        super.init();
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String commandName = doProcess(request);
            RequestDispatcher dispatcher = request.getRequestDispatcher(commandName);
            dispatcher.forward(request, response);
        } catch (IOException e) {
            logger.log(Level.ERROR, "Error in frontController", e);
            RequestDispatcher dispatcherError =
                    request.getRequestDispatcher(NamePage.ERROR_PAGE.getForwardPage());
            dispatcherError.forward(request, response);
        }
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String commandName = doProcess(request);
            response.sendRedirect(commandName);
        } catch (IOException e) {
            logger.log(Level.ERROR, "Error in frontController", e);
            RequestDispatcher dispatcherError =
                    request.getRequestDispatcher(NamePage.ERROR_PAGE.getForwardPage());
            dispatcherError.forward(request, response);
        }
    }

    /**
     * Do process.
     *
     * @param request the request
     * @return the string
     */
    private String doProcess(HttpServletRequest request) {
        Command command =
                ActionFactory.defineCommand(request.getParameter(COMMAND_NAME));
        return command.execute(request);
    }

    /* (non-Javadoc)
     * @see javax.servlet.GenericServlet#destroy()
     */
    @Override
    public void destroy() {
        try {
            ConnectionPool.getInstance().closeConnectionPool();
        } catch (SelectorException e) {
            logger.log(Level.ERROR, "ConnectionPool doesn't close", e);
        }
        super.destroy();
    }
}
