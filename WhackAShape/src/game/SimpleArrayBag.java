// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who
// do.
// -- Randy Fu (randyf333)
package game;

import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * // -------------------------------------------------------------------------
 * /** Class for ArrayBag which implements bag as array
 * 
 * @param <T>
 * @author Randy Fu
 * @version Sep 24, 2023
 */
public class SimpleArrayBag<T>
    implements SimpleBagInterface<T>
{
    private T[] bag;
    private static final int MAX = 18;
    private int numberOfEntries;

    // ----------------------------------------------------------
    /**
     * Create a new SimpleArrayBag object.
     */
    public SimpleArrayBag()
    {
        @SuppressWarnings("unchecked")
        T[] tempbag = (T[])new Object[MAX];
        bag = tempbag;
        numberOfEntries = 0;
    }


    /**
     * Add item to array
     * 
     * @return true if add is successful
     */
    @Override
    public boolean add(T anEntry)
    {
        if (numberOfEntries >= MAX || anEntry == null)
        {
            return false;
        }
        bag[numberOfEntries] = anEntry;
        numberOfEntries++;
        return true;
    }


    /**
     * get current size
     * 
     * @return numberOfEntries
     */
    @Override
    public int getCurrentSize()
    {
        return numberOfEntries;
    }


    /**
     * See if array is empty
     * 
     * @return true if array is empty
     */
    @Override
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }


    /**
     * Method to randomly select item from bag
     * 
     * @return item at index
     */

    @Override
    public T pick()
    {
        if (isEmpty())
        {
            return null;
        }
        TestableRandom generator = new TestableRandom();
        int index = generator.nextInt(numberOfEntries);
        return bag[index];
    }


    /**
     * Helper method for remove, gets index of anEntry
     * 
     * @param T
     *            anEntry
     * @return index of anEntry
     */
    private int getIndexOf(T anEntry)
    {
        for (int i = 0; i < numberOfEntries; i++)
        {
            if (bag[i].equals(anEntry))
            {
                return i;
            }
        }
        return -1;
    }


    /**
     * Method to remove anEntry
     * 
     * @param anEntry
     * @return true if item removed successfully
     */
    @Override
    public boolean remove(T anEntry)
    {
        int index = getIndexOf(anEntry);
        if (index == -1)
        {
            return false;
        }
        bag[index] = bag[numberOfEntries - 1];
        bag[numberOfEntries - 1] = null;
        numberOfEntries--;
        return true;
    }

}
