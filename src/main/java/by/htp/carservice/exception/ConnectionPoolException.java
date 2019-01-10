package by.htp.carservice.exception;

/**
 * The Class ConnectionPoolException.
 */
public class ConnectionPoolException extends Exception {
    
    /**
     * Instantiates a new connection pool exception.
     */
    public ConnectionPoolException() {
        super();
    }

    /**
     * Instantiates a new connection pool exception.
     *
     * @param message the message
     */
    public ConnectionPoolException(String message) {
        super(message);
    }

    /**
     * Instantiates a new connection pool exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public ConnectionPoolException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new connection pool exception.
     *
     * @param cause the cause
     */
    public ConnectionPoolException(Throwable cause) {
        super(cause);
    }

}
