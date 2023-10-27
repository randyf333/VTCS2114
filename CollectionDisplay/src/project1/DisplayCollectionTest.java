package project1;

import bag.BagInterface;
import student.TestableRandom;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test class for DisplayCollection methods
 * 
 * @author Randy
 * @version Sep 8, 2023
 */
public class DisplayCollectionTest extends TestCase {
    // ----------------------------------------------------------
    /**
     * Create a new DisplayCollectionTest object.
     */
    public DisplayCollectionTest() {
        // Included in class diagram but not used or needed
    }


    /**
     * setUp method for JUnit testing
     */
    public void setUp() {
        // No fields to instantiate
    }


    /**
     * test for BagContents
     */
    public void testBagContents() {
        DisplayCollection dc = new DisplayCollection();
        BagInterface<String> items = dc.getItemBag();
        int size = items.getCurrentSize();
        for (int i = 0; i < size; i++) {
            assertTrue(findString(items.remove()));
        }
    }


    // ----------------------------------------------------------
    /**
     * Helper method for testBagContents
     * 
     * @param s
     *            string removed from BagInterface
     * @return boolean
     */
    public boolean findString(String s) {
        for (int i = 0; i < DisplayCollection.STRINGS.length; i++) {
            if (s.equals(DisplayCollection.STRINGS[i])) {
                return true;
            }
        }
        return false;
    }


    // ----------------------------------------------------------
    /**
     * test for BagSize
     */
    public void testBagSize() {
        for (int i = 5; i <= 15; i++) {
            TestableRandom.setNextInts(i - 5);
            DisplayCollection dc = new DisplayCollection();
            BagInterface<String> itemBag = dc.getItemBag();
            assertEquals(i, itemBag.getCurrentSize());
        }
    }

}
