import java.io.Serializable;

/**
 * Program Name
 *
 * Abstraction of a college teacher. Each teacher is uniquely identifiable by their ID (starting at 0).
 *
 * @author Max WIlliams
 *
 * @version 03.16.2018
 *
 */

public class Teacher implements Person, Serializable {
    /**
     * Static variable used to determine the next ID number
     */
    protected static int nextID = 0;

    private String name;
    private int age;
    private String gender;
    private int id;
    private Course courses[];
    private int perCourseSalary;
    private int baseSalary;

    public Teacher(String name, int age, String gender) 
    {
    	/*
         * Constructs a new Teacher with the corresponding parameters as field values, an array for storing courses, and
         * the next ID value (one greater than the previously created teacher's id value). Set the Teacher's baseSalary to
         * 30,000 and perCourseSalary to 15,000 by default.
         *
         * @param name Name of the new Teacher to be added
         * @param age Age of the new Teacher to be added
         * @param gender Gender of the new Teacher to be added
         */
    	if( name.equals(null) )
    		this.name = "";
    	else 
    		this.name = name;
    	if( gender.equals(null) )
    		this.gender = "";
    	else
    		this.gender = gender;
    	
    	this.age  = age;
    	this.id = nextID;
    	nextID++;			// increments nextID 
    	
    	// defaults
    	this.baseSalary = 30000;
    	this.perCourseSalary = 15000;
    	this.courses = new Course[10];	// Initializes to null
    }
    public Teacher(String name, int age, String gender, int baseSalary, int perCourseSalary) 
    {
    	 /*
         * Constructs a new Teacher with the corresponding parameters as field values, an array for storing courses, and
         * the next ID value (one greater than the previously created teacher's ID value).
         *
         * @param name Name of the new Teacher to be added
         * @param age Age of the new Teacher to be added
         * @param gender Gender of the new Teacher to be added
         * @param baseSalary Amount the Teacher must be paid
         * @param perCourseSalary Amount the Teacher must be paid for each course they lead
         */
    	
    	if( name.equals(null) )
    		this.name = "";
    	else 
    		this.name = name;
    	if( gender.equals(null) )
    		this.gender = "";
    	else
    		this.gender = gender;
    	
    	this.age  = age;
    	this.id = nextID;
    	nextID++;			// increments nextID     	
    	this.baseSalary = baseSalary;
    	this.perCourseSalary = perCourseSalary;   
    	this.courses = new Course[10];	// Initializes to null
    }
    public void addCourse(Course course)
    {
    	 /*
         * Adds a course to the Teacher's array of courses taught. If the course array is full, then its size is doubled
         * the course is added. A Teacher may teach the same course more than once (like having multiple sections). If
         * course is null, nothing changes.
         *
         * This method should not modify the passed course object.
         *
         * @param course
         */
    	if( course.equals(null) )
    	{
    		// quick check for null input
    		return;
    	}
    	try {
    		// assumes that the courses[] isn't full
	    	int i = 0;
			while( this.courses[i] != null )
			{
				// finds the last empty slot
				i++;
			}
    		this.courses[i] = course;		// adds the final value
    	} catch( ArrayIndexOutOfBoundsException e ) {
    		// reached when the list is full
    		// doubles the length of the courses and adds the course
    		
    		Course temp[] = this.getCourses();	// Creates a temp array to house courses
    		this.courses  = new Course[ (this.courses.length * 2) ];	// Doubles the length of the array
    		int i = 0;
    		while( i < temp.length )
    		{
    			this.courses[i] = temp[i];
    			i++;
    		}
    		this.courses[i] = course;		// adds the final value
    	}
    }
    public boolean dropCourse(Course course)
    {
    	/* removes the given course from the list
    	 * If there are multiple courses : then the first occurrence is removed
    	 */
    	if( course == null )
    		return false;
    	
    	int i = 0;
    	while( i < this.courses.length )
    	{
    		if( this.courses[i].getName().equals(course.getName()) )
    		{
    			this.courses[i] = null;		// removes the course
    			// shifts the array to have null be at the end for data consistency
    			while( i < this.courses.length - 1 )
    			{
    				this.courses[i] = this.courses[i + 1];
    				i++; 
    			}
    			this.courses[this.courses.length - 1] = null;	// null value is moved to the end
    			break;
    		}
    		i++;
    	}
        return false;
    }
    public Course[] getCourses()
    {
    	/**			TODO ask about this >>>
         * @return a reference to the array of courses taught by this Teacher.
         * 
         * addTeacher throw exception: when should error be thrown
         * Professor id scope is trapped within teacher making it unable to be a unique id for professors and teachers
         * 		Solutions : create public setter method for teachers
         */
    	// returns the courses of teacher
    	return this.courses;
    }
    public int teachesCourse(Course course)
    {
    	/**
         * Returns the number of times the Teacher teaches course. For example, if the course occurs twice this returns 2.
         * If the course is not taught by this Teacher, this returns 0. Returns 0 if course is null.
         *
         * @param course Course being confirmed if taught by teacher
         * @return Course object.
         */
    	if( course == null ) 
    		return 0;
    	
    	int i = 0;
    	int count = 0;
    	while( i < this.courses.length )
    	{
    		if( this.courses[i] == null )
    			break;
    		if( this.courses[i].getName().equals(course.getName()) )
    			count++;
    		i++;
    	}
    	return count;
    }
    public int getPerCourseSalary() 
    {
    	// guess what this does!
        return this.perCourseSalary; 
    }
    public int getBaseSalary() 
    {
    	// returns the base salary of the teacher
        return this.baseSalary; 
    }
    /*
     * Inherited form Person
     */
    public void setName(String name)
    {
    	// sets the name of the teacher
    	this.name = name;
    }
    public void setGender(String gender)
    {
    	// sets the gender of the teacher
    	this.gender = gender;
    }
    public void setAge(int age)
    {
    	// sets the age of the teacher
    	this.age = age;
    }
    public String getName()
    {
    	// returns the name of the teacher
    	return this.name;
    }
    public String getGender()
    {
    	// returns the gender of the teacher
        return this.gender;
    }
    public int getAge()
    {
    	// returns the age of the teacher
        return this.age;
    }
    public int getID() 
    {
        return this.id;
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




















