package model.exceptions;


/**
 * This is exception for case when users bet is less than max bet on some lot
 */
public class BadBetException extends Exception {
    //super(Конкретное описание этого исключение)???

    /**
     * Constructs new object of exception
     * @param msg Descrioption
     */
    public BadBetException (String msg){
        super(msg);
    }
}
