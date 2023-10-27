package towerofhanoi;

import cs2.Shape;
import student.TestableRandom;
import java.awt.Color;

// -------------------------------------------------------------------------
/**
 * Class for Disk
 * 
 * @author randy
 * @version Oct 13, 2023
 */
public class Disk
    extends Shape
    implements Comparable<Disk>
{
    // ----------------------------------------------------------
    /**
     * Create a new Disk object.
     * 
     * @param width
     *            width of the disk
     */
    public Disk(int width)
    {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        TestableRandom randomGen = new TestableRandom();
        int red = randomGen.nextInt(256);
        int green = randomGen.nextInt(256);
        int blue = randomGen.nextInt(256);
        Color col = new Color(red, green, blue);
        setBackgroundColor(col);
    }


    /**
     * Method to compare sizes of disks
     * 
     * @param otherDisk
     *            Disk to compare to
     */
    @Override
    public int compareTo(Disk otherDisk)
    {
        if (otherDisk == null)
        {
            throw new IllegalArgumentException();
        }
        if (this.getWidth() < otherDisk.getWidth())
        {
            return -1;
        }
        else if (this.getWidth() > otherDisk.getWidth())
        {
            return 1;
        }
        return 0;
    }


    /**
     * Output width of disk as a string
     * 
     * @return Disk width as string
     */
    public String toString()
    {
        return "" + this.getWidth();
    }


    /**
     * Compares two disks together
     * 
     * @param other
     *            Other object to compare to
     * @return true if disks are equal
     */
    public boolean equals(Object other)
    {
        if (other == null)
        {
            return false;
        }
        if (other == this)
        {
            return true;
        }
        if (this.getClass() == other.getClass())
        {
            Disk disk = (Disk)other;
            if (this.getWidth() == disk.getWidth())
            {
                return true;
            }
        }
        return false;
    }
}
