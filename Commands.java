import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.ArrayList;

/**
 * Handles all user commands for interacting with a RecipeBook and MealPlan.
 * Provides methods to add, search, rate, scale recipes and manage meal plans.
 * Stores a LinkedHashMap of commands for display and reference.
 * 
 * @author Julien P-H
 * @version (a version number or a date)
 */
public class Commands
{
    private Scanner scanner;
    private RecipeBook recipeBook;
    private MealPlan mealPlan;
    private LinkedHashMap<String, String> commandList;
    
    /**
     * Constructs a Commands object for a specific RecipeBook and MealPlan.
     * 
     * @param scanner    Scanner object for reading user input
     * @param recipeBook The RecipeBook instance to manipulate
     * @param mealPlan   The MealPlan instance to manipulate
     */
    public Commands(Scanner scanner, RecipeBook recipeBook, MealPlan mealPlan)
    {
        this.scanner = scanner;
        this.recipeBook = recipeBook;
        this.mealPlan = mealPlan;
        commandList = new LinkedHashMap<>();
        fillCommandList();
    }
    
    /**
     * Returns the LinkedHashMap of all available commands and descriptions.
     * 
     * @return The command list map
     */
    public LinkedHashMap<String, String> getCommandList()
    {
        return commandList;
    }
    
    /**
     * Populates the command list with all available commands and descriptions.
     */
    public void fillCommandList() 
    {
        commandList.put("help", "Show all commands");
        commandList.put("quit", "Quit the program");
        commandList.put("1", "Change the recipe books title.");
        commandList.put("2", "List all recipes.");
        commandList.put("3", "Search recipe book by title.");
        commandList.put("4", "Search the recipe book by a specific ingredient.");
        commandList.put("5", "Search the recipe book by a tag.");
        commandList.put("6", "List all recipes by type.");
        commandList.put("7", "Get the highest rated recipe in the recipe book.");
        commandList.put("8", "Get a specified recipes ingredients and quantities.");
        commandList.put("9", "Rate a specific recipe in the recipe book.");
        commandList.put("10", "Scale a specific recipes servings.");
        commandList.put("11", "Print the weekly meal plan.");
        commandList.put("12", "Assigns a specific recipe to a specific day.");
        commandList.put("13", "Remove recipe from specified day.");
        commandList.put("14", "Clear the entire meal plan.");
    }
    
    //--*EVERYTHING UNDER THIS IS THE ACTUAL COMMANDS*--
    //EVERY COMMAND MUST START WITH commandList.put(#, description);
    
    /**
     * When called, prompts the user to change the RecipeBook title.
     */
    public void changeRecipeBookTitle() 
    {
        System.out.print("Enter new recipe book title: ");
        String title = scanner.nextLine();
        
        recipeBook.setTitle(title);
        System.out.println("Recipe book title changed to: " + title);
    }
    
    /**
     * Lists all recipes currently in the RecipeBook.
     */
    public void listAllRecipes()
    {
        System.out.println("--- All Recipes ---");

        if (recipeBook.listAllRecipes().isEmpty()) {
            System.out.println("No recipes in the book.");
            return;
        }

        for (Recipe r : recipeBook.listAllRecipes()) {
            System.out.println(r);
        }
    }
    
    /**
     * Searches the RecipeBook by recipe title entered by the user.
     */
    public void searchRecipeBookByTitle() 
    {
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
    
    /**
     * Searches the RecipeBook by a specific ingredient entered by the user.
     */
    public void searchRecipeBookByIngredient() 
    {
        System.out.print("Enter ingredient name: ");
        String name = scanner.nextLine();

        System.out.print("Enter ingredient quantity (without units, units are inputted next): ");
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
    
    /**
     * Searches the RecipeBook by a specific Tag entered by the user.
     */
    public void searchRecipeBookByTag() 
    {
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
    
    /**
     * Searches the RecipeBook by a specific RecipeType entered by the user.
     */
    public void searchRecipeBookByType() 
    {
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
    
    /**
     * Displays the top-rated recipe(s) in the RecipeBook.
     */
    public void getTopRatedRecipe() 
    {
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
    
    /**
     * Gets a recipe from the user and lists all of its ingredients with quantities.
     */
    public void getRecipeIngredientsAndQuantities()
    {
        System.out.print("Enter recipe title: ");
        String title = scanner.nextLine();

        var matches = recipeBook.searchByTitle(title);

        if (matches == null || matches.isEmpty()) {
            System.out.println("No recipe found with that title.");
            return;
        }

        Recipe r = matches.get(0);

        System.out.println("\n--- Ingredients for: " + r.getTitle() + " ---");
    
        var ingredients = r.getIngredients();

        if (ingredients.isEmpty()) {
            System.out.println("This recipe has no ingredients listed.");
            return;
        }

        for (Ingredient i : ingredients) {
            System.out.println("- " + i);
        }
    }
    
    /**
     * Prompts the user to rate a recipe in the RecipeBook.
     */
    public void rateRecipe() 
    {
        System.out.print("Enter recipe title to rate: ");
        String title = scanner.nextLine();

        var matches = recipeBook.searchByTitle(title);

        if (matches == null || matches.isEmpty()) {
            System.out.println("No recipe found with that title.");
            return;
        }

        Recipe r = matches.get(0);

        System.out.print("Enter rating (1–5): ");
        int rating = Integer.parseInt(scanner.nextLine());

        r.setRating(rating);
        System.out.println("Rated recipe: " + r.getTitle() + " as " + rating);
    }
    
    /**
     * Prompts the user to scale the servings of a recipe.
     */
    public void scaleRecipeServings() 
    {
        System.out.print("Enter recipe title to scale: ");
        String title = scanner.nextLine();

        var matches = recipeBook.searchByTitle(title);

        if (matches == null || matches.isEmpty()) {
            System.out.println("No recipe found with that title.");
            return;
        }

        Recipe r = matches.get(0);

        System.out.print("Enter scale factor (2 for double, 0.5 for half): ");
        double scale = Double.parseDouble(scanner.nextLine());

        r.scaleServings(scale);

        System.out.println("Scaled recipe: " + r.getTitle());
        System.out.println("New servings: " + r.getServings());
    }
    
    /**
     * Prints the weekly meal plan.
     */
    public void printWeeklyMealPlan() 
    {
        System.out.println();
        mealPlan.printWeeklyPlan();
    }
    
    /**
     * Assigns a recipe to a specific day in the meal plan.
     */
    public void assignRecipeToDay()
    {
        System.out.print("Enter day of week (MONDAY, TUESDAY...): ");
        String dayInput = scanner.nextLine().toUpperCase();

        DayOfWeek day;
        try {
            day = DayOfWeek.valueOf(dayInput);
        } 
        catch (IllegalArgumentException e) {
            System.out.println("Invalid day of week.");
            return;
        }

        System.out.print("Enter recipe title to assign: ");
        String title = scanner.nextLine();

        var matches = recipeBook.searchByTitle(title);

        if (matches == null || matches.isEmpty()) {
            System.out.println("No recipe found with that title.");
            return;
        }

        Recipe r = matches.get(0);

        mealPlan.assignRecipe(day, r);

        System.out.println("Assigned: " + r.getTitle() + " to " + day + ".");
    }
    
    /**
     * Removes a recipe from a specific day in the meal plan.
     */
    public void removeRecipeFromDay() 
    {
        System.out.print("Enter day of week to clear (MONDAY, TUESDAY...): ");
        String dayInput = scanner.nextLine().toUpperCase();

        DayOfWeek day;
        try {
            day = DayOfWeek.valueOf(dayInput);
        } 
        catch (IllegalArgumentException e) {
            System.out.println("Invalid day.");
            return;
        }

        mealPlan.removeRecipe(day);

        System.out.println("Removed recipe from " + day + ".");
    }
    
    /**
     * Clears the entire weekly meal plan.
     */
    public void clearWeeklyPlan() 
    {
        mealPlan.clear();
        System.out.println("Weekly meal plan cleared.");
    }
}