/**
 * College
 *
 * Represents an abstraction of a college. Each college may have courses, professors, students, and teachers.
 *
 * @author You
 *
 * @version date of completion
 *
 */

public class College {

    /**
     * Maximum number of Courses allowed to be added to a College
     */
    protected static final int MAX_COURSES = 10;

    /**
     * Maximum number of Professors allowed to be hired by a College
     */
    protected static final int MAX_PROFESSORS = 5;
    
    /**
     * Maximum number of Teachers allowed to be hired by a College
     */
    protected static final int MAX_TEACHERS = 25;

    /**
     * Maximum number of Students allowed to be enrolled to a College
     */
    protected static final int MAX_STUDENTS = 500;


    private int tuition;				// cost to attend the College

    private String name;				// name of the College
    private Professor[] professors;		// array of the professors at the College
    private Teacher[] teachers;			// array of the teachers   at the College
    private Student[] students;			// array of the students   at the College
    private Course[] courses;			// array of the courses    at the College

    public College(String name, int tuition) {
    	/**
         * Constructs a new College object with the corresponding parameters as field values, and new arrays of Professors,
         * Students, Teachers, and Courses limited by the corresponding MAX variables.
         *
         * @param name Name of the College to be created.
         * @param tuition Cost for students to attend.
         */
    	this.name = name;
    	this.tuition = tuition;
    	
    	this.professors = new Professor[MAX_PROFESSORS];
    	this.teachers   = new Teacher[MAX_TEACHERS];
    	this.students   = new Student[MAX_STUDENTS];
    	this.courses    = new Course[MAX_COURSES];
    }
    public void addCourse(Course course) 
    {
    	/**
         * Adds course to the College's array of courses. If the course is null, the course is already available at the
         * College, or the College cannot add more courses, nothing changes.
         *
         * @param course A course object to be added to the College's array of courses.
         */
    	if( course == null )
    		return;
    		
    	for( int i = 0; i < this.courses.length; i++)
    	{
    		if( this.courses[i] == null )		// find the last open slot in the courses	
    		{
    			this.courses[i] = course;
    			break;
    		}
    		if( this.courses[i].getName().equals(course.getName()))
    		{
    			// can't add duplicates
    			return;
    		}
    	}
    	// if there is no room nothing happens
    }
    public void hireProfessor(Professor professor) 
    {
    	/**
         * Adds professor to the College's array of Professors. If the Professor is null, the College cannot add more
         * Professors, or the Professor is already employed by the College, nothing changes.
         *
         * @param professor Professor to be added to the College's array of Professors
         */
    	if( professor == null )
    		return;											// someone dumb sent a null parameter
    		
    	for(int i = 0; i < this.professors.length; i++ )
    	{
    		if( this.professors[i] == null )
    		{
    			this.professors[i] = professor;				// adds the professor
    			break;
    		}
    		if( this.professors[i].getID() == professor.getID())
    		{
    			return;										// professor already exits 
    		}
    	}
    	// the College can not hire more professors
    }
    public void hireTeacher(Teacher teacher)
    {
    	/**
         * Adds teacher to the College's array of Teachers. If teacher is null, the College cannot add more Teachers,
         * or teacher is already employed by the College, nothing changes.
         *
         * @param teacher Teacher to be added to the College's array of teachers
         */
    	if( teacher == null )
    		return;											// someone dumb sent a null parameter
    		
    	for(int i = 0; i < this.teachers.length; i++ )
    	{
    		
    		if( this.teachers[i] == null )
    		{
    			this.teachers[i] = teacher;				// adds the teacher
    			break;
    		}
    		if( this.teachers[i].getID() == teacher.getID() )
    		{
    			return;										// teacher already exits 
    		}
    	}
    	// the College can not hire more professors
    }
    public void addStudent(Student student)
    {
    	/**
         * Adds student to the College's array of students. If the student is null, the student is already enrolled at the
         * College, or the College cannot add more students, nothing changes.
         *
         * @param student A Student object to be added to the College's array of students.
         */
    	if( student == null )
    		return;											// someone dumb sent a null parameter
    		
    	for(int i = 0; i < this.students.length; i++ )
    	{
    		if( this.students[i] == null )
    		{
    			this.students[i] = student;					// adds the student
    			break;
    		}
    		if( this.students[i].getID() == student.getID() )
    		{
    			return;										// student already exits 
    		}
    	}
    	// the College can not enroll more students
    }
    public void dropStudent(Student student) 
    {
    	/**
         * Removes student from the College's array of Students. If the student is enrolled in any Courses, they should be
         * removed from these courses. If student is null or the student is not currently enrolled, nothing changes.
         *
         * @param student Student to be removed from the College's array of students
         */
    	if( student == null )
    	{
    		return;
    	}
    	
    	// removes student from courses
    	for( int i = 0; i < this.courses.length; i ++)
    	{
			try {
				// attempts to drop the student from the course
				this.courses[i].dropStudent(student);
				break;
			} catch (DropFromCourseException e) {
				continue;
				// nothing will be done if student is unable to be removed 
				// because that means the student is not in the course
			} catch( NullPointerException e1 ) {
				continue;
			}
    	}
    	// removes student from the course list 
    	for( int i = 0; i < this.students.length; i ++ )
    	{
    		if(this.students[i] == null)
    			return;
	    	if(this.students[i].getID() == student.getID() )
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
    }
    public int calculateNetBudgetChange() {
    	/**
         * Returns the net change in the colleges budget. Tuition per student will increase the net change, and payments for
         * Professors and Teachers according to both their base and per course salaries will decrease the net change.
         *
         * @return Net change in the College's funds
         */
    	int net = 0;
    	
    	// calculates the per course costs for teachers and professors
    	for( int i = 0; i < this.teachers.length; i++ )
    	{
    		if( this.teachers[i] == null )
    			break;
    		
    		// this loop gets the teachers
    		for( int c = 0; c < this.courses.length; c++)
    		{
    			// this loop gets each course to be compared
    			if( this.courses[c] == null )
    				break;
	    		for( int j = 0; j < this.courses[c].getTeachers().length; j++)
	    		{
	    			// this loop gets the teachers of the course
	    			if( this.teachers[i].equals(this.courses[c].getTeachers()[j]) ) 
	    			{
	    				// adds the teacher's per course salary for each course they teach
	    				net -= this.teachers[i].getPerCourseSalary();	
	    			}
	    		}
    		}
    		// adds the teacher's base salary 
    		net -= this.teachers[i].getBaseSalary();
    	}
    	for( int i = 0; i < this.professors.length; i++ )
    	{
    		// this loop gets the teachers
    		if( this.professors[i] == null )
    			break;
    		
    		for( int c = 0; c < this.courses.length; c++)
    		{
    			// this loop gets each course to be compared
    			if( this.courses[c] == null )
    				break;
    			if( this.professors[i].equals(this.courses[c].getProfessor()) ) 
    			{
    				// adds the teacher's per course salary for each course they teach
    				net -= this.professors[i].getPerCourseSalary();	
    			}
    		}
    		// adds the teacher's base salary 
    		net -= this.professors[i].getBaseSalary();
    	}
    	int i = 0;
    	// gets the total number of enrolled students
    	for( ; i < this.students.length; i++ )
    	{
    		if( this.students[i] == null )
    		{
    			// if there are no more students enrolled
    			break;
    		}
    	}
    	// adds the profit from tuition
    	net += ( i * this.getTuition() );

    	return net;
    }
    public Course[] getCourses()
    {
    	/**
         * @return A reference to the array of courses offered by this College.
         */
    	return this.courses;
    }
    public Teacher[] getTeachers()
    {
    	/**
         * @return A reference to the array of Teachers employed by this College.
         */
        return this.teachers;
    }
    public Professor[] getProfessors()
    {
    	/**
         * @return A reference to the array of Professors employed by this College.
         */
    	return this.professors;
    }
    public Student[] getStudents()
    {
    	/**
         * @return A reference to the array of Students enrolled at this College.
         */
    	return this.students;
    }
    public String getName() 
    {
    	/**
         * @return The name of the College object
         */
    	return this.name;
    }
    public int getTuition()
    {
    	/**
         * @return The tuition charged per student
         */
    	return this.tuition; 
    }
}



















