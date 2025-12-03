
/**
 * Write a description of class Ingredient here.
 *
 * @author Julien P-H
 * @version (a version number or a date)
 */
public class Ingredient
{
    private String name;
    private double quantity;
    private String unit;

    /**
     * Constructor for objects of class Ingredient
     */
    public Ingredient(String name, double qty, String unit)
    {
        this.name = name;
        quantity = qty;
        this.unit = unit;
    }
    
    public String getName() 
    {
        return name;
    }
    
    public double getQuantity() 
    {
        return quantity;
    }
    
    public String getUnit() 
    {
        return unit;
    }
    
    public void setName(String newName) 
    {
        name = newName;
    }
    
    public void setQuantity(double newQuantity) 
    {
        quantity = newQuantity;        
    }
    
    public void setUnit(String newUnit) 
    {
        unit = newUnit;
    }
}
