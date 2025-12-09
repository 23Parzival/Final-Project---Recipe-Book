
/**
 * Represents an ingredient in a recipe, including name,
 * quantity, and unit of measurement.
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
     * Constructs a new Ingredient with a name, quantity, and unit.
     * 
     * @param name Name of the ingredient
     * @param qty  Quantity of the ingredient
     * @param unit Unit of measurement (g, ml, tbsp)
     */
    public Ingredient(String name, double qty, String unit)
    {
        this.name = name;
        quantity = qty;
        this.unit = unit;
    }
    
    /**
     * Returns the name of the ingredient.
     * 
     * @return Name of ingredient
     */
    public String getName() 
    {
        return name;
    }
    
    /**
     * Returns the quantity of the ingredient.
     * 
     * @return Quantity of ingredient
     */
    public double getQuantity() 
    {
        return quantity;
    }
    
    /**
     * Returns the unit of measurement of the ingredient.
     * 
     * @return Unit of ingredient
     */
    public String getUnit() 
    {
        return unit;
    }
    
    /**
     * Sets a new name for the ingredient.
     * 
     * @param newName The new name to set
     */
    public void setName(String newName) 
    {
        name = newName;
    }
    
    /**
     * Sets a new quantity for the ingredient.
     * 
     * @param newQuantity The new quantity to set
     */
    public void setQuantity(double newQuantity) 
    {
        quantity = newQuantity;        
    }
    
    /**
     * Sets a new unit of measurement for the ingredient.
     * 
     * @param newUnit The new unit to set
     */
    public void setUnit(String newUnit) 
    {
        unit = newUnit;
    }
    
    @Override
    public String toString() {
        return name + ": " + quantity + " " + unit;
    }
}
