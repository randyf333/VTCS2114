package employees;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test class for Employees test
 * 
 * @author Randy
 * @version Aug 25, 2023
 */
public class PartTimeEmployeeTest extends TestCase {
    // ~ Fields ................................................................
    private PartTimeEmployee partTimer;
    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    /**
     * setUp object for PartTimeEmployee testing
     */
    public void setUp() {
        partTimer = new PartTimeEmployee("Test", 123, 10, 10);
    }


    // ----------------------------------------------------------
    /**
     * Test getHoursWorked method
     */
    public void testGetHours() {
        assertEquals(10, partTimer.getHoursWorked());
    }


    // ----------------------------------------------------------
    /**
     * Test override weeklyPay
     */
    public void testWeeklyPay() {
        assertEquals(100, partTimer.weeklyPay(), 0.1);
    }
}
