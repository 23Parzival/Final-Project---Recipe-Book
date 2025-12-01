import java.util.ArrayList;
import java.util.EnumSet;

/**
 * Write a description of class Recipe here.
 *
 * @author Cristina A
 * @version (a version number or a date)
 */
public class Recipe
{
    public String title;
    public ArrayList<Ingredient> ingredients;
    public ArrayList<Step> steps;
    public EnumSet<Tag> tags;
    public double ratingSum;
    public int ratingCount;
    public int servings;
    

    /**
     * Constructor for objects of class Recipe
     */
    public Recipe(String title, int servings)
    {
        this.title = title;
        this.servings = servings;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addIngredient(Ingredient i)
    {
        ingredients.add(i);
    }
    
    public void addStep(Step s)
    {
        steps.add(s);
    }
    
    public void addTag(Tag t)
    {
        tags.add(t);
    }
    
    public void rate(int score)
    {
        ratingCount = score;
    }
    
    public void scaleServings(int newServ)
    {
        
    }
}
