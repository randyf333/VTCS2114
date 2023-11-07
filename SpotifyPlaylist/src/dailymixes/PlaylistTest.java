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
 * Test class for Playlist
 * 
 * @author randy
 * @version Nov 3, 2023
 */
public class PlaylistTest
    extends TestCase
{
    private Playlist playlist;

    /**
     * Setup method
     */
    public void setUp()
    {
        playlist = new Playlist("p1", 30, 50, 25, 60, 80, 50, 3);
    }


    /**
     * Test setName method
     */
    public void testSetName()
    {
        assertEquals("p1", playlist.getName());
        playlist.setName("p2");
        assertEquals("p2", playlist.getName());
    }


    /**
     * Test getSpacesLeft method
     */
    public void testGetSpacesLeft()
    {
        assertEquals(3, playlist.getSpacesLeft());
    }


    /**
     * Test getMaxGenreSet method
     */
    public void testGetMaxGenreSet()
    {
        GenreSet max = new GenreSet(60, 80, 50);
        assertEquals(max, playlist.getMaxGenreSet());
    }


    /**
     * Test compareTo method
     */
    public void testCompareTo()
    {
        Song s = new Song("Song1", 45, 60, 30, "p1");
        Playlist larger = new Playlist("p1", 30, 50, 25, 60, 80, 50, 5);
        Playlist small = new Playlist("p1", 30, 50, 25, 60, 80, 50, 2);
        assertEquals(-1, playlist.compareTo(larger));
        assertEquals(1, playlist.compareTo(small));
        Playlist lessSpace = new Playlist("p1", 30, 50, 25, 60, 80, 50, 3);
        Playlist moreSpace = new Playlist("p1", 30, 50, 25, 60, 80, 50, 3);
        playlist.addSong(s);
        lessSpace.addSong(s);
        lessSpace.addSong(s);
        assertEquals(1, playlist.compareTo(lessSpace));
        assertEquals(-1, playlist.compareTo(moreSpace));

        Playlist smallMin = new Playlist("p1", 20, 40, 10, 60, 80, 50, 3);
        smallMin.addSong(s);
        assertEquals(1, playlist.compareTo(smallMin));
        Playlist bigMin = new Playlist("p1", 35, 55, 30, 60, 80, 50, 3);
        bigMin.addSong(s);
        assertEquals(-1, playlist.compareTo(bigMin));

        Playlist smallMax = new Playlist("p1", 30, 50, 25, 50, 70, 40, 3);
        smallMax.addSong(s);
        assertEquals(1, playlist.compareTo(smallMax));
        Playlist bigMax = new Playlist("p1", 30, 50, 25, 70, 90, 60, 3);
        bigMax.addSong(s);
        assertEquals(-1, playlist.compareTo(bigMax));

        Playlist lessAlpha = new Playlist("a1", 30, 50, 25, 60, 80, 50, 3);
        lessAlpha.addSong(s);
        assertTrue(playlist.compareTo(lessAlpha) > 0);
        Playlist moreAlpha = new Playlist("z1", 30, 50, 25, 60, 80, 50, 3);
        moreAlpha.addSong(s);
        assertTrue(playlist.compareTo(moreAlpha) < 0);

    }


    /**
     * Test getNumberOfSongs method
     */
    public void testGetNumberOfSongs()
    {
        assertEquals(0, playlist.getNumberOfSongs());
    }


    /**
     * Test addSong method
     */

    public void testAddSong()
    {
        assertEquals(0, playlist.getNumberOfSongs());
        assertTrue(playlist.addSong(new Song("Song1", 45, 60, 30, "p1")));
        assertEquals(1, playlist.getNumberOfSongs());
        assertFalse(playlist.addSong(new Song("Song 2", 10, 60, 30, "p2")));
        assertTrue(playlist.addSong(new Song("Song2", 45, 60, 30, "p1")));
        assertTrue(playlist.addSong(new Song("Song3", 45, 60, 30, "p1")));
        assertFalse(playlist.addSong(new Song("Song4", 45, 60, 30, "p1")));
    }


    /**
     * Test toString method
     */

    public void testToString()
    {
        assertEquals(
            "Playlist: p1, # of songs: 0 (cap: 3), "
                + "Requires: Pop:30%-60%, Rock:50%-80%, Country:25%-50%",
            playlist.toString());
    }


    /**
     * Test isFull method
     */

    public void testIsFull()
    {
        assertFalse(playlist.isFull());
        for (int i = 0; i < 3; i++)
        {
            playlist.addSong(new Song("Song", 45 + i, 60 + 1, 30 + i, "p1"));
        }
        assertTrue(playlist.isFull());
    }


    /**
     * Test equals method
     */
    public void testEquals()
    {
        assertFalse(playlist.equals(null));
        assertTrue(playlist.equals(playlist));
        assertFalse(playlist.equals("Hi"));
        Playlist diffName = new Playlist("p2", 30, 50, 25, 60, 80, 50, 3);
        Playlist diffMin = new Playlist("p1", 35, 50, 25, 60, 80, 50, 3);
        Playlist diffMax = new Playlist("p1", 30, 50, 25, 60, 85, 50, 3);
        Playlist diffCapacity = new Playlist("p1", 30, 50, 25, 60, 80, 50, 4);
        assertFalse(playlist.equals(diffCapacity));
        assertFalse(playlist.equals(diffName));
        assertFalse(playlist.equals(diffMin));
        assertFalse(playlist.equals(diffMax));
        Playlist same = new Playlist("p1", 30, 50, 25, 60, 80, 50, 3);
        playlist.addSong(new Song("Song1", 45, 60, 30, "p1"));
        same.addSong(new Song("Song1", 45, 60, 30, "p1"));
        assertTrue(playlist.equals(same));
        Playlist diffSongs = new Playlist("p1", 30, 50, 25, 60, 80, 50, 3);
        diffSongs.addSong(new Song("Song2", 45, 60, 30, "p1"));
        assertFalse(playlist.equals(diffSongs));
    }


    /**
     * Test getSongs method
     */
    public void testGetSongs()
    {
        playlist.addSong(new Song("Song1", 45, 60, 30, "p1"));
        playlist.addSong(new Song("Song2", 45, 60, 30, "p1"));
        playlist.addSong(new Song("Song3", 45, 60, 30, "p1"));
        Song[] songs = playlist.getSongs();
        assertEquals(new Song("Song1", 45, 60, 30, "p1"), songs[0]);
        assertEquals(new Song("Song2", 45, 60, 30, "p1"), songs[1]);
        assertEquals(new Song("Song3", 45, 60, 30, "p1"), songs[2]);
    }


    /**
     * Test getCapacity method
     */
    public void testGetCapacity()
    {
        assertEquals(3, playlist.getCapacity());
    }


    /**
     * Test getName method
     */
    public void testGetName()
    {
        assertEquals("p1", playlist.getName());
    }


    /**
     * Test isQualified method
     */
    public void testIsQualified()
    {
        assertTrue(playlist.isQualified(new Song("Song1", 45, 60, 30, "p1")));
        assertFalse(playlist.addSong(new Song("Song2", 10, 60, 30, "p2")));
    }

}
