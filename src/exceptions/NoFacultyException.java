package exceptions;

public class NoFacultyException extends Exception{
    public NoFacultyException() {
        super();
    }

    public NoFacultyException(String message) {
        super(message);
    }

    public NoFacultyException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoFacultyException(Throwable cause) {
        super(cause);
    }
}
