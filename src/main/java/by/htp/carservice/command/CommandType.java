package by.htp.carservice.command;

import by.htp.carservice.command.impl.EmptyCommand;
import by.htp.carservice.command.impl.LoginCommand;
import by.htp.carservice.command.impl.MainCommand;
import by.htp.carservice.command.impl.SignupCommand;

public enum CommandType {
    LOGIN(new LoginCommand()),
    SIGNUP(new SignupCommand()),
    MAIN(new MainCommand()),
    EMPTY(new EmptyCommand());

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
