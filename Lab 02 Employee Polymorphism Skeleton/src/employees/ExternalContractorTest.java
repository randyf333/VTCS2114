package employees;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Testing class for External Contractor
 * 
 * @author Randy
 * @version Aug 30, 2023
 */
public class ExternalContractorTest extends TestCase {
    // ~ Fields ................................................................
    private ExternalContractor contractor;
    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    /**
     * Setup object for testing Externalcontractor methods
     */
    public void setUp() {
        contractor = new ExternalContractor("Test", 123, 10);
    }


    // ----------------------------------------------------------
    /**
     * Tests getHourlyRate for overload getHourlyRate
     */
    public void testGetHourlyRate() {
        assertEquals(38.5, contractor.getHourlyRate('A'), 0.1);
        assertEquals(41.75, contractor.getHourlyRate('B'), 0.1);
        assertEquals(45.5, contractor.getHourlyRate('C'), 0.1);
        assertEquals(0, contractor.getHourlyRate('D'), 0.1);
    }


    // ----------------------------------------------------------
    /**
     * Test overload weeklyPay method
     */
    public void testWeeklyPay() {
        assertEquals(45.5, contractor.weeklyPay(1, 'C'), 0.1);
    }
}
