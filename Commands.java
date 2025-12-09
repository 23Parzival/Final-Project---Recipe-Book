import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

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
    
    public void searchRecipeBookByIngredient() 
    {
        commandList.put("4", "Search the recipe book by a specific ingredient.");
        
        System.out.print("Enter ingredient name: ");
        String name = scanner.nextLine();

        System.out.print("Enter ingredient quantity: ");
        double quantity = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter ingredient unit (g, ml, tbsp): ");
        String unit = scanner.nextLine();

        Ingredient ingredient = new Ingredient(name, quantity, unit);

        ArrayList<Recipe> results = recipeBook.searchByIngredient(ingredient);
        
        if (results == null || results.isEmpty()) {
            System.out.println("No recipes contain ingredient: " + ingredient);
        } 
        else {
            System.out.println("\n--- Recipes Containing Ingredient: " + ingredient + " ---");
            for (Recipe r : results) {
                System.out.println(r);
            }
        }
    }
    
    public void searchRecipeBookByTag() 
    {
        commandList.put("5", "Search the recipe book by a tag.");
        
        System.out.println("Available tags: VEGAN, VEGETARIAN, GLUTEN_FREE, QUICK, LOW_CALORIE, HIGH_PROTEIN");
        System.out.print("Enter tag: ");
        String tagInput = scanner.nextLine().toUpperCase();

        Tag tag;

        try {
            tag = Tag.valueOf(tagInput);
        } 
        catch (IllegalArgumentException e) {
            System.out.println("Invalid tag.");
            return;
        }

        ArrayList<Recipe> results = recipeBook.searchByTag(tag);

        if (results == null || results.isEmpty()) {
            System.out.println("No recipes found with tag: " + tag);
        } 
        else {
            System.out.println("\n--- Recipes With Tag: " + tag + " ---");
            for (Recipe r : results) {
                System.out.println(r);
            }
        }
    }
    
    public void searchRecipBookByType(RecipeType t) 
    {
        commandList.put("6", "List all recipes by type.");
        
        System.out.println("Available types: MAIN_COURSE, DESSERT, DRINK");
        System.out.print("Enter recipe type: ");
        String typeInput = scanner.nextLine().toUpperCase();

        RecipeType type;

        try {
            type = RecipeType.valueOf(typeInput);
        } 
        catch (IllegalArgumentException e) {
            System.out.println("Invalid recipe type.");
            return;
        }

        ArrayList<Recipe> results = recipeBook.searchByType(type);

        if (results == null || results.isEmpty()) {
            System.out.println("No recipes of type: " + type);
        }   
        else {
            System.out.println("\n--- Recipes of Type: " + type + " ---");
            for (Recipe r : results) {
                System.out.println(r);
            }
        }
    }
    
    public void getTopRatedRecipe() 
    {
        commandList.put("7", "Get the highest rated recipe in the recipe book.");
        
        var results = recipeBook.getTopRated();

        if (results == null || results.isEmpty()) {
            System.out.println("No recipes found or no ratings.");
        } 
        else {
            System.out.println("\n--- Top Rated Recipes ---");
            for (Recipe r : results) {
                System.out.println(r);
            }
        }
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