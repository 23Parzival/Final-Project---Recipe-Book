
/**
 * Write a description of class Step here.
 *
 * @author Julien P-H
 * @version (a version number or a date)
 */
public class Step
{
    private String description;
    
    /**
     * Constructor for objects of class Step
     */
    public Step(String description)
    {
        this.description = description;
    }
    
    public String getDescription() 
    {
        return description;
    }
    
    public void setDescription(String newDescription) 
    {
        description = newDescription;
    }
}
