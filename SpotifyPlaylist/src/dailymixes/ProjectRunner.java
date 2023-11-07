// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who
// do.
// -- Randy Fu (randyf333)
package dailymixes;

import java.io.FileNotFoundException;
import java.text.ParseException;

// -------------------------------------------------------------------------
/**
 * Runner class
 * 
 * @author randy
 * @version Nov 5, 2023
 */
public class ProjectRunner
{

    // ----------------------------------------------------------
    /**
     * Main method
     * 
     * @param args
     *            input files
     * @throws DailyMixDataException
     * @throws ParseException
     * @throws FileNotFoundException
     */
    public static void main(String[] args)
        throws FileNotFoundException,
        ParseException,
        DailyMixDataException
    {
        PlaylistReader reader;
        if (args.length == 2)
        {
            reader = new PlaylistReader(args[0], args[1]);
        }
        else
        {
            reader = new PlaylistReader("input.txt", "playlists.txt");
        }
    }

}
