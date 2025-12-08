import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class RecipeBook here.
 *
 * @author Julien P-H
 * @version (a version number or a date)
 */
public class RecipeBook
{
    private String title;
    private String author;
    private String bookID;
    private ArrayList<Recipe> recipes;
    
    /**
     * Constructor for objects of class RecipeBook
     */
    public RecipeBook(String title, String author, String bookID)
    {
        this.title = title;
        this.author = author;
        this.bookID = bookID;
        recipes = new ArrayList<>();
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String newTitle) 
    {
        title = newTitle;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getBookID()
    {
        return bookID;
    }

    public void addRecipe(Recipe r)
    {
        recipes.add(r);
    }
    
    public ArrayList<Recipe> listAllRecipes() 
    {
        return recipes;
    }
    
    public ArrayList<Recipe> searchByType(RecipeType t) 
    {
        if(!recipes.isEmpty()) {
            ArrayList<Recipe> recipesByType = new ArrayList<>();
            for(Recipe r: recipes) {
                if(r.getType().equals(t)) {
                    recipesByType.add(r);
                }
            }
            return recipesByType;
        }
        else {
            return null;
        }
    }
    
    public ArrayList<Recipe> seachByTitle(String t) 
    {
        if(!recipes.isEmpty()) {
            ArrayList<Recipe> recipesByTitle = new ArrayList<>();
            for(Recipe r: recipes) {
                if(r.getTitle().equals(t)) {
                    recipesByTitle.add(r);
                }
            }
            return recipesByTitle;
        }
        else {
            return null;
        }
    }
    
    public ArrayList<Recipe> searchByIngredient(Ingredient i)
    {
        if(!recipes.isEmpty()) {
            ArrayList<Recipe> recipesByIngredient = new ArrayList<>();
            for(Recipe r: recipes) {
                if(r.checkIngredient(i)) {
                    recipesByIngredient.add(r);
                }
            }
            return recipesByIngredient;
        }
        else {
            return null;
        }
    }
    
    public ArrayList<Recipe> searchByTag(Tag t) 
    {
        if(!recipes.isEmpty()) {
            ArrayList<Recipe> recipesByTag = new ArrayList<>();
            for(Recipe r: recipes) {
                if(r.checkTag(t)) {
                    recipesByTag.add(r);
                }
            }
            return recipesByTag;
        }
        else {
            return null;
        }
    }
    
    public ArrayList<Recipe> getTopRated() 
    {
        if(!recipes.isEmpty()) {
            ArrayList<Recipe> result = new ArrayList<>();
            int maxRating = recipes.get(0).getRating();
            //find largest rating (int)
            for (Recipe r : recipes) {
                if (r.getRating() > maxRating) {
                    maxRating = r.getRating();
                }
            }
            //find every recipe with largest rating then return them all in an arraylist
            for (Recipe r : recipes) {
                if (r.getRating() == maxRating) {
                    result.add(r);
                }
            }
            return result;
        }
        else {
            return null;
        }
    }
    
    @Override
    public String toString() 
    {
        return title + ", " + author;
    }
    
    @Override
    public boolean equals(Object other) 
    {
        RecipeBook otherBook = (RecipeBook) other;
        if (other instanceof RecipeBook) {
            if(this.bookID.equals(otherBook.getBookID())) {
                return true;
            }
        }
        return false;
    }
}
