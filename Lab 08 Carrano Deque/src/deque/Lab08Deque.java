package deque;

/**
 * A deque implemented using a doubly-linked chain.
 *
 * @param <T>
 *            The type of elements contained in the deque.
 * @author Randy Fu randyf333
 * @version 10/9
 */
public class Lab08Deque<T>
    extends DLinkedDeque<T>
{
// ----------------------------------------------------------
    /**
     * Create a new Lab08Deque object.
     */
    public Lab08Deque()
    {
        super();
    }


    /**
     * Inserts a new item at the front of the deque.
     *
     * @param newEntry
     *            the item to insert.
     */
    public void addToFront(T newEntry)
    {
        DLNode<T> anEntry = new DLNode<T>(newEntry);
        if (isEmpty())
        {
            firstNode = anEntry;
            lastNode = anEntry;
        }
        else
        {
            anEntry.setNextNode(firstNode);
            firstNode.setPreviousNode(anEntry);
            firstNode = anEntry;
        }
        size++;
    }


    /**
     * Insert a new item at the rear of the deque.
     *
     * @param newEntry
     *            the item to insert.
     */
    public void addToBack(T newEntry)
    {
        DLNode<T> anEntry = new DLNode<T>(newEntry);
        if (isEmpty())
        {
            firstNode = anEntry;
            lastNode = anEntry;
        }
        else
        {
            anEntry.setPreviousNode(lastNode);
            lastNode.setNextNode(anEntry);
            lastNode = anEntry;
        }
        size++;
    }


    /**
     * Remove the item at the front of the deque.
     *
     * @return The item that was removed
     * @throws EmptyQueueException
     *             if there is not an element at the front
     */
    public T removeFront()
    {
        if (firstNode == null)
        {
            throw new EmptyQueueException();
        }
        T frontValue = firstNode.getData();
        firstNode = firstNode.getNextNode();
        if (firstNode == null)
        {
            lastNode = null;
        }
        size--;
        return frontValue;
    }


    /**
     * Remove the item at the rear of the deque.
     *
     * @return The item that was removed
     * @throws EmptyQueueException
     *             if there is no element at the back
     */
    public T removeBack()
    {
        if (lastNode == null)
        {
            throw new EmptyQueueException();
        }
        T backValue = lastNode.getData();
        lastNode = lastNode.getPreviousNode();
        if (lastNode == null)
        {
            firstNode = null;
        }
        size--;
        return backValue;
    }


    /**
     * Get the item at the front (the head) of the deque. Does not alter the
     * deque.
     *
     * @return the item at the front of the deque.
     * @throws EmptyQueueException
     *             if no element at the front
     */
    public T getFront()
    {
        if (firstNode == null)
        {
            throw new EmptyQueueException();
        }
        return firstNode.getData();
    }


    /**
     * Get the item at the rear (the tail) of the deque. Does not alter the
     * deque.
     *
     * @return the item at the rear of the deque.
     * @throws EmptyQueueException
     *             if no element at rear
     */
    public T getBack()
    {
        if (lastNode == null)
        {
            throw new EmptyQueueException();
        }
        return lastNode.getData();
    }


    /**
     * Check if the deque is empty
     *
     * @return true if the deque has no items
     */
    public boolean isEmpty()
    {
        return size() == 0;
    }


    /**
     * Empty the deque.
     */
    public void clear()
    {
        while (!isEmpty())
        {
            removeFront();
        }
    }


// ----------------------------------------------------------
    /**
     * Returns a string representation of this deque. A deque's string
     * representation is written as a comma-separated list of its contents (in
     * front-to-rear order) surrounded by square brackets, like this: [52, 14,
     * 12, 119, 73, 80, 35] An empty deque is simply [].
     *
     * @return a string representation of the deque
     */
    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("[");
        DLNode<T> p = firstNode;
        while (p != null)
        {
            if (s.length() > 1)
            {
                s.append(", ");
            }
            s.append(p.getData());
            p = p.getNextNode();
        }
        s.append("]");
        return s.toString();
    }
}
