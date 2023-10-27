// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who
// do.
// -- Randy Fu (randyf333)
package towerofhanoi;

// -------------------------------------------------------------------------
/**
 * Class for the tower
 * 
 * @author randy
 * @version Oct 15, 2023
 */
public class Tower
    extends LinkedStack<Disk>
{
    private Position position;

    // ----------------------------------------------------------
    /**
     * Create a new Tower object.
     * 
     * @param p
     *            position of the tower
     */
    public Tower(Position p)
    {
        super();
        position = p;
    }


    // ----------------------------------------------------------
    /**
     * Return Tower position
     * 
     * @return position
     */
    public Position position()
    {
        return position;
    }


    @Override
    public void push(Disk disk)
    {
        if (disk == null)
        {
            throw new IllegalArgumentException();
        }
        if (isEmpty() || disk.compareTo(peek()) < 0)
        {
            super.push(disk);
        }
        else
        {
            throw new IllegalStateException();
        }
    }
}
