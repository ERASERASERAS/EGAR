package model;

/**
 * This class represents categories
 */
public class Category {

    /**
     * Id of category
     */
    private  final int id;

    /**
     * Name of category
     */
    private String name;

    /**
     * Constructs new object of Category with all variables
     * @param id Id of category
     * @param name Name of category
     */
    public Category(int id, String name){
        this.id = id;
        this.name = name;
    }

    /**
     * Gets id of category
     * @return Categorie's id
     */
    public int getID(){
        return id;
    }

    /**
     * Sets name of category
     * @param name New categorie's name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Gets a name of category
     * @return Categories's name
     */
    public String getName(){
        return name;
    }
}
