package by.htp.carservice.command.impl;

import by.htp.carservice.command.AbstractCommand;
import by.htp.carservice.local.MessageManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class LogOutCommand extends AbstractCommand {
    private static Logger logger = LogManager.getLogger();
    private static final String BUNDEL_NAME = "bundel";

    @Override
    public String execute(HttpServletRequest request) {
        logger.log(Level.INFO,"Start method LogOutCommand");
        request.getSession().invalidate();
        MessageManager bundelMessage = MessageManager.EN;
        request.getSession().setAttribute(BUNDEL_NAME, bundelMessage);
        return new MainCommand().getPathJsp();
    }
}
