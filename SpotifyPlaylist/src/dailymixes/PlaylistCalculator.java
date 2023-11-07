package dailymixes;

import java.util.Arrays;
import list.AList;

// -------------------------------------------------------------------------
/**
 * PlaylistCalculator class
 * 
 * @author randy
 * @version Nov 4, 2023
 */
public class PlaylistCalculator
{
    private Playlist[] playlists;
    /**
     * Number of playlists
     */
    public final static int NUM_PLAYLISTS = 3;
    /**
     * Lowest percentage
     */
    public final static int MIN_PERCENT = 0;
    /**
     * Highest percentage
     */
    public final static int MAX_PERCENT = 100;
    private AList<Song> rejectedTracks;
    private ArrayQueue<Song> songQueue;

    // ----------------------------------------------------------
    /**
     * Create a new PlaylistCalculator object.
     * 
     * @param songs
     *            songs to input
     * @param playlist
     *            array of playlists
     */
    public PlaylistCalculator(ArrayQueue<Song> songs, Playlist[] playlist)
    {
        if (songs == null)
        {
            throw new IllegalArgumentException();
        }
        playlists = playlist;
        songQueue = songs;
        rejectedTracks = new AList<Song>(songs.getSize());
    }


    /**
     * Determine if next song can be added to playlist
     * 
     * @param nextSong
     *            song to be added
     * @return Playlist to be added to
     */
    public Playlist getPlaylistForSong(Song nextSong)
    {
        if (nextSong == null)
        {
            return null;
        }
        int index = this.getPlaylistIndex(nextSong.getPlaylistName());
        if (!nextSong.getPlaylistName().equals("") && index >= 0)
        {
            if (this.canAccept(playlists[index], nextSong))
            {
                return playlists[index];
            }
        }
        return this.getPlaylistWithMostRoom(nextSong);
    }


    /**
     * Add next song
     * 
     * @return true if song successfully added
     */
    public boolean addSongToPlaylist()
    {
        if (!songQueue.isEmpty())
        {
            Playlist playlist = getPlaylistForSong(songQueue.getFront());
            if (playlist != null)
            {
                playlist.addSong(songQueue.dequeue());
                return true;
            }
        }
        return false;
    }


    /**
     * Remove song and add to rejected tracks
     */
    public void reject()
    {
        rejectedTracks.add(songQueue.dequeue());
    }


    /**
     * Helper to see if song can be accepted into playlist
     */
    private boolean canAccept(Playlist playlist, Song song)
    {
        return (!playlist.isFull() && playlist.isQualified(song));
    }


    private Playlist getPlaylistWithMostRoom(Song s)
    {
        Playlist[] copy = playlists.clone();
        Arrays.sort(copy);
        for (int i = playlists.length - 1; i >= 0; i--)
        {
            if (this.canAccept(copy[i], s))
            {
                return copy[i];
            }
        }
        return null;
    }


    // ----------------------------------------------------------
    /**
     * Get index of playlist
     * 
     * @param playlist
     *            Name of playlist to find
     * @return index of playlist or -1 if not found
     */
    public int getPlaylistIndex(String playlist)
    {
        for (int i = 0; i < playlists.length; i++)
        {
            if (playlists[i].getName().equals(playlist))
            {
                return i;
            }
        }
        return -1;
    }


    // ----------------------------------------------------------
    /**
     * Get songQueue
     * 
     * @return songQueue
     */
    public ArrayQueue<Song> getQueue()
    {
        return songQueue;
    }


    // ----------------------------------------------------------
    /**
     * Get array of playlists
     * 
     * @return playlists
     */
    public Playlist[] getPlaylists()
    {
        return playlists;
    }
}
