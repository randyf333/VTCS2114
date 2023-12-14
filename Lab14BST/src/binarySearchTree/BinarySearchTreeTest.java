package binarySearchTree;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Class to test BinarySearchTree
 * 
 * @author randy
 * @version Nov 29, 2023
 */
public class BinarySearchTreeTest
    extends TestCase
{
    private Lab14BinarySearchTree<String> tree;

    /**
     * Set up method
     */
    public void setUp()
    {
        tree = new Lab14BinarySearchTree<String>();
    }


    /**
     * Test insert method
     */
    public void testInsert()
    {
        tree.insert("a");
        assertFalse(tree.isEmpty());
        tree.insert("b");
        tree.insert("c");
        assertEquals("(a, b, c)", tree.toString());
        tree.insert("e");
        tree.insert("d");
        assertEquals("(a, b, c, d, e)", tree.toString());
        Exception exception = null;
        try
        {
            tree.insert("b");
        }
        catch (DuplicateItemException e)
        {
            exception = e;
        }
        assertNotNull(exception);
    }


    /**
     * Test remove method
     */
    public void testRemove()
    {
        tree.insert("d");
        tree.insert("e");
        tree.insert("a");
        tree.insert("c");
        tree.insert("b");
        tree.insert("f");
        tree.remove("c");
        assertEquals("(a, b, d, e, f)", tree.toString());
        tree.remove("b");
        assertEquals("(a, d, e, f)", tree.toString());
        tree.remove("a");
        assertEquals("(d, e, f)", tree.toString());
        tree.insert("b");
        tree.remove("d");
        assertEquals("(b, e, f)", tree.toString());
        Exception exception = null;
        try
        {
            tree.remove("g");
        }
        catch (ItemNotFoundException e)
        {
            exception = e;
        }
        assertNotNull(exception);
    }


    /**
     * Test findMin method
     */
    public void testFindMin()
    {
        assertNull(tree.findMin());
        tree.insert("c");
        tree.insert("a");
        tree.insert("b");
        tree.insert("d");
        tree.insert("e");
        tree.insert("f");
        assertEquals("a", tree.findMin());
        tree.remove("a");
        assertEquals("b", tree.findMin());
    }


    /**
     * Test findMax method
     */
    public void testFindMax()
    {
        assertNull(tree.findMax());
        tree.insert("a");
        tree.insert("b");
        tree.insert("c");
        tree.insert("d");
        assertEquals("d", tree.findMax());
        tree.remove("d");
        assertEquals("c", tree.findMax());
    }


    /**
     * Test find method
     */
    public void testFind()
    {
        tree.insert("d");
        tree.insert("b");
        tree.insert("a");
        tree.insert("c");
        tree.insert("e");
        tree.insert("f");
        assertNull(tree.find("g"));
        assertEquals("a", tree.find("a"));
        assertEquals("c", tree.find("c"));
    }


    /**
     * Test makeEmpty method
     */
    public void testMakeEmpty()
    {
        tree.insert("a");
        tree.insert("b");
        tree.insert("c");
        tree.insert("d");
        assertFalse(tree.isEmpty());
        tree.makeEmpty();
        assertTrue(tree.isEmpty());
    }


    /**
     * Test isEmpty method
     */
    public void testIsEmpty()
    {
        assertTrue(tree.isEmpty());
        tree.insert("a");
        assertFalse(tree.isEmpty());
    }


    /**
     * Test toString method
     */
    public void testToString()
    {
        assertEquals("()", tree.toString());
        tree.insert("a");
        tree.insert("b");
        tree.insert("c");
        tree.insert("d");
        assertEquals("(a, b, c, d)", tree.toString());
    }
}
