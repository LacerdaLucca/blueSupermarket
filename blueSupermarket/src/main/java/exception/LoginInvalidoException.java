package exception;

public class LoginInvalidoException extends RuntimeException {

    public LoginInvalidoException() {
        super("Login invalido");
    }
}
