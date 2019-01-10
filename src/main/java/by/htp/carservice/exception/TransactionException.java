package by.htp.carservice.exception;

/**
 * The Class TransactionException.
 */
public class TransactionException extends Exception {
    
    /**
     * Instantiates a new transaction exception.
     */
    public TransactionException() {
        super();
    }

    /**
     * Instantiates a new transaction exception.
     *
     * @param message the message
     */
    public TransactionException(String message) {
        super(message);
    }

    /**
     * Instantiates a new transaction exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public TransactionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new transaction exception.
     *
     * @param cause the cause
     */
    public TransactionException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new transaction exception.
     *
     * @param message the message
     * @param cause the cause
     * @param enableSuppression the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected TransactionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
