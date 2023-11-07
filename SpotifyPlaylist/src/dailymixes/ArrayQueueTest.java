// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who
// do.
// -- Randy Fu (randyf333)
package dailymixes;

import queue.EmptyQueueException;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test class for ArrayQueue
 * 
 * @author randy
 * @version Oct 30, 2023
 */
public class ArrayQueueTest
    extends TestCase
{
    private ArrayQueue<String> queue;

    /**
     * Setup method
     */
    public void setUp()
    {
        queue = new ArrayQueue<String>(3);
    }


    /**
     * Test clear method
     */
    public void testClear()
    {
        queue.enqueue("One");
        queue.enqueue("Two");
        queue.enqueue("Three");
        assertEquals(3, queue.getSize());
        queue.clear();
        assertEquals(0, queue.getSize());
    }


    /**
     * Test equals method
     */
    public void testEquals()
    {
        ArrayQueue<String> same = new ArrayQueue<String>(3);
        ArrayQueue<String> diff = new ArrayQueue<String>();
        ArrayQueue<String> diff2 = new ArrayQueue<String>();
        assertFalse(queue.equals(null));
        assertFalse(queue.equals("other"));
        assertTrue(queue.equals(queue));
        assertTrue(queue.equals(same));
        queue.enqueue("t1");
        queue.enqueue("t2");
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("4");
        queue.enqueue("5");
        queue.enqueue("6");
        same.enqueue("temp");
        same.enqueue("temp2");
        same.enqueue("1");
        same.enqueue("2");
        same.enqueue("3");
        same.enqueue("4");
        same.enqueue("5");
        same.enqueue("6");
        same.dequeue();
        same.dequeue();
        diff.enqueue("First");
        diff.enqueue("Sec");
        diff.enqueue("Third");
        diff.enqueue("4");
        diff.enqueue("5");
        diff.enqueue("6");
        assertFalse(queue.equals(diff));
        assertTrue(queue.equals(same));
        diff2.enqueue("One");
        diff2.enqueue("Two");
        diff2.enqueue("three");
        assertFalse(queue.equals(diff2));
    }


    /**
     * Test dequeue method
     */
    public void testDequeue()
    {
        Exception error = null;
        try
        {
            queue.dequeue();
        }
        catch (Exception e)
        {
            error = e;
        }
        assertTrue(error instanceof EmptyQueueException);
        queue.enqueue("First");
        assertEquals("First", queue.dequeue());
        assertEquals(0, queue.getSize());
    }


    /**
     * Test enqueue method
     */
    public void testEnqueue()
    {
        queue.enqueue("First");
        assertEquals(1, queue.getSize());
        for (int i = 0; i < 6; i++)
        {
            queue.enqueue("" + i);
        }
        assertEquals(7, queue.getSize());
        assertEquals("First", queue.getFront());
        queue.clear();
        queue.enqueue("1");
        assertEquals("1", queue.getFront());
    }


    /**
     * Test getFront method
     */
    public void testGetFront()
    {
        Exception error = null;
        try
        {
            queue.getFront();
        }
        catch (Exception e)
        {
            error = e;
        }
        assertTrue(error instanceof EmptyQueueException);
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");
        queue.enqueue("Fourth");
        queue.enqueue("Fifth");
        assertEquals("First", queue.getFront());
        queue.dequeue();
        assertEquals("Second", queue.getFront());
    }


    /**
     * Test isEmpty method
     */
    public void testIsEmpty()
    {
        assertTrue(queue.isEmpty());
        queue.enqueue("One");
        assertFalse(queue.isEmpty());
    }


    /**
     * Test getLengthUnderlyingArray method
     */
    public void testGetLengthUnderlyingArray()
    {
        assertEquals(4, queue.getLengthOfUnderlyingArray());
    }


    /**
     * Test getSize method
     */
    public void testGetSize()
    {
        assertEquals(0, queue.getSize());
        queue.enqueue("One");
        assertEquals(1, queue.getSize());
    }


    /**
     * Test toArray method
     */
    public void testToArray()
    {
        Exception error = null;
        try
        {
            queue.toArray();
        }
        catch (Exception e)
        {
            error = e;
        }
        assertTrue(error instanceof EmptyQueueException);
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        Object[] arr = queue.toArray();
        assertEquals("1", arr[0]);
        assertEquals("2", arr[1]);
        assertEquals("3", arr[2]);
        queue.enqueue("4");
        queue.enqueue("5");
        queue.dequeue();
        queue.enqueue("6");
        queue.dequeue();
        queue.enqueue("7");
        Object[] test = queue.toArray();
        for (int i = 0; i < test.length; i++)
        {
            System.out.println(test[i]);
        }
    }


    /**
     * Test toString method
     */
    public void testToString()
    {
        assertEquals("[]", queue.toString());
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        assertEquals("[1, 2, 3]", queue.toString());
    }
}
