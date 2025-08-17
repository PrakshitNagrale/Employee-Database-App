package exceptions;

public class DetailsNotInsertedInDBException extends RuntimeException {
    public DetailsNotInsertedInDBException(String message) {
        super(message);
    }
}
