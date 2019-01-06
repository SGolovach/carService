package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class InfoSignUpExistCommand extends AbstractCommand {
    private static Logger logger = LogManager.getLogger();
    private static final String PAGE_EXIST_LOGIN = "/WEB-INF/jsp/info/signupexist.jsp";

    @Override
    public String execute(HttpServletRequest request) {
        logger.log(Level.INFO,"Method InfoSignUpExistCommand");
        return PAGE_EXIST_LOGIN;
    }
}
