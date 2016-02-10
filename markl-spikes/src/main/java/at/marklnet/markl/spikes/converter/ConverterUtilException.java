package at.marklnet.markl.spikes.converter;

/**
 * Exception in case converting fails.
 * 
 * @author marklm
 */
public class ConverterUtilException extends Exception {

    /**
     * 
     */
    public ConverterUtilException() {
        super();
    }

    /**
     * @param message the exception message
     * @param cause the cause
     */
    public ConverterUtilException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message the exception message
     */
    public ConverterUtilException(String message) {
        super(message);
    }

    /**
     * @param cause the cause
     */
    public ConverterUtilException(Throwable cause) {
        super(cause);
    }
}
