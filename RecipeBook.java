import java.util.ArrayList;
import java.util.List;

/**
 * Represents a RecipeBook that contains multiple recipes.
 * Provides methods to add, search, and retrieve recipes.
 * Each RecipeBook has a title, author, and unique bookID.
 *
 * @author Julien P-H
 * @version (a version number or a date)
 */
public class RecipeBook
{
    private String title;
    private String author;
    private String bookID;
    private ArrayList<Recipe> recipes;
    
    /**
     * Constructs a new RecipeBook with the specified title, author, and ID.
     * Initializes an empty list of recipes.
     * 
     * @param title  The title of the recipe book
     * @param author The author of the recipe book
     * @param bookID The unique identifier for the recipe book
     */
    public RecipeBook(String title, String author, String bookID)
    {
        this.title = title;
        this.author = author;
        this.bookID = bookID;
        recipes = new ArrayList<>();
    }
    
    /**
     * Returns the title of the recipe book.
     * 
     * @return The title of the recipe book
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Sets a new title for the recipe book.
     * 
     * @param newTitle The new title to set
     */
    public void setTitle(String newTitle) 
    {
        title = newTitle;
    }
    
    /**
     * Returns the author of the recipe book.
     * 
     * @return The author of the recipe book
     */
    public String getAuthor() {
        return author;
    }
    
    /**
     * Returns the unique identifier (ID) of the recipe book.
     * 
     * @return The book ID
     */
    public String getBookID()
    {
        return bookID;
    }

    /**
     * Adds a recipe to the recipe book.
     * 
     * @param r The Recipe object to add
     */
    public void addRecipe(Recipe r)
    {
        recipes.add(r);
    }
    
    /**
     * Returns a list of all recipes in the book.
     * 
     * @return An ArrayList of all Recipe objects
     */
    public ArrayList<Recipe> listAllRecipes() 
    {
        return recipes;
    }
    
    /**
     * Returns a list of recipes matching the given type.
     * 
     * @param t The RecipeType to search for
     * @return An ArrayList of recipes of the specified type, or null if the book is empty
     */
    public ArrayList<Recipe> searchByType(RecipeType t) 
    {
        if(!recipes.isEmpty()) {
            ArrayList<Recipe> recipesByType = new ArrayList<>();
            for(Recipe r: recipes) {
                if(r.getType().equals(t)) {
                    recipesByType.add(r);
                }
            }
            return recipesByType;
        }
        else {
            return null;
        }
    }
    
    /**
     * Returns a list of recipes with a matching title.
     * 
     * @param t The title to search for
     * @return An ArrayList of recipes with the given title, or null if the book is empty
     */
    public ArrayList<Recipe> searchByTitle(String t) 
    {
        if(!recipes.isEmpty()) {
            ArrayList<Recipe> recipesByTitle = new ArrayList<>();
            for(Recipe r: recipes) {
                if(r.getTitle().equals(t)) {
                    recipesByTitle.add(r);
                }
            }
            return recipesByTitle;
        }
        else {
            return null;
        }
    }
    
    /**
     * Returns a list of recipes that contain a specific ingredient.
     * 
     * @param i The Ingredient to search for
     * @return An ArrayList of recipes containing the ingredient, or null if the book is empty
     */
    public ArrayList<Recipe> searchByIngredient(Ingredient i)
    {
        if(!recipes.isEmpty()) {
            ArrayList<Recipe> recipesByIngredient = new ArrayList<>();
            for(Recipe r: recipes) {
                if(r.checkIngredient(i)) {
                    recipesByIngredient.add(r);
                }
            }
            return recipesByIngredient;
        }
        else {
            return null;
        }
    }
    
    /**
     * Returns a list of recipes that contain a specific tag.
     * 
     * @param t The Tag to search for
     * @return An ArrayList of recipes with the given tag, or null if the book is empty
     */
    public ArrayList<Recipe> searchByTag(Tag t) 
    {
        if(!recipes.isEmpty()) {
            ArrayList<Recipe> recipesByTag = new ArrayList<>();
            for(Recipe r: recipes) {
                if(r.checkTag(t)) {
                    recipesByTag.add(r);
                }
            }
            return recipesByTag;
        }
        else {
            return null;
        }
    }
    
    public void fillRecipeBook() 
    {
        // There's probably a much more efficient way to do this but I'm lazy
        
        // Create the recipe
        Recipe dessert1 = new Recipe("Chocolate Chip Cookies", 12, RecipeType.DESSERT);
        dessert1.addTag(Tag.QUICK);
        dessert1.addTag(Tag.VEGETARIAN);
        
        // Create and add all the ingredients, first wall of code
        // Yes I stole this recipe from that Tasty app, I LOVE THESE COOKIES
        Ingredient sugar = new Ingredient("granulated sugar", 0.5, "cup");
        dessert1.addIngredient(sugar);
        Ingredient bsugar = new Ingredient("brown sugar", 0.75, "cup");
        dessert1.addIngredient(bsugar);
        Ingredient salt = new Ingredient("salt", 1, "teaspoon");
        dessert1.addIngredient(salt);
        Ingredient butter = new Ingredient("butter, melted", 0.5, "cup");
        dessert1.addIngredient(butter);
        Ingredient egg = new Ingredient("egg", 1, "whole");
        dessert1.addIngredient(egg);
        Ingredient vanilla = new Ingredient("vanilla extract", 1, "teaspoon");
        dessert1.addIngredient(egg);
        Ingredient flour = new Ingredient("all-purpose flour", 1.25, "cup");
        dessert1.addIngredient(flour);
        Ingredient bsoda = new Ingredient("baking soda", 0.5, "teaspoon");
        dessert1.addIngredient(bsoda);
        Ingredient cchip = new Ingredient("chocolate chips", 8, "ounce");
        dessert1.addIngredient(cchip);
        
        // Create and add the steps, another wall
        Step step1 = new Step("In a large bowl, whisk together the sugars, salt, and butter until a paste forms with no lumps.");
        dessert1.addStep(step1);
        Step step2 = new Step("Whisk in the egg and vanilla, beating until light ribbons fall off the whisk and remain for a short while before falling back into the mixture.");
        dessert1.addStep(step2);
        Step step3 = new Step("Sift in the flour and baking soda, then fold the mixture with a spatula (Be careful not to overmix, which would cause the gluten in the flour to toughen resulting in cakier cookies).");
        dessert1.addStep(step3);
        Step step4 = new Step("Fold in the chocolate chunks, then chill the dough for at least 30 minutes.");
        dessert1.addStep(step4);
        Step step5 = new Step("Preheat oven to 350 degrees F (180 degrees C). Line a baking sheet with parchment paper.");
        dessert1.addStep(step5);
        Step step6 = new Step("Scoop the dough with an ice cream scoop onto the baking sheet, leaving 10cm of space between cookies and 5cm of space between the pan edges");
        dessert1.addStep(step6);
        Step step7 = new Step("Bake for 12-15 minutes, until the edges have started to barely brown.");
        dessert1.addStep(step7);
        Step step8 = new Step("Cool completely before serving.");
        dessert1.addStep(step8);
        Step step9 = new Step("Enjoy!");
        dessert1.addStep(step9);
        
        // FINALLY add the dessert to the book
        recipes.add(dessert1);
        
        Recipe dessert2 = new Recipe("Brownies", 24, RecipeType.DESSERT);
        dessert2.addTag(Tag.QUICK);
        dessert2.addTag(Tag.VEGETARIAN);
        
        Ingredient sugar2 = new Ingredient("granulated sugar", 1, "cup");
        dessert2.addIngredient(sugar);
        Ingredient salt2 = new Ingredient("salt", 0.5, "teaspoon");
        dessert2.addIngredient(salt);
        Ingredient butter2 = new Ingredient("unsalted butter", 180, "grams");
        dessert2.addIngredient(butter);
        Ingredient egg2 = new Ingredient("large egg", 4, "whole");
        dessert2.addIngredient(egg);
        Ingredient vanilla2 = new Ingredient("vanilla extract", 1, "tablespoon");
        dessert2.addIngredient(egg);
        Ingredient flour2 = new Ingredient("all-purpose flour", 1.25, "cup");
        dessert2.addIngredient(flour);
        Ingredient bsoda2 = new Ingredient("baking soda", 0.75, "teaspoon");
        dessert2.addIngredient(bsoda);
        Ingredient cchip2 = new Ingredient("semisweet chocolate", 170, "grams");
        dessert2.addIngredient(cchip);
        
        Step step11 = new Step("Adjust oven rack to middle position, preheat to 350 degrees. Then, smear butter all over baking pan.");
        dessert2.addStep(step1);
        Step step22 = new Step("In a medium bowl, whisk together flour, baking powder and salt.");
        dessert2.addStep(step2);
        Step step33 = new Step("In large microwave-safe bowl, combine butter and chocolate. Melt and mix together until smooth.");
        dessert2.addStep(step3);
        Step step44 = new Step("Add sugar, eggs, and vanilla to chocolate mixture, mix until smooth.");
        dessert2.addStep(step4);
        Step step55 = new Step("Add chocolate mixture(wet) to flour mixture(dry). Stir together with a rubber spatula. Once combined, scrape chocolate batter into pan. Place chocolate chips on top as you please.");
        dessert2.addStep(step5);
        Step step66 = new Step("Place into over, bake for 30-35 minutes.");
        dessert2.addStep(step6);
        Step step77 = new Step("Once baked, pull it out and let cool for 10 minutes.");
        dessert2.addStep(step7);
        
        recipes.add(dessert2);
    }
    
    /**
     * Returns a list of the highest rated recipe(s) in the book.
     * 
     * @return An ArrayList of the top-rated recipes, or null if the book is empty
     */
    public ArrayList<Recipe> getTopRated() 
    {
        if(!recipes.isEmpty()) {
            ArrayList<Recipe> result = new ArrayList<>();
            int maxRating = recipes.get(0).getRating();
            //find largest rating (int)
            for (Recipe r : recipes) {
                if (r.getRating() > maxRating) {
                    maxRating = r.getRating();
                }
            }
            //find every recipe with largest rating then return them all in an arraylist
            for (Recipe r : recipes) {
                if (r.getRating() == maxRating) {
                    result.add(r);
                }
            }
            return result;
        }
        else {
            return null;
        }
    }
    
    /**
     * Returns a string representation of the RecipeBook.
     * 
     * @return A string in the format "title, author"
     */
    @Override
    public String toString() 
    {
        return title + ", " + author;
    }
    
    /**
     * Compares this RecipeBook with another object for equality based on bookID.
     * 
     * @param other The object to compare with
     * @return true if other is a RecipeBook with the same bookID, false otherwise
     */
    @Override
    public boolean equals(Object other) 
    {
        RecipeBook otherBook = (RecipeBook) other;
        if (other instanceof RecipeBook) {
            if(this.bookID.equals(otherBook.getBookID())) {
                return true;
            }
        }
        return false;
    }
}
