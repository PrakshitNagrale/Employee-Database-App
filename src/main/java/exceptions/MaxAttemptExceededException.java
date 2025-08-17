package exceptions;

public class MaxAttemptExceededException extends RuntimeException {

    public MaxAttemptExceededException(String message) {
        super(message);
    }
}
