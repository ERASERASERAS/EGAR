package data;

import model.*;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


/**
 * This is class-folder for data.
 */
public class DataHolder {

    /**
     * This is variable for access to this class
     */
    private static DataHolder dataHolder;

    /**
     * Empty constructor(for Singleton)
     */
    private DataHolder() {}

    /**
     * Get variable for access to class
     * @return Variable for access to class
     */
    public static synchronized DataHolder getDataHolder(){
        if(dataHolder == null){
            dataHolder = new DataHolder();
            users = new LinkedList<User>();
            lots = new LinkedList<Lot>();
            bets = new LinkedList<Bet>();
            items = new LinkedList<Item>();
            categories = new LinkedList<Category>();
            users.add(new User(00, "ImAdmin","admin", AccessLevel.ADMIN));
            users.add(new User(01, "Kris1", "321123", AccessLevel.USER));
            users.add(new User (02, "Mr.Adam", "321654", AccessLevel.USER));
            categories.add(new Category(00, "Alcohol"));
            categories.add(new Category(01, "Wear"));
            categories.add(new Category(02, "Musical instruments"));
            items.add(new Item(00, 00, "Beer"));
            items.add(new Item(01, 00, "Wine"));
            items.add(new Item(02, 01, "Jeans"));
            items.add(new Item(03, 02, "Guitar"));
            lots.add(new Lot(00, 00, 3232, 02, new GregorianCalendar(2013,1,25), 00, 1));
            lots.add(new Lot(01, 01, 34532, 01, new GregorianCalendar(2017,11,23),00, 2));
            lots.add(new Lot(02, 02, 895839,02, new GregorianCalendar(2018,0,22), 01,3));
            lots.add(new Lot(03, 03, 80000, 01, new GregorianCalendar(2017,10, 21), 02,5));
            bets.add(new Bet(00, 01, 00, 3232));
            bets.add(new Bet(01, 01, 01, 36000));
            bets.add(new Bet(02, 02, 01, 37843));
            bets.add(new Bet(03, 02, 03, 82000));

        }
        return dataHolder;
    }

    /**
     * This is massive holds information about all users
     */
    private static List<User> users;

    /**
     * This is massive holds information about all categories
     */
    private static List<Category> categories;

    /**
     * This is massive holds information about all items
     */
    private static List<Item> items;

    /**
     * This is massive holds information about all lots
     */
    private static List<Lot> lots;

    /**
     * This is massive holds information about all bets
     */
    private static List<Bet> bets;

    /**
     * Get massive of users
     * @return Massive of users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Set massive of users
     * @param users New massive of users
     */
    public void setUsers(List<User> users) {
        DataHolder.users = users;
    }

    /**
     * Get massive of categories
     * @return New massive of categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * Set massive of categories
     * @param categories New massive of categories
     */
    public void setCategories(List<Category> categories) {
        DataHolder.categories = categories;
    }

    /**
     * Get massive of items
     * @return Massive of items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Set massive of items
     * @param items New massive of items
     */
    public void setItems(List<Item> items) {
        DataHolder.items = items;
    }

    /**
     * Get massive of lots
     * @return Massive of lots
     */
    public List<Lot> getLots() {
        return lots;
    }

    /**
     * Set massive of lots
     * @param lots NEw massive of lots
     */
    public void setLots(List<Lot> lots) {
        DataHolder.lots = lots;
    }

    /**
     * Get massive of bets
     * @return Massive of bets
     */
    public List<Bet> getBets() {
        return bets;
    }

    /**
     * Set massive of bets
     * @param bets New massive of bets
     */
    public void setBets(List<Bet> bets) {
        DataHolder.bets = bets;
    }







}
