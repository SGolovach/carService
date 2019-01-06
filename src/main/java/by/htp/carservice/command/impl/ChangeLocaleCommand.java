package by.htp.carservice.command.impl;


import by.htp.carservice.command.AbstractCommand;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class ChangeLocaleCommand extends AbstractCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        logger.log(Level.INFO,"Start method ChangeLocaleCommand");
        return new MainCommand().getPathJsp();
    }
}
