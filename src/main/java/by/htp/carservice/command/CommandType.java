package by.htp.carservice.command;

import by.htp.carservice.command.impl.*;

/**
 * The Enum CommandType.
 */
public enum CommandType {

    /**
     * The login.
     */
    LOGIN(new LoginCommand()),

    /**
     * The sign up.
     */
    SIGN_UP(new SignupCommand()),

    /**
     * The main.
     */
    MAIN(new MainCommand()),

    /**
     * The log out.
     */
    LOG_OUT(new LogOutCommand()),

    /**
     * The user detail.
     */
    USER_DETAIL(new UserDetailCommand()),

    /**
     * The comment.
     */
    COMMENT(new CommentCommand()),

    /**
     * The write comment.
     */
    WRITE_COMMENT(new WriteCommentCommand()),

    /**
     * The selector.
     */
    SERVICE(new ServiceCommand()),

    /**
     * The bill.
     */
    BILL(new BillCommand()),

    /**
     * The bill order.
     */
    BILL_ORDER(new BillOrderCommand()),

    /**
     * The check out selector.
     */
    CHECK_OUT_SERVICE(new CheckOutServiceCommand()),

    /**
     * The account.
     */
    ACCOUNT(new AccountCommand()),

    /**
     * The invoice user.
     */
    INVOICE_USER(new InvoiceUserCommand()),

    /**
     * The error.
     */
    ERROR(new ErrorCommand()),

    /**
     * The change locale.
     */
    CHANGE_LOCALE(new ChangeLocaleCommand()),

    /**
     * The info sign up exist.
     */
    INFO_SIGN_UP_EXIST(new InfoSignUpExistCommand()),

    /**
     * The info sign up valid.
     */
    INFO_SIGN_UP_VALID(new InfoSignUpValidCommand()),

    /**
     * The info login valid.
     */
    INFO_LOGIN_VALID(new InfoLoginValidCommand()),

    /**
     * The info login password.
     */
    INFO_LOGIN_PASSWORD(new InfoLoginPasswordCommand()),

    /**
     * The info create car valid.
     */
    INFO_CREATE_CAR_VALID(new InfoCreateCarValidCommand()),

    /**
     * The info user detail valid.
     */
    INFO_USER_DETAIL_VALID(new InfoUserDetailValidCommand()),

    /**
     * The info session invalidate.
     */
    INFO_SESSION_INVALIDATE(new InfoSessionInvalidateCommand()),

    /**
     * The info create order.
     */
    INFO_CREATE_ORDER(new InfoCreateOrderCommand()),

    /**
     * The info comment valid.
     */
    INFO_COMMENT_VALID(new InfoCommentValidCommand()),

    /**
     * The info create service valid.
     */
    INFO_CREATE_SERVICE_VALID(new InfoCreateServiceValidCommand()),

    /**
     * The info create service valid.
     */
    INFO_BILL_ORDER_VALID(new InfoBillOrderValidCommand()),

    /**
     * The create car.
     */
    CREATE_CAR(new CreateCarCommand()),

    /**
     * The create service.
     */
    CREATE_SERVICE(new CreateServiceCommand()),

    /**
     * The edit car.
     */
    EDIT_CAR(new EditCarCommand()),

    /**
     * The edit user detail.
     */
    EDIT_USER_DETAIL(new EditUserDetailCommand()),

    /**
     * The edit login password.
     */
    EDIT_LOGIN_PASSWORD(new EditLoginPasswordCommand()),

    /**
     * The edit comment.
     */
    EDIT_COMMENT(new EditCommentCommand()),

    /**
     * The edit order.
     */
    EDIT_ORDER(new EditOrderCommand()),

    /**
     * The show order user.
     */
    SHOW_ORDER_USER(new ShowOrderUserCommand()),

    /**
     * The empty.
     */
    EMPTY(new EmptyCommand());

    /**
     * The command.
     */
    private Command command;

    /**
     * Instantiates a new command type.
     *
     * @param command the command
     */
    CommandType(Command command) {
        this.command = command;
    }

    /**
     * Gets the command.
     *
     * @return the command
     */
    public Command getCommand() {
        return command;
    }
}
