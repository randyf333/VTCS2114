// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who
// do.
// -- Randy Fu (randyf333)
package dailymixes;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Class to test Song class
 * 
 * @author randy
 * @version Oct 27, 2023
 */
public class SongTest
    extends TestCase
{
    private Song song;

    // ----------------------------------------------------------
    /**
     * setUp method
     */
    public void setUp()
    {
        song = new Song("Hello", 60, 25, 40, "playlist1");
    }


    /**
     * Test toString method
     */
    public void testToString()
    {
        assertEquals(
            "Hello Pop:60 Rock:25 Country:40 Suggested: playlist1",
            song.toString());
        Song noList = new Song("Goodbye", 20, 44, 40, "");
        assertEquals(
            "No-Playlist Goodbye Pop:20 Rock:44 Country:40",
            noList.toString());
    }


    /**
     * Test getPlaylistName method
     */
    public void testGetPlaylistName()
    {
        assertEquals("playlist1", song.getPlaylistName());
    }


    /**
     * test Equals method
     */
    public void testEquals()
    {
        Song same = new Song("Hello", 60, 25, 40, "playlist1");
        assertTrue(song.equals(same));
        assertFalse(song.equals(null));
        assertFalse(song.equals("Other"));
        assertTrue(song.equals(song));
        assertFalse(song.equals(new Song("Hello", 60, 25, 26, "playlist1")));
        assertFalse(song.equals(new Song("Bye", 60, 25, 26, "playlist1")));
        assertFalse(song.equals(new Song("Hello", 60, 25, 26, "playlist2")));
    }


    /**
     * test getName method
     */
    public void testGetName()
    {
        assertEquals("Hello", song.getName());
    }


    /**
     * test getGenreSet
     */
    public void testGetGenreSet()
    {
        assertEquals(new GenreSet(60, 25, 40), song.getGenreSet());
    }
}
