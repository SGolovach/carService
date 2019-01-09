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
    INVOICEUSER(new InvoiceUserCommand()),
    ERROR(new ErrorCommand()),
    CHANGELOCALE(new ChangeLocaleCommand()),
    INFOSIGNUPEXIST(new InfoSignUpExistCommand()),
    INFOSIGNUPVALID(new InfoSignUpValidCommand()),
    INFOLOGINVALID(new InfoLoginValidCommand()),
    INFOCREATECARVALID(new InfoCreateCarValidCommand()),
    INFOUSERDETAILVALID(new InfoUserDetailValidCommand()),
    INFOSESSIONINVALIDATE(new InfoSessionInvalidateCommand()),
    INFOCREATEORDER(new InfoCreateOrderCommand()),
    INFOCOMMENTVALID(new InfoCommentValidCommand()),
    CREATECAR(new CreateCarCommand()),
    EDITCAR(new EditCarCommand()),
    EDITUSERDETAIL(new EditUserDetailCommand()),
    EDITLOGINPASSWORD(new EditLoginPasswordCommand()),
    EDITCOMMENT(new EditCommentCommand()),
    EDITORDER(new EditOrderCommand()),
    EMPTY(new EmptyCommand());

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
