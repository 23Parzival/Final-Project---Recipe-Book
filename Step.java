
/**
 * Represents a single step in a recipe.
 * Stores a description of the step and allows reading/updating it.
 * 
 * @author Julien P-H
 * @version (a version number or a date)
 */
public class Step
{
    private String description;
    
    /**
     * Constructs a new Step with the specified description.
     * 
     * @param description Text describing the step
     */
    public Step(String description)
    {
        this.description = description;
    }
    
    /**
     * Returns the description of this step.
     * 
     * @return Step description
     */
    public String getDescription() 
    {
        return description;
    }
    
    /**
     * Updates the description of this step.
     * 
     * @param newDescription The new description text
     */
    public void setDescription(String newDescription) 
    {
        description = newDescription;
    }
    
    /**
     * Returns a string representation of the Step.
     * 
     * @return A string in the format "description"
     */
    @Override
    public String toString()
    {
        return description;
    }
}
