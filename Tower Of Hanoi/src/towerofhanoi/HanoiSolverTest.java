// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who
// do.
// -- Randy Fu (randyf333)
package towerofhanoi;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Class to test HanoiSolver
 * 
 * @author randy
 * @version Oct 15, 2023
 */
public class HanoiSolverTest
    extends TestCase
{
    private HanoiSolver solver;
    private Tower left;
    private Tower middle;
    private Tower right;

    /**
     * Setup method for testing
     */
    public void setUp()
    {
        solver = new HanoiSolver(3);
        left = solver.getTower(Position.LEFT);
        middle = solver.getTower(Position.MIDDLE);
        right = solver.getTower(Position.RIGHT);
    }


    /**
     * test disk method
     */
    public void testDisk()
    {
        assertEquals(3, solver.disks());
    }


    /**
     * test getTower method
     */
    public void testGetTower()
    {
        assertEquals(
            left.position(),
            solver.getTower(Position.LEFT).position());
        assertEquals(
            right.position(),
            solver.getTower(Position.RIGHT).position());
        assertEquals(
            middle.position(),
            solver.getTower(Position.MIDDLE).position());
        assertEquals(
            middle.position(),
            solver.getTower(Position.DEFAULT).position());
    }


    /**
     * test toString method
     */
    public void testToString()
    {
        left.push(new Disk(3));
        left.push(new Disk(2));
        middle.push(new Disk(5));
        middle.push(new Disk(4));
        right.push(new Disk(1));
        assertEquals("[2, 3][4, 5][1]", solver.toString());
    }


    /**
     * test solve method
     */
    public void testSolve()
    {
        left.push(new Disk(3));
        left.push(new Disk(2));
        left.push(new Disk(1));
        solver.solve();
        assertEquals("[][][1, 2, 3]", solver.toString());
    }
}
