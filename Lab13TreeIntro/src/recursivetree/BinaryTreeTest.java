package recursivetree;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Testing class for Binary Trees
 * 
 * @author randy
 * @version Nov 13, 2023
 */
public class BinaryTreeTest
    extends TestCase
{
    private BinaryTree<String> tree;
    private BinaryTree<String> t2;
    private BinaryTree<String> t3;

    /**
     * Setup testing
     */
    public void setUp()
    {
        tree = new BinaryTree<String>("root");
        t2 = new BinaryTree<String>("root");
        t3 = new BinaryTree<String>(
            "root",
            new BinaryTree<String>("l1"),
            new BinaryTree<String>("r1"));
    }


    /**
     * Test getElement method
     */
    public void testGetElement()
    {
        assertEquals("root", tree.getElement());
    }


    /**
     * Test setElement method
     */
    public void testSetElement()
    {
        tree.setElement("newRoot");
        assertEquals("newRoot", tree.getElement());
    }


    /**
     * Test getLeft method
     */
    public void testGetLeft()
    {
        assertNull(tree.getLeft());
        tree.setLeft(new BinaryTree<String>("l1"));
        assertEquals("l1", tree.getLeft().getElement());
    }


    /**
     * Test getRight method
     */
    public void testGetRight()
    {
        assertNull(tree.getRight());
        tree.setRight(new BinaryTree<String>("r1"));
        assertEquals("r1", tree.getRight().getElement());
    }


    /**
     * Test setLeft method
     */
    public void testSetLeft()
    {
        tree.setLeft(new BinaryTree<String>("l1"));
        assertEquals("l1", tree.getLeft().getElement());
    }


    /**
     * Test setRight method
     */
    public void testSetRight()
    {
        tree.setRight(new BinaryTree<String>("r1"));
        assertEquals("r1", tree.getRight().getElement());
    }


    /**
     * Test size method
     */
    public void testSize()
    {
        assertEquals(1, tree.size());
        tree.setLeft(new BinaryTree<String>("l1"));
        assertEquals(2, tree.size());

        t2.setRight(new BinaryTree<String>("r1"));
        assertEquals(2, t2.size());
    }


    /**
     * Test height method
     */
    public void testHeight()
    {
        assertEquals(1, tree.height());
        tree.setLeft(new BinaryTree<String>("l1"));
        assertEquals(2, tree.height());

        t2.setRight(new BinaryTree<String>("r1"));
        assertEquals(2, t2.height());

        assertEquals(2, t3.height());
    }


    /**
     * Test toPreOrderString method
     */
    public void testToPreOrderString()
    {
        tree.setLeft(new BinaryTree<String>("l1"));
        tree.setRight(new BinaryTree<String>("r1"));
        assertEquals("(root(l1)(r1))", tree.toPreOrderString());
    }


    /**
     * Test toInOrderString method
     */
    public void testToInOrderString()
    {
        tree.setLeft(new BinaryTree<String>("l1"));
        tree.setRight(new BinaryTree<String>("r1"));
        assertEquals("((l1)root(r1))", tree.toInOrderString());
    }


    /**
     * Test toPostOrderString
     */
    public void testToPostOrderString()
    {
        tree.setLeft(new BinaryTree<String>("l1"));
        tree.setRight(new BinaryTree<String>("r1"));
        assertEquals("((l1)(r1)root)", tree.toPostOrderString());
    }
}
