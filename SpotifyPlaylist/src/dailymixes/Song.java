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
 * Song class
 * 
 * @author randy
 * @version Oct 22, 2023
 */
public class Song
{
    private String name;
    private String suggestedPlaylist;
    private GenreSet genreSet;

    // ----------------------------------------------------------
    /**
     * Create a new Song object.
     * 
     * @param title
     *            title of song
     * @param pop
     *            percent pop
     * @param rock
     *            percent rock
     * @param country
     *            percent country
     * @param playlist
     *            suggested playlist
     */
    public Song(String title, int pop, int rock, int country, String playlist)
    {
        name = title;
        genreSet = new GenreSet(pop, rock, country);
        suggestedPlaylist = playlist;
    }


    /**
     * output song as a string
     * 
     * @return string representation of song
     */
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        if (suggestedPlaylist.length() == 0)
        {
            s.append("No-Playlist ");
        }
        s.append(name);
        s.append(" ");
        s.append(genreSet.toString());
        if (suggestedPlaylist.length() > 0)
        {
            s.append(" Suggested: ");
            s.append(suggestedPlaylist);
        }

        return s.toString();
    }


    // ----------------------------------------------------------
    /**
     * Gets suggestedPlaylsit name
     * 
     * @return suggestedPlaylist
     */
    public String getPlaylistName()
    {
        return suggestedPlaylist;
    }


    /**
     * equals method
     * 
     * @return true if other is equal to song
     * @param other
     *            object to compare equals to
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
        if (other.getClass() == this.getClass())
        {
            Song s = (Song)other;
            return this.name == s.name && this.genreSet.equals(s.genreSet)
                && this.suggestedPlaylist == s.suggestedPlaylist;
        }
        return false;
    }


    // ----------------------------------------------------------
    /**
     * Get song name
     * 
     * @return name
     */
    public String getName()
    {
        return name;
    }


    // ----------------------------------------------------------
    /**
     * Get genreset
     * 
     * @return genreSet
     */
    public GenreSet getGenreSet()
    {
        return genreSet;
    }
}
