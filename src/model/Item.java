package model;

/**
 * This is class represents item
 */
public class Item {
    /**
     * Item's id
     */
    private final int id;

    /**
     * Categorie's id
     */
    private int categoryID;

    /**
     * Item's name
     */
    private String name;

    /**
     * Construscts new Item object with all variables
     * @param id Item's id
     * @param categoryID Categorie's id
     * @param name Item's name
     */
    public Item(int id, int categoryID, String name){
        this.id = id;
        this.categoryID = categoryID;
        this.name = name;
    }

    /**
     * Gets item's id
     * @return Item's id
     */
    public int getId(){
        return id;
    }

    /**
     * Gets category's id
     * @return
     */
    public int getCategoryID(){
        return categoryID;
    }

    /**
     * Sets id of category
     * @param categoryID
     */
    public void setCategoryID(int categoryID){
        this.categoryID = categoryID;
    }

    /**
     * Gets item's name
     * @return Name of item
     */
    public String getName(){
        return  name;
    }

    /**
     * Sets item's name
     * @param name New item's name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Represented this object such a string
     * @return string with this object
     */
    public String toString(){
        return "ID товара: " + id + "  Наименование товара:  " + name + "  ID категории:  " + categoryID;
    }
}
