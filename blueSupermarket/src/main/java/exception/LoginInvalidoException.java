package exception;

public class LoginInvalidoException extends RuntimeException {

    public LoginInvalidoException(String msg){
        super(msg);
    };

    public LoginInvalidoException() {
        super("Login invalido");
    }
}
