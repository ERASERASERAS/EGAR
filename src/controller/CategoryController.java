package controller;

import data.DataHolder;
import model.Category;

/**
 * This is controller for Category. It's provided methods for work with Category class
 *
 * @author
 */
public class CategoryController {


    /**
     * Returns category by index
     * @param name name of category
     * @return category with such index
     */
    public Category getCategoryByName(String name){
        Category category = null;
        for(Category currentCategory : DataHolder.getDataHolder().getCategories()){
            if(currentCategory.getName().equals(name)){
                category = currentCategory;
            }
        }
        return category;
    }

    public Category getCategoryById(int id){
        Category returnedCategory = null;
        for(Category category : DataHolder.getDataHolder().getCategories()){
            if(category.getID() == id)
                returnedCategory = category;
        }
        return returnedCategory;
    }
}
