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
 * Testing class for LinkedStack
 * 
 * @author randy
 * @version Oct 15, 2023
 */
public class LinkedStackTest
    extends TestCase
{
    private LinkedStack<String> stack;

    /**
     * Setup method
     */
    public void setUp()
    {
        stack = new LinkedStack<String>();
    }


    // ----------------------------------------------------------
    /**
     * Test push method
     */
    public void testPush()
    {
        stack.push("Bottom");
        assertEquals(1, stack.size());
        assertEquals("Bottom", stack.peek());
    }


    /**
     * Test peek method
     */
    public void testPeek()
    {
        stack.push("First");
        assertEquals("First", stack.peek());
    }


    /**
     * test pop method
     */
    public void testPop()
    {
        stack.push("First");
        assertEquals("First", stack.pop());
        assertEquals(0, stack.size());
    }


    // ----------------------------------------------------------
    /**
     * test clear method
     */
    public void testClear()
    {
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        stack.push("Four");
        stack.clear();
        assertTrue(stack.isEmpty());
    }


    /**
     * test isEmpty method
     */
    public void testEmpty()
    {
        assertTrue(stack.isEmpty());
        stack.push("One");
        assertFalse(stack.isEmpty());
    }


    /**
     * test size method
     */
    public void testSize()
    {
        assertEquals(0, stack.size());
    }


    /**
     * test toString method
     */
    public void testToString()
    {
        stack.push("First");
        stack.push("Second");
        assertEquals("[Second, First]", stack.toString());
    }
}
