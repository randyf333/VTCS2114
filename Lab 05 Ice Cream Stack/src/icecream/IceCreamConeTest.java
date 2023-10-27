package icecream;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Class for testing IceCreamCone methods
 * 
 * @author Randy
 * @version Sep 19, 2023
 */
public class IceCreamConeTest extends TestCase {
    private IceCreamCone iceCream;
    private IceCreamCone blueBell;
    private IceCreamCone coldStone;

    /**
     * Set up method
     */
    public void setUp() {
        iceCream = new IceCreamCone();
        iceCream.addScoop("Vanilla");
        iceCream.addScoop("Chocolate");
        iceCream.addScoop("Strawberry");
        
        blueBell = new IceCreamCone();
        blueBell.addScoop("Vanilla");
        blueBell.addScoop("Chocolate");
        blueBell.addScoop("Strawberry");

        coldStone = new IceCreamCone();
        coldStone.addScoop("Vaniila");
        coldStone.addScoop("Mint");

    }


    // ----------------------------------------------------------
    /**
     * Test eatScoop
     */
    public void testEatScoop() {
        assertEquals("Strawberry", iceCream.eatScoop());
    }


    // ----------------------------------------------------------
    /**
     * Test addScoop
     */
    public void testAddScoop() {
        iceCream.addScoop("Coffee");
        assertEquals("Coffee", iceCream.eatScoop());
    }


    // ----------------------------------------------------------
    /**
     * Test numScoops
     */
    public void testNumScoops() {
        assertEquals(3, iceCream.numScoops());
    }


    // ----------------------------------------------------------
    /**
     * Test contains
     */
    public void testContains() {
        assertTrue(iceCream.contains("Vanilla"));
        assertFalse(iceCream.contains("Rocky Road"));
    }


    // ----------------------------------------------------------
    /**
     * Test emptyCone method
     */
    public void testEmptyCone() {
        assertFalse(iceCream.emptyCone());
        iceCream.eatScoop();
        iceCream.eatScoop();
        iceCream.eatScoop();
        assertTrue(iceCream.emptyCone());
    }


    // ----------------------------------------------------------
    /**
     * test CurrentScoop method
     */
    public void testCurrentScoop() {
        assertEquals("Strawberry", iceCream.currentScoop());
        iceCream.eatScoop();
        assertEquals("Chocolate", iceCream.currentScoop());
    }


    // ----------------------------------------------------------
    /**
     * Test toString method
     */
    public void testToString() {
        assertEquals("[Vanilla, Chocolate, Strawberry]", iceCream.toString());
    }


    // ----------------------------------------------------------
    /**
     * Test equals method
     */
    public void testEquals() {
        String bJ = "Ben and Jerry";
        assertTrue(iceCream.equals(blueBell));
        assertFalse(iceCream.equals(coldStone));
        assertFalse(iceCream.equals(bJ));
        assertFalse(iceCream.equals(null));
    }
}
