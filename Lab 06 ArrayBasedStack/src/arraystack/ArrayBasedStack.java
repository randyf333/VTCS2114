package arraystack;

import java.util.EmptyStackException;

// -------------------------------------------------------------------------
/**
 * Implement Stack as an array
 * 
 * @param <T>
 * @author tld
 * @version Sep 26, 2023
 */
public class ArrayBasedStack<T>
    implements StackADT<T>
{
    private T[] stackArray;
    private int count;
    private int capacity;

    // ----------------------------------------------------------
    /**
     * Create a new ArrayBasedStack object.
     * 
     * @param limit
     *            capacity of the stack
     */
    @SuppressWarnings("unchecked")
    public ArrayBasedStack(int limit)
    {
        stackArray = (T[])new Object[limit];
        count = 0;
        capacity = limit;
    }


    // ----------------------------------------------------------
    /**
     * Create a new ArrayBasedStack object.
     */
    public ArrayBasedStack()
    {
        this(100);
    }


    /**
     * see if stack is empty
     * 
     * @return true if stack is empty
     */
    @Override
    public boolean isEmpty()
    {
        return count == 0;
    }


    /**
     * Get object on top of stack
     * 
     * @return object on top of the stack
     */
    @Override
    public T peek()
    {
        if (count == 0)
        {
            throw new EmptyStackException();
        }
        return stackArray[count - 1];
    }


    /**
     * Get and remove object on top of stack
     * 
     * @return object on top of the stack
     */
    @Override
    public T pop()
    {
        if (count == 0)
        {
            throw new EmptyStackException();
        }
        T item = stackArray[count - 1];
        stackArray[count - 1] = null;
        count--;
        return item;
    }


    /**
     * Add object to stack, updates size if over capacity
     * 
     * @param item
     *            to add
     */
    @Override
    public void push(T item)
    {
        if (count == capacity)
        {
            expandCapacity();
        }
        stackArray[count] = item;
        count++;

    }


    /**
     * Sees if stack contains item
     * 
     * @param item
     * @return true if stack has item
     */
    @Override
    public boolean contains(T item)
    {
        for (int i = 0; i < count; i++)
        {
            if (stackArray[i].equals(item))
            {
                return true;
            }
        }
        return false;
    }


    @Override
    public int size()
    {
        return count;
    }


    @Override
    public void clear()
    {
        while (count != 0)
        {
            pop();
        }
    }


    @Override
    public Object[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] copy = (T[])new Object[this.size()];
        for (int i = 0; i < this.size(); i++)
        {
            copy[i] = this.stackArray[i];
        }
        return copy;
    }


    /**
     * Expands the capacity of the stack by doubling its current capacity.
     */
    private void expandCapacity()
    {

        @SuppressWarnings("unchecked")
        T[] newArray = (T[])new Object[this.capacity * 2];

        for (int i = 0; i < this.capacity; i++)
        {
            newArray[i] = this.stackArray[i];
        }

        this.stackArray = newArray;
        this.capacity *= 2;
    }


    /**
     * Two stacks are equal iff they both have the same size and contain the
     * same elements in the same order.
     *
     * @param other
     *            the other object to compare to this
     * @return {@code true}, if the stacks are equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object other)
    {
        if (this == other)
        {
            return true;
        }
        if (other == null)
        {
            return false;
        }
        if (this.getClass().equals(other.getClass()))
        {
            ArrayBasedStack<?> otherStack = (ArrayBasedStack<?>)other;
            if (this.size() != otherStack.size())
            {
                return false;
            }
            Object[] otherArray = otherStack.toArray();
            for (int i = 0; i < this.size(); i++)
            {
                if (!(this.stackArray[i].equals(otherArray[i])))
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }


    /**
     * Returns the string representation of the stack. [] (if the stack is
     * empty) [bottom, item, ..., item, top] (if the stack contains items)
     * 
     * @return the string representation of the stack.
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append('[');

        boolean firstItem = true;
        for (int i = 0; i < this.size(); i++)
        {
            if (!firstItem)
            {
                builder.append(", ");
            }
            else
            {
                firstItem = false;
            }

            // String.valueOf will print null or the toString of the item
            builder.append(String.valueOf(this.stackArray[i]));
        }
        builder.append(']');
        return builder.toString();
    }

}
