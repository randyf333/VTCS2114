// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who
// do.
// -- Randy Fu (randyf333)
package towerofhanoi;

import java.util.Observable;

// -------------------------------------------------------------------------
// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author randy
 * @version Oct 16, 2023
 */
public class HanoiSolver
    extends Observable
{
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;

    // ----------------------------------------------------------
    /**
     * Create a new HanoiSolver object.
     * 
     * @param num
     *            number of disks in tower
     */
    public HanoiSolver(int num)
    {
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
        numDisks = num;
    }


    // ----------------------------------------------------------
    /**
     * Get number of disks in tower
     * 
     * @return numDisks
     */
    public int disks()
    {
        return numDisks;
    }


    // ----------------------------------------------------------
    /**
     * Get specific tower at position
     * 
     * @param pos
     *            position of the tower
     * @return position
     */
    public Tower getTower(Position pos)
    {
        switch (pos)
        {
            case LEFT:
                return left;
            case MIDDLE:
                return middle;
            case RIGHT:
                return right;
            default:
                return middle;
        }
    }


    /**
     * toString of towers
     * 
     * @return string display of towers
     */
    public String toString()
    {
        return left.toString() + middle.toString() + right.toString();
    }


    /**
     * method to move disk
     */
    private void move(Tower source, Tower destination)
    {
        Disk mover = source.pop();
        destination.push(mover);
        setChanged();
        notifyObservers(destination.position());
    }


    /**
     * helper solve puzzle method
     */
    private
        void
        solveTowers(int num, Tower startPole, Tower tempPole, Tower endPole)
    {
        if (num == 1)
        {
            move(startPole, endPole);
        }
        else
        {
            solveTowers(num - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(num - 1, tempPole, startPole, endPole);
        }

    }


    /**
     * Solve towers method
     */
    public void solve()
    {
        solveTowers(numDisks, left, middle, right);
    }
}
