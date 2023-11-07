// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who
// do.
// -- Randy Fu (randyf333)
package dailymixes;

// -------------------------------------------------------------------------
/**
 * Class for exception
 * 
 * @author randy
 * @version Nov 4, 2023
 */
public class DailyMixDataException
    extends Exception
{
    // ----------------------------------------------------------
    /**
     * Create a new DailyMixDataException object.
     * 
     * @param message
     */
    public DailyMixDataException(String message)
    {
        super(message);
    }

}
