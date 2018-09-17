
public class test {
	public static void main( String args[] ) 
	{
		College college = new College("school", 10);
		Professor p6 = new Professor("professor7", 12, "on");

		Teacher t1 = new Teacher("name1", 1, "");
		Teacher t2 = new Teacher("name2", 1, "");
		Teacher t3 = new Teacher("name3", 1, "");
		Teacher t4 = new Teacher("name4", 1, "");
		Teacher t5 = new Teacher("name5", 1, "");
		Teacher t6 = new Teacher("name6", 1, "");

		Student s = new Student("student1", 10, "h");
		
		college.hireProfessor(p6);
		
		college.hireTeacher(t1);
		college.hireTeacher(t2);
		college.hireTeacher(t3);
		college.hireTeacher(t4);
		college.hireTeacher(t5);
		college.hireTeacher(t6);
		
		college.addStudent(s);
		
		try {
			Course c = new Course("as", p6);
			c.addStudent(s);
			c.addTeacher(t1);
			c.addTeacher(t2);
			college.addCourse(c);
			
			System.out.println(c.getRoster()[0].getID());
			
			college.dropStudent(s);
			
		} catch (AddToCourseException e) {
			System.out.println("error in add student");
		}
		
		college.calculateNetBudgetChange();
	}
}
