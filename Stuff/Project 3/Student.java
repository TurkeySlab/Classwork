/**
 * Program Name
 *
 * Abstraction of a college student. Each student is uniquely identifiable by their ID (starting at 0).
 *
 * @author Max Williams
 *
 * @version 03.16.2018
 */

public class Student implements Person {
    /**
     * Static variable used to determine the next ID number
     */
    protected static int nextID = 0;

    private int id;
    private String name;
    private int age;
    private String gender;

    /**
     * Constructs a new Student with the corresponding parameters as field values, and the next ID value (one greater
     * than the previously created students's id value).
     *
     * @param name Name to be assigned to this Student
     * @param age Age of this Student
     * @param gender Gender of this Student
     */
    public Student(String name, int age, String gender)
    {
    	if( name.equals(null) )
    		this.name = "";
    	else 
    		this.name = name;
    	this.age  = age;
    	if( gender.equals(null) )
    		this.gender = "";
    	else
    		this.gender = gender;
    	
    	this.id = this.nextID;
    	this.nextID++;
    }
    public int getID() 
    {
        return this.id;
    }
    public void setName(String name)
    {
    	// sets the name of the student
    	this.name = name;
    }
    public void setGender(String gender)
    {
    	// sets the gender of the student
    	this.gender = gender;
    }
    public void setAge(int age)
    {
    	// sets the age of the student
    	this.age = age;
    }
    public String getName()
    {
    	// returns the name of the student
    	return this.name;
    }
    public String getGender()
    {
    	// returns the gender of the student
        return this.gender;
    }
    public int getAge()
    {
    	// returns the age of the student
        return this.age;
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



















