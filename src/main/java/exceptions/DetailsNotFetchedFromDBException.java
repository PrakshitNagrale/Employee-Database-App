package exceptions;

public class DetailsNotFetchedFromDBException extends RuntimeException {
    public DetailsNotFetchedFromDBException(String message) {
        super(message);
    }
}
