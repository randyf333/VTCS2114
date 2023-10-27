// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who
// do.
// -- Randy Fu (randyf333)
package towerofhanoi;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Class for testing Tower
 * 
 * @author randy
 * @version Oct 15, 2023
 */
public class TowerTest
    extends TestCase
{
    private Tower t;

    /**
     * Setup method for testing
     */
    public void setUp()
    {
        t = new Tower(Position.LEFT);
    }


    /**
     * test position method
     */
    public void testPosition()
    {
        assertEquals(Position.LEFT, t.position());
    }


    /**
     * test push method
     */
    public void testPush()
    {
        Disk d1 = new Disk(8);
        t.push(d1);
        assertEquals(d1, t.peek());
        Disk d2 = new Disk(4);
        t.push(d2);
        assertEquals(d2, t.peek());
        Disk empty = null;
        Exception e1 = null;
        try
        {
            t.push(empty);
        }
        catch (Exception e)
        {
            e1 = e;
        }
        assertTrue(e1 instanceof IllegalArgumentException);
        Exception e2 = null;
        Disk big = new Disk(15);
        try
        {
            t.push(big);
        }
        catch (Exception e)
        {
            e2 = e;
        }
        assertTrue(e2 instanceof IllegalStateException);
    }

}
