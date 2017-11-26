package model.exceptions;

public class PasswordValidationException extends RegistrationException {

    public PasswordValidationException(String msg){
        super(msg);
    }
}
