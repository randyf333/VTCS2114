package icecream;

import java.util.Stack;

// -------------------------------------------------------------------------
/**
 * Class for IceCreamCone
 * 
 * @author Randy
 * @version Sep 19, 2023
 */
public class IceCreamCone implements IceCreamConeADT {

    private Stack<String> flavors;
    private int numScoops;

    // ----------------------------------------------------------
    /**
     * Create a new IceCreamCone object.
     */
    public IceCreamCone() {
        numScoops = 0;
        flavors = new Stack<String>();
    }


    /**
     * Eat the top scoop of ice cream.
     * 
     * @precondition There exists at least one flavor of ice cream in the ice
     *               cream cone. (The cone isn't empty).
     * @return The flavor of the scoop eaten.
     */
    @Override
    public String eatScoop() {
        numScoops--;
        return flavors.pop();
    }


    /**
     * Add a scoop of ice cream to the top of the ice cream cone.
     * 
     * @precondition The flavor isn't null.
     * @param flavor
     *            Flavor of ice cream to be added.
     */
    @Override
    public void addScoop(String flavor) {
        numScoops++;
        flavors.push(flavor);
    }


    /**
     * The number of scoops on the cone.
     * 
     * @return Returns the number of scoops on the cone.
     */
    @Override
    public int numScoops() {
        return numScoops;
    }


    /**
     * Check if your cone already contains a specific flavor of ice cream.
     * 
     * @precondition The flavor isn't null.
     * @param flavor
     *            Flavor to be checked for.
     * @return Returns true if the cone already contains the desired flavor.
     */
    @Override
    public boolean contains(String flavor) {
        return flavors.contains(flavor);
    }


    /**
     * Checks if any scoops of ice cream are left.
     * 
     * @return Returns true if there are no ice cream scoops left in the cone.
     */
    @Override
    public boolean emptyCone() {
        return flavors.empty();
    }


    /**
     * The flavor of the ice cream at the top of the cone.
     * 
     * @precondition There exists at least one flavor of ice cream in the ice
     *               cream cone. (The cone isn't empty).
     * @return Returns the flavor of the top of the cone.
     */
    @Override
    public String currentScoop() {
        return flavors.peek();
    }


    /**
     * Returns a string representation of the ice cream cone. Format: The
     * flavors are surrounded by brackets: [] The flavors are separated by
     * commas. Example: [Vanilla, Chocolate, Rocky Road] Orientation: Flavors
     * are appended to the right when pushed onto the stack. Flavors are removed
     * from the right when popped off the stack.
     * 
     * @return The string of the ice cream flavors.
     */
    @Override
    public String toString() {
        return flavors.toString();
    }


    /**
     * Equals method for IceCreamCones
     * 
     * @param other
     *            Object to be compared to
     */
    @Override
    public boolean equals(Object other) {
        if ((other == null) || (other.getClass() != this.getClass())) {
            return false;
        }
        return flavors.equals(((IceCreamCone)other).flavors);
    }

}
