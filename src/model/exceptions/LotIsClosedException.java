package model.exceptions;

/**
 * This exception was occured when user makes bet for closed lot
 */
public class LotIsClosedException extends Exception {

    /**
     * Constructs new object of exception with
     * @param msg description
     */
    public LotIsClosedException(String msg){
        super(msg);
    }
}
