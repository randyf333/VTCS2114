package project1;

import bag.Bag;
import bag.BagInterface;
import student.TestableRandom;

// -------------------------------------------------------------------------
/**
 * Class for DisplayCollection
 * 
 * @author Randy
 * @version Sep 8, 2023
 */
public class DisplayCollection {
    // ~ Fields ................................................................
    /**
     * Array of possible strings to appear
     */
    public static final String[] STRINGS = new String[] { "red circle",
        "blue circle", "red square", "blue square" };
    private BagInterface<String> itemBag;

    // ----------------------------------------------------------
    /**
     * Create a new DisplayCollection object.
     */
    // ~ Constructors ..........................................................
    public DisplayCollection() {
        this.itemBag = new Bag<>();
        TestableRandom random = new TestableRandom();
        int number = random.nextInt(11) + 5;
        for (int i = 0; i < number; i++) {
            itemBag.add(STRINGS[random.nextInt(STRINGS.length)]);
        }
    }


    // ----------------------------------------------------------
    /**
     * Method to getItemBag
     * 
     * @return itemBag
     */
    // ~Public Methods ........................................................
    public BagInterface<String> getItemBag() {
        return itemBag;
    }
}
