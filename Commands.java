import java.util.Scanner;
import java.util.HashMap;

/**
 * Write a description of class Commands here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Commands
{
    private Scanner scanner;
    private RecipeBook recipeBook;
    private MealPlan mealPlan;
    private HashMap<String, String> commandList;
    
    /**
     * Constructor for objects of class Commands
     */
    public Commands(Scanner scanner, RecipeBook recipeBook, MealPlan mealPlan)
    {
        this.scanner = scanner;
        this.recipeBook = recipeBook;
        this.mealPlan = mealPlan;
        commandList = new HashMap<>();
    }
    
    public HashMap<String, String> getCommandList()
    {
        commandList.put("help", "Show all commands");
        return commandList;
    }
    
    //--*EVERYTHING UNDER THIS IS THE ACTUAL COMMANDS*--
    //EVERY COMMAND MUST START WITH commandList.put(#, description);
    
    public void listAllRecipes()
    {
        commandList.put("1", "List all recipes");
        
        System.out.println("--- All Recipes ---");

        if (recipeBook.listAllRecipes().isEmpty()) {
            System.out.println("No recipes in the book.");
            return;
        }

        for (Recipe r : recipeBook.listAllRecipes()) {
            System.out.println(r);
        }
    }
}