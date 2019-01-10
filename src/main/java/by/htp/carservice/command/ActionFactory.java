package by.htp.carservice.command;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A factory for creating Action objects.
 */
public class ActionFactory {
    
    /** The logger. */
    private static Logger logger = LogManager.getLogger();
    
    /** The Constant PATTERN_COMMAND. */
    private static final String PATTERN_COMMAND = "_";
    
    /** The Constant REPLACE_COMMAND. */
    private static final String REPLACE_COMMAND = "";

    /**
     * Define command.
     *
     * @param commandName the command name
     * @return the command
     */
    public static Command defineCommand(String commandName) {
        logger.log(Level.INFO, "Start defineCommand with commandName = " + commandName);
        Command current = CommandType.EMPTY.getCommand();
        if (commandName == null) {
            return current;
        }
        current = getCommandWithString(commandName);
        logger.log(Level.INFO, "Finish defineCommand with command = " + current.getClass());
        return current;
    }

    /**
     * Gets the command with string.
     *
     * @param commandName the command name
     * @return the command
     */
    private static Command getCommandWithString(String commandName) {
        logger.log(Level.INFO, "Start getCommandWithString with commandName = " + commandName);
        Command command = null;
        for (CommandType value : CommandType.values()) {
            if (value.toString().replaceAll(PATTERN_COMMAND, REPLACE_COMMAND).equalsIgnoreCase(commandName)) {
                command = value.getCommand();
            }
        }
        if (command == null) {
            command = CommandType.ERROR.getCommand();
            logger.log(Level.ERROR, "Command not found, commandName = " + commandName);
        }
        logger.log(Level.INFO, "Finish getCommandWithString with command = " + command.getClass());
        return command;
    }
}
