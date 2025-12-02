 

import java.util.HashMap;

/**
 * Write a description of class MealPlan here.
 *
 * @author Julien P-H
 * @version (a version number or a date)
 */
public class MealPlan
{
    private HashMap<DayOfWeek, Recipe> plan;

    /**
     * Constructor for objects of class MealPlan
     */
    public MealPlan()
    {
        plan = new HashMap<>();
    }

    public void assignRecipe(DayOfWeek day, Recipe r)
    {
        plan.put(day, r);
    }
    
    public void removeRecipe(DayOfWeek day) 
    {
        plan.remove(day);
    }
    
    public HashMap<DayOfWeek, Recipe> getWeeklyPlan() 
    {
        return plan;
    }
    
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
    
    public void clear() 
    {
        plan.clear();
    }
}
