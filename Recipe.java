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
    private String title;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<Step> steps;
    private EnumSet<Tag> tags;
    private RecipeType type;
    private int rating;
    private int servings;
    
    /**
     * Constructor for objects of class Recipe
     */
    public Recipe(String title, int servings, RecipeType type)
    {
        this.title = title;
        this.servings = servings;
        this.type = type;
        
        ingredients = new ArrayList<>();
        steps = new ArrayList<>();
        tags = EnumSet.noneOf(Tag.class);
    }
    
    public String getTitle() {
        return title;
    }
    
    public RecipeType getType() {
        return type;
    }
    
    public boolean checkIngredient(Ingredient i) {
        return ingredients.contains(i);
    }
    
    public boolean checkTag(Tag t) {
        return tags.contains(t);
    }
    
    public int getRating() {
        return rating;
    }

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
    
    public void setRating(int rating)
    {
        this.rating = rating;
    }
    
    public void scaleServings(int newServ)
    {
        
    }
}
