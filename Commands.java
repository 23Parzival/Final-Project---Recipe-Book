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
    
    public void changeRecipeBookTitle() 
    {
        commandList.put("1", "Change the recipe books title.");
        
        System.out.print("Enter new recipe book title: ");
        String title = scanner.nextLine();
        
        recipeBook.setTitle(title);
        System.out.println("Recipe book title changed to: " + title);
    }
    
    public void listAllRecipes()
    {
        commandList.put("2", "List all recipes.");
        
        System.out.println("--- All Recipes ---");

        if (recipeBook.listAllRecipes().isEmpty()) {
            System.out.println("No recipes in the book.");
            return;
        }

        for (Recipe r : recipeBook.listAllRecipes()) {
            System.out.println(r);
        }
    }
    
    public void searchRecipeBookByTitle() 
    {
        commandList.put("3", "Search recipe book by title.");
        
        System.out.print("Enter recipe title to search: ");
        String title = scanner.nextLine();
        
        var results = recipeBook.searchByTitle(title);
        if (results == null || results.isEmpty()) {
            System.out.println("No recipes found with title: " + title);
        } 
        else {
            System.out.println("\n--- Recipes Matching: " + title + " ---");
            for (Recipe r : results) {
                System.out.println(r);
            }
        }
    }
    
    public void searchRecipeBookByIngredient(Ingredient i) 
    {
        commandList.put("4", "Search the recipe book by a specific ingredient.");
    }
    
    public void searchRecipeBookByTag(Tag t) 
    {
        commandList.put("5", "Search the recipe book by a tag.");
    }
    
    public void searchRecipBookByType(RecipeType t) 
    {
        commandList.put("6", "List all recipes by type.");
    }
    
    public void getTopRatedRecipe() 
    {
        commandList.put("7", "Get the highest rated recipe in the recipe book.");
    }
    
    public void addRecipeToRecipeBook() 
    {
        commandList.put("8", "Add a recipe to the recipe book.");
    }
    
    public void rateRecipe(Recipe r) 
    {
        commandList.put("9", "Rate a specific recipe in the recipe book.");
    }
    
    public void scaleRecipeServings(Recipe r, double scale) 
    {
        commandList.put("10", "Scale a specific recipes servings.");
    }
    
    public void printWeeklyMealPlan() 
    {
        commandList.put("11", "Print the weekly meal plan.");
    }
    
    public void assignRecipeToDay(DayOfWeek d, Recipe r)
    {
        commandList.put("12", "Assigns a specific recipe to a specific day.");
    }
    
    public void removeRecipeFromDay(DayOfWeek d) 
    {
        commandList.put("13", "Remove recipe from specified day.");
    }
    
    public void clearWeeklyPlan() 
    {
        commandList.put("14", "Clear the entire meal plan.");
    }
}