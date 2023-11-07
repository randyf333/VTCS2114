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
 * Class for Genres
 * 
 * @author randy
 * @version Oct 20, 2023
 */
public class GenreSet
    implements Comparable<GenreSet>
{

    private int rock;
    private int pop;
    private int country;

    // ----------------------------------------------------------
    /**
     * Create a new GenreSet object.
     * 
     * @param p
     *            value for pop
     * @param r
     *            value for rock
     * @param c
     *            value for country
     */
    public GenreSet(int p, int r, int c)
    {
        pop = p;
        rock = r;
        country = c;
    }


    // ----------------------------------------------------------
    /**
     * Get rock value
     * 
     * @return rock
     */
    public int getRock()
    {
        return rock;
    }


    // ----------------------------------------------------------
    /**
     * Get pop value
     * 
     * @return pop
     */
    public int getPop()
    {
        return pop;
    }


    // ----------------------------------------------------------
    /**
     * Get country value
     * 
     * @return country
     */
    public int getCountry()
    {
        return country;
    }


    /**
     * Compares two GenreSet
     * 
     * @return true if obj is equals to GenreSet
     * @param obj
     *            other object to check equals to
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
            GenreSet g = (GenreSet)obj;
            return (this.rock == g.getRock() && this.pop == g.getPop()
                && this.country == g.getCountry());
        }
        return false;
    }


    // ----------------------------------------------------------
    /**
     * Checks in GenreSet is within range
     * 
     * @param minGenreSet
     *            min genre set
     * @param maxGenreSet
     *            max genre set
     * @return true if all values in GenreSet between min and max
     */
    public boolean isWithinRange(GenreSet minGenreSet, GenreSet maxGenreSet)
    {
        return isLessThanOrEqualTo(maxGenreSet)
            && minGenreSet.isLessThanOrEqualTo(this);
    }


    private boolean isLessThanOrEqualTo(GenreSet other)
    {
        return (this.pop <= other.pop && this.rock <= other.rock
            && this.country <= other.country);
    }


    /**
     * Return string rep of GenreSet
     * 
     * @return string of values
     */
    public String toString()
    {
        return "Pop:" + pop + " Rock:" + rock + " Country:" + country;
    }


    /**
     * compareTo method
     * 
     * @return negative if lower total values, positive if greater total value,
     *             0 if values are same
     */
    @Override
    public int compareTo(GenreSet other)
    {
        return (this.pop + this.country + this.rock)
            - (other.country + other.pop + other.rock);
    }

}
