/**
 * Program Name
 *
 * Abstraction of a college course. Each course is uniquely identifiable by its course name.
 *
 * @author You
 *
 * @version date of completion
 *
 */

public class Course {
    /**
     * Maximum number of students allowed to be enrolled in a Course
     */
    protected final static int MAX_STUDENTS = 100;

    private String name;
    private Professor professor;
    private Teacher[] teachers;
    private Student[] students;

    public Course(String name, Professor professor) 
    {
    	/**
         * Constructs a Course object with the corresponding parameters as its name and a reference to the lead Professor.
         * Creates an array to contain at most 100 students enrolled in the course and ensures the Professor adds the course
         * to their list of courses.
         * 
         * @param name Name of the Course to be offered.
         * @param professor A reference to the lead professor for the course.
         */
    	this.name = name;
    	this.professor = professor;
    	this.students = new Student[MAX_STUDENTS];
    	this.teachers = new Teacher[10];
    	professor.addCourse(this);
    }
    public void addStudent(Student student) throws AddToCourseException 
    {
    	 /**
         * Adds student to the course. Throws AddToCourseException if the course is full, if student is null, or
         * if the student is already enrolled in the course
         *
         * @param student Student to be added to the Course
         * @throws AddToCourseException If the course is full, if student is null, or if the student is already enrolled in
         * the course
         */
    	if(student == null)
    	{
    		throw new AddToCourseException("Student must not be null");
    	}
    	
    	boolean full = false;
    	int i = 0;
    	for(;i < this.students.length; i++)
    	{
    		if(this.students[i] == null)
    			break;							// breaks if there is empty space in the class
    		if(this.students[i].equals(student))
    		{
    			throw new AddToCourseException("The student is already enrolled in the class");	// if the student already exists
    		}
    		if( i == this.students.length - 1)
    			full = true;					// class is full
    	}
    	if( full )
    	{
    		throw new AddToCourseException("The class is full");
    	}
    	this.students[i] = student;
    }
    public void dropStudent(Student student) throws DropFromCourseException
    {
    	/**
         * Removes student from the course. Throws DropFromCourseException if student is null or if the student
         * is not enrolled in the course.
         *
         * @param student Student to be removed from the course
         * @throws DropFromCourseException If student is null or if the student is not enrolled in the course.
         */
    	if(student == null)
    	{
    		throw new DropFromCourseException("Student must not be null");
    	}
    	
    	for(int i = 0; i < this.students.length; i++)
    	{
    		if(this.students[i] == null)
    		{
        		throw new DropFromCourseException("Student must not be null");
    		}
    		if(this.students[i].equals(student))
    		{
    			this.students[i] = null;		// removes the course
    			
    			// shifts the array to have null be at the end for data consistency
    			while( i < this.students.length - 1 )
    			{
    				this.students[i] = this.students[i + 1];
    				i++; 
    			}
    			this.students[this.students.length - 1] = null;	// null value is moved to the end
    			
    			return;		// student has been removed
    		}
    	}
    	
    	throw new DropFromCourseException("Student is not enrolled in this course");
    }
    public void addTeacher(Teacher teacher) throws AddToCourseException 
    {
    	/**
         * Adds teacher to the course. If the teachers array is full, then its size is doubled and the teacher is added.
         * A Teacher may teach the same course more than once (like having multiple sections). Throws AddToCourseException
         * if teacher is null. The teacher should add this course to their personal list of courses.
         *
         * @param teacher Teacher to be added to the Course
         * @throws AddToCourseException If the course is full or if teacher is null
         */
    	if(teacher == null)
    	{
    		throw new AddToCourseException("Teacher must not be null");
    	}
    	
    	try {
    		// assumes that the courses[] isn't full
	    	int i = 0;
			while( this.teachers[i] != null )
			{
				// finds the last empty slot
				i++;
			}
    		this.teachers[i] = teacher;		// adds the final value
    		teacher.addCourse(this);		// adds course to the teacher's list
    	} catch( ArrayIndexOutOfBoundsException e ) {
    		// reached when the list is full
    		// doubles the length of the courses and adds the course
    		Teacher temp[] = this.teachers;	// Creates a temp array to house courses
    		this.teachers  = new Teacher[ (this.teachers.length * 2) ];	// Doubles the length of the array
    		int i = 0;
    		while( i < temp.length )
    		{
    			this.teachers[i] = temp[i];
    			i++;
    		}
    		this.teachers[i] = teacher;		// adds the final value
    		teacher.addCourse(this);		// adds course to the teacher's list
    	}
    }
    public void dropTeacher(Teacher teacher)throws DropFromCourseException
    {
    	/**
         * Removes teacher from the courses's array of teachers. If teacher teaches multiple instances of the
         * course, only one is removed. Throws DropFromCourseException if teacher is null or if teacher is not found.
         *
         * @param teacher Teacher to be added to the Course
         * @throws DropFromCourseException if teacher is null or if teacher is not found.
         */
    	if(teacher == null)
    	{
    		throw new DropFromCourseException("Teacher must not be null");
    	}
    	for(int i = 0; i < this.students.length; i++)
    	{
    		if(this.teachers[i] == null )
    		{
        		throw new DropFromCourseException("Student must not be null");
    		}
    		if(this.teachers[i].equals(teacher))
    		{
    			this.teachers[i] = null;						// removes the teacher
    			
    			// shifts the array to have null be at the end for data consistency
    			while( i < this.teachers.length - 1 )
    			{
    				this.teachers[i] = this.teachers[i + 1];
    				i++; 
    			}
    			this.teachers[this.teachers.length - 1] = null;	// null value is moved to the end
    			teacher.dropCourse(this);						// removes course form the teacher
    			return;		// teacher has been removed
    		}
    	}
    	throw new DropFromCourseException("Teacher is not enrolled in this course");    }
    public Professor getProfessor()
    {
    	/**
         * @return Reference to Professor leading this Course
         */
        return this.professor;
    }
    public Student[] getRoster()
    {
    	/*
         * Creates and returns a new array containing the list of Students. The new array should have a length equal to the
         * number of students currently enrolled in the course. Returns an array of length 0 if the course has no Students.
         *
         * @return A new array containing the Course's Students with no null elements.
         */
    	int len = 0;
    	for(int i = 0; i < this.students.length; i++)
    	{
    		if(this.students[i] == null)
    		{
    			len = i;
    			break;						// increments i to find the used length of the students
    		}
    	}
    	Student s[] = new Student[len];		// temp variable to be returned with the lis of students
    	for(int i = 0; i < len; i++)
    	{
    		s[i] = this.students[i];		// adds the values in until the new list is filled
    	}
    	return s;
    }
    public String getName() 
    {
    	// returns the course name
        return this.name;
    }
    public Teacher[] getTeachers() 
    {
    	/**
         * Returns a new array containing the Courses's Teachers. The new array should have a length equal to the
         * number of Teachers currently teaching the course, duplicates included. Returns an array of length 0 if the course
         * has no Teachers.
         *
         * @return A new array containing the Course's Teachers with no null elements.
         */
    	int len = 0;
    	for(int i = 0; i < this.teachers.length; i++)
    	{
    		if(this.teachers[i] == null)
    		{
    			len = i;
    			break;						// increments i to find the used length of the students
    		}
    	}
    	Teacher t[] = new Teacher[len];		// temp variable to be returned with the lis of students
    	for(int i = 0; i < len; i++)
    	{
    		t[i] = this.teachers[i];		// adds the values in until the new list is filled
    	}
    	return t;
    }
    public void changeProfessor(Professor professor) 
    {
    	/**
         * Makes professor the Course professor and updates the old and new Professors involved accordingly.
         *
         * @param professor Reference to Professor object to be made the lead Professor of the course.
         */
    	if( professor == null )
    		return;
    	
    	this.professor.dropCourse(this);
    	this.professor = professor;
    	professor.addCourse(this);
    }

    /**
     * Returns a String representation of the Course object. This method must exist, but will not be tested.
     *
     * @return String
     */
    public String toString() {
        return "";
    }
}
