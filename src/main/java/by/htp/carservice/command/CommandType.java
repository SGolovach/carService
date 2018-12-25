package by.htp.carservice.command;

import by.htp.carservice.command.impl.EmptyCommand;
import by.htp.carservice.command.impl.LoginCommand;

public enum CommandType {
    LOGIN(new LoginCommand()),
    EMPTY(new EmptyCommand());

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
