package exceptions;

public class NoStudentException extends Exception{
    public NoStudentException() {
    }

    public NoStudentException(String message) {
        super(message);
    }

    public NoStudentException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoStudentException(Throwable cause) {
        super(cause);
    }
}
