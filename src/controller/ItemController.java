package controller;

import data.DataHolder;
import model.Category;
import model.Item;

import javax.xml.crypto.Data;
import java.util.LinkedList;
import java.util.List;


/**
 * This is controller for Item. It's provided mentods for working with Item class
 */
public class ItemController {

    /**
     * Get set of items by category
     *
     * @param category category of items
     * @return massive of items
     */
    public List<Item> getItemsByCategory(Category category){
        List<Item> returnedItems = new LinkedList<Item>();
        for(Item item : DataHolder.getDataHolder().getItems()){
            if(item.getCategoryID() == category.getID())
                returnedItems.add(item);
        }
        return returnedItems;
    }

    public Item getItemByName(String name){
        Item returnedItem = null;
        for(Item item : DataHolder.getDataHolder().getItems()){
            if(item.getName().equals(name))
                returnedItem = item;
        }
        return returnedItem;
    }

    public Item getItemById(int id){
        Item returnedItem = null;
        for(Item item : DataHolder.getDataHolder().getItems()){
            if(item.getId() == id)
                returnedItem = item;
        }
        return returnedItem;
    }

    public boolean checkExistenceOfItem(String name){
        boolean result = false;
        for(Item item : DataHolder.getDataHolder().getItems()){
            if(item.getName().equals(name))
                result = true;
        }
        return result;
    }

    public boolean addNewItem(int categoryId, String name) {
        return DataHolder.getDataHolder().getItems().add(new Item(DataHolder.getDataHolder().getItems().size() + 1,
                                                            categoryId, name));
    }


}
