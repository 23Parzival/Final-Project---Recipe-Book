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
    private ArrayList<Recipe> recipes;
    
    /**
     * Constructor for objects of class RecipeBook
     */
    public RecipeBook(String title, String author)
    {
        this.title = title;
        this.author = author;
        recipes = new ArrayList<>();
    }

    public void addRecipe(Recipe r)
    {
        recipes.add(r);
    }
    
    public ArrayList<Recipe> listAllRecipes() 
    {
        return recipes;
    }
    
    public ArrayList<Recipe> listByType(RecipeType t) 
    {
        //loop through each recipe checking to see if it has RecipeType t,
        //if it does add it to new ArrayList then return that ArrayList
    }
    
    public ArrayList<Recipe> seachByTitle(String title) 
    {
        
    }
    
    public ArrayList<Recipe> searchByIngredient(String ingredient)
    {
        
    }
    
    public ArrayList<Recipe> searchByTag(Tag t) 
    {
        
    }
    
    public ArrayList<Recipe> getTopRated(int n) 
    {
        
    }
    
    @Override
    public String toString() {
        if (recipes.isEmpty()) {
            return "Recipe Book is empty.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Recipe Book:\n");

        int index = 1;
        for (Recipe r : recipes) {
            sb.append(index++)
              .append(". ")
              .append(r.toString())   //uses each Recipe's own toString()
              .append("\n");
        }

        return sb.toString();
    }

}
