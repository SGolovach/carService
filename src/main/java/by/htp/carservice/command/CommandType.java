package by.htp.carservice.command;

import by.htp.carservice.command.impl.*;

public enum CommandType {
    LOGIN(new LoginCommand()),
    SIGNUP(new SignupCommand()),
    MAIN(new MainCommand()),
    LOGOUT(new LogOutCommand()),
    USERDETAIL(new UserDetailCommand()),
    COMMENT(new CommentCommand()),
    WRITECOMMENT(new WriteCommentCommand()),
    SERVICE(new ServiceCommand()),
    CHECKOUTSERVICE(new CheckOutServiceCommand()),
    ACCOUNT(new AccountCommand()),
    ERROR(new ErrorCommand()),
    CHANGELOCALE(new ChangeLocaleCommand()),
    INFOSIGNUPEXIST(new InfoSignUpExistCommand()),
    INFOSIGNUPVALID(new InfoSignUpValidCommand()),
    INFOLOGINVALID(new InfoLoginValidCommand()),
    INFOCREATECARVALID(new InfoCreateCarValidCommand()),
    INFOUSERDETAILVALID(new InfoUserDetailValidCommand()),
    CREATECAR(new CreateCarCommand()),
    EDITCAR(new EditCarCommand()),
    EMPTY(new EmptyCommand());

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
