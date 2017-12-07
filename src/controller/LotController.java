package controller;

import data.DataHolder;
import model.Category;
import model.Item;
import model.Lot;
import model.exceptions.AddLotException;
import model.exceptions.LotIsClosedException;

import javax.xml.crypto.Data;
import java.awt.peer.PanelPeer;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * This is controller for Lot. It's provided methods for working with Lot
 * </p>
 *
 * @author Yaroslav
 * @version 1.0
 */
public class LotController {

    /**
     *
     * @param category
     * @return
     */
    public List<Lot> getLotByCategory(Category category) {
        List<Lot> returnedLot = new LinkedList<Lot>();
        for(Lot lot : DataHolder.getDataHolder().getLots()){
            if(lot.getCategoryId() == category.getID())
                returnedLot.add(lot);
        }
        return returnedLot;
    }


    /**
     * Get lot by id
     * @param id an integer, id of lot
     * @return  lot with such id
     */
    public Lot getLotById(int id){
        Lot returned = null;
        for(Lot lot : DataHolder.getDataHolder().getLots()){
            if(lot.getId() == id)
                returned = lot;
        }
        return returned;
    }

    public boolean isOpened(Lot lot){
        boolean result = false;
        Calendar currentDate = Calendar.getInstance();
        if(lot.getDate().get(Calendar.YEAR) > currentDate.get(Calendar.YEAR)){
            result = true;
        } else if(lot.getDate().get(Calendar.MONTH) > currentDate.get(Calendar.MONTH)){
            result = true;
        } else if(lot.getDate().get(Calendar.DAY_OF_MONTH) > currentDate.get(Calendar.DAY_OF_MONTH)) {
            result = true;
        }
        return result;
    }

    public List<Lot> getLotsByItem(Item item){
        List<Lot> returnedLots = new LinkedList<Lot>();
        for(Lot lot : DataHolder.getDataHolder().getLots()){
            if(lot.getItemId() == item.getId())
                returnedLots.add(lot);
        }
        return returnedLots;
    }

    public void addNewLot(int itemId, int price, int userId, Calendar date, int categoryId, int count) throws AddLotException{
        if(!DataHolder.getDataHolder().getLots().add(new Lot(DataHolder.getDataHolder().getLots().size() + 1,
                                                            itemId, price, userId, date, categoryId, count)))
            throw new AddLotException("Возникли проблемы с добавлением лота");
    }



}
