// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who
// do.
// -- Randy Fu (randyf333)
package game;

/**
 * Class for running the game
 * 
 * @author Randy Fu
 * @version Sep 24, 2023
 */
public class ProjectRunner
{

    // ----------------------------------------------------------
    /**
     * Create a new ProjectRunner object.
     */
    public ProjectRunner()
    {
        // Constructor not needed
    }


    // ----------------------------------------------------------
    /**
     * main run method.
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        if (args.length > 0)
        {
            WhackAShape game = new WhackAShape(args);
        }
        else
        {
            WhackAShape game = new WhackAShape();
        }

    }

}
