package by.htp.carservice.command;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActionFactory {
    private static Logger logger = LogManager.getLogger();

    public static Command defineCommand(String commandName) {
        Command current = CommandType.EMPTY.getCommand();
        if (commandName == null) {
            return current;
        }
        try {
            current = CommandType.valueOf(commandName.toUpperCase()).getCommand();
        } catch (IllegalArgumentException e) {
            logger.log(Level.ERROR, "Command not found", e);
            current = CommandType.ERROR.getCommand();
        }
        return current;
    }
}
