
/**
 * Write a description of class DessertRecipe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DessertRecipe extends Recipe
{
    public int sweetness;
    
    /**
     * Constructor for objects of class DessertRecipe
     */
    public DessertRecipe(String title, int servings, RecipeType type)
    {
        super(title, servings, type);
    }
    
    public void setSweetness(int newSweetness)
    {
        sweetness = newSweetness;
    }
}
