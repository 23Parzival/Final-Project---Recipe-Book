import java.util.HashMap;
import java.util.Scanner;

/**
 * Write a description of class InputReader here.
 *
 * @author Julien P-H
 * @version (a version number or a date)
 */
public class Controller
{
    private Scanner scanner;
    private RecipeBook recipeBook;
    private MealPlan mealPlan;
    private Commands commands;
    
    /**
     * Constructor for objects of class InputReader
     */
    public Controller(String title, String author, String bookID)
    {
        scanner = new Scanner(System.in);
        recipeBook = new RecipeBook(title, author, bookID);
        mealPlan = new MealPlan();
        commands = new Commands(scanner, recipeBook, mealPlan);
    }
    
    public void start()
    {
        boolean finished = false;
        printWelcome();
        while(!finished) {
            System.out.print("> ");
            String command = readInput();
            
            switch (command) {
                case "help" -> printHelp();
                //---RecipeBook commands---
                case "1" -> commands.changeRecipeBookTitle();
                case "2" -> commands.listAllRecipes();
                case "3" -> commands.searchRecipeBookByTitle(//parameter);
                case "4" -> commands.searchRecipeBookByIngredient(//parameter);
                case "5" -> commands.searchRecipeBookByTag(//parameter);
                case "6" -> commands.searchRecipeBookByType(//parameter);
                case "7" -> commands.getTopRatedRecipe();
                //---Recipe commands---
                case "8" -> commands.addRecipeToRecipeBook();
                case "9" -> commands.rateRecipe(//parameter);
                case "10" -> commands.scaleRecipeServings(//parameter);
                //---MealPlan commands---
                case "11" -> commands.printWeeklyMealPlan();
                case "12" -> commands.assignRecipeToDay(//parameter);
                case "13" -> commands.removeRecipeFromDay(//parameter);
                case "14" -> commands.clearWeeklyPlan();
            }
        }
    }
    
    public String readInput() 
    {
        return scanner.nextLine().trim().toLowerCase();
    }
    
    private void printWelcome() 
    {
        System.out.println("Welcome to your RecipeBook!");
        System.out.println("Type 'help' to get a list of all commands and call a command using numbers 1-10.");
    }
    
    private void printHelp() {
        System.out.println("Commands:");

        //get list of commands from Commands class
        for (var entry : commands.getCommandList().entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
    
    private void printGoodbye() {
        System.out.println("Goodbye!");
    }
}
