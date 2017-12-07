package controller;

import com.sun.org.apache.xerces.internal.impl.xs.util.LSInputListImpl;
import controller.DeliveryController.DeliverysCalculator;
import data.DataHolder;
import model.*;
import model.exceptions.UserAlreadyExistException;

import javax.jws.soap.SOAPBinding;
import javax.xml.crypto.Data;
import java.util.*;

/**
 * <p>
 * This is controller for User. It's provided methods for working with User
 * </p>
 *
 * @author Yaroslav
 * @version 1.0
 */
public class UserController {



    /**
     * Gets user by login
     *
     * @param login user's login(for authorization)
     * @return User, if user with such login is exists; null, if user with such login isn't exists
     */
    public User getUserByLogin(String login) {
        User returnedUser = null;
        for(User user : DataHolder.getDataHolder().getUsers()){
            if(user.getLogin().equals(login))
                returnedUser = user;
        }
        return returnedUser;
    }

    public User getUserById(int id){
        User returnedUser = null;
        for(User user : DataHolder.getDataHolder().getUsers()){
            if(user.getId() == id)
                returnedUser = user;
        }
        return returnedUser;
    }

    /**
     * check password's right
     *
     * @param user    user for check
     * @param password user's password
     * @return true - right password, false - wrong password
     */
    public boolean checkPassword(User user, String password) {
        return user.getPassword().equals(password);
    }

    /**
     * Get Count of registered users
     *
     * @return  int - count of registered users
     */
    public static int getUsersCount() {
        return DataHolder.getDataHolder().getUsers().size();
    }

    /** Returns count bets for current user
     *
     * @return count of bets
     */
    public int getCountOfBets(User user) {
        int count = 0;
        for(Bet bet : DataHolder.getDataHolder().getBets()){
            if(bet.getUserId() == user.getId())
                ++count;
        }
        return count;
    }


    /**Returns massive of bets for current user
     *
     * @return massive of bets for
     */
    public List<Bet> getUsersBets(User user) {
        List<Bet> returnedBets = new LinkedList<Bet>();
        for(Bet bet : DataHolder.getDataHolder().getBets()){
            if(bet.getUserId() == user.getId())
                returnedBets.add(bet);
        }
        return  returnedBets;
    }



    public List<User> getAllUsers() {
        return DataHolder.getDataHolder().getUsers();
    }


    /**
     * Returns lots for current users
     * @return massive of lots
     */
    public List<Lot> getUsersLots(User user) {
        List<Lot> returnedLots = new LinkedList<Lot>();
        for(Lot lot : DataHolder.getDataHolder().getLots()){
            if(lot.getUserId() == user.getId())
                returnedLots.add(lot);
        }
        return returnedLots;
    }

    public void checkDuplicateUsers(String login) throws UserAlreadyExistException{
        for(User user : DataHolder.getDataHolder().getUsers()) {
            if(user.getLogin().toLowerCase().equals(login.toLowerCase())) {
                throw new UserAlreadyExistException("Пользователь с таким лоигном уже существует. Придумайте другой логин.");
            }
        }
    }

    public boolean addNewUser(String login, String password){
        return DataHolder.getDataHolder().getUsers().add(new User(DataHolder.getDataHolder().getUsers().size() + 1,
                                                            login, password, AccessLevel.USER));
    }

    public List<Lot> getParticipatedLots(User user){
        List<Lot> returnedLots = new LinkedList<Lot>();
        for(Bet bet : DataHolder.getDataHolder().getBets()){
            if(user.getId() == bet.getUserId()){
                returnedLots.add(new LotController().getLotById(bet.getLotId()));
            }
        }
        return returnedLots;
    }

    public List<Lot> getClosedParticipatedLots(User user){
        List<Lot> returnedLots = new LinkedList<Lot>();
        for(Lot lot : getParticipatedLots(user)){
            if(new LotController().isOpened(lot)){
                returnedLots.add(lot);
            }
        }
        return returnedLots;
    }

    public List<Lot> getWonLots(User user){
        List<Lot> wonLots = new LinkedList<Lot>();
        for(Lot lot : getClosedParticipatedLots(user)){
            if(user.getId() == new BetController().getMaxBetByLot(lot).getUserId()){
                wonLots.add(lot);
            }
        }
        return wonLots;
    }

    public Map<Bet, Item> getBoughtItems(User user){
        Map<Bet, Item> boughtItems = new HashMap<Bet,Item>();
        List<Lot> wonLots = getWonLots(user);
        for(Lot lot : wonLots){
            boughtItems.put(new BetController().getMaxBetByLot(lot),new ItemController().getItemById(lot.getItemId()));
        }
        return boughtItems;
    }











    /*public List<Item> getBoughtItems(User user){

    }*/



}
