

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class RecipeBookTest.
 *
 * @author  Cristina A
 * @version (a version number or a date)
 */
public class RecipeBookTest
{
    /**
     * Default constructor for test class RecipeBookTest
     */
    public RecipeBookTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testAddRecipe()
    {
        Recipe recipe1 = new Recipe("test", 2, RecipeType.DRINK);
        RecipeBook recipeBo1 = new RecipeBook("book", "john", "1");
        recipeBo1.addRecipe(recipe1);
        assertEquals(recipe1, recipeBo1.listAllRecipes().get(0));
    }
}


