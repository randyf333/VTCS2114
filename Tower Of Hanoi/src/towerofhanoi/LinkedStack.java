// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who
// do.
// -- Randy Fu (randyf333)
package towerofhanoi;

import stack.StackInterface;
import java.util.EmptyStackException;

// -------------------------------------------------------------------------
/**
 * Class to implement stack as linked list
 * 
 * @param <T>
 * @author randy
 * @version Oct 13, 2023
 */
public class LinkedStack<T>
    implements StackInterface<T>
{

    private int size;
    private Node<T> topNode;

    // ----------------------------------------------------------
    /**
     * Create a new LinkedStack object.
     */
    public LinkedStack()
    {
        topNode = null;
    }


    @Override
    public void clear()
    {
        topNode = null;
        size = 0;
    }


    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }


    @Override
    public T peek()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }


    @Override
    public T pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        T data = topNode.getData();
        topNode = topNode.getNextNode();
        size--;
        return data;
    }


    @Override
    public void push(T value)
    {
        Node<T> newEntry = new Node<T>(value, topNode);
        topNode = newEntry;
        size++;
    }


    /**
     * Return size of stack
     * 
     * @return size
     */
    public int size()
    {
        return size;
    }


    /**
     * Output stack as a string
     * 
     * @return Stack as string
     */
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("[");
        Node<T> node = topNode;
        while (node != null)
        {
            if (s.length() > 1)
            {
                s.append(", ");
            }
            s.append(node.getData());
            node = node.getNextNode();
        }
        s.append("]");
        return s.toString();
    }
}




// -------------------------------------------------------------------------
/**
 * Private class Node
 * 
 * @author randy
 * @version Oct 15, 2023
 * @param <T>
 */
class Node<T>
{
    // ----------------------------------------------------------
    /**
     * Create a new Node object.
     * 
     * @param obj
     * @param next
     */
    private T data;
    private Node<T> next;

    // ----------------------------------------------------------
    /**
     * Create a new Node object.
     * 
     * @param obj
     *            data for node
     * @param node
     *            Next node in link
     */
    public Node(T obj, Node<T> node)
    {
        this(obj);
        this.setNextNode(node);
    }


    // ----------------------------------------------------------
    /**
     * Create a new Node object.
     * 
     * @param obj
     *            data for node
     */
    public Node(T obj)
    {
        this.data = obj;
        next = null;
    }


    // ----------------------------------------------------------
    /**
     * Changes next node
     * 
     * @param node
     *            node to set next to
     */
    public void setNextNode(Node<T> node)
    {
        next = node;
    }


    // ----------------------------------------------------------
    /**
     * Get next node
     * 
     * @return next
     */
    public Node<T> getNextNode()
    {
        return next;
    }


    // ----------------------------------------------------------
    /**
     * Get data of node
     * 
     * @return data
     */
    public T getData()
    {
        return data;
    }

}
