package psn.lotus.core.exception;

/**
 * @author: nicee
 * @since: 2015/12/17
 */
public class UnknownException extends Exception {

    private static final long serialVersionUID = 488155915008252984L;

    private String code;

    private String message;

    public UnknownException(String code, String message) {
        this(code, message, new Throwable());
    }

    public UnknownException(String code, String message, Throwable throwable) {
        super("[" + code + "] - [" + message + "]", throwable);
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
