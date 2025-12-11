

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class RecipeTest.
 *
 * @author  Julien P-H
 * @version (a version number or a date)
 */
public class RecipeTest
{
    /**
     * Default constructor for test class RecipeTest
     */
    public RecipeTest()
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
    public void testSetRating()
    {
        Recipe recipe1 = new Recipe("test", 2, RecipeType.DRINK);
        assertEquals(0, recipe1.getRating());
        recipe1.setRating(5);
        assertEquals(5, recipe1.getRating());
    }
    
    @Test
    public void testScaleServings()
    {
        Recipe recipe1 = new Recipe("test", 5, RecipeType.DRINK);
        assertEquals(5, recipe1.getServings());
        recipe1.scaleServings(2);
        assertEquals(10, recipe1.getServings());
    }

    @Test
    public void testToString()
    {
        Recipe recipe1 = new Recipe("test", 2, RecipeType.DESSERT);
        assertEquals("test", recipe1.toString());
    }
}



