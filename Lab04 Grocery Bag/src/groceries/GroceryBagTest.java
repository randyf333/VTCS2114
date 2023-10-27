package groceries;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Class to test GroceryBag Test
 * 
 * @author Randy
 * @version Sep 11, 2023
 */
public class GroceryBagTest extends TestCase {
    private GroceryBag bag1; // unordered
    private GroceryBag bag2; // unordered with repeat items
    private GroceryBag bag3; // ordered
    private GroceryBag bag4; // ordered with repeat items
    // ----------------------------------------------------------

    /**
     * Set up all objects
     */
    public void setUp() {
        bag1 = new GroceryBag();
        bag1.add("apples");
        bag1.add("chips");
        bag1.add("yogurt");
        bag1.add("chicken");
        bag1.add("pasta");

        bag2 = new GroceryBag();
        bag2.add("pizza");
        bag2.add("broccoli");
        bag2.add("pasta");
        bag2.add("pasta");
        bag2.add("apples");

        bag3 = new GroceryBag();
        bag3.add("apples");
        bag3.add("chicken");
        bag3.add("chicken");
        bag3.add("pasta");
        bag3.add("pizza");
        bag3.add("soda");
        bag3.add("yogurt");
        bag3.add("wheat");

        bag4 = new GroceryBag();
        bag4.add("chicken");
        bag4.add("chicken");
        bag4.add("pasta");
        bag4.add("pasta");
        bag4.add("yogurt");
    }


    // ----------------------------------------------------------
    /**
     * Test intersection method
     */
    public void testIntersection() {
        GroceryBag intersect = new GroceryBag();
        intersect.add("chicken");
        intersect.add("pasta");
        intersect.add("yogurt");
        assertTrue(intersect.equals(bag1.intersection(bag4)));
    }


    // ----------------------------------------------------------
    /**
     * Test equals method
     */
    public void testEquals() {
        GroceryBag bag5 = new GroceryBag();
        bag5.add("chips");
        bag5.add("apples");
        bag5.add("pasta");
        bag5.add("chicken");
        bag5.add("yogurt");
        assertTrue(bag1.equals(bag1));
        assertFalse(bag1.equals(null));
        assertFalse(bag1.equals("Hello"));
        assertFalse(bag1.equals(bag2));
        assertTrue(bag1.equals(bag5));
        assertFalse(bag1.equals(bag3));
    }

}
