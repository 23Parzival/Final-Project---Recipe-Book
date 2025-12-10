import java.util.HashMap;
import java.util.Scanner;

/**
 * Controller class for the RecipeBook application.
 * Handles user input, commands, and the main application loop.
 * It manages a RecipeBook, a MealPlan, and the Commands class.
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
     * Initializes the Scanner object for user input.
     */
    public Controller()
    {
        scanner = new Scanner(System.in);
    }
    
    /**
     * Starts the main application.
     * Prompts the user to set up the RecipeBook, then enters a command loop
     * where the user can call commands, view the meal plan, or quit the program.
     */
    public void start()
    {
        boolean finished = false;
        
        System.out.println("Welcome! Let's set up your Recipe Book.");

        System.out.print("Enter Recipe Book Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Recipe Book Author: ");
        String author = scanner.nextLine();

        System.out.print("Enter Recipe Book ID: ");
        String bookID = scanner.nextLine();
        
        recipeBook = new RecipeBook(title, author, bookID);
        mealPlan = new MealPlan();
        commands = new Commands(scanner, recipeBook, mealPlan);

        System.out.println("Recipe Book created successfully!");
        System.out.println("Title: " + title + "\nAuthor: " + author + "\nID: " + bookID);
        System.out.println();
        
        printWelcome();
        while(!finished) {
            System.out.print("> ");
            String command = readInput();
            
            switch (command) {
                case "help" -> printHelp();
                case "quit" -> {
                    printGoodbye();
                    finished = true;
                }
                //---RecipeBook commands---
                case "1" -> commands.changeRecipeBookTitle();
                case "2" -> commands.listAllRecipes();
                case "3" -> commands.searchRecipeBookByTitle();
                case "4" -> commands.searchRecipeBookByIngredient();
                case "5" -> commands.searchRecipeBookByTag();
                case "6" -> commands.searchRecipeBookByType();
                case "7" -> commands.getTopRatedRecipe();
                //---Recipe commands---
                case "8" -> commands.getRecipeIngredientsAndQuantities();
                case "9" -> commands.getRecipeSteps();
                case "10" -> commands.rateRecipe();
                case "11" -> commands.scaleRecipeServings();
                //---MealPlan commands---
                case "12" -> commands.printWeeklyMealPlan();
                case "13" -> commands.assignRecipeToDay();
                case "14" -> commands.removeRecipeFromDay();
                case "15" -> commands.clearWeeklyPlan();
            }
        }
    }
    
    /**
     * Reads a line of input from the user.
     * Trims leading/trailing whitespace and converts to lowercase.
     * 
     * @return The user's input as a lowercase string.
     */
    private String readInput() 
    {
        return scanner.nextLine().trim().toLowerCase();
    }
    
    /**
     * Prints the welcome message when the program starts.
     */
    private void printWelcome() 
    {
        System.out.println("Welcome to your RecipeBook!");
        System.out.println("Type 'help' to get a list of all commands and call a command using numbers 1-14.");
    }
    
    /**
     * Prints a list of all available commands with their descriptions.
     * The commands are retrieved from the Commands class.
     */
    private void printHelp() {
        System.out.println("Commands:");

        //get list of commands from Commands class
        for (var entry : commands.getCommandList().entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
    
    /**
     * Prints a goodbye message when the user exits the program.
     */
    private void printGoodbye() {
        System.out.println("Goodbye!");
    }
    
    /**
     * Main method so the program can run outside BlueJ.
     * Creates a Controller instance depending on user input or closes application.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args)
    {
        System.out.println("=== Welcome to the Recipe Book Application ===");
        System.out.println("1 - Start application");
        System.out.println("2 - Exit");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1" -> {
                Controller controller = new Controller();
                controller.start();
            }
            case "2" -> System.out.println("Exiting application. Goodbye!");
            default -> System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
