package model.exceptions;

/**
 * This exception occured when new user try registrates with already existing login
 */
public class UserAlreadyExistException extends Exception {

    /**
     * Constructs new object of excpetions with desctiption
     * @param msg Description
     */
    public UserAlreadyExistException(String msg){
        super(msg);
    }
}
