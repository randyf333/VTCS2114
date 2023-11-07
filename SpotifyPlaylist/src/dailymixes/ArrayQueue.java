// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who
// do.
// -- Randy Fu (randyf333)
package dailymixes;

import queue.EmptyQueueException;
import queue.QueueInterface;

// -------------------------------------------------------------------------
/**
 * ArrayQueue class
 * 
 * @author Randy Fu (randyf333)
 * @version Oct 29, 2023
 * @param <T>
 */
public class ArrayQueue<T>
    implements QueueInterface<T>
{
    /**
     * Default capacity for array
     */
    public static final int DEFAULT_CAPACITY = 20;
    private T[] queue;
    private int dequeueIndex;
    private int size;
    private int enqueueIndex;

    // ----------------------------------------------------------
    /**
     * Create a new ArrayQueue object.
     * 
     * @param num
     *            size of array queue
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int num)
    {
        queue = (T[])new Object[num + 1];
        size = 0;
        dequeueIndex = 0;
        enqueueIndex = queue.length - 1;
    }


    // ----------------------------------------------------------
    /**
     * Create a new ArrayQueue object.
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue()
    {
        size = 0;
        queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        dequeueIndex = 0;
        enqueueIndex = queue.length - 1;
    }


    @SuppressWarnings("unchecked")
    @Override
    /**
     * clear the queue of all elements
     */
    public void clear()
    {
        size = 0;
        queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        enqueueIndex = queue.length - 1;
        dequeueIndex = 0;

    }


    private int incrementIndex(int index)
    {
        return ((index + 1) % queue.length);
    }


    /**
     * Check equals method
     * 
     * @return true if two arrayqueues are equal
     * @param other
     *            other object to compare equals to
     */
    @SuppressWarnings("unchecked")
    public boolean equals(Object other)
    {
        if (other == null)
        {
            return false;
        }
        if (other == this)
        {
            return true;
        }
        if (other.getClass() == this.getClass())
        {
            ArrayQueue<T> temp = (ArrayQueue<T>)other;
            if (temp.getSize() == this.size)
            {
                if (this.size == 0)
                {
                    return true;
                }
                Object[] arr = temp.toArray();
                Object[] queueArr = this.toArray();
                for (int i = 0; i < size; i++)
                {
                    if (!arr[i].equals(queueArr[i]))
                    {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }


    /**
     * Remove item from queue
     * 
     * @return first element in queue
     */
    @Override
    public T dequeue()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        T data = queue[dequeueIndex];
        queue[dequeueIndex] = null;
        dequeueIndex = incrementIndex(dequeueIndex);
        size--;
        return data;
    }


    /**
     * Add element to queue
     * 
     * @param value
     *            Object to enqueue
     */
    @Override
    public void enqueue(T value)
    {
        ensureCapacity();
        enqueueIndex = (enqueueIndex + 1) % queue.length;
        queue[enqueueIndex] = value;
        size++;
    }


    /**
     * Get first element in queue but not remove
     * 
     * @return first element in queue
     */
    @Override
    public T getFront()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        return queue[dequeueIndex];
    }


    /**
     * Check if queue is empty
     * 
     * @return true if empty
     */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }


    @SuppressWarnings("unchecked")
    private void ensureCapacity()
    {
        if (isFull())
        {
            T[] oldContents = queue;
            int oldSize = oldContents.length;
            int newSize = (2 * oldSize) - 1;
            queue = (T[])new Object[newSize];
            int j = dequeueIndex;
            for (int i = 0; i < oldSize - 1; i++)
            {
                queue[i] = oldContents[j];
                j = (j + 1) % oldContents.length;
            }
            dequeueIndex = 0;
            enqueueIndex = oldSize - 2;
        }

    }


    // ----------------------------------------------------------
    /**
     * Return underlying length of array
     * 
     * @return capacity+1
     */
    public int getLengthOfUnderlyingArray()
    {
        return queue.length;
    }


    // ----------------------------------------------------------
    /**
     * Get size of queue
     * 
     * @return size
     */
    public int getSize()
    {
        return size;
    }


    private boolean isFull()
    {
        return (enqueueIndex + 2) % queue.length == dequeueIndex;
    }


    /**
     * Output queue as array
     * 
     * @return array of elements in queue
     */
    public Object[] toArray()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        int j = dequeueIndex;
        Object[] arr = new Object[size];
        for (int i = 0; i < size; i++)
        {
            arr[i] = queue[j];
            j = incrementIndex(j);
        }
        return arr;
    }


    /**
     * Output queue as string
     * 
     * @return string
     */
    public String toString()
    {
        if (isEmpty())
        {
            return "[]";
        }
        StringBuilder s = new StringBuilder();
        int dequeueTemp = dequeueIndex;
        s.append("[");
        for (int i = 0; i < size - 1; i++)
        {
            s.append(queue[dequeueIndex].toString());
            s.append(", ");
            dequeueIndex = incrementIndex(dequeueIndex);
        }
        s.append(queue[dequeueIndex]);
        s.append("]");
        dequeueIndex = dequeueTemp;
        return s.toString();
    }
}
