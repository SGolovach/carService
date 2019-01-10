package by.htp.carservice.command;

/**
 * The Class AbstractCommand.
 */
public abstract class AbstractCommand implements Command{
    
    /** The Constant DIRECTORY_JSP_NAME. */
    private static final String DIRECTORY_JSP_NAME = "/WEB-INF/jsp/";
    
    /** The Constant EXTENSION_JSP_NAME. */
    private static final String EXTENSION_JSP_NAME = ".jsp";
    
    /** The Constant COMMAND_NAME_WITH_ACTION. */
    private static final String COMMAND_NAME_WITH_ACTION =  "action?command=";
    
    /** The Constant REPLACE_NAME_COMMAND. */
    private static final String REPLACE_NAME_COMMAND = "Command";

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return (this.getClass().getSimpleName().replaceFirst(REPLACE_NAME_COMMAND,""));
    }

    /**
     * Gets the path jsp.
     *
     * @return the path jsp
     */
    public String getPathJsp(){
        return (DIRECTORY_JSP_NAME + this.toString().toLowerCase()+EXTENSION_JSP_NAME);
    }

    /**
     * Gets the command name.
     *
     * @return the command name
     */
    public String getCommandName(){
       return (COMMAND_NAME_WITH_ACTION + this.toString().toLowerCase());
    }
}
