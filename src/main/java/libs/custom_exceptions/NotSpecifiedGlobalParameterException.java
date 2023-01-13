package libs.custom_exceptions;

public class NotSpecifiedGlobalParameterException extends RuntimeException {
    public NotSpecifiedGlobalParameterException(String message) {
        super(message);
    }
}
