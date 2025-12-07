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
    
    /**
     * Constructor for objects of class InputReader
     */
    public Controller()
    {
        scanner = new Scanner(System.in);
        recipeBook = new RecipeBook();
        mealPlan = new MealPlan();
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
                case "1" -> .listAllRecipes(); //add reference to recipebook somewhere
                case "bye" -> {
                    printHelp();
                    finished = true;
                }
                default -> System.out.println("Unknown command. Type 'help' for help");
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
        System.out.println("1 - List all recipes");
        System.out.println("2 - Add a new recipe");
        System.out.println("3 - Search for a recipe");
        System.out.println("4 - Generate weekly meal plan");
        System.out.println("bye - Exit program");
    }
    
    private void printHelp() {
        System.out.println("Goodbye!");
    }
}
