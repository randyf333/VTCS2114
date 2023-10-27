package employees;

// -------------------------------------------------------------------------
/**
 * Represents PartTime Employee
 * 
 * @author Randy
 * @version Aug 25, 2023
 */
public class PartTimeEmployee extends Employee {
    // ~ Fields ................................................................
    private int hrsWorked;

    // ~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * Create a new PartTimeEmployee object.
     * 
     * @param name
     *            name of employee
     * @param employeeId
     *            id number of employee
     * @param hourlyRate
     *            hourly pay of employee
     * @param hours
     *            number of hours worked
     */
    public PartTimeEmployee(
        String name,
        int employeeId,
        double hourlyRate,
        int hours) {
        super(name, employeeId, hourlyRate);
        hrsWorked = hours;
    }


    // ----------------------------------------------------------
    /**
     * Gets the number of hours worked
     * 
     * @return hours worked
     */
    // ~Public Methods ........................................................
    public int getHoursWorked() {
        return hrsWorked;
    }


    @Override
    public double weeklyPay() {
        return this.getHourlyRate() * hrsWorked;
    }

}
