package employees;

// -------------------------------------------------------------------------
/**
 * Represents ExternalContractor
 * 
 * @author Randy
 * @version Aug 25, 2023
 */
public class ExternalContractor extends Employee {

    // ----------------------------------------------------------
    /**
     * Create a new ExternalContractor object.
     * 
     * @param name
     *            name of employee
     * @param employeeId
     *            employee id number
     * @param hourlyRate
     *            hourly pay for the employee
     */
    // ~ Constructors ..........................................................
    public ExternalContractor(String name, int employeeId, double hourlyRate) {
        super(name, employeeId, hourlyRate);
    }


    // ~Public Methods ........................................................
    // ----------------------------------------------------------
    /**
     * Gets HourlyRate based on Contractor Rank
     * 
     * @param rank
     *            Letter rank to determine hourly rate
     * @return contractor hourly rate
     */
    public double getHourlyRate(char rank) {
        switch (rank) {
            case 'A':
                return 38.5;
            case 'B':
                return 41.75;
            case 'C':
                return 45.50;
            default:
                return 0;
        }
    }


    // ----------------------------------------------------------
    /**
     * Calculates pay for contractors
     * 
     * @param hours
     *            Number of hours worked
     * @param rank
     *            Letter rank of the contractor
     * @return contractor weekly pay
     */
    public double weeklyPay(int hours, char rank) {
        return hours * this.getHourlyRate(rank);
    }
}
