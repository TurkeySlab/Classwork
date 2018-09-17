/**
 * Professor
 *
 * Abstraction of a college professor. Each professor is uniquely identifiable by their ID (starting at 0).
 *
 * @author You
 *
 * @version date of completion
 *
 */

public class Professor extends Teacher {
    /**
     * Static variable used to determine the next ID number
     */
    protected static int nextID = 0;

    public Professor(String name, int age, String gender) {
    	/*
         * Constructs a new Professor with the corresponding parameters as field values, an array for storing courses, and
         * the next ID value (one greater than the previously created professors's id value). Set the Professors's
         * baseSalary to 50,000 and perCourseSalary to 15,000 by default.
         *
         * @param name Name of the new Professor to be added
         * @param age Age of the new Professor to be added
         * @param gender Gender of the new Professor to be added
         */
    	super(name, age, gender, 50000, 15000);
    }

    public Professor(String name, int age, String gender, int baseSalary, int perCourseSalary) 
    {
	   /**
	     * Constructs a new Professor with the corresponding parameters as field values, an array for storing courses, and
	     * the next ID value (one greater than the previously created professors's id value).
	     *
	     * @param name Name of the new Professor to be added
	     * @param age Age of the new Professor to be added
	     * @param gender Gender of the new Professor to be added
	     * @param baseSalary Amount the Professor must be paid
	     * @param perCourseSalary Amount the Professor must be paid for each course they lead
	     */
    	super(name, age, gender, baseSalary, perCourseSalary);
    }
    public String toString() 
    {
    	/**
         * Returns a String representation of the Student object. This method must exist, but will not be tested.
         *
         * @return String
         */
    	String f = String.format("Name   : %s\nID     : %d\nAge    : %d\nGender : %s", this.getName(), this.getID(), this.getAge(), this.getGender());
        return f;
    }
}



















