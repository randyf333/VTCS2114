package arraystack;

import java.util.EmptyStackException;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Class for testing ArrayBasedStack methods
 * 
 * @author Randy Fu
 * @version Sep 27, 2023
 */
public class ArrayBasedStackTest
    extends TestCase
{
    private ArrayBasedStack<String> stack;
    private ArrayBasedStack<String> empty;

    // ----------------------------------------------------------
    /**
     * Method for setting up the testing
     */
    public void setUp()
    {
        stack = new ArrayBasedStack<String>(3);
        stack.push("Item1");
        stack.push("Item2");
        empty = new ArrayBasedStack<String>();
    }


    // ----------------------------------------------------------
    /**
     * test isEmpty method
     */
    public void testIsEmpty()
    {
        assertFalse(stack.isEmpty());
        assertTrue(empty.isEmpty());
    }


    // ----------------------------------------------------------
    /**
     * Test peek method
     */
    public void testPeek()
    {
        assertEquals("Item2", stack.peek());
        Exception thrown = null;
        try
        {
            empty.peek();
        }
        catch (Exception e)
        {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
    }


    // ----------------------------------------------------------
    /**
     * Test pop method
     */
    public void testPop()
    {
        assertEquals("Item2", stack.pop());
        Exception thrown = null;
        try
        {
            empty.pop();
        }
        catch (Exception e)
        {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
        assertEquals(1, stack.size());
    }


    // ----------------------------------------------------------
    /**
     * Test push method
     */
    public void testPush()
    {
        stack.push("Item3");
        assertEquals(3, stack.size());
        stack.push("Item4");
        assertEquals(4, stack.size());
        assertEquals("Item4", stack.peek());
    }


    // ----------------------------------------------------------
    /**
     * Test equals method
     */
    public void testEquals()
    {
        ArrayBasedStack<String> other = new ArrayBasedStack<String>(3);
        ArrayBasedStack<String> sizeDiff = new ArrayBasedStack<String>(5);
        ArrayBasedStack<String> order = new ArrayBasedStack<String>(3);
        ArrayBasedStack<String> same = new ArrayBasedStack<String>(3);
        other.push("Item1");
        other.push("Item4");
        order.push("Item2");
        order.push("Item1");
        same.push("Item1");
        same.push("Item2");
        assertTrue(stack.equals(stack));
        assertFalse(stack.equals(null));
        assertFalse(stack.equals("Otherthing"));
        assertFalse(stack.equals(empty));
        assertFalse(stack.equals(other));
        assertFalse(stack.equals(sizeDiff));
        assertFalse(stack.equals(order));
        assertTrue(stack.equals(same));

    }


    // ----------------------------------------------------------
    /**
     * Test contains method
     */
    public void testContains()
    {
        assertTrue(stack.contains("Item1"));
        assertFalse(stack.contains("Item4"));
    }


    // ----------------------------------------------------------
    /**
     * Test size method
     */
    public void testSize()
    {
        assertEquals(2, stack.size());
    }


    // ----------------------------------------------------------
    /**
     * Test clear method
     */
    public void testClear()
    {
        stack.clear();
        assertEquals(0, stack.size());
    }


    // ----------------------------------------------------------
    /**
     * Test toArray method
     */
    public void testToArray()
    {
        Object[] obj = stack.toArray();
        assertEquals("Item1", obj[0]);
        assertEquals("Item2", obj[1]);
    }


    // ----------------------------------------------------------
    /**
     * Test toString
     */
    public void testToString()
    {
        String str = "[Item1, Item2]";
        assertEquals(str, stack.toString());
    }
}
