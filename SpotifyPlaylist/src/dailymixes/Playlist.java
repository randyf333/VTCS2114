package dailymixes;

// -------------------------------------------------------------------------
/**
 * Class for playlist
 * 
 * @author randy
 * @version Nov 1, 2023
 */
public class Playlist
    implements Comparable<Playlist>
{

    private GenreSet minGenreSet;
    private GenreSet maxGenreSet;
    private Song[] songs;
    private int capacity;
    private int numberOfSongs;
    private String name;

    // ----------------------------------------------------------
    /**
     * Create a new Playlist object.
     * 
     * @param playlistName
     *            name of playlist
     * @param minPop
     *            min value for pop
     * @param maxPop
     *            max value for pop
     * @param minRock
     *            min value for rock
     * @param maxRock
     *            max value for rock
     * @param minCountry
     *            min value for country
     * @param maxCountry
     *            max value for country
     * @param playlistCap
     *            capacity of playlist
     */
    public Playlist(
        String playlistName,
        int minPop,
        int minRock,
        int minCountry,
        int maxPop,
        int maxRock,
        int maxCountry,
        int playlistCap)
    {
        name = playlistName;
        minGenreSet = new GenreSet(minPop, minRock, minCountry);
        maxGenreSet = new GenreSet(maxPop, maxRock, maxCountry);
        numberOfSongs = 0;
        capacity = playlistCap;
        songs = new Song[capacity];
    }


    /**
     * Get minGenreSet
     * 
     * @return minGenreSet
     */
    public GenreSet getMinGenreSet()
    {
        return minGenreSet;
    }


    /**
     * Set newName
     * 
     * @param newName
     *            the new name of playlist
     */
    public void setName(String newName)
    {
        name = newName;
    }


    /**
     * Get number of spaces in playlist left
     * 
     * @return number of spaces left
     */
    public int getSpacesLeft()
    {
        return capacity - numberOfSongs;
    }


    /**
     * get maxGenreSet
     * 
     * @return maxGenreSet
     */
    public GenreSet getMaxGenreSet()
    {
        return maxGenreSet;
    }


    /**
     * get number of songs in playlist
     * 
     * @return numberOfSongs
     */
    public int getNumberOfSongs()
    {
        return numberOfSongs;
    }


    /**
     * Get song array
     * 
     * @return songs
     */
    public Song[] getSongs()
    {
        return songs;
    }


    /**
     * Get capacity of array
     * 
     * @return capacity
     */
    public int getCapacity()
    {
        return capacity;
    }


    /**
     * Get name of playlist
     * 
     * @return name
     */
    public String getName()
    {
        return name;
    }


    /**
     * See if song is qualified to be in playlist
     * 
     * @return true if song is qualified
     * @param possibleSong
     *            song to be added
     */
    public boolean isQualified(Song possibleSong)
    {
        return possibleSong.getGenreSet()
            .isWithinRange(minGenreSet, maxGenreSet);
    }


    /**
     * See if playlist is full
     * 
     * @return true if is full
     */
    public boolean isFull()
    {
        return numberOfSongs == capacity;
    }


    /**
     * Add song to array
     * 
     * @param newSong
     *            song to be added
     * @return true if successfully added
     */
    public boolean addSong(Song newSong)
    {
        if (!isFull() && isQualified(newSong))
        {
            songs[numberOfSongs] = newSong;
            numberOfSongs++;
            return true;
        }
        return false;
    }


    /**
     * Create string representation of playlist
     * 
     * @return string of playlist
     */
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("Playlist: " + name);
        s.append(", ");
        s.append("# of songs: " + numberOfSongs);
        s.append(" (cap: ");
        s.append(capacity);
        s.append(")");
        s.append(", ");
        s.append("Requires: ");
        s.append(
            "Pop:" + minGenreSet.getPop() + "%-" + maxGenreSet.getPop() + "%");
        s.append(", ");
        s.append(
            "Rock:" + minGenreSet.getRock() + "%-" + maxGenreSet.getRock()
                + "%");
        s.append(", ");
        s.append(
            "Country:" + minGenreSet.getCountry() + "%-"
                + maxGenreSet.getCountry() + "%");
        return s.toString();
    }


    /**
     * Compare if playlists are equal
     * 
     * @return true if playlist is equal
     * @param obj
     *            Object to check equals with
     */
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (obj == this)
        {
            return true;
        }
        if (this.getClass() == obj.getClass())
        {
            Playlist p = (Playlist)obj;
            if (name == p.name && minGenreSet.equals(p.minGenreSet)
                && maxGenreSet.equals(p.maxGenreSet)
                && capacity == p.getCapacity())
            {
                Song[] other = p.getSongs();
                for (int i = 0; i < numberOfSongs; i++)
                {
                    if (!songs[i].equals(other[i]))
                    {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }


    /**
     * compareTo implementation
     * 
     * @param other
     *            other playlist to compareTo
     * @return negative if less, 0 if same, positive if greater than
     */
    @Override
    public int compareTo(Playlist other)
    {
        if (capacity > other.capacity)
        {
            return 1;
        }
        else if (capacity < other.capacity)
        {
            return -1;
        }
        if (this.getSpacesLeft() > other.getSpacesLeft())
        {
            return 1;
        }
        else if (this.getSpacesLeft() < other.getSpacesLeft())
        {
            return -1;
        }
        int min = minGenreSet.compareTo(other.getMinGenreSet());
        if (min > 0)
        {
            return 1;
        }
        else if (min < 0)
        {
            return -1;
        }
        int max = maxGenreSet.compareTo(other.getMaxGenreSet());
        if (max > 0)
        {
            return 1;
        }
        else if (max < 0)
        {
            return -1;
        }
        return name.compareTo(other.getName());
    }

}
