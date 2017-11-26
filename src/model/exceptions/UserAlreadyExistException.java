package model.exceptions;

public class UserAlreadyExistException extends RegistrationException {

    public UserAlreadyExistException(String msg){
        super(msg);
    }
}
