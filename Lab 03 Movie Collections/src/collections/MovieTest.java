package collections;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Testing class for Movie class
 * 
 * @author Randy
 * @version Sep 4, 2023
 */
public class MovieTest extends TestCase {
    // ~ Fields ................................................................
    private Movie movie;

    /**
     * sets up testing objects
     */
    // ~ Constructors ..........................................................
    public void setUp() {
        movie = new Movie("Superman");
        movie.setGenre("Action");
        movie.setYear(2002);
        movie.setRating(4);
    }


    // ~Public Methods ........................................................
// ----------------------------------------------------------
    /**
     * Test method for getTitle
     */
    public void testGetTitle() {
        assertEquals("Superman", movie.getTitle());
    }


// ----------------------------------------------------------
    /**
     * Test method getGenre
     */
    public void testGetGenre() {
        assertEquals("Action", movie.getGenre());
    }


// ----------------------------------------------------------
    /**
     * Test method setGenre
     */
    public void testSetGenre() {
        movie.setGenre("Romance");
        assertEquals("Romance", movie.getGenre());
    }


// ----------------------------------------------------------
    /**
     * Test method getRating
     */
    public void testGetRating() {
        assertEquals(4, movie.getRating());
    }


// ----------------------------------------------------------
    /**
     * Test method setRating
     */
    public void testSetRating() {
        movie.setRating(5);
        assertEquals(5, movie.getRating());
    }


// ----------------------------------------------------------
    /**
     * Test method getYear
     */
    public void testGetYear() {
        assertEquals(2002, movie.getYear());
    }


// ----------------------------------------------------------
    /**
     * Test method setYear
     */
    public void testSetYear() {
        movie.setYear(2023);
        assertEquals(2023, movie.getYear());
    }


// ----------------------------------------------------------
    /**
     * Test method equals
     */
    public void testEquals() {
        Movie nullTest = null;
        Movie sameName = new Movie("Superman");
        Movie diffName = new Movie("Batman");
        String diffClass = "Flash";
        assertTrue(movie.equals(movie));
        assertTrue(movie.equals(sameName));
        assertFalse(movie.equals(nullTest));
        assertFalse(movie.equals(diffName));
        assertFalse(movie.equals(diffClass));

    }

}
