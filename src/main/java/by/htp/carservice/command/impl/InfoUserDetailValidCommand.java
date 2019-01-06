package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class InfoUserDetailValidCommand extends AbstractCommand {
    private static Logger logger = LogManager.getLogger();
    private static final String PAGE_VALIDATE = "/WEB-INF/jsp/info/userdetailvalid.jsp";

    @Override
    public String execute(HttpServletRequest request) {
        logger.log(Level.INFO,"Method InfoUserDetailValidCommand");
        return PAGE_VALIDATE;
    }
}
