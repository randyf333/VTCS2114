package project1;

import bag.Bag;
import bag.BagInterface;
import cs2.TextShape;
import student.TestableRandom;
import cs2.Window;
import cs2.Button;
import cs2.WindowSide;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here.
 * Follow it with additional details about its purpose, what abstraction
 * it represents, and how to use it.
 * 
 * @author Randy
 * @version Sep 8, 2023
 */
public class ProjectRunner {
    // ----------------------------------------------------------
    /**
     * Create a new ProjectRunner object.
     */ 

    // ~ Constructors ..........................................................
    public ProjectRunner() {
        // Included in class diagram but not used or needed
    }


    // ----------------------------------------------------------
    /**
     * Main method
     * 
     * @param args
     *            for inputs
     */
    // ~Public Methods ........................................................
    public static void main(String args[]) {
        DisplayCollection display = new DisplayCollection();
        ShapeWindow window = new ShapeWindow(display.getItemBag());
    }
}
