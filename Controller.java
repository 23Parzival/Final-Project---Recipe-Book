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
    private String command;
    private Scanner scanner;
    private HashMap<String, String> possibleResponses;
    
    /**
     * Constructor for objects of class InputReader
     */
    public Controller()
    {
        possibleResponses = new HashMap<>();
        scanner = new Scanner(System.in);
        fillHashMap();
    }
    
    public void start()
    {
        boolean finished = false;
        printWelcome();
        while(!finished) {
            if(!finished) {
                System.out.print("> ");
                String command = readInput();

                //quit command
                if(command.equals("bye")) {
                    finished = true;
                    carryOutCommand("bye");
                }
                else {
                    carryOutCommand(command);
                }
            }
        }
    }

    public void fillHashMap()
    {
        possibleResponses.put("help", "Your possible commands are: \n1.");//add all te commands.
        possibleResponses.put("1", "");
        possibleResponses.put("2", "");
        possibleResponses.put("3", "");
        possibleResponses.put("4", "");
        possibleResponses.put("5", "");
        possibleResponses.put("bye", "Thanks for using the program. Goodbye!");
    }
    
    public String readInput() 
    {
        return scanner.nextLine().trim().toLowerCase();
    }
    
    public void carryOutCommand(String command) 
    {
        switch(readInput()) {
            case "help" -> System.out.println(possibleResponses.get("help"));
            case "1" -> System.out.println(possibleResponses.get("1")); //add method call
            case "2" -> System.out.println(possibleResponses.get("2")); //add method call
            //all other cases
            case "bye" -> System.out.println(possibleResponses.get("bye"));
            default -> System.out.println("Unknown command. Type 'help' for a list of commands.");
        }
    }
    
    public void printWelcome() 
    {
        System.out.println("Welcome to your RecipeBook!");
        System.out.println("Type 'help' to get a list of all commands and call a command using numbers 1-10.");
    }
}
