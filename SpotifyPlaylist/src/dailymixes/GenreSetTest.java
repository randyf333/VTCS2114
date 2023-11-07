// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who
// do.
// -- Randy Fu (randyf333)
package dailymixes;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Class for testing GenreSet class
 * 
 * @author randy
 * @version Oct 22, 2023
 */
public class GenreSetTest
    extends TestCase
{
    private GenreSet genreSet;

    /**
     * Setup method
     */
    public void setUp()
    {
        genreSet = new GenreSet(15, 45, 30);
    }


    /**
     * Test getRock method
     */
    public void testGetRock()
    {
        assertEquals(45, genreSet.getRock());
    }


    /**
     * Test getPop method
     */
    public void testGetPop()
    {
        assertEquals(15, genreSet.getPop());
    }


    /**
     * Test getCountry method
     */
    public void testGetCountry()
    {
        assertEquals(30, genreSet.getCountry());
    }


    /**
     * Test toString method
     */
    public void testToString()
    {
        assertEquals("Pop:15 Rock:45 Country:30", genreSet.toString());
    }


    /**
     * Test compareTo method
     */
    public void testCompareTo()
    {
        GenreSet less = new GenreSet(10, 10, 15);
        GenreSet greater = new GenreSet(40, 50, 80);
        GenreSet same = new GenreSet(30, 15, 45);
        assertTrue(genreSet.compareTo(less) > 0);
        assertTrue(genreSet.compareTo(greater) < 0);
        assertEquals(0, genreSet.compareTo(same));
    }


    /**
     * test isWithinRange method
     */
    public void testIsWithinRange()
    {
        GenreSet min = new GenreSet(10, 10, 10);
        GenreSet max = new GenreSet(50, 64, 50);
        assertTrue(genreSet.isWithinRange(min, max));
        GenreSet f1 = new GenreSet(20, 40, 25);
        assertFalse(genreSet.isWithinRange(f1, max));
        GenreSet f2 = new GenreSet(30, 30, 27);
        assertFalse(genreSet.isWithinRange(min, f2));
    }


    /**
     * test Equals method
     */
    public void testEquals()
    {
        GenreSet same = new GenreSet(15, 45, 30);
        assertTrue(genreSet.equals(genreSet));
        assertFalse(genreSet.equals(null));
        assertFalse(genreSet.equals("Other"));
        assertTrue(genreSet.equals(same));
        assertFalse(genreSet.equals(new GenreSet(15, 45, 26)));
        assertFalse(genreSet.equals(new GenreSet(15, 40, 30)));
        assertFalse(genreSet.equals(new GenreSet(10, 45, 30)));
    }
}
