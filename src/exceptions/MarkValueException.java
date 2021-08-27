package exceptions;

public class MarkValueException extends Exception{
    public MarkValueException() {
    }

    public MarkValueException(String message) {
        super(message);
    }

    public MarkValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public MarkValueException(Throwable cause) {
        super(cause);
    }
}
