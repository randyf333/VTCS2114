package towerofhanoi;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Testing class for Disk
 * 
 * @author randy
 * @version Oct 15, 2023
 */
public class DiskTest
    extends TestCase
{
    private Disk disk;

    /**
     * Setup method for DiskTest
     */
    public void setUp()
    {
        disk = new Disk(5);
    }


    // ----------------------------------------------------------
    /**
     * Test compareTo method
     */
    public void testCompareTo()
    {
        Disk smaller = new Disk(3);
        Disk larger = new Disk(8);
        Disk same = new Disk(5);
        Disk none = null;
        assertEquals(-1, disk.compareTo(larger));
        assertEquals(1, disk.compareTo(smaller));
        assertEquals(0, disk.compareTo(same));
        Exception exception = null;
        try
        {
            disk.compareTo(none);
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);

    }


    // ----------------------------------------------------------
    /**
     * Test toString method
     */
    public void testToString()
    {
        assertEquals("5", disk.toString());
    }


    // ----------------------------------------------------------
    /**
     * Test equals method
     */
    public void testEquals()
    {
        Disk same = new Disk(5);
        assertTrue(disk.equals(disk));
        assertFalse(disk.equals(null));
        assertFalse(disk.equals("Other"));
        assertTrue(disk.equals(same));
    }
}
