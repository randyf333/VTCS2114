package collections;

// -------------------------------------------------------------------------
/**
 * Movie Class
 * 
 * @author Randy
 * @version Sep 4, 2023
 */
public class Movie extends MovieADT {
    // ~ Fields ................................................................
    private String movieName;

    // ----------------------------------------------------------
    /**
     * Create a new Movie object.
     * 
     * @param title
     *            the name of the movie
     */

    // ~ Constructors ..........................................................
    public Movie(String title) {
        super(title);
        movieName = title;
    }


    /**
     * return movie title
     * 
     * @return movieName
     */
    // ~Public Methods ........................................................
    public String getTitle() {
        return movieName;
    }
}
