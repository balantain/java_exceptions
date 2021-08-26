package exceptions;

public class NoDisciplineException extends Exception{
    public NoDisciplineException() {
    }

    public NoDisciplineException(String message) {
        super(message);
    }

    public NoDisciplineException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoDisciplineException(Throwable cause) {
        super(cause);
    }
}
