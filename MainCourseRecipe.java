
/**
 * Write a description of class MainCourseRecipe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MainCourseRecipe extends Recipe
{
    public int cookingTime;
    
    /**
     * Constructor for objects of class MainCourseRecipe
     */
    public MainCourseRecipe(String title, int servings, RecipeType type, int cookingTime)
    {
        super(title, servings, type);
        this.cookingTime = cookingTime;
    }
}
