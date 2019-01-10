package by.htp.carservice.command;

import javax.servlet.http.HttpServletRequest;

/**
 * The Interface Command.
 */
public interface Command {

    /**
     * Execute.
     *
     * @param request the request
     * @return the string
     */
    String execute(HttpServletRequest request);
}
