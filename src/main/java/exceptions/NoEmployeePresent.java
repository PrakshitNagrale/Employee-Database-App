package exceptions;

public class NoEmployeePresent extends RuntimeException {
    public NoEmployeePresent(String message) {
        super(message);
    }
}
