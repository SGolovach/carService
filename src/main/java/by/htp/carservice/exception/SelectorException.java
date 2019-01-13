package by.htp.carservice.exception;

/**
 * The Class SelectorException.
 */
public class SelectorException extends Exception {
    
    /**
     * Instantiates a new command exception.
     */
    public SelectorException() {
        super();
    }

    /**
     * Instantiates a new command exception.
     *
     * @param message the message
     */
    public SelectorException(String message) {
        super(message);
    }

    /**
     * Instantiates a new command exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public SelectorException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new command exception.
     *
     * @param cause the cause
     */
    public SelectorException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new command exception.
     *
     * @param message the message
     * @param cause the cause
     * @param enableSuppression the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected SelectorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
