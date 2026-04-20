package homework13.Ex1;

/**
 * @author Elena Chinarina
 *
 **/

public class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super();
    }
    public WrongPasswordException(String message) {
        super(message);
    }
}
