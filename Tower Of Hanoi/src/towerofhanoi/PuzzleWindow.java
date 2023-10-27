package towerofhanoi;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who
// do.
// -- Randy Fu (randyf333)package project3;

import java.util.Observable;
import java.util.Observer;

// -------------------------------------------------------------------------
/**
 * Class for gui
 * 
 * @author randy
 * @version Oct 15, 2023
 */
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Michael Peters (mpeters01)
import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * The main front-end work and the view for the Tower of Hanoi puzzle
 *
 * @author Michael Peters
 * @version 10.12.2021
 */
public class PuzzleWindow
    implements Observer
{
    private HanoiSolver game;
    private Shape left;
    private Shape middle;
    private Shape right;
    private Window window;
    /**
     * A factor in which the width of the disks are multiplied by
     */
    public static final int WIDTH_FACTOR = 15;
    /**
     * The vertical gap between each disk on the tower
     */
    public static final int DISK_GAP = 0;
    /**
     * The height of each disk on the tower
     */
    public static final int DISK_HEIGHT = 15;

    /**
     * Creates a new PuzzleWindow view for a given HanoiSolver game
     *
     * @param g
     *            the game to create a view for
     */
    public PuzzleWindow(HanoiSolver g)
    {
        this.game = g;
        game.addObserver(this);
        window = new Window();
        window.setSize(1000, 800);
        window.setTitle("Tower of Hanoi");
        int poleHeight = 400;
        int poleY = (window.getGraphPanelHeight() / 2) - poleHeight / 2;
        left = new Shape(
            (200 - 15 / 2),
            poleY,
            15,
            poleHeight,
            new Color(50, 50, 50));
        middle = new Shape(
            ((window.getGraphPanelWidth() / 2) - 15 / 2),
            poleY,
            15,
            poleHeight,
            new Color(50, 50, 50));
        right = new Shape(
            ((window.getGraphPanelWidth() - 200) - 15 / 2),
            poleY,
            15,
            poleHeight,
            new Color(50, 50, 50));
        for (int width =
            (game.disks() + 1) * WIDTH_FACTOR; width > WIDTH_FACTOR; width -=
                WIDTH_FACTOR)
        {
            Disk d = new Disk(width);
            game.getTower(Position.LEFT).push(d);
            window.addShape(d);
            moveDisk(Position.LEFT);
        }
        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);
        Button solve = new Button("Solve");
        window.addButton(solve, WindowSide.NORTH);
        solve.onClick(this, "clickedSolve");
    }


    private void moveDisk(Position position)
    {
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole = null;
        if (position == Position.LEFT)
        {
            currentPole = left;
        }
        else if (position == Position.MIDDLE)
        {
            currentPole = middle;
        }
        else if (position == Position.RIGHT)
        {
            currentPole = right;
        }
        int xcoord = currentPole.getX()
            - ((currentDisk.getWidth() - currentPole.getWidth()) / 2);
        int ycoord = currentPole.getY() + (currentPole.getHeight()
            - (game.getTower(position).size() * DISK_HEIGHT));
        currentDisk.moveTo(xcoord, ycoord);
    }


    /**
     * Updates the view whenever a disk is moved in the back-end
     *
     * @param o
     *            The observable that triggered the update
     * @param arg
     *            arguments sent by the game; should be a position
     */
    @Override
    public void update(Observable o, Object arg)
    {
        if (arg.getClass() == Position.class)
        {
            Position position = (Position)arg;
            moveDisk(position);
            sleep();
        }
    }


    /**
     * Runs when the Solve button is clicked, tells the puzzle to start solving
     *
     * @param button
     *            the button that was clicked
     */
    public void clickedSolve(Button button)
    {
        button.disable();
        new Thread() {
            public void run()
            {
                game.solve();
            }
        }.start();
    }


    private void sleep()
    {
        try
        {
            Thread.sleep(500);
        }
        catch (Exception e)
        {
        }
    }
}
