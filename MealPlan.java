 

import java.util.HashMap;

/**
 * Represents a weekly meal plan that maps each day of the week
 * to a specific Recipe. Allows assigning, removing, printing,
 * and clearing recipes for each day.
 *
 * @author Julien P-H
 * @version (a version number or a date)
 */
public class MealPlan
{
    private HashMap<DayOfWeek, Recipe> plan;

    /**
     * Constructs a new empty MealPlan.
     */
    public MealPlan()
    {
        plan = new HashMap<>();
    }

    /**
     * Assigns a recipe to a specific day in the meal plan.
     * 
     * @param day The day of the week
     * @param r   The Recipe to assign
     */
    public void assignRecipe(DayOfWeek day, Recipe r)
    {
        plan.put(day, r);
    }
    
    /**
     * Removes the recipe assigned to a specific day.
     * 
     * @param day The day of the week
     */
    public void removeRecipe(DayOfWeek day) 
    {
        plan.remove(day);
    }
    
    /**
     * Returns the internal map of the weekly meal plan.
     * 
     * @return HashMap mapping DayOfWeek to Recipe
     */
    public HashMap<DayOfWeek, Recipe> getWeeklyPlan() 
    {
        return plan;
    }
    
    /**
     * Prints the weekly meal plan to the console.
     * Displays "(no recipe assigned)" if a day has no recipe.
     */
    public void printWeeklyPlan() 
    {
        System.out.println("=== Weekly Meal Plan ===");
        for (DayOfWeek day : DayOfWeek.values()) {
            Recipe r = plan.get(day);
            if (r != null) {
                System.out.println(day + ": " + r.getTitle());
            } 
            else {
                System.out.println(day + ": (no recipe assigned)");
            }
        }
        System.out.println("========================");
    }
    
    /**
     * Clears all recipes from the weekly meal plan.
     */
    public void clear() 
    {
        plan.clear();
    }
}
