 

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
        ArrayList<Recipe> recipesByType = new ArrayList<>();
        for(Recipe r: recipes) {
            if(r.getType().equals(t)) {
                recipesByType.add(r);
            }
        }
        return recipesByType;
    }
    
    public ArrayList<Recipe> seachByTitle(String t) 
    {
        ArrayList<Recipe> recipesByTitle = new ArrayList<>();
        for(Recipe r: recipes) {
            if(r.getTitle().equals(t)) {
                recipesByTitle.add(r);
            }
        }
        return recipesByTitle;
    }
    
    public ArrayList<Recipe> searchByIngredient(String i)
    {
        ArrayList<Recipe> recipesByIngredient = new ArrayList<>();
        for(Recipe r: recipes) {
            if(r.getIngredient().equals(i)) {
                recipesByIngredient.add(r);
            }
        }
        return recipesByIngredient;
    }
    
    public ArrayList<Recipe> searchByTag(Tag t) 
    {
        ArrayList<Recipe> recipesByTag = new ArrayList<>();
        for(Recipe r: recipes) {
            if(r.getTag().equals(t)) {
                recipesByTag.add(r);
            }
        }
        return recipesByTag;
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
