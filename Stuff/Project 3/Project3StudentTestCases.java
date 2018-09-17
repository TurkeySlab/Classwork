import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.Test;

public class Project3StudentTestCases {
    static String NAMES[]={"Josue","Sherrill","Genna","Debroah","Arielle",
            "Jeana","Anja Pendergraft","Jenae","Charlsie","Myrle","Luigi Mario",
            "Salina Freudenthal","Sonny","Luciano Cupit","Shameka Rakow","Charissa","Mario Mario",
            "Samira","Tamie","Daphine","Maud","Derick","Ronald McDonald",
            "Elinor","Afanador","Hermelinda", "Irmgard","Coleen","Toad",
            "Roger","Freddy","Mika Duane","Victory Soe","Mirtha","Saundra","Donky Kong",
            "Marissa","Lilia Kane","Jayne","Mariah","Ashleigh","Sherron Duffey",
            "Judith","Horace","Isidro","Elden","Carmelina Tisdale","Garrett Bohm",
            "Takako ","Annamaria","Ashton","Marquita","Tiffiny Saxon","Judy",
            "Kenisha","Yvonne","Frog Mario","Shawnta","Letha","Nena",
            "Klara","Morton","Agripina","Elfriede","Sheri","Michaele",
            "Ashely","Zoe","Danae","Shanna","Adrian","Valentine",
            "Fermina","Erika","Teofila","Lexie","Lenna","Rikki",
            "Mina","Neda","Estrella","Judy","Kurtis Gimenez","Hipolito",
            "Roselyn","Rebecca", "Ofelia","Annett","Raquel","Ericka",
            "Camie Jaime","Londa","Kaycee Rodrigues","Lucretia Greeno","Terrance","Shemika",
            "Fatima","Torie","Gillian","Suanne","Juana Beaudry","Freddie ",
            "Zenobia Bowersox","Glennis","Sripath","Kulinski","Dunsmore","Jacob",
            "Anna Payor","Rocky the Dog","Tuxen the Cat","Eiyu Stew Dent", "Runninata Names"};
    static String DEPARTMENT_CODES[]={"EDCI","CS","ENGR","MATH","SPAN","ITAL","AAS"};

    /**************************************************************************************************
     *
     * Variable Usage (10%)
     */

    @Test(timeout = 100)
    //@ScoringWeight(0.020)
    public void testForStaticVariables() throws Exception {
        try {
            String[] permittedCollegeStaticVariableString = {"MAX_COURSES", "MAX_PROFESSORS", "MAX_TEACHERS", "MAX_STUDENTS"};
            String[] permittedTeacherStaticVariableString = {"nextID"};
            String[] permittedProfessorStaticVariableString = {"nextID"};
            String[] permittedStudentStaticVariableString = {"nextID"};
            String[] permittedCourseStaticVariableString = {"MAX_STUDENTS"};

            ArrayList<String> permittedCollegeVariables = new ArrayList<String>(Arrays.asList(permittedCollegeStaticVariableString));
            ArrayList<String> permittedTeacherVariables = new ArrayList<String>(Arrays.asList(permittedTeacherStaticVariableString));
            ArrayList<String> permittedProfessorVariables = new ArrayList<String>(Arrays.asList(permittedProfessorStaticVariableString));
            ArrayList<String> permittedStudentVariables = new ArrayList<String>(Arrays.asList(permittedStudentStaticVariableString));
            ArrayList<String> permittedCourseVariables = new ArrayList<String>(Arrays.asList(permittedCourseStaticVariableString));

            Field[] collegeFields = College.class.getDeclaredFields();
            Field[] teacherFields = Teacher.class.getDeclaredFields();
            Field[] professorFields = Professor.class.getDeclaredFields();
            Field[] studentFields = Student.class.getDeclaredFields();
            Field[] courseFields = Course.class.getDeclaredFields();

            //Check each class for illegal static variables
            for (Field f : collegeFields) {
                if (Modifier.isStatic(f.getModifiers()) && !permittedCollegeVariables.contains(f.getName())) {
                    fail("testForStaticVariables::You may not declare static variables unless they were provided for you.");
                }
            }

            for (Field f : teacherFields) {
                if (Modifier.isStatic(f.getModifiers()) && !permittedTeacherVariables.contains(f.getName())) {
                    fail("testForStaticVariables::You may not declare static variables unless they were provided for you.");
                }
            }

            for (Field f : professorFields) {
                if (Modifier.isStatic(f.getModifiers()) && !permittedProfessorVariables.contains(f.getName())) {
                    fail("testForStaticVariables::You may not declare static variables unless they were provided for you.");
                }
            }

            for (Field f : studentFields) {
                if (Modifier.isStatic(f.getModifiers()) && !permittedStudentVariables.contains(f.getName())) {
                    fail("testForStaticVariables::You may not declare static variables unless they were provided for you.");
                }
            }

            for (Field f : courseFields) {
                if (Modifier.isStatic(f.getModifiers()) && !permittedCourseVariables.contains(f.getName())) {
                    fail("testForStaticVariables::You may not declare static variables unless they were provided for you.");
                }
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testForStaticVariables::An unexpected exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100)
    //@ScoringWeight(0.020)
    public void testForPublicVariables() throws Exception {
        try {
            String[] permittedCollegeStaticVariableString = {"MAX_COURSES", "MAX_PROFESSORS", "MAX_TEACHERS", "MAX_STUDENTS"};
            String[] permittedTeacherStaticVariableString = {"nextID"};
            String[] permittedProfessorStaticVariableString = {"nextID"};
            String[] permittedStudentStaticVariableString = {"nextID"};
            String[] permittedCourseStaticVariableString = {"MAX_STUDENTS"};

            ArrayList<String> permittedCollegeVariables = new ArrayList<String>(Arrays.asList(permittedCollegeStaticVariableString));
            ArrayList<String> permittedTeacherVariables = new ArrayList<String>(Arrays.asList(permittedTeacherStaticVariableString));
            ArrayList<String> permittedProfessorVariables = new ArrayList<String>(Arrays.asList(permittedProfessorStaticVariableString));
            ArrayList<String> permittedStudentVariables = new ArrayList<String>(Arrays.asList(permittedStudentStaticVariableString));
            ArrayList<String> permittedCourseVariables = new ArrayList<String>(Arrays.asList(permittedCourseStaticVariableString));

            Field[] collegeFields = College.class.getDeclaredFields();
            Field[] teacherFields = Teacher.class.getDeclaredFields();
            Field[] professorFields = Professor.class.getDeclaredFields();
            Field[] studentFields = Student.class.getDeclaredFields();
            Field[] courseFields = Course.class.getDeclaredFields();

            //Check each class for illegal static variables
            for (Field f : collegeFields) {
                if (Modifier.isPublic(f.getModifiers()) && !permittedCollegeVariables.contains(f.getName())) {
                    fail("testForPublicVariables::You may not declare public variables.");
                }
            }

            for (Field f : teacherFields) {
                if (Modifier.isPublic(f.getModifiers()) && !permittedTeacherVariables.contains(f.getName())) {
                    fail("testForPublicVariables::You may not declare public variables.");
                }
            }

            for (Field f : professorFields) {
                if (Modifier.isPublic(f.getModifiers()) && !permittedProfessorVariables.contains(f.getName())) {
                    fail("testForPublicVariables::You may not declare public variables.");
                }
            }

            for (Field f : studentFields) {
                if (Modifier.isPublic(f.getModifiers()) && !permittedStudentVariables.contains(f.getName())) {
                    fail("testForPublicVariables::You may not declare public variables.");
                }
            }

            for (Field f : courseFields) {
                if (Modifier.isPublic(f.getModifiers()) && !permittedCourseVariables.contains(f.getName())) {
                    fail("testForPublicVariables::You may not declare public variables.");
                }
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testForStaticVariables::An unexpected exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100)
    //@ScoringWeight(0.025)
    public void testTeachersHaveIncreasingIDs() throws Exception {
        try {
            int idIncr     = 90;
            int expectedID = idIncr + Teacher.nextID;
            Teacher lastTeacher = null;
            for (int i = 0; i <= idIncr; i++) {
                String name = NAMES[(i + 6) % NAMES.length];
                int age = 50;
                String gender = "Unspecified";
                if (i % 2 == 0)
                    lastTeacher = new Teacher(name, age, gender);
                else
                    lastTeacher = new Teacher(name, age, gender, 50, 100);
            }
            assertTrue("testTeachersHaveIncreasingIDs::Ensure that teacher IDs are increasing properly",
                    expectedID == lastTeacher.getID());
        } catch (AssertionError e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testTeachersHaveIncreasingIDs::An unexpected exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100)
    //@ScoringWeight(0.020)
    public void testStudentsHaveIncreasingIDs() throws Exception {
        try {
            int expectedID = 87;
            Student lastStudent = null;
            for (int i = 0; i <= expectedID; i++) {
                String name = NAMES[(i +17) % NAMES.length];
                int age = 25;
                String gender = "Unspecified";
                lastStudent = new Student(name, age, gender);
            }
            if (expectedID == lastStudent.getID()) {
                fail("testStudentsHaveIncreasingIDs::Ensure that student IDs are increasing properly");
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Exception e){
            //e.printStackTrace;
            System.out.println("testStudentsHaveIncreasingIDs::An unexpected exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100)
    //@ScoringWeight(0.025)
    public void testProfessorsHaveIncreasingIDs() throws Exception {
        int idIncr;
        int expectedID1 ;
        int expectedID2;
        int actualID;

        try {
            idIncr      = 15;
            expectedID1 = idIncr + Professor.nextID;
            expectedID2 = idIncr + Teacher.nextID;
            Professor lastProfessor = null;
            for (int i = 0; i <= idIncr; i++) {
                String name = NAMES[(i + 10) % NAMES.length];
                int age = 50;
                String gender = "Unspecified";
                if (i % 2 == 0)
                    lastProfessor = new Professor(name, age, gender);
                else
                    lastProfessor = new Professor(name, age, gender, 50, 100);
            }
            String message = String.format("testProessorsHaveIncreasingIDs::Ensure that teacher/professor IDs are " +
                    "increasing properly.%nExpected: %d (if Professor individiual ID) OR %d (if Professor " +
                    "and Teachers share IDs), Actual: %d", expectedID1, expectedID2, lastProfessor.getID()
            );
            assertTrue(message,
                    expectedID1 == lastProfessor.getID() || expectedID2 == lastProfessor.getID());
        } catch (AssertionError e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testProfessorsHaveIncreasingIDs::An unexpected exception occurred (see stack trace).");
            throw e;
        }
    }


    /**************************************************************************************************
     *
     * Teacher and Professor (30%)
     */

    @Test(timeout = 100)
    //@ScoringWeight(0.050)
    public void testProfessorInheritsFromTeacher() {
        try {
            assertEquals("testProfessorInheritsFromTeacher::Professor class must inherit from Teacher class.", Professor.class.getSuperclass(), Teacher.class);
        } catch (AssertionError e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testProfessorInheritsFromTeacher::An unexpected exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100)
    //@ScoringWeight(0.050)
    public void testTeacherFullConstructorAndGetters() throws Exception {
        try {
            String expectedName = NAMES[50];
            int expectedAge = 54;
            String expectedGender = "male";
            int expectedBaseSal = 700;
            int expectedPerCourseSalary = 9000;

            Teacher testTeacher = new Teacher(expectedName, expectedAge, expectedGender, expectedBaseSal, expectedPerCourseSalary);

            String message = "testTeacherFullConstructorAndGetters::Ensure you store the correct values and return them" +
                    "with your getter methods";

            String actualName = testTeacher.getName();
            int actualAge = testTeacher.getAge();
            String actualGender = testTeacher.getGender();
            int actualBaseSal = testTeacher.getBaseSalary();
            int actualPerCourseSalary = testTeacher.getPerCourseSalary();

            assertEquals(message, expectedName, actualName);
            assertEquals(message, expectedAge, actualAge);
            assertEquals(message, expectedGender, actualGender);
            assertEquals(message, expectedBaseSal, actualBaseSal);
            assertEquals(message, expectedPerCourseSalary, actualPerCourseSalary);
        } catch (AssertionError e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testTeacherFullConstructorAndGetters::An unexpected exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100)
    //@ScoringWeight(0.050)
    public void testVerifyDefaultSalaries() throws Exception {
        try {
            //Create a Professor and Teacher using three param constructor
            String professorName   = NAMES[40];
            int professorAge       = 10;
            String professorGender = "Unspecified";
            Professor professor    = new Professor(professorName,professorAge,professorGender);

            String teacherName   = NAMES[63];
            int teacherAge       = 90;
            String teacherGender = "Unspecified";
            Teacher teacher      = new Teacher(teacherName,teacherAge,teacherGender);

            //Compare salaries with expected defaults
            int expectedTeacherBaseSalaryDefault   = 30000;
            int expectedTeacherPerCSalaryDefault   = 15000;
            int expectedProfessorBaseSalaryDefault = 50000;
            int expectedProfessorPerCSalaryDefault = 15000;
            assertEquals("testVerifyDefaultSalaries::Ensure you are assigning the correct default salaries.",
                    expectedTeacherBaseSalaryDefault, teacher.getBaseSalary());
            assertEquals("testVerifyDefaultSalaries::Ensure you are assigning the correct default salaries.",
                    expectedTeacherPerCSalaryDefault, teacher.getPerCourseSalary());
            assertEquals("testVerifyDefaultSalaries::Ensure you are assigning the correct default salaries.",
                    expectedProfessorBaseSalaryDefault, professor.getBaseSalary());
            assertEquals("testVerifyDefaultSalaries::Ensure you are assigning the correct default salaries.",
                    expectedProfessorPerCSalaryDefault, professor.getPerCourseSalary());
        } catch (AssertionError e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testVerifyDefaultSalaries::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100)
    //@ScoringWeight(0.050)
    public void testTeachesCourses() throws Exception {
        try {
            //Create an array of Teachers (identify special teacher) and an array of courses
            Teacher[] teachers     = createTeachers(9);
            int sampleTeacherIndex = 5;
            Teacher sampleTeacher  = teachers[sampleTeacherIndex];

            Professor[] professors = createProfessors(3);
            Course[] courses       = createCourses(professors, 4);

            //Add Teacher to one course, verify Teacher teaches the course
            courses[0].addTeacher(sampleTeacher);
            assertEquals("testTeachesCourses::Ensure you are correctly counting how often a teacher teachers a given course.",
                    1, sampleTeacher.teachesCourse(courses[0]));

            //Add other teachers to multiple courses. Put Teacher in the middle again somewhere
            for (int i = 0; i < sampleTeacherIndex; i++) {
                courses[i % courses.length].addTeacher(teachers[i]);
            }
            courses[0].addTeacher(sampleTeacher);
            for (int i = sampleTeacherIndex + 1; i < teachers.length; i++) {
                courses[i % courses.length].addTeacher(teachers[i]);
            }

            //Verify teachesCourses for two courses (one teaching, the other not)
            assertEquals("testTeachesCourses::Ensure you are correctly counting how often a teacher teachers a given course.",
                    2, sampleTeacher.teachesCourse(courses[0]));
            assertEquals("testTeachesCourses::Ensure you are correctly counting how often a teacher teachers a given course.",
                    0, sampleTeacher.teachesCourse(courses[1]));


            //Remove teacher from a Course
            courses[0].dropTeacher(sampleTeacher);
            courses[0].dropTeacher(sampleTeacher);
            assertEquals("testTeachesCourses::Ensure you are correctly counting how often a teacher teachers a given course.",
                    0, sampleTeacher.teachesCourse(courses[0]));

            //Verify teachesCourses when Course is null
            assertEquals("testTeachesCourses::Ensure you are correctly counting how often a teacher teachers a given course.",
                    0, sampleTeacher.teachesCourse(null));
        } catch (AssertionError e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testTeachesCourses::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100)
    //@ScoringWeight(0.050)
    public void testTeachersCoursesArrayDoublesAtCapacity() throws Exception {
        try {
            //Create a Teacher, get capacity, and create capacity number of Courses + 1
            String teacherName     = NAMES[30];
            int teacherAge         = 20;
            String teacherGender   = "Unspecified";
            Teacher teacher        = new Teacher(teacherName,teacherAge,teacherGender);
            Professor[] professors = createProfessors(teacher.getCourses().length + 1);
            Course[] courses       = createCourses(professors, 5);

            //Add Courses to teacher, get new capacity
            int expectedCapacity = teacher.getCourses().length * 2;
            for (Course c: courses) {
                c.addTeacher(teacher);
            }

            //Verify capacity doubled
            assertEquals("testTeachersCoursesArrayDoublesAtCapacity::Ensure you are doubling the size of the Teacher's course array when if fills up.",
                    expectedCapacity, teacher.getCourses().length);
        } catch (AssertionError e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testTeachersCoursesArrayDoublesAtCapacity::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100)
    //@ScoringWeight(0.050)
    public void testProfessorUpdatedWhenAddedToCourse() throws Exception {
        try {
            //Create a Professor
            String professorName   = NAMES[2];
            int professorAge       = 45;
            String professorGender = "Unspecified";
            Professor professor    = new Professor(professorName,professorAge,professorGender);

            //Create a Course with this Professor
            Course course = new Course(DEPARTMENT_CODES[1] + "15000", professor);

            //Verify Professor object references the Course
            boolean courseFound = false;
            for (Course c: professor.getCourses()) {
                if (c == null) continue;
                if (c.getName().equals(course.getName())) {
                    courseFound = true;
                    break;
                }
            }
            assertTrue("testProfessorUpdatedWhenAddedToCourse::Ensure the Professor is updated when a Course is created with them.",
                    courseFound);
        } catch (AssertionError e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testProfessorUpdatedWhenAddedToCourse::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }


    /**************************************************************************************************
     *
     * Course (30%)
     */
    @Test(timeout = 100, expected = AddToCourseException.class)
    //@ScoringWeight(0.025)
    public void testAddStudentToFullCourse() throws AddToCourseException {
        try {
            String professorName = NAMES[20];
            int professorAge = 20;
            String professorGender = "Unspecified";
            Professor courseProfessor = new Professor(professorName, professorAge, professorGender);

            String courseName = DEPARTMENT_CODES[5] + "40000";
            Course testCourse = new Course(courseName, courseProfessor);

            for (int i = 0; i <= Course.MAX_STUDENTS; i++) {
                String name = NAMES[(i +2) % NAMES.length];
                int age = 32;
                String gender = "Unspecified";
                testCourse.addStudent(new Student(name, age, gender));
            }
            fail("testAddStudentToFullCourse::An exception should be thrown when adding a student to a course twice");
        } catch (AddToCourseException e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testAddStudentToFullCourse::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100, expected = AddToCourseException.class)
    //@ScoringWeight(0.025)
    public void testAddStudentTwiceToCourse() throws AddToCourseException {
        try {
            String professorName = NAMES[80];
            int professorAge = 80;
            String professorGender = "Unspecified";
            Professor courseProfessor = new Professor(professorName, professorAge, professorGender);

            String courseName = DEPARTMENT_CODES[3] + "11111";
            Course testCourse = new Course(courseName, courseProfessor);

            String name = NAMES[6];
            int age = 25;
            String gender = "Unspecified";
            Student courseStudent = new Student(name, age, gender);

            testCourse.addStudent(courseStudent);
            for (int i = 0; i <= 50; i++) {
                name = NAMES[(i + 4) % NAMES.length];
                age = 28;
                gender = "Unspecified";
                if (i == 35) {
                    testCourse.addStudent(courseStudent);
                }
                testCourse.addStudent(new Student(name, age, gender));
            }
            fail("testAddStudentTwiceToCourse::An exception should be thrown when adding a student to a course twice");
        } catch (AddToCourseException e) {
            throw e;
        } catch (AssertionError e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testAddStudentTwiceToCourse::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100, expected = AddToCourseException.class)
    //@ScoringWeight(0.025)
    public void testAddNullStudentToCourse() throws AddToCourseException {
        try {
            String professorName = NAMES[55];
            int professorAge = 55;
            String professorGender = "Unspecified";
            Professor courseProfessor = new Professor(professorName, professorAge, professorGender);

            String courseName = DEPARTMENT_CODES[0] + "25100";
            Course testCourse = new Course(courseName, courseProfessor);

            Student courseStudent = null;

            for (int i = 9; i <= 50; i++) {
                String name   = NAMES[(i - 4) % NAMES.length];
                int age       = 23;
                String gender = "Unspecified";
                testCourse.addStudent(new Student(name, age, gender));
            }
            testCourse.addStudent(courseStudent);
            fail("testAddNullStudentToCourse::An exception should be thrown when student is null");
        } catch (AssertionError e) {
            throw e;
        } catch (AddToCourseException e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testAddNullStudentToCourse::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100, expected = DropFromCourseException.class)
    //@ScoringWeight(0.025)
    public void testRemoveStudentNotInCourse() throws Exception {
        try {
            String professorName = NAMES[75];
            int professorAge = 85;
            String professorGender = "Unspecified";
            Professor courseProfessor = new Professor(professorName, professorAge, professorGender);

            String courseName = DEPARTMENT_CODES[0] + "25100";
            Course testCourse = new Course(courseName, courseProfessor);

            String name   = NAMES[9];
            int age       = 77;
            String gender = "Female";
            Student courseStudent = new Student(name, age, gender);

            for (int i = 9; i <= 50; i++) {
                name   = NAMES[(i + 7) % NAMES.length];
                age    = 23;
                gender = "Unspecified";
                testCourse.addStudent(new Student(name, age, gender));
            }
            testCourse.dropStudent(courseStudent);
            fail("testRemoveStudentNotInCourse::An exception should be thrown when trying to remove a student not in the course");
        } catch (AssertionError e) {
            throw e;
        } catch (DropFromCourseException e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testRemoveStudentNotInCourse::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100, expected = DropFromCourseException.class)
    //@ScoringWeight(0.025)
    public void testRemoveNullStudentFromCourse() throws Exception {
        try {
            String professorName = NAMES[60];
            int professorAge = 8;
            String professorGender = "Unspecified";
            Professor courseProfessor = new Professor(professorName, professorAge, professorGender);

            String courseName = DEPARTMENT_CODES[1] + "86753";
            Course testCourse = new Course(courseName, courseProfessor);

            for (int i = 9; i <= 50; i++) {
                String name   = NAMES[i - 2];
                int age       = 23;
                String gender = "Unspecified";
                testCourse.addStudent(new Student(name, age, gender));
            }
            testCourse.dropStudent(null);
            fail("testRemoveNullStudentFromCourse::An exception should be thrown when trying to remove a null student from the course");
        } catch (AssertionError e) {
            throw e;
        } catch (DropFromCourseException e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testRemoveNullStudentFromCourse::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100)
    //@ScoringWeight(0.025)
    public void testAddTeacherToCourseMultipleTimes() throws Exception {
        try {
            Course testCourse  = createCourse(50);
            Teacher[] teachers = createTeachers(9);
            Teacher duplicate  = teachers[2];

            for (Teacher t: teachers) {
                testCourse.addTeacher(t);
            }
            testCourse.addTeacher(duplicate);

            int instancesExpected = 2;
            int instancesActual = 0;
            for (Teacher t: testCourse.getTeachers()) {
                if (t == null) continue;
                if (t.getID() == duplicate.getID()) instancesActual++;
            }

            assertEquals("testAddTeacherToCourseMultipleTimes::Teachers should be able to be added to a course multiple times.",
                    instancesExpected, instancesActual);

            instancesExpected = 2;
            instancesActual = 0;
            for (Course c: duplicate.getCourses()) {
                if (c == null) continue;
                if (c.getName().equals(testCourse.getName())) instancesActual++;
            }
            assertEquals("testAddTeacherToCourseMultipleTimes::Courses should be able to be added to a Teacher's array of courses multiple times.",
                    instancesExpected, instancesActual);

        } catch (AssertionError e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testAddTeacherToCourseMultipleTimes::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100, expected = AddToCourseException.class)
    //@ScoringWeight(0.025)
    public void testAddNullTeacherToCourse() throws Exception {
        try {
            String professorName = NAMES[55];
            int professorAge = 100;
            String professorGender = "Unspecified";
            Professor courseProfessor = new Professor(professorName, professorAge, professorGender);

            String courseName = DEPARTMENT_CODES[4] + "12345";
            Course testCourse = new Course(courseName, courseProfessor);

            Teacher courseTeacher = null;

            for (int i = 9; i <= 50; i++) {
                String name   = NAMES[(i + 8) % NAMES.length];
                int age       = 23;
                String gender = "Unspecified";
                testCourse.addTeacher(new Teacher(name, age, gender));
            }
            testCourse.addTeacher(courseTeacher);
            fail("testAddNullTeacherToCourse::An exception should be thrown when teacher is null");
        } catch (AssertionError e) {
            throw e;
        } catch (AddToCourseException e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testAddNullTeacherToCourse::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100)
    //@ScoringWeight(0.025)
    public void testAddTeacherToFullCourse() throws Exception {
        try {
            String professorName = NAMES[66];
            int professorAge = 900;
            String professorGender = "Unspecified";
            Professor courseProfessor = new Professor(professorName, professorAge, professorGender);

            String courseName = DEPARTMENT_CODES[2] + "54321";
            Course testCourse = new Course(courseName, courseProfessor);

            int initialLength = testCourse.getTeachers().length;
            for (int i = 0; i < initialLength; i++) {
                String name = NAMES[(i + 4) % NAMES.length];
                int age = 80;
                String gender = "Unspecified";
                testCourse.addTeacher(new Teacher(name, age, gender));
            }
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testAddTeacherToFullCourse::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100, expected = DropFromCourseException.class)
    //@ScoringWeight(0.025)
    public void testRemoveTeacherNotInCourse() throws Exception {
        try {
            String professorName = NAMES[8];
            int professorAge = 88;
            String professorGender = "Unspecified";
            Professor courseProfessor = new Professor(professorName, professorAge, professorGender);

            String courseName = DEPARTMENT_CODES[2] + "25110";
            Course testCourse = new Course(courseName, courseProfessor);

            String name   = NAMES[5];
            int age       = 56;
            String gender = "Female";
            Teacher courseTeacher = new Teacher(name, age, gender);

            for (int i = 9; i <= 50; i++) {
                name   = NAMES[i - 7];
                age    = 23;
                gender = "Unspecified";
                testCourse.addTeacher(new Teacher(name, age, gender));
            }
            testCourse.dropTeacher(courseTeacher);
            fail("testRemoveTeacherNotInCourse::An exception should be thrown when trying to remove a teacher not in the course");
        } catch (AssertionError e) {
            throw e;
        } catch (DropFromCourseException e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testRemoveTeacherNotInCourse::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100, expected = DropFromCourseException.class)
    //@ScoringWeight(0.025)
    public void testRemoveNullTeacherFromCourse() throws Exception {
        try {
            String professorName = NAMES[9];
            int professorAge = 1000;
            String professorGender = "Unspecified";
            Professor courseProfessor = new Professor(professorName, professorAge, professorGender);

            String courseName = DEPARTMENT_CODES[3] + "11110";
            Course testCourse = new Course(courseName, courseProfessor);

            for (int i = 9; i <= 50; i++) {
                String name   = NAMES[i + 1];
                int age       = 23;
                String gender = "Unspecified";
                testCourse.addTeacher(new Teacher(name, age, gender));
            }
            testCourse.dropTeacher(null);
            fail("testRemoveNullTeacherFromCourse::An exception should be thrown when trying to remove a null teacher from the course");
        } catch (AssertionError e) {
            throw e;
        } catch (DropFromCourseException e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testRemoveNullTeacherFromCourse::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100)
    //@ScoringWeight(0.025)
    public void testProfessorsUpdatedWhenChangingCourseProfessor() throws Exception {
        try {
            //Create two professors
            String professor1Name   = NAMES[5];
            int professor1Age       = 12;
            String professor1Gender = "Unspecified";
            Professor professor1    = new Professor(professor1Name,professor1Age,professor1Gender);

            String professor2Name   = NAMES[90];
            int professor2Age       = 3;
            String professor2Gender = "Unspecified";
            Professor professor2    = new Professor(professor2Name,professor2Age,professor2Gender);

            //Create a course with one Professor
            Course course = new Course(DEPARTMENT_CODES[2] + "11100", professor1);

            //Update course with a different Professor
            course.changeProfessor(professor2);

            //Verify original Professor no longer references the Course, new Professor references the Course
            for (Course c: professor1.getCourses()) {
                if (c == null) continue;
                assertFalse("testProfessorsUpdatedWhenChangingCourseProfessor::Ensure the Course is removed from the old professor when changing that course's professors.",
                        c.getName().equals(course.getName()));
            }

            boolean courseFound = false;
            for (Course c: professor2.getCourses()) {
                if (c == null) continue;
                if (c.getName().equals(course.getName())) {
                    courseFound = true;
                    break;
                }
            }
            assertTrue("testProfessorsUpdatedWhenChangingCourseProfessor::Ensure the Course is added to the new professor when changing that course's professors.",
                    courseFound);

        } catch (AssertionError e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testProfessorsUpdatedWhenChangingCourseProfessor::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100)
    //@ScoringWeight(0.025)
    public void testStudentRosterForACourse() throws Exception{
        try {
            //Create a Course and an array of Students
            String professorName   = NAMES[10];
            int professorAge       = 667;
            String professorGender = "Unspecified";
            Professor professor    = new Professor(professorName,professorAge,professorGender);
            Course course          = new Course(DEPARTMENT_CODES[2] + "90999", professor);
            Student[] students     = createStudents(19);

            //Add and remove some Students from the Course
            int dropRangeFrom = 4;  //inclusive
            int dropRangeTo   = 9;  //exclusive
            for (int i = 0; i < students.length; i++) {
                course.addStudent(students[i]);
            }
            for (int i = dropRangeFrom; i < dropRangeTo; i++) {
                course.dropStudent(students[i]);
            }

            //Get the student roster
            Student[] roster = course.getRoster();

            //Verify roster has no null values, contains each Student, no dropped students, and does not reference the original array
            for (int i = 0; i < students.length; i++) {
                for (Student rosterStudent: roster) {
                    assertFalse("testStudentRosterForACourse::Ensure no null values are present in a Course student roster.",
                            rosterStudent == null);
                }
                if (i >= dropRangeFrom && i < dropRangeTo) {
                    assertTrue("testStudentRosterForACourse::Ensure dropped students are not included in the roster.",
                            countInstances(students[i], roster) == 0);
                } else {
                    assertTrue("testStudentRosterForACourse::Ensure students still enrolled in the course are included in the roster.",
                            countInstances(students[i], roster) == 1);
                }
            }


        } catch (AssertionError e) {
            throw e;
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("testStudentRosterForACourse::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }

    /**************************************************************************************************
     *
     * College (30%)
     */
    @Test(timeout = 100)
    //@ScoringWeight(0.02727)
    public void testCollegeConstructorsAndGetters() throws Exception {
        try {
            //Create a college
            String expectedCollegeName     = "School for People Who Use Binary";
            int expectedCollegeTuition     = 100001;
            int expectedCoursesLength      = College.MAX_COURSES;
            int expectedTeachersLength     = College.MAX_TEACHERS;
            int expectedStudentsLength     = College.MAX_STUDENTS;
            int expectedProfessorsLength   = College.MAX_PROFESSORS;
            College college = new College(expectedCollegeName, expectedCollegeTuition);

            //Confirm fields were initialized properly using getters
            assertEquals("testCollegeConstructorsAndGetters::The College's name was not initialized correctly or getter is incorrect.",
                    expectedCollegeName, college.getName());
            assertEquals("testCollegeConstructorsAndGetters::The College's tuition was not initialized correctly or getter is incorrect.",
                    expectedCollegeTuition, college.getTuition());
            assertEquals("testCollegeConstructorsAndGetters::The College's Course array was not initialized correctly or getter is incorrect.",
                    expectedCoursesLength, college.getCourses().length);
            assertEquals("testCollegeConstructorsAndGetters::The College's Teacher array was not initialized correctly or getter is incorrect.",
                    expectedTeachersLength, college.getTeachers().length);
            assertEquals("testCollegeConstructorsAndGetters::The College's Student array was not initialized correctly or getter is incorrect.",
                    expectedStudentsLength, college.getStudents().length);
            assertEquals("testCollegeConstructorsAndGetters::The College's Professor array was not initialized correctly or getter is incorrect.",
                    expectedProfessorsLength, college.getProfessors().length);
        } catch (AssertionError e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testCollegeConstructorsAndGetters::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100)
    //@ScoringWeight(0.02727)
    public void testAddCourseToCollege() throws Exception {
        try {
            //Create a College
            String collegeName = "Dunsmore U";
            int collegeTuition = 500;
            College college    = new College(collegeName, collegeTuition);

            //Create Professors; Add to College
            Professor[] professors = createProfessors(3);

            //Generate arrays of courses, create expected Course configuration
            Course[] courses1 = createCourses(professors, 0);  //Add all courses
            Course[] courses2 = createCourses(professors, 1);  //Add all courses
            Course[] courses3 = createCourses(professors, 2);  //Add all courses
            Course[] courses4 = createCourses(professors, 3);  //Add all courses (should fail to add last two)

            //Add courses
            for (Course c: courses1) {
                college.addCourse(c);
            }
            for (Course c: courses2) {
                college.addCourse(c);
            }
            for (Course c: courses3) {
                college.addCourse(c);
            }
            for (Course c: courses4) {
                college.addCourse(c);
            }

            //Verify courses
            for (Course searchFor: courses1) {
                boolean foundCourse = false;
                for (Course checkIf: college.getCourses()) {
                    if (checkIf == null) continue;
                    if (searchFor.getName().equals(checkIf.getName())) {
                        foundCourse = true;
                        break;
                    }
                }
                assertTrue("testAddCourseToCollege::Course added to College not found in College's Course array.", foundCourse);
            }
            for (Course searchFor: courses2) {
                boolean foundCourse = false;
                for (Course checkIf: college.getCourses()) {
                    if (checkIf == null) continue;
                    if (searchFor.getName().equals(checkIf.getName())) {
                        foundCourse = true;
                        break;
                    }
                }
                assertTrue("testAddCourseToCollege::Course added to College not found in College's Course array.", foundCourse);
            }
            for (Course searchFor: courses3) {
                boolean foundCourse = false;
                for (Course checkIf: college.getCourses()) {
                    if (checkIf == null) continue;
                    if (searchFor.getName().equals(checkIf.getName())) {
                        foundCourse = true;
                        break;
                    }
                }
                assertTrue("testAddCourseToCollege::Course added to College not found in College's Course array.", foundCourse);
            }
            for (int i = 0; i < courses4.length; i++) {
                boolean foundCourse = false;
                for (Course checkIf: college.getCourses()) {
                    if (checkIf == null) continue;
                    if (courses4[i].getName().equals(checkIf.getName())) {
                        foundCourse = true;
                        break;
                    }
                }
                if(i == 0) {
                    assertTrue("testAddCourseToCollege::Course added to College not found in College's Course array.", foundCourse);
                } else {
                    assertFalse("testAddCourseToCollege::Course added to College despite College being at capacity.", foundCourse);
                }
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testAddCourseToCollege::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100)
    //@ScoringWeight(0.02727)
    public void testAddCourseToCollegeAtCapacity() throws Exception {
        try {
            String collegeName = "Monsters Academy";
            int collegeTuition = 900;
            College college = new College(collegeName,collegeTuition);

            for (int i = 0; i <= College.MAX_COURSES; i++) {
                String dept       = DEPARTMENT_CODES[i % DEPARTMENT_CODES.length];
                String courseNum  = Integer.toString(i * 100 + 11000);
                String courseName = dept + " " + courseNum;
                int numStudents   = i % Course.MAX_STUDENTS;
                college.addCourse(createCourse(numStudents, courseName));
            }
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("testAddCourseToCollegeAtCapacity::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100)
    //@ScoringWeight(0.02727)
    public void testAddDuplicateCourseToCollege() throws Exception {
        try {
            //Create a college
            String collegeName = "Norhall";
            int collegeTuition = 7;
            College college = new College(collegeName, collegeTuition);

            //Populate college with courses, select duplicate and add again
            Course duplicateCourse = null;
            for (int i = 0; i < College.MAX_COURSES - 1; i++) {
                String dept       = DEPARTMENT_CODES[i % DEPARTMENT_CODES.length];
                String courseNum  = Integer.toString(i * 100 + 5000);
                String courseName = dept + " " + courseNum;
                int numStudents   = i % Course.MAX_STUDENTS;
                if (i == 1) {
                    duplicateCourse = createCourse(numStudents, courseName);
                    college.addCourse(duplicateCourse);
                } else {
                    college.addCourse(createCourse(numStudents, courseName));
                }

            }
            college.addCourse(new Course(duplicateCourse.getName(),duplicateCourse.getProfessor()));

            //Count instances of the duplicate
            int instancesExpected = 1;
            int instancesActual   = 0;
            for (Course c: college.getCourses()) {
                if (c == null) continue;
                if (c.getName().equals(duplicateCourse.getName())) instancesActual++;
            }

            assertEquals("testAddDuplicateCourseToCollege::A course should not be able to be added to a College multiple times.",
                    instancesExpected, instancesActual);
        } catch (AssertionError e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testAddDuplicateCourseToCollege::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100)
    //@ScoringWeight(0.02727)
    public void testAddFacultyToCollege() throws Exception {
        try {
            //Create a College
            String collegeName = "Anime High School";
            int collegeTuition = 8;
            College college    = new College(collegeName, collegeTuition);

            //Create arrays of Teachers and Professors
            Professor[] professors = createProfessors(3);
            Teacher[] teachers     = createTeachers(6);

            //Add faculty to college
            for (Professor p: professors) {
                college.hireProfessor(p);
            }
            for (Teacher t: teachers) {
                college.hireTeacher(t);
            }

            //Confirm selected faculty are added to college
            for (Professor searchFor: professors) {
                boolean professorFound = false;
                for (Professor checkIf: college.getProfessors()) {
                    if (checkIf == null) continue;
                    if(searchFor.getID() == checkIf.getID()) {
                        professorFound = true;
                        break;
                    }
                }
                assertTrue("testAddFacultyToCollege::Ensure Professors are being added correctly to Colleges.",
                        professorFound);
            }

            for (Teacher searchFor: teachers) {
                boolean teacherFound = false;
                for (Teacher checkIf: college.getTeachers()) {
                    if (checkIf == null) continue;
                    if(searchFor.getID() == checkIf.getID()) {
                        teacherFound = true;
                        break;
                    }
                }
                assertTrue("testAddFacultyToCollege::Ensure Teachers are being added correctly to Colleges.",
                        teacherFound);
            }

        } catch (AssertionError e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testAddFacultyToCollege::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100)
    //@ScoringWeight(0.02727)
    public void testAddFacultyWhenCollegeAtCapacity() throws Exception {
        try {
            //Create a College
            String collegeName = "Ball So Hard State";
            int collegeTuition = 500;
            College college    = new College(collegeName, collegeTuition);

            //Create arrays of Professors and Teachers
            Professor[] professors = createProfessors(College.MAX_PROFESSORS + 1);
            Teacher[] teachers     = createTeachers(College.MAX_TEACHERS + 1);

            //Add Professors and Teachers to College beyond capacity
            for (Professor p: professors) {
                college.hireProfessor(p);
            }
            for (Teacher t: teachers) {
                college.hireTeacher(t);
            }

            //Verify only the first MAX_ Teachers and Professors are hired
            for (int i = 0; i < teachers.length; i++) {
                boolean teacherFound = false;
                for (Teacher t : college.getTeachers()) {
                    if (t == null) continue;
                    if (teachers[i].getID() == t.getID()) {
                        teacherFound = true;
                        break;
                    }
                }
                if (i == teachers.length - 1) {
                    assertFalse("testAddFacultyWhenCollegeAtCapacity::Teacher added when College at capacity.", teacherFound);
                } else {
                    assertTrue("testAddFacultyWhenCollegeAtCapacity::Teachers not found when hired by College.", teacherFound);
                }
            }

            for (int i = 0; i < professors.length; i++) {
                boolean professorFound = false;
                for (Professor p : college.getProfessors()) {
                    if (p == null) continue;
                    if (professors[i].getID() == p.getID()) {
                        professorFound = true;
                        break;
                    }
                }
                if (i == professors.length - 1) {
                    assertFalse("testAddFacultyWhenCollegeAtCapacity::Teacher added when College at capacity.", professorFound);
                } else {
                    assertTrue("testAddFacultyWhenCollegeAtCapacity::Teachers not found when hired by College.", professorFound);
                }
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testAddFacultyWhenCollegeAtCapacity::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100)
    //@ScoringWeight(0.02727)
    public void testAddDuplicateFacultyToCollege() throws Exception {
        try {
            //Create a College
            String collegeName = "Kitten Academy";
            int collegeTuition = 3;
            College college    = new College(collegeName, collegeTuition);

            //Create arrays of Teachers and Professors
            Professor[] professors = createProfessors(4);
            Teacher[] teachers     = createTeachers(4);

            //Add Teachers and Professors to College, pick a duplicate
            Professor duplicateProfessor = professors[2];
            for (int i = 0; i < professors.length; i++) {
                college.hireProfessor(professors[i]);
            }

            Teacher duplicateTeacher = teachers[1];
            for (int i = 0; i < professors.length; i++) {
                college.hireTeacher(teachers[i]);
            }

            //Attempt to hire the duplicates
            college.hireProfessor(duplicateProfessor);
            college.hireTeacher(duplicateTeacher);


            //Seek the duplicate for both arrays
            int instancesExpected = 1;
            int instancesActual = 0;
            for (int i = 0; i < professors.length; i++) {
                if (professors[i].getID() == duplicateProfessor.getID()) instancesActual++;
            }
            assertEquals("testAddDuplicateFacultyToCollege::Professors should be added to a College once at most.",
                    instancesExpected, instancesActual);

            instancesExpected = 1;
            instancesActual = 0;
            for (int i = 0; i < teachers.length; i++) {
                if (teachers[i].getID() == duplicateTeacher.getID()) instancesActual++;
            }
            assertEquals("testAddDuplicateFacultyToCollege::Teachers should be added to a College once at most.",
                    instancesExpected, instancesActual);

        } catch (AssertionError e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testAddDuplicateFacultyToCollege::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100)
    //@ScoringWeight(0.02727)
    public void testDropStudentWithCoursesFromCollege() throws Exception {
        try {
            //Create a College
            String collegeName = "College State";
            int collegeTuition = 1234;

            //Create College and assets
            Professor[] professors = createProfessors(4);
            Teacher[] teachers     = createTeachers(10);
            Course[] courses       = createCourses(professors, 4);
            Student[] students     = createStudents(45);
            College college        = createCollege(collegeName,collegeTuition,courses,professors,students, teachers);

            //Select Student to drop by index
            int dropStudentIndex = 12;
            Student dropStudent  = students[dropStudentIndex];

            //Enroll students in Courses, placing special Student in the middle somewhere
            for (int i = 0; i < students.length; i++) {
                courses[i % courses.length].addStudent(students[i]);
            }
            for (int i = 0; i < students.length; i++) {
                courses[(i + 1) % courses.length].addStudent(students[i]);
            }

            //Get roster copies for courses
            Student[][] courseRosters = new Student[4][];
            int rosterNum = 0;
            for (Course c: courses) {
                courseRosters[rosterNum++] = c.getRoster();
            }

            //Drop Student from College
            college.dropStudent(dropStudent);

            //Iterate through Courses to confirm Student dropped
            for (Course c: courses) {
                assertTrue("testDropStudentWithCoursesFromCollege::Make sure students dropped from their college are dropped from their courses.",
                        countInstances(dropStudent, c.getRoster()) == 0);
            }

            //Iterate through Courses to confirm that the values weren't just made null.
            for (int i = 0; i < 4; i++) {
                for(Student searchFor: courseRosters[i]) {
                    if (searchFor == null) continue;
                    if (searchFor.getID() == dropStudent.getID()) continue;
                    assertTrue("testDropStudentWithCoursesFromCollege::Make sure students stay in their courses when others are dropped from college.",
                            countInstances(searchFor, courses[i].getRoster()) == 1);
                }
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testDropStudentWithCoursesFromCollege::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100)
    //@ScoringWeight(0.02727)
    public void testDropNullStudentFromCollege() throws Exception {
        try {
            //Create a College
            String collegeName = "Hard Knocks";
            int collegeTuition = 0;
            College college    = new College(collegeName, collegeTuition);

            //Create array of Students
            Student[] students = createStudents(40);

            //Add Students to College
            for (Student s: students) {
                college.addStudent(s);
            }

            //Attempt to drop null from College
            college.dropStudent(null);

            //Verify Students are still in college
            for (Student s: students) {
                assertTrue("Verify college's student array is not changed if a null Student is dropped",
                        countInstances(s,college.getStudents()) == 1);
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testDropNullStudentFromCollege::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100)
    //@ScoringWeight(0.02727)
    public void testDropStudentNotEnrolledInCollege() throws Exception {
        try {
            //Create a College
            String collegeName = "Hard Knocks";
            int collegeTuition = 0;
            College college    = new College(collegeName, collegeTuition);

            //Create array of Students
            Student[] students = createStudents(49);

            //Add Students to College
            for (Student s: students) {
                college.addStudent(s);
            }

            //Create and attempt to drop student not in college
            String notEnrolledName   = NAMES[80];
            int notEnrolledAge       = 80;
            String notEnrolledGender = "Unspecified";
            Student notEnrolled      = new Student(notEnrolledName,notEnrolledAge,notEnrolledGender);
            college.dropStudent(notEnrolled);

            //Verify Students are still in college
            for (Student s: students) {
                assertTrue("testDropStudentNotEnrolledInCollege::Verify college's student array is not changed if an non-enrolled Student is dropped",
                        countInstances(s,college.getStudents()) == 1);
            }
        } catch (AssertionError e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testDropStudentNotEnrolledInCollege::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }

    @Test(timeout = 100)
    //@ScoringWeight(0.02727)
    public void testCalculateBudgetChange() throws Exception {
        try {
            //Create a College object, an array of Students, an array of Courses, and two Teachers and two Professors with intentional salaries
            String collegeName = "Top Dolla U";
            int collegeTuition = 1;
            College college    = new College(collegeName, collegeTuition);

            String student1Name   = NAMES[67];
            int student1Age       = 18;
            String student1Gender = "Unspecified";
            Student student1      = new Student(student1Name, student1Age, student1Gender);

            String student2Name   = NAMES[47];
            int student2Age       = 27;
            String student2Gender = "Unspecified";
            Student student2      = new Student(student2Name, student2Age, student2Gender);

            String professor1Name   = NAMES[30];
            int professor1Age       = 78;
            String professor1Gender = "Unspecified";
            int professor1BaseSal   = 2;
            int professor1PerCSal   = 3;
            Professor professor1    = new Professor(professor1Name,professor1Age,professor1Gender,professor1BaseSal,professor1PerCSal);

            String professor2Name   = NAMES[31];
            int professor2Age       = 97;
            String professor2Gender = "Unspecified";
            int professor2BaseSal   = 600;
            int professor2PerCSal   = 500;
            Professor professor2    = new Professor(professor2Name,professor2Age,professor2Gender,professor2BaseSal,professor2PerCSal);

            String teacher1Name   = NAMES[32];
            int teacher1Age       = 100;
            String teacher1Gender = "Unspecified";
            int teacher1BaseSal   = 7;
            int teacher1PerCSal   = 8;
            Teacher teacher1    = new Teacher(teacher1Name,teacher1Age,teacher1Gender,teacher1BaseSal,teacher1PerCSal);

            String teacher2Name   = NAMES[35];
            int teacher2Age       = 32;
            String teacher2Gender = "Unspecified";
            int teacher2BaseSal   = 9;
            int teacher2PerCSal   = 9;
            Teacher teacher2    = new Teacher(teacher2Name,teacher2Age,teacher2Gender,teacher2BaseSal,teacher2PerCSal);

            String course1Name = DEPARTMENT_CODES[4] + "18000";
            String course2Name = DEPARTMENT_CODES[3] + "18100";

            //Assert equal budget change with no students/faculty
            int expectedNoPersons = 0;
            assertEquals("testCalculateBudgetChange::Ensure you are considering the number of People, salaries, and Courses being taught in your budget calculations.",
                    expectedNoPersons, college.calculateNetBudgetChange());

            //Add a student, assert equal budget change
            college.addStudent(student1);
            int expected1Student = collegeTuition;
            assertEquals("testCalculateBudgetChange::Ensure you are considering the number of People, salaries, and Courses being taught in your budget calculations.",
                    expected1Student, college.calculateNetBudgetChange());

            //Add a teacher, assert equal budget change
            college.hireTeacher(teacher1);
            int expected1Student1Teacher = collegeTuition - teacher1BaseSal;
            assertEquals("testCalculateBudgetChange::Ensure you are considering the number of People, salaries, and Courses being taught in your budget calculations.",
                    expected1Student1Teacher, college.calculateNetBudgetChange());

            //Add a professor, assert equal budget change
            college.hireProfessor(professor1);
            int expected1Student1Teacher1Professor = collegeTuition - teacher1BaseSal - professor1BaseSal;
            assertEquals("testCalculateBudgetChange::Ensure you are considering the number of People, salaries, and Courses being taught in your budget calculations.",
                    expected1Student1Teacher1Professor, college.calculateNetBudgetChange());

            //Add teacher, assert equal budget change
            college.hireTeacher(teacher2);
            int expected1Student2Teacher1Professor = collegeTuition - teacher1BaseSal - teacher2BaseSal - professor1BaseSal;
            assertEquals("testCalculateBudgetChange::Ensure you are considering the number of People, salaries, and Courses being taught in your budget calculations.",
                    expected1Student2Teacher1Professor, college.calculateNetBudgetChange());

            //Add a professor, assert equal budget change
            college.hireProfessor(professor2);
            int expected1Student2Teacher2Professor = collegeTuition - teacher1BaseSal - teacher2BaseSal - professor1BaseSal - professor2BaseSal;
            assertEquals("testCalculateBudgetChange::Ensure you are considering the number of People, salaries, and Courses being taught in your budget calculations.",
                    expected1Student2Teacher2Professor, college.calculateNetBudgetChange());

            //Add another student, assign each professor and teachers to Courses, assert equal budget change
            Course course1 = new Course(course1Name, professor1);
            Course course2 = new Course(course2Name, professor2);
            course1.addTeacher(teacher1);
            course2.addTeacher(teacher1);
            course1.addTeacher(teacher2);
            college.addStudent(student2);
            int expectedFinalBudgetChange = collegeTuition * 2 - (teacher1BaseSal + teacher2BaseSal + professor1BaseSal + professor2BaseSal + teacher1PerCSal * 2 + teacher2PerCSal + professor1PerCSal + professor2PerCSal);
            assertEquals("testCalculateBudgetChange::Ensure you are considering the number of People, salaries, and Courses being taught in your budget calculations.",
                    expectedFinalBudgetChange, college.calculateNetBudgetChange());
        } catch (AssertionError e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace;
            System.out.println("testCalculateBudgetChange::An unexpected (incorrect) exception occurred (see stack trace).");
            throw e;
        }
    }





    /***************************
     *
     *     Utility Methods
     *
     ***************************/


    /*
     * Create a sample Course with passed number of Students
     */
    private static Course createCourse(int numberOfStudents) throws AddToCourseException{
        if (numberOfStudents > Course.MAX_STUDENTS) numberOfStudents = Course.MAX_STUDENTS;

        String professorName   = NAMES[numberOfStudents];
        int professorAge       = numberOfStudents;
        String professorGender = "Unspecified";
        Professor courseProfessor = new Professor(professorName, professorAge, professorGender);

        Course course = new Course(DEPARTMENT_CODES[numberOfStudents % DEPARTMENT_CODES.length], courseProfessor);
        for (int i = 0; i < numberOfStudents; i++) {
            String name = NAMES[Math.abs((i - 6) % NAMES.length)];
            int age = 23;
            String gender = "Unspecified";
            course.addStudent(new Student(name, age, gender));
        }
        return course;
    }

    /*
     * Create sample Courses with each Professors teaching one of the courses. Department code offset because name clashing.
     */
    private static Course[] createCourses(Professor[] professors, int codeOffset) throws AddToCourseException{
        Course[] courses = new Course[professors.length];
        for (int i = 0; i < professors.length; i++) {
            courses[i] = new Course(DEPARTMENT_CODES[(i + codeOffset) % DEPARTMENT_CODES.length] + Integer.toString(10000 + i), professors[i]);
        }

        return courses;
    }

    /*
     * Create a sample Course with passed number of Students and course name
     */
    private static Course createCourse(int numberOfStudents, String courseName) throws AddToCourseException{
        if (numberOfStudents > Course.MAX_STUDENTS) numberOfStudents = Course.MAX_STUDENTS;

        String professorName   = NAMES[numberOfStudents];
        int professorAge       = numberOfStudents;
        String professorGender = "Unspecified";
        Professor courseProfessor = new Professor(professorName, professorAge, professorGender);

        Course course = new Course(courseName, courseProfessor);
        for (int i = 0; i < numberOfStudents; i++) {
            String name = NAMES[Math.abs((i - 6) % NAMES.length)];
            int age = 23;
            String gender = "Unspecified";
            course.addStudent(new Student(name, age, gender));
        }
        return course;
    }

    /*
     * Create an array with the specified number of students
     */
    private static Student[] createStudents(int numberOfStudents) {
        Student[] students = new Student[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            String name = NAMES[Math.abs((numberOfStudents * 2) % NAMES.length)];
            int age = 20 + Math.abs((numberOfStudents * 2) % 10);
            String gender = "Unspecified";
            students[i] = new Student(name, age, gender);
        }
        return students;
    }

    /*
     * Create an array with the specified number of Professors
     */
    private static Professor[] createProfessors(int numberOfProfessors) {
        Professor[] professors = new Professor[numberOfProfessors];
        for (int i = 0; i < numberOfProfessors; i++) {
            String name = NAMES[Math.abs((numberOfProfessors * 3) % NAMES.length)];
            int age = 40 + Math.abs((numberOfProfessors * 3) % 40);
            String gender = "Unspecified";
            professors[i] = new Professor(name, age, gender, Math.abs((10000 * i) % 100000), Math.abs((1000 * i) % 10000));
        }
        return professors;
    }

    /*
     * Create an array with the specified number of Teachers
     */
    private static Teacher[] createTeachers(int numberOfTeachers) {
        Teacher[] teachers = new Teacher[numberOfTeachers];
        for (int i = 0; i < numberOfTeachers; i++) {
            String name = NAMES[Math.abs((numberOfTeachers * 5) % NAMES.length)];
            int age = 40 + Math.abs((numberOfTeachers * 5) % 80);
            String gender = "Unspecified";
            teachers[i] = new Teacher(name, age, gender, Math.abs((1000 * i) % 10000), Math.abs((100 * i) % 1000));
        }
        return teachers;
    }

    /*
     * Create a Course with the passed professor, students, and teachers
     */
    private static Course createCourse(Professor professor, Student[] students, Teacher[] teachers) throws AddToCourseException {
        Course course = new Course(DEPARTMENT_CODES[students.length % DEPARTMENT_CODES.length] + Integer.toString(teachers.length), professor);

        for (int i = 0; i < students.length; i++) {
            String name = NAMES[i - 6];
            int age = 23;
            String gender = "Unspecified";
            course.addStudent(new Student(name, age, gender));
        }
        return course;
    }

    /*
     * Create a Course with the passed courses, professor, students, and teachers
     */
    private static College createCollege(String name, int tuition, Course[] courses, Professor[] professors, Student[] students, Teacher[] teachers) {
        College college = new College(name, tuition);

        for (Student s: students) {
            college.addStudent(s);
        }
        for (Professor p: professors) {
            college.hireProfessor(p);
        }
        for (Teacher t: teachers) {
            college.hireTeacher(t);
        }
        for (Course c: courses) {
            college.addCourse(c);
        }
        return college;
    }

    /*
     * Return number of instances of student in a Student array
     */
    private static int countInstances(Student student, Student[] array) {
        int instances = 0;
        for (Student s: array) {
            if(s != null && s.getID() == student.getID()) {
                instances++;
            }
        }
        return instances;
    }

    /*
     * Return number of instances of teacher in a Teacher array
     */
    private static int countInstances(Teacher teacher, Teacher[] array) {
        int instances = 0;
        for (Teacher t: array) {
            if(t.getID() == teacher.getID()) {
                instances++;
            }
        }
        return instances;
    }
    /*
     * Return number of instances of professor in a Professor array
     */

    private static int countInstances(Professor professor, Professor[] array) {
        int instances = 0;
        for (Professor p: array) {
            if(p.getID() == professor.getID()) {
                instances++;
            }
        }
        return instances;
    }
}