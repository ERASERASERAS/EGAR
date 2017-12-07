package model.exceptions;

/**
 * This exception occured when password isn't validate
 */
public class PasswordValidationException extends Exception {

    /**
     * Constructs new object of exception with description
     * @param msg Description
     */
    public PasswordValidationException(String msg){
        super(msg);
    }
}
