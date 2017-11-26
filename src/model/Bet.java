package model;

/**
 *This is class represents bets
 */
public class Bet {
    /**
     * Id of bets
     */
    private int id;

    /**
     * Id of user which makes a rate
     */
    private int userId;

    /**
     * Id of lot on which bet was placed
     */
    private int lotId;

    /**
     * price for lot
     */
    private int price;

    /**
     *Constructs new object with all parameters
     * @param id bet's id
     * @param userId user's id
     * @param lotId  lot's id
     * @param price price
     */
    public Bet(int id, int userId, int lotId, int price){
        this.id = id;
        this.userId = userId;
        this.lotId = lotId;
        this.price = price;
    }

    /**
     * Gets user's id
     * @return User's id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets user's id
     * @param userId New user's id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets lot's id
     * @return Lot's id
     */
    public int getLotId() {
        return lotId;
    }

    /**
     * Sets lot's id
     * @param lotId New lot's id
     */
    public void setLotId(int lotId) {
        this.lotId = lotId;
    }

    /**
     * Gets price of lot
     * @return Price of lot
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets price of lot
     * @param price New price of lot
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Gets this bet's id
     * @return Bet's id
     */
    public int getId() {
        return id;
    }

    /**
     * Represents this objects of Bet to string
     * @return String representation of object
     */
    public String toString(){
        return "id: " + id  + "  id лота: " + lotId  + ", id пользователя: " + userId + "  Цена:  " + price;
    }
}


