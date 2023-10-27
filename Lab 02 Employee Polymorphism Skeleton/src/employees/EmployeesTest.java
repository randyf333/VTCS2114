package employees;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test class for Employees test
 * 
 * @author Randy
 * @version Aug 25, 2023
 */
public class EmployeesTest extends TestCase {
    // ~ Fields ................................................................
    private Employee test;
    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    /**
     * sets up the testing object
     */
    public void setUp() {
        test = new Employee("Test", 123, 10);
    }


    // ----------------------------------------------------------
    /**
     * Test getName.
     */
    public void testGetName() {
        assertEquals("Test", test.getName());
    }


    // ----------------------------------------------------------
    /**
     * Test getEmployeeId
     */
    public void testGetEmployeeId() {
        assertEquals(123, test.getEmployeeId());
    }


    // ----------------------------------------------------------
    /**
     * Test getHourlyRate.
     */
    public void testGetHourlyRate() {
        assertEquals(10.0, test.getHourlyRate(), 0.01);
    }


    // ----------------------------------------------------------
    /**
     * Test weeklyPay
     */
    public void testWeeklyPay() {
        assertEquals(400, test.weeklyPay(), 0.01);
    }


    // ----------------------------------------------------------
    /**
     * Test override equals method
     */
    public void testEquals() {
        Employee same = new Employee("Test", 123, 10);
        Employee dID = new Employee("Test", 124, 10);
        Employee dName = new Employee("Other", 123, 10);
        Employee bothD = new Employee("Other", 124, 10);
        Employee nothing = null;
        String str = "Hi";
        assertTrue(test.equals(test));
        assertTrue(test.equals(same));
        assertFalse(test.equals(dID));
        assertFalse(test.equals(dName));
        assertFalse(test.equals(bothD));
        assertFalse(test.equals(nothing));
        assertFalse(test.equals(str));
    }
}
