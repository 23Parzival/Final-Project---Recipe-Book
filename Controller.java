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
            
            // switch (command) {
                // case "help" -> printHelp();
                // //---RecipeBook commands---
                // case "1" -> //change recipe book title
                // case "2" -> commands.listAllRecipes();
                // case "3" -> //list by type
                // case "4" -> //search by title
                // case "5" -> //seach by ingredient
                // case "6" -> //search by tag
                // case "7" -> //get top rated recipe
                // //---Recipe commands---
                // case "8" -> //add recipe(title, servings, type)
                // case "9" -> //get recipe title(recipe r)
                // case "10" -> //get recipe type(recipe r)
                // case "11" -> //get recipe tags(recipe r)
                // case "12" -> //rate recipe(recipe r)
                // case "12" -> //scale recipe servings(recipe r)
                // //---MealPlan commands---
                // case "13" -> //print weekly plan
                // case "14" -> //assign recipe to day(DayOfWeek day, Recipe r)
                // case "15" -> //remove recipe
                // case "16" -> //clear weekly plan
                
                // case "bye" -> {
                    // printGoodbye();
                    // finished = true;
                // }
                // default -> System.out.println("Unknown command. Type 'help' for help");
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
