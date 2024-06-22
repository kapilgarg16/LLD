package exception;

public class ATMException extends RuntimeException{
    private ErrorCode errorCode;
    private String msg;

    public ATMException(ErrorCode errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getMsg() {
        return msg;
    }
}
