package homework13.Ex1;

/**
 * @author Elena Chinarina
 *
 **/

public class WrongLoginException extends Exception {
    public WrongLoginException() {
        super();
    }
    public WrongLoginException(String message) {
        super(message);
    }
}
