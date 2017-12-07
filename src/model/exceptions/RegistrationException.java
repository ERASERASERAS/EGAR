package model.exceptions;

/**
 * This is base class for exceptions which relates to registration
 */
public class RegistrationException extends Exception {

    /**
     * Constructs new object with description
     * @param msg Descriprion
     */
    public RegistrationException(String msg){
        super(msg);
    }
}
