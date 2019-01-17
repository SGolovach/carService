package by.htp.carservice.command.impl;

import by.htp.carservice.command.Command;
import by.htp.carservice.command.NamePage;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * The Class InfoUserDetailValidCommand.
 */
public class InfoUserDetailValidCommand implements Command {
    
    /** The logger. */
    private static Logger logger = LogManager.getLogger();

    /* (non-Javadoc)
     * @see by.htp.carservice.command.Command#execute(javax.servlet.http.HttpServletRequest)
     */
    @Override
    public String execute(HttpServletRequest request) {
        logger.log(Level.INFO,"Method InfoUserDetailValidCommand");
        return NamePage.USER_DETAIL_VALID_PAGE.getForwardPage();
    }
}
