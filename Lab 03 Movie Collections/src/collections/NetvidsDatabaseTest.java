package collections;

import java.util.NoSuchElementException;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Class for testing NetvidsDatabase
 * 
 * @author Randy
 * @version Sep 6, 2023
 */
public class NetvidsDatabaseTest extends TestCase {
    // ~ Fields ................................................................
    private NetvidsDatabase netvids;
    private Movie movie;

    /**
     * sets up testing objects
     */
    // ~ Constructors ..........................................................
    public void setUp() {
        netvids = new NetvidsDatabase();
        movie = new Movie("Superman");

    }


    // ----------------------------------------------------------
    /**
     * Test addMovie method
     */
    // ~Public Methods ........................................................
    public void testAdd() {
        assertTrue(netvids.addMovie(movie));
        assertFalse(netvids.addMovie(movie));
    }


    /**
     * 
     * Tests the remove method when the object to be removed is present.
     * 
     */

    public void testRemove()

    {

        netvids.addMovie(movie);

        // Make sure the size has been updated properly

        assertEquals(1, netvids.size());

        // Make sure the remove method finds what we just added

        assertTrue(netvids.remove(movie).equals(movie));

        // Make sure the size has been updated properly

        assertEquals(0, netvids.size());

        // Double check that the string was actually removed

        assertFalse(netvids.contains(movie));

    }


    /**
     * 
     * Tests the remove method when the object to be removed is null.
     * 
     */

    public void testRemoveNull()

    {

        Movie nullMovie = null;

        Exception exception = null;

        // Use try-catch block to see whether you get an exception of expected
        // type

        try {

            netvids.remove(nullMovie);

        }

        catch (IllegalArgumentException e) {

            exception = e;

        }

        assertNotNull(exception);

    }


    /**
     * 
     * Tests the remove method when the object to be removed is not present.
     * 
     */

    public void testRemoveNo()

    {

        Movie present = new Movie("Test1");

        Movie notPresent = new Movie("Test2");

        netvids.addMovie(present);

        Exception exception = null;

        // Use try-catch block to see whether you get an exception of expected
        // type

        try {

            netvids.remove(notPresent);

        }

        catch (NoSuchElementException e) {

            exception = e;

        }

        assertNotNull(exception);

    }


    // ----------------------------------------------------------
    /**
     * test contains method
     */
    public void testContains() {
        assertFalse(netvids.contains(movie));
        netvids.addMovie(movie);
        assertTrue(netvids.contains(movie));
        assertFalse(netvids.contains(new Movie("Fake")));
    }


    // ----------------------------------------------------------
    /**
     * tests isEmpty method
     */
    public void testIsEmpty() {
        assertTrue(netvids.isEmpty());
        netvids.addMovie(movie);
        assertFalse(netvids.isEmpty());
    }


    // ----------------------------------------------------------
    /**
     * tests size method
     */
    public void testSize() {
        netvids.addMovie(movie);
        assertEquals(1, netvids.size());
        netvids.remove(movie);
        assertEquals(0, netvids.size());
    }


    // ----------------------------------------------------------
    /**
     * tests capacity method
     */
    public void testCapacity() {
        assertEquals(10, netvids.capacity());
    }


    // ----------------------------------------------------------
    /**
     * tests expandCapacityMethod
     */
    public void testExpandCapacity() {
        for (int i = 0; i < 10; i++) {
            netvids.addMovie(new Movie("Movie#" + i));
        }
        netvids.addMovie(new Movie("Movie Last"));
        assertEquals(20, netvids.capacity());
    }
}
