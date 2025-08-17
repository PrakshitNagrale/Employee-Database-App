package exceptions;

public class DetailsNotUpdateInDBException extends RuntimeException {
    public DetailsNotUpdateInDBException(String message) {
        super(message);
    }
}
