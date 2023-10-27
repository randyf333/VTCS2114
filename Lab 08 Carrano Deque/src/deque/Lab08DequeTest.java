package deque;

import student.TestCase;

/**
 * Tests for the DLinkedDeque class.
 *
 * @author Randy Fu
 * @version 10/11
 */
public class Lab08DequeTest
    extends TestCase
{
    private Lab08Deque<String> deque;
    private Lab08Deque<String> empty;

    /**
     * Creates two brand new, empty sets for each test method.
     */
    public void setUp()
    {
        deque = new Lab08Deque<String>();
        empty = new Lab08Deque<String>();
    }


// ----------------------------------------------------------
    /**
     * Test addToFront method
     */
    public void testAddFront()
    {
        deque.addToFront("Front");
        assertEquals("Front", deque.getFront());
    }


// ----------------------------------------------------------
    /**
     * Test addToBack method
     */
    public void testAddBack()
    {
        deque.addToBack("Back");
        assertEquals("Back", deque.getBack());
    }


// ----------------------------------------------------------
    /**
     * Test removeFront method
     */
    public void testRemoveFront()
    {
        deque.addToFront("First");
        deque.addToFront("Back");
        assertEquals("Back", deque.removeFront());
        assertEquals("First", deque.removeFront());
        Exception exception = null;
        try
        {
            empty.removeFront();
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue(exception instanceof EmptyQueueException);
    }


// ----------------------------------------------------------
    /**
     * Test removeBack method
     */
    public void testRemoveBack()
    {
        deque.addToBack("Back");
        deque.addToBack("First");
        assertEquals("First", deque.removeBack());
        assertEquals("Back", deque.removeBack());
        Exception exception = null;
        try
        {
            empty.removeBack();
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue(exception instanceof EmptyQueueException);
    }


// ----------------------------------------------------------
    /**
     * Test getFront method
     */
    public void testGetFront()
    {
        deque.addToFront("Back");
        assertEquals("Back", deque.getFront());
        Exception exception = null;
        try
        {
            empty.getFront();
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue(exception instanceof EmptyQueueException);
    }


// ----------------------------------------------------------
    /**
     * test getBack method
     */
    public void testGetBack()
    {
        deque.addToBack("Back");
        assertEquals("Back", deque.getBack());
        Exception exception = null;
        try
        {
            empty.getBack();
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue(exception instanceof EmptyQueueException);
    }


// ----------------------------------------------------------
    /**
     * Test isEmpty method
     */
    public void testIsEmpty()
    {
        deque.addToFront("Things");
        assertTrue(empty.isEmpty());
        assertFalse(deque.isEmpty());
    }


// ----------------------------------------------------------
    /**
     * Test clear method
     */
    public void testClear()
    {
        deque.addToFront("First");
        deque.addToBack("Back");
        deque.addToBack("Stuff");
        deque.clear();
        assertTrue(deque.isEmpty());
    }


    /**
     * Test toString method
     */
    public void testToString()
    {
        deque.addToBack("First");
        deque.addToBack("Second");
        assertEquals("[First, Second]", deque.toString());
        assertEquals("[]", empty.toString());
    }
}
