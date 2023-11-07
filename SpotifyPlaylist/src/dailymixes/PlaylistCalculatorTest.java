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
 * Test class for PlaylistCalculator
 * 
 * @author randy
 * @version Nov 4, 2023
 */
public class PlaylistCalculatorTest
    extends TestCase
{
    private PlaylistCalculator calc;

    /**
     * Setup method
     */
    public void setUp()
    {
        Playlist p1 = new Playlist("p1", 10, 20, 30, 30, 40, 50, 3);
        Playlist p2 = new Playlist("p2", 30, 40, 50, 60, 70, 80, 3);
        Playlist p3 = new Playlist("p3", 70, 80, 90, 100, 100, 100, 3);
        ArrayQueue<Song> queue = new ArrayQueue<Song>();
        queue.enqueue(new Song("Song1", 20, 30, 40, "p1"));
        queue.enqueue(new Song("Song2", 50, 60, 70, "p2"));
        queue.enqueue(new Song("Song3", 80, 90, 99, "p3"));
        Playlist[] playlist = new Playlist[PlaylistCalculator.NUM_PLAYLISTS];
        playlist[0] = p1;
        playlist[1] = p2;
        playlist[2] = p3;
        calc = new PlaylistCalculator(queue, playlist);
    }


    /**
     * Test reject method
     */
    public void testReject()
    {
        assertEquals(3, calc.getQueue().getSize());
        calc.reject();
        assertEquals(2, calc.getQueue().getSize());
    }


    /**
     * Test getPlaylistForSong method
     */
    public void testGetPlaylistForSong()
    {
        assertEquals(
            new Playlist("p1", 10, 20, 30, 30, 40, 50, 3),
            calc.getPlaylistForSong(calc.getQueue().dequeue()));
        assertEquals(
            new Playlist("p2", 30, 40, 50, 60, 70, 80, 3),
            calc.getPlaylistForSong(calc.getQueue().dequeue()));
        assertEquals(
            new Playlist("p3", 70, 80, 90, 100, 100, 100, 3),
            calc.getPlaylistForSong(calc.getQueue().dequeue()));
        calc.getQueue().enqueue(new Song("Song1", 50, 60, 70, ""));
        assertEquals(
            new Playlist("p2", 30, 40, 50, 60, 70, 80, 3),
            calc.getPlaylistForSong(calc.getQueue().dequeue()));
        assertNull(calc.getPlaylistForSong(new Song("Fail", 0, 0, 0, "")));
        assertNull(calc.getPlaylistForSong(null));

    }


    /**
     * Test addSongToPlaylist method
     */
    public void testAddSongToPlaylist()
    {
        calc.getQueue().enqueue(new Song("Fail", 0, 0, 0, ""));
        calc.getQueue().enqueue(new Song("Test", 20, 30, 40, "p1"));
        assertTrue(calc.addSongToPlaylist());
        assertTrue(calc.addSongToPlaylist());
        assertTrue(calc.addSongToPlaylist());
        assertFalse(calc.addSongToPlaylist());
    }


    /**
     * Test getQueue method
     */
    public void testGetQueue()
    {
        ArrayQueue<Song> queue = calc.getQueue();
        assertEquals(new Song("Song1", 20, 30, 40, "p1"), queue.getFront());
    }


    /**
     * Test getPlaylistIndex
     */
    public void testGetPlaylistIndex()
    {
        assertEquals(0, calc.getPlaylistIndex("p1"));
        assertEquals(1, calc.getPlaylistIndex("p2"));
        assertEquals(2, calc.getPlaylistIndex("p3"));
        assertEquals(-1, calc.getPlaylistIndex("p4"));
    }


    /**
     * Test getPlaylists method
     */
    public void testGetPlaylists()
    {
        Playlist[] playlist = calc.getPlaylists();
        assertEquals(
            new Playlist("p1", 10, 20, 30, 30, 40, 50, 3),
            playlist[0]);
    }

}
