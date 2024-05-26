package exception;

import model.ErrorCode;

public class OlaException extends RuntimeException {
    public ErrorCode errorCode;
    public String message;

    public OlaException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }
}
