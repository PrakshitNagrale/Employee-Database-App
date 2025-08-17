package exceptions;

public class DetailsNotDeletedFromDBException extends RuntimeException {
    public DetailsNotDeletedFromDBException(String message) {
        super(message);
    }
}
