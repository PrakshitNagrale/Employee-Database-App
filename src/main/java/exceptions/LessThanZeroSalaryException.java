package exceptions;

public class LessThanZeroSalaryException extends RuntimeException {
    public LessThanZeroSalaryException(String message) {
        super(message);
    }
}
