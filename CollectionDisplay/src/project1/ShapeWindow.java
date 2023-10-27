/*
 * Virginia Tech Honor Code
 * As a Hokie, I will conduct myself with honor and integrity at all times
 * I will not lie, cheat, or steal, nor will I accept the actions of those who
 * do
 * Randy Fu (randyf333)
 */
package project1;

import bag.Bag;
import bag.BagInterface;
import cs2.TextShape;
import student.TestableRandom;
import cs2.Window;
import cs2.Button;
import cs2.WindowSide;
import java.awt.Color;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here.
 * Follow it with additional details about its purpose, what abstraction
 * it represents, and how to use it.
 * 
 * @author Randy
 * @version Sep 8, 2023
 */
public class ShapeWindow {
    // ~ Fields ................................................................
    private Window window;
    private TextShape textShape;
    private Button quitButton;
    private Button chooseButton;
    private BagInterface<String> itemBag;

    // ----------------------------------------------------------
    /**
     * Create a new ShapeWindow object.
     * 
     * @param s
     *            BagInterface<String> for constructor
     */
    // ~ Constructors ..........................................................
    public ShapeWindow(BagInterface<String> s) {
        window = new Window();
        window.setTitle("Project 1");
        itemBag = s;
        quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);
        chooseButton = new Button("Choose");
        chooseButton.onClick(this, "clickedChoose");
        window.addButton(chooseButton, WindowSide.SOUTH);
        textShape = new TextShape(0, 0, "");
        window.addShape(textShape);
    }


    // ----------------------------------------------------------
    /**
     * Exit the window button
     * 
     * @param button
     *            button pressed
     */
    // ~Public Methods ........................................................
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    // ----------------------------------------------------------
    /**
     * Choose string from bag
     * 
     * @param button
     *            button pressed
     */
    public void clickedChoose(Button button) {
        if (itemBag.isEmpty()) {
            textShape.setText("No more items");
        }
        else {
            textShape.setText(itemBag.remove());
        }
        colorText();
        centerText();
    }


    /**
     * change color of text
     */
    private void colorText() {
        if (textShape.getText().contains("red")) {
            textShape.setForegroundColor(Color.RED);
        }
        else if (textShape.getText().contains("blue")) {
            textShape.setForegroundColor(Color.BLUE);
        }
        else {
            textShape.setForegroundColor(Color.BLACK);
        }
    }


    /**
     * Make text center in window
     */
    private void centerText() {
        textShape.moveTo((window.getGraphPanelWidth() / 2) - textShape
            .getWidth() / 2, (window.getGraphPanelHeight() / 2) - textShape
                .getHeight() / 2);
    }
}
