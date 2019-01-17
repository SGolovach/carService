package by.htp.carservice.command;

/**
 * The Enum NamePage.
 */
public enum NamePage {
    
    /** The directory jsp name. */
    DIRECTORY_JSP_NAME("/WEB-INF/jsp/"),
    
    /** The extension jsp name. */
    EXTENSION_JSP_NAME(".jsp"),
    
    /** The account page. */
    ACCOUNT_PAGE("account"),
    
    /** The main page. */
    MAIN_PAGE("main"),
    
    /** The login page. */
    LOGIN_PAGE("login"),
    
    /** The sign up page. */
    SIGN_UP_PAGE("signup"),
    
    /** The log out page. */
    LOG_OUT_PAGE("logout"),
    
    /** The user detail page. */
    USER_DETAIL_PAGE("userdetail"),
    
    /** The comment page. */
    COMMENT_PAGE("comment"),
    
    /** The write comment page. */
    WRITE_COMMENT_PAGE("writecomment"),
    
    /** The service page. */
    SERVICE_PAGE("service"),
    
    /** The bill page. */
    BILL_PAGE("bill"),
    
    /** The bill order page. */
    BILL_ORDER_PAGE("billorder"),
    
    /** The check out service page. */
    CHECK_OUT_SERVICE_PAGE("checkoutservice"),
    
    /** The invoice user page. */
    INVOICE_USER_PAGE("invoiceuser"),
    
    /** The error page. */
    ERROR_PAGE("error"),
    
    /** The change locale page. */
    CHANGE_LOCALE_PAGE("changelocale"),
    
    /** The info sign up exist page. */
    INFO_SIGN_UP_EXIST_PAGE("infosignupexist"),
    
    /** The info sign up valid page. */
    INFO_SIGN_UP_VALID_PAGE("infosignupvalid"),
    
    /** The info login valid page. */
    INFO_LOGIN_VALID_PAGE("infologinvalid"),
    
    /** The info login password page. */
    INFO_LOGIN_PASSWORD_PAGE("infologinpassword"),
    
    /** The info create car valid page. */
    INFO_CREATE_CAR_VALID_PAGE("infocreatecarvalid"),
    
    /** The info user detail valid page. */
    INFO_USER_DETAIL_VALID_PAGE("infouserdetailvalid"),
    
    /** The info session invalidate page. */
    INFO_SESSION_INVALIDATE_PAGE("infosessioninvalidate"),
    
    /** The info create order page. */
    INFO_CREATE_ORDER_PAGE("infocreateorder"),
    
    /** The info comment valid page. */
    INFO_COMMENT_VALID_PAGE("infocommentvalid"),
    
    /** The info create service valid page. */
    INFO_CREATE_SERVICE_VALID_PAGE("infocreateservicevalid"),
    
    /** The info bill order valid page. */
    INFO_BILL_ORDER_VALID_PAGE("infobillordervalid"),
    
    /** The create car page. */
    CREATE_CAR_PAGE("createcar"),
    
    /** The create service page. */
    CREATE_SERVICE_PAGE("createservice"),
    
    /** The edit car page. */
    EDIT_CAR_PAGE("editcar"),
    
    /** The edit user detail page. */
    EDIT_USER_DETAIL_PAGE("edituserdetail"),
    
    /** The edit login password page. */
    EDIT_LOGIN_PASSWORD_PAGE("editloginpassword"),
    
    /** The edit comment page. */
    EDIT_COMMENT_PAGE("editcomment"),
    
    /** The edit order page. */
    EDIT_ORDER_PAGE("editorder"),
    
    /** The edit service page. */
    EDIT_SERVICE_PAGE("editservice"),
    
    /** The show order user page. */
    SHOW_ORDER_USER_PAGE("showorderuser"),
    
    /** The empty page. */
    EMPTY_PAGE("empty"),
    
    /** The session user invalidate page. */
    SESSION_USER_INVALIDATE_PAGE("info/sessionInvalidate"),
    
    /** The comment valid page. */
    COMMENT_VALID_PAGE("info/commentvalid"),
    
    /** The create car valid page. */
    CREATE_CAR_VALID_PAGE("info/carcreatevalid"),
    
    /** The create order page. */
    CREATE_ORDER_PAGE("info/orderCreate"),
    
    /** The login password valid page. */
    LOGIN_PASSWORD_VALID_PAGE("info/loginpassvalid"),
    
    /** The login valid page. */
    LOGIN_VALID_PAGE("info/loginvalid"),
    
    /** The sign up exist page. */
    SIGN_UP_EXIST_PAGE("info/signupexist"),
    
    /** The sign up valid page. */
    SIGN_UP_VALID_PAGE("info/signupvalid"),
    
    /** The user detail valid page. */
    USER_DETAIL_VALID_PAGE("info/userdetailvalid"),
    
    /** The create service valid page. */
    CREATE_SERVICE_VALID_PAGE("info/createservice"),
    
    /** The bill order valid page. */
    BILL_ORDER_VALID_PAGE("info/billordervalid"),
    
    /** The view all order page. */
    VIEW_ALL_ORDER_PAGE("viewallorder"),
    
    /** The view all invoice page. */
    VIEW_ALL_INVOICE_PAGE("viewallinvoice"),
    
    /** The command name with action. */
    COMMAND_NAME_WITH_ACTION("action?command=");

    /** The name page. */
    private String namePage;

    /**
     * Instantiates a new name page.
     *
     * @param namePage the name page
     */
    NamePage(String namePage) {
        this.namePage = namePage;
    }

    /**
     * Gets the name page.
     *
     * @return the name page
     */
    private String getNamePage() {
        return namePage;
    }

    /**
     * Gets the forward page.
     *
     * @return the forward page
     */
    public String getForwardPage() {
        return DIRECTORY_JSP_NAME.getNamePage() + namePage + EXTENSION_JSP_NAME.getNamePage();
    }

    /**
     * Gets the redirect page.
     *
     * @return the redirect page
     */
    public String getRedirectPage() {
        return COMMAND_NAME_WITH_ACTION.getNamePage() + namePage;
    }

}
