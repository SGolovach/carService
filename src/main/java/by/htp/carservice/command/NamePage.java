package by.htp.carservice.command;

public enum NamePage {
    DIRECTORY_JSP_NAME("/WEB-INF/jsp/"),
    EXTENSION_JSP_NAME(".jsp"),
    ACCOUNT_PAGE("account"),
    MAIN_PAGE("main"),
    LOGIN_PAGE("login"),
    SIGN_UP_PAGE("signup"),
    LOG_OUT_PAGE("logout"),
    USER_DETAIL_PAGE("userdetail"),
    COMMENT_PAGE("comment"),
    WRITE_COMMENT_PAGE("writecomment"),
    SERVICE_PAGE("service"),
    BILL_PAGE("bill"),
    BILL_ORDER_PAGE("billorder"),
    CHECK_OUT_SERVICE_PAGE("checkoutservice"),
    INVOICE_USER_PAGE("invoiceuser"),
    ERROR_PAGE("error"),
    CHANGE_LOCALE_PAGE("changelocale"),
    INFO_SIGN_UP_EXIST_PAGE("infosignupexist"),
    INFO_SIGN_UP_VALID_PAGE("infosignupvalid"),
    INFO_LOGIN_VALID_PAGE("infologinvalid"),
    INFO_LOGIN_PASSWORD_PAGE("infologinpassword"),
    INFO_CREATE_CAR_VALID_PAGE("infocreatecarvalid"),
    INFO_USER_DETAIL_VALID_PAGE("infouserdetailvalid"),
    INFO_SESSION_INVALIDATE_PAGE("infosessioninvalidate"),
    INFO_CREATE_ORDER_PAGE("infocreateorder"),
    INFO_COMMENT_VALID_PAGE("infocommentvalid"),
    INFO_CREATE_SERVICE_VALID_PAGE("infocreateservicevalid"),
    INFO_BILL_ORDER_VALID_PAGE("infobillordervalid"),
    CREATE_CAR_PAGE("createcar"),
    CREATE_SERVICE_PAGE("createservice"),
    EDIT_CAR_PAGE("editcar"),
    EDIT_USER_DETAIL_PAGE("edituserdetail"),
    EDIT_LOGIN_PASSWORD_PAGE("editloginpassword"),
    EDIT_COMMENT_PAGE("editcomment"),
    EDIT_ORDER_PAGE("editorder"),
    EDIT_SERVICE_PAGE("editservice"),
    SHOW_ORDER_USER_PAGE("showorderuser"),
    EMPTY_PAGE("empty"),
    SESSION_USER_INVALIDATE_PAGE("info/sessionInvalidate"),
    COMMENT_VALID_PAGE("info/commentvalid"),
    CREATE_CAR_VALID_PAGE("info/carcreatevalid"),
    CREATE_ORDER_PAGE("info/orderCreate"),
    LOGIN_PASSWORD_VALID_PAGE("info/loginpassvalid"),
    LOGIN_VALID_PAGE("info/loginvalid"),
    SIGN_UP_EXIST_PAGE("info/signupexist"),
    SIGN_UP_VALID_PAGE("info/signupvalid"),
    USER_DETAIL_VALID_PAGE("info/userdetailvalid"),
    CREATE_SERVICE_VALID_PAGE("info/createservice"),
    BILL_ORDER_VALID_PAGE("info/billordervalid"),
    VIEW_ALL_ORDER_PAGE("viewallorder"),
    VIEW_ALL_INVOICE_PAGE("viewallinvoice"),
    COMMAND_NAME_WITH_ACTION("action?command=");

    private String namePage;

    NamePage(String namePage) {
        this.namePage = namePage;
    }

    private String getNamePage() {
        return namePage;
    }

    public String getForwardPage() {
        return DIRECTORY_JSP_NAME.getNamePage() + namePage + EXTENSION_JSP_NAME.getNamePage();
    }

    public String getRedirectPage() {
        return COMMAND_NAME_WITH_ACTION.getNamePage() + namePage;
    }

}
