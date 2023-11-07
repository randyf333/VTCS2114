package dailymixes;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

// -----------------------------------------------------------------------------
/**
 * PlaylistReader: The PlaylistReader parses the input data from two text files
 * containing comma-separated values. It generates the playlists and queue of
 * songs based on two files containing comma-separated values. One file contains
 * data about the songs and the other file contains data about each playlist.
 * Then it gives PlaylistWindow this queue in order to tie everything together.
 * UML
 * -----------------------------------------------------------------------------------------------
 * |c PlaylistReader (String songFileName, String playlistFileName) |
 * |ArrayQueue<Song> songQueue | |Playlist[] playlistArray |
 * |-------------------------------------------- | |readPlaylistFile(String
 * playlistFileName) Playlist[] | |readQueueFile (String queueFileName)
 * ArrayQueue<Song> | |isInValidPercentRange(int popPercent, int rockPercent,
 * int countryPercent ) boolean | | |
 * -----------------------------------------------------------------------------------------------
 */
public class PlaylistReader
{
    // Member Fields
    private ArrayQueue<Song> queue;

    private Playlist[] playlists;

    /**
     * A constant designating the number of playlist's tokens accepted.
     */
    public static final int PLAYLIST_TOKENS = 8;

    /**
     * A constant designating the number of song tokens accepted.
     */
    public static final int SONG_TOKENS = 5;

    // Member Methods
    /**
     * Constructor to initialize a new Reader
     * 
     * @param songsFileName
     *            file name of the program's songs.
     * @param playlistsFileName
     *            file name of the suggested playlists.
     * @throws java.text.ParseException
     *             if an error has been reached while parsing the input file.
     * @throws DailyMixDataException
     *             if data is incorrect in the input files.
     * @throws java.io.FileNotFoundException
     *             if the input file is inaccessible or does not exist.
     */
    public PlaylistReader(String songsFileName, String playlistsFileName)
        throws ParseException,
        DailyMixDataException,
        FileNotFoundException
    {

        queue = readQueueFile(songsFileName);
        playlists = readPlaylistFile(playlistsFileName);

        PlaylistCalculator calculate = new PlaylistCalculator(queue, playlists);

        PlaylistWindow window = new PlaylistWindow(calculate);
    } // end of constructor


    /**
     * Reads the playlist file and parses data to populate and return a list of
     * Playlist objects.
     * 
     * @param playlistFileName
     *            a playlist file name.
     * @throws ParseException
     *             if an error has been reached while parsing the input file.
     *             For example, percentages are not valid
     * @throws DailyMixDataException
     *             if data is incorrect in the input files.
     * @throws FileNotFoundException
     *             if the input file is inaccessible or does not exist.
     * @return a Playlist array for the program's use.
     */
    private Playlist[] readPlaylistFile(String playlistFileName)
        throws ParseException,
        DailyMixDataException,
        FileNotFoundException
    {

        Playlist[] parsedPlaylists =
            new Playlist[PlaylistCalculator.NUM_PLAYLISTS];

        // Declare a new Scanner named file and instantiate it to be a new
        // Scanner, with a new File as its parameter.
        // Give your new File the String playlistFileName parameter.
        // Note: You do not have to use a try catch statement to catch a
        // FileNotFoundException, you can just let it be thrown.
        File newFile = new File(playlistFileName);
        Scanner file = new Scanner(newFile);

        // If the filename was correct, you can begin parsing the file.
        // Loop through it using hasNextLine().
        // Only read in the first 3 Playlists.
        int playlistCounter = 0;
        // Use Scanner's iterator to parse the lines.
        while (file.hasNextLine()
            && playlistCounter < PlaylistCalculator.NUM_PLAYLISTS)
        {
            String read = file.nextLine();
            String[] tokens = read.split(",\\s*");

            if (tokens.length < 8)
            {

                throw new ParseException("Not enough commas", tokens.length);
            }
            else if (tokens.length > 8)
            {

                throw new ParseException("Too many commas", tokens.length);
            }

            else
            {

                String playlistName;
                int minPop;
                int minRock;
                int minCountry;
                int maxPop;
                int maxRock;
                int maxCountry;
                int maxSongsPerPlaylist;
                playlistName = tokens[0];
                minPop = Integer.valueOf(tokens[1]);
                minRock = Integer.valueOf(tokens[2]);
                minCountry = Integer.valueOf(tokens[3]);
                maxPop = Integer.valueOf(tokens[4]);
                maxRock = Integer.valueOf(tokens[5]);
                maxCountry = Integer.valueOf(tokens[6]);
                maxSongsPerPlaylist = Integer.valueOf(tokens[7]);
                if (!this.isInValidPercentRange(minPop, minRock, minCountry))
                {
                    throw new DailyMixDataException(
                        "Values not between min and max");
                }
                if (!this.isInValidPercentRange(maxPop, maxRock, maxCountry))
                {
                    throw new DailyMixDataException(
                        "Values not between min and max");
                }

                Playlist newPlaylist = new Playlist(
                    playlistName,
                    minPop,
                    minRock,
                    minCountry,
                    maxPop,
                    maxRock,
                    maxCountry,
                    maxSongsPerPlaylist);

                parsedPlaylists[playlistCounter] = newPlaylist;
                playlistCounter++;
            }
        } // end of while loop

        if (playlistCounter < PlaylistCalculator.NUM_PLAYLISTS)
        {

            throw new DailyMixDataException("Not enough playlists");
        }

        file.close();
        return parsedPlaylists;
    } // end of readPlaylistFile method


    // -------------------------------------------------------------------------
    /**
     * Parses data from a song file to populate and return a queue of Song
     * objects.
     * 
     * @param songFileName
     *            a song file name.
     * @return a Song queue for the program's use.
     */
    private ArrayQueue<Song> readQueueFile(String songFileName)
        throws ParseException,
        DailyMixDataException,
        FileNotFoundException
    {

        // local ArrayQueue<Song> using the defined DEFAULT_CAPACITY
        ArrayQueue<Song> parsedSongs =
            new ArrayQueue<Song>(ArrayQueue.DEFAULT_CAPACITY);

        File newFile = new File(songFileName);
        Scanner file = new Scanner(newFile);

        while (file.hasNextLine())
        {
            String read = file.nextLine();
            String[] tokens = read.split(",\\s*");

            if (tokens.length != SONG_TOKENS
                && tokens.length != SONG_TOKENS - 1)
            {
                throw new ParseException(
                    "Incorrect number of tokens",
                    tokens.length);

            }

            String playlist = "";
            String songName;
            int pop;
            int rock;
            int country;

            songName = tokens[0];
            pop = Integer.valueOf(tokens[1]);
            rock = Integer.valueOf(tokens[2]);
            country = Integer.valueOf(tokens[3]);
            if (tokens.length == SONG_TOKENS)
            {
                playlist = tokens[4];
            }

            if (!this.isInValidPercentRange(pop, rock, country))
            {
                throw new DailyMixDataException("Percentages not valid");
            }

            Song song = new Song(songName, pop, rock, country, playlist);
            parsedSongs.enqueue(song);

        } // end of while (file.hasNextLine())
        file.close();
        return parsedSongs;
    } // end of readQueueFile method


    /**
     * Determines whether the given integers are between the minimum and maximum
     * possible values for a genre's percent composition N.B. use the "public
     * static final variables" in PlaylistCalculator to avoid hard coding
     * 
     * @param num1
     *            first genre percent composition (pop)
     * @param num2
     *            second genre percent composition (Rock)
     * @param num3
     *            third genre percent composition (Country)
     * @return true if the integers are between the MIN_PERCENT and MAX_PERCENT
     *             possible values for each genre's percent composition, false
     *             otherwise.
     */
    private boolean isInValidPercentRange(int num1, int num2, int num3)
    {
        boolean valid = false;
        if (num1 >= PlaylistCalculator.MIN_PERCENT
            && num1 <= PlaylistCalculator.MAX_PERCENT)
        {
            valid = true;
        }
        else
        {
            valid = false;
        }
        if (num2 >= PlaylistCalculator.MIN_PERCENT
            && num2 <= PlaylistCalculator.MAX_PERCENT)
        {
            valid = true;
        }
        else
        {
            valid = false;
        }
        if (num3 >= PlaylistCalculator.MIN_PERCENT
            && num3 <= PlaylistCalculator.MAX_PERCENT)
        {
            valid = true;
        }
        else
        {
            valid = false;
        }
        return valid;
    } // end of isInValidPercentRange method

} // end of PlaylistReader class
