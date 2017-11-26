package model;

import sun.util.resources.cldr.ta.CalendarData_ta_IN;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * This is class represents Lot
 */
public class Lot {

    /**
     * Id of lot
     */
    private final int id;

    /**
     * Id of item
     */
    private int itemId;

    /**
     * Start pride of lot
     */
    private int startPrice;

    /**
     * Id of user-owner
     */
    private int userId;

    /**
     *
     * @return
     */
    public int getCategoryId() {
        return categoryId;
    }



    /**
     *
     * @param categoryId
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     *
     */
    private int categoryId;

    /**
     *
     * @return
     */
    public int getItemsCount() {
        return itemsCount;
    }

    /**
     *
     * @param itemsCount
     */
    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    /**
     *
     */
    private int itemsCount;

    /**
     *
     * @return
     */
    public Calendar getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    /**
     *
     */
    private Calendar date;

    /**
     *
     * @param id
     * @param itemId
     * @param startPrice
     * @param userId
     * @param date
     * @param categoryId
     */
    public Lot(int id, int itemId, int startPrice, int userId, Calendar date, int categoryId, int itemsCount) {
        this.id = id;
        this.itemId = itemId;
        this.startPrice = startPrice;
        this.userId = userId;
        this.date = date;
        this.categoryId = categoryId;
        this.itemsCount = itemsCount;
    }


    /**
     * Gets id of lot
     *
     * @return Lot's id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public int getItemId(){
        return itemId;
    }

    /**
     *Sets id of item
     * @param itemId New item's id
     */
    public void setItemId(int itemId){
        this.itemId = itemId;
    }

    /**
     *Gets start price of lot
     *
     * @return
     */
    public int getStartPrice(){
        return  startPrice;
    }

    /**
     *Sets start price of lot
     * @param startPrice New start price of lot
     */
    public void setStartPrice(int startPrice){
        this.startPrice = startPrice;
    }

    /**
     *Gets id of user-owner of lot
     * @return
     */
    public int getUserId() {
        return userId;
    }

    /**
     *Sets id of user-owner of lot
     * @param userId New id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     *Transfers this object to string representation
     * @return String representation of this object
     */
    public String toString(){
        return "Id: " + id + "  Id пользователя:  " + userId + " Id товара: " + itemId + " начальная цена: " + startPrice;
    }
}
