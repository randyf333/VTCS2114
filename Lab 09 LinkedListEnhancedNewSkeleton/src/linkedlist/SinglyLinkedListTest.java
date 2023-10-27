package linkedlist;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test class for SinglyLinkedList
 * 
 * @author randy
 * @version Oct 18, 2023
 */
public class SinglyLinkedListTest
    extends TestCase
{
    private SinglyLinkedList<String> test;

    /**
     * Setup method for testing
     */
    public void setUp()
    {
        test = new SinglyLinkedList<String>();
    }


    /**
     * Test size method
     */
    public void testSize()
    {
        assertEquals(0, test.size());
        test.add("A");
        assertEquals(1, test.size());
    }


    /**
     * Test add method based on index;
     */
    public void testAddIndex()
    {
        test.add(0, "A");
        test.add(0, "C");
        test.add(1, "B");
        assertEquals("C", test.get(0));
        assertEquals("B", test.get(1));
        assertEquals("A", test.get(2));
        test.add(3, "D");
        assertEquals("D", test.get(3));
        Exception error = null;
        try
        {
            test.add(8, "B");
        }
        catch (Exception e)
        {
            error = e;
        }
        assertTrue(error instanceof IndexOutOfBoundsException);
        try
        {
            test.add(1, null);
        }
        catch (Exception e)
        {
            error = e;
        }
        assertTrue(error instanceof IllegalArgumentException);
        try
        {
            test.add(-1, "B");
        }
        catch (Exception e)
        {
            error = e;
        }
        assertTrue(error instanceof IndexOutOfBoundsException);

    }


    /**
     * Test add with 1 parameter
     */
    public void testAdd()
    {
        test.add("A");
        test.add("B");
        assertEquals("B", test.get(1));
        Exception error = null;
        try
        {
            test.add(null);
        }
        catch (Exception e)
        {
            error = e;
        }
        assertTrue(error instanceof IllegalArgumentException);
    }


    /**
     * test isEmpty method
     */
    public void testIsEmpty()
    {
        assertTrue(test.isEmpty());
        test.add("Temp");
        assertFalse(test.isEmpty());
    }


    /**
     * test remove method with generics
     */
    public void testRemoveGeneric()
    {
        assertFalse(test.remove("A"));
        test.add("A");
        test.add("B");
        assertTrue(test.remove("B"));
        assertTrue(test.remove("A"));
        assertTrue(test.isEmpty());
        test.add("A");
        test.add("B");
        test.add("C");
        test.add("D");
        test.add("E");
        assertFalse(test.remove("Not"));
        assertTrue(test.remove("C"));
        assertTrue(test.remove("E"));
        assertEquals(3, test.size());
        assertFalse(test.remove(null));
    }


    /**
     * test remove by index
     */
    public void testRemoveInt()
    {
        Exception error = null;
        try
        {
            test.remove(-1);
        }
        catch (Exception e)
        {
            error = e;
        }
        assertTrue(error instanceof IndexOutOfBoundsException);
        try
        {
            test.remove(2);
        }
        catch (Exception e)
        {
            error = e;
        }
        assertTrue(error instanceof IndexOutOfBoundsException);
        test.add("A");
        test.add("B");
        test.add("C");
        assertTrue(test.remove(0));
        assertEquals(2, test.size());
        assertEquals("B", test.get(0));
        assertEquals("C", test.get(1));
        test.add(0, "A");
        test.remove(1);
        assertEquals("{A, C}", test.toString());
        try
        {
            test.remove(4);
        }
        catch (Exception e)
        {
            error = e;
        }
        assertTrue(error instanceof IndexOutOfBoundsException);
    }


    /**
     * Test get method
     */
    public void testGet()
    {
        test.add("A");
        assertEquals("A", test.get(0));
        test.add("B");
        test.add("C");
        assertEquals("C", test.get(2));
        Exception error = null;
        try
        {
            test.get(6);
        }
        catch (Exception e)
        {
            error = e;
        }
        assertTrue(error instanceof IndexOutOfBoundsException);
        try
        {
            test.get(-1);
        }
        catch (Exception e)
        {
            error = e;
        }
        assertTrue(error instanceof IndexOutOfBoundsException);

    }


    /**
     * test contains method
     */
    public void testContains()
    {
        test.add("A");
        test.add("B");
        test.add("C");
        assertTrue(test.contains("B"));
        assertTrue(test.contains("A"));
        assertTrue(test.contains("C"));
        assertFalse(test.contains("D"));
        assertFalse(test.contains(null));
    }


    /**
     * test clear method
     */
    public void testClear()
    {
        test.clear();
        test.add("A");
        test.add("B");
        test.add("C");
        test.clear();
        assertTrue(test.isEmpty());
    }


    /**
     * test lastIndexOf method
     */
    public void testLastIndexOf()
    {
        test.add("A");
        test.add("B");
        test.add("C");
        test.add("B");
        test.add("D");
        assertEquals(-1, test.lastIndexOf("P"));
        assertEquals(3, test.lastIndexOf("B"));
        assertEquals(4, test.lastIndexOf("D"));
    }


    /**
     * test toString method
     */
    public void testToString()
    {
        assertEquals("{}", test.toString());
        test.add("A");
        test.add("B");
        test.add("C");
        assertEquals("{A, B, C}", test.toString());
    }
}
