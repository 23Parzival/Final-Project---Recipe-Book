import java.util.ArrayList;
import java.util.List;

/**
 * Represents a RecipeBook that contains multiple recipes.
 * Provides methods to add, search, and retrieve recipes.
 * Each RecipeBook has a title, author, and unique bookID.
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
     * Constructs a new RecipeBook with the specified title, author, and ID.
     * Initializes an empty list of recipes.
     * 
     * @param title  The title of the recipe book
     * @param author The author of the recipe book
     * @param bookID The unique identifier for the recipe book
     */
    public RecipeBook(String title, String author, String bookID)
    {
        this.title = title;
        this.author = author;
        this.bookID = bookID;
        recipes = new ArrayList<>();
    }
    
    /**
     * Returns the title of the recipe book.
     * 
     * @return The title of the recipe book
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Sets a new title for the recipe book.
     * 
     * @param newTitle The new title to set
     */
    public void setTitle(String newTitle) 
    {
        title = newTitle;
    }
    
    /**
     * Returns the author of the recipe book.
     * 
     * @return The author of the recipe book
     */
    public String getAuthor() {
        return author;
    }
    
    /**
     * Returns the unique identifier (ID) of the recipe book.
     * 
     * @return The book ID
     */
    public String getBookID()
    {
        return bookID;
    }

    /**
     * Adds a recipe to the recipe book.
     * 
     * @param r The Recipe object to add
     */
    public void addRecipe(Recipe r)
    {
        recipes.add(r);
    }
    
    /**
     * Returns a list of all recipes in the book.
     * 
     * @return An ArrayList of all Recipe objects
     */
    public ArrayList<Recipe> listAllRecipes() 
    {
        return recipes;
    }
    
    /**
     * Returns a list of recipes matching the given type.
     * 
     * @param t The RecipeType to search for
     * @return An ArrayList of recipes of the specified type, or null if the book is empty
     */
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
    
    /**
     * Returns a list of recipes with a matching title.
     * 
     * @param t The title to search for
     * @return An ArrayList of recipes with the given title, or null if the book is empty
     */
    public ArrayList<Recipe> searchByTitle(String t) 
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
    
    /**
     * Returns a list of recipes that contain a specific ingredient.
     * 
     * @param i The Ingredient to search for
     * @return An ArrayList of recipes containing the ingredient, or null if the book is empty
     */
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
    
    /**
     * Returns a list of recipes that contain a specific tag.
     * 
     * @param t The Tag to search for
     * @return An ArrayList of recipes with the given tag, or null if the book is empty
     */
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
    
    /**
     * Returns a list of the highest rated recipe(s) in the book.
     * 
     * @return An ArrayList of the top-rated recipes, or null if the book is empty
     */
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
    
    /**
     * Returns a string representation of the RecipeBook.
     * 
     * @return A string in the format "title, author"
     */
    @Override
    public String toString() 
    {
        return title + ", " + author;
    }
    
    /**
     * Compares this RecipeBook with another object for equality based on bookID.
     * 
     * @param other The object to compare with
     * @return true if other is a RecipeBook with the same bookID, false otherwise
     */
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
