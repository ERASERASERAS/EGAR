package model.exceptions;

/**
 * This exception will occurred when user makes double bet
 */
public class DoubleBetException extends Exception{

    /**
     * Constructs new object of exception with description
     * @param msg
     */
    public DoubleBetException(String msg){
        super(msg);
    }
}
