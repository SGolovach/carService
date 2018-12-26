package by.htp.carservice.command;

public abstract class AbstractCommand implements Command{
    private static final String DIRECTORY_JSP_NAME = "/WEB-INF/jsp/";
    private static final String EXTENSION_JSP_NAME = ".jsp";
    private static final String COMMAND_NAME_WITH_ACTION =  "action?command=";
    private static final String REPLACE_NAME_COMMAND = "Command";

    @Override
    public String toString() {
        return (this.getClass().getSimpleName().replaceFirst(REPLACE_NAME_COMMAND,""));
    }

    public String getPathJsp(){
        return (DIRECTORY_JSP_NAME + this.toString().toLowerCase()+EXTENSION_JSP_NAME);
    }

    public String getCommandName(){
       return (COMMAND_NAME_WITH_ACTION + this.toString().toLowerCase());
    }
}
