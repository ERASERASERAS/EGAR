package controller;

import data.DataHolder;
import model.Bet;
import model.Lot;
import model.exceptions.BadBetException;
import model.exceptions.DoubleBetException;

import java.util.LinkedList;
import java.util.List;

/**
 * This is controler for Bet. It's provided methods for working with Bet class
 */
public class BetController {

    /**
     * Get set of bets for certain lot
     * @param lot Lot
     * @return massive of bets
     */
    public List<Bet> getBetsByLot(Lot lot){
        List<Bet> returnedBets = new LinkedList<Bet>();
        for(Bet bet : DataHolder.getDataHolder().getBets()){
            if(bet.getLotId() == lot.getId())
                returnedBets.add(bet);
        }
        return  returnedBets;
    }

    public Bet getBetById(int id){
        Bet returnedBet = null;
        for(Bet bet : DataHolder.getDataHolder().getBets()){
            if(bet.getId() == id)
                returnedBet = bet;
        }
        return  returnedBet;
    }

    public boolean addNewBet(int userId, int lotId, int price) throws DoubleBetException, BadBetException {
        if(checkOnDoubleBet(userId, lotId)) throw new DoubleBetException("Нельзя ставить два или более раза подряд!");
        if(checkOnBadBet(price, lotId)) throw new BadBetException("Надо поставить больше!");
        return DataHolder.getDataHolder().getBets().add(new Bet(DataHolder.getDataHolder().getBets().size() + 1, userId,
                                                        lotId, price));

    }

    public boolean checkOnDoubleBet(int userId, int lotId) {
        boolean result = false;
        Bet lastBetOfLot = null;
        for(Bet bet : DataHolder.getDataHolder().getBets()){
            if(bet.getLotId() == lotId)
                lastBetOfLot = bet;
        }
        if(lastBetOfLot != null){
            if(lastBetOfLot.getUserId() == userId)
                result = true;
        }
        return result;
    }

    public boolean checkOnBadBet(int price, int lotId){
        boolean result = false;
        Bet lastBetOfLot = null;
        for(Bet bet : DataHolder.getDataHolder().getBets()){
            if(bet.getLotId() == lotId)
                lastBetOfLot = bet;
        }
        if(lastBetOfLot != null){
            result = (lastBetOfLot.getPrice() > price);
        }
        return result;
    }



}
