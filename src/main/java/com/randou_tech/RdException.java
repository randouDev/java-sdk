package com.randou_tech;

public class RdException extends RuntimeException{
    private String errorMessage;
    private String errorCode;

    /**
     * Creates a default instance.
     */
    public RdException() {
        super();
    }

    /**
     * Creates an instance with error message.
     *
     * @param errorMessage
     *            Error message.
     */
    public RdException(String errorMessage) {
        this(errorMessage, (Throwable) null);
    }

    /**
     * Creates an instance with an exception
     *
     * @param cause
     *            An exception.
     */
    public RdException(Throwable cause) {
        this(null, cause);
    }

    /**
     * Creates an instance with error message and an exception.
     *
     * @param errorMessage
     *            Error message.
     * @param cause
     *            An exception.
     */
    public RdException(String errorMessage, Throwable cause) {
        super(null, cause);
        this.errorMessage = errorMessage;
        this.errorCode = ClientErrorCode.UNKNOWN;
    }

    /**
     * Creates an instance with error message, error code, request Id
     *
     * @param errorMessage
     *            Error message.
     * @param errorCode
     *            Error code, which typically is from a set of predefined
     *            errors. The handler code could do action based on this.
     */
    public RdException(String errorMessage, String errorCode) {
        this(errorMessage, errorCode, null);
    }

    /**
     * Creates an instance with error message, error code, request Id and an
     * exception.
     *
     * @param errorMessage
     *            Error message.
     * @param errorCode
     *            Error code.
     * @param cause
     *            An exception.
     */
    public RdException(String errorMessage, String errorCode, Throwable cause) {
        this(errorMessage, cause);
        this.errorCode = errorCode;
    }

    /**
     * Get error message.
     *
     * @return Error message in string.
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Get error code.
     *
     * @return Error code.
     */
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return getErrorMessage() + "\n[ErrorCode]: " + (errorCode != null ? errorCode : "");
    }
}
