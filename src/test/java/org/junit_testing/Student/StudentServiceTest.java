package org.junit_testing.Student;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentService();
        System.out.println("SetUp method is executed before ech test method...!");
    }

    @AfterEach
    void tearDown() {
        studentService = null;
        System.out.println("TearDown method is executed after each test method...!");
    }

    @Test
    public void testAddStudent() {
        Student student = new Student(3, "Anisa C", "IE");
        Student student1 = new Student(2, "Ramesh Fadare", "Enginnering");
        Student student2 = new Student(2, "Ramous Fredrich", "Enginnering");
        Student study = studentService.addStudent(student);
        Student student11 = studentService.addStudent(student1);
        //Student student2 = studentService.addStudent(2, "Ram Fadare", "Data Science");
        Integer actualId = study.getId();
        assertNotNull(actualId);
        // assertNotNull(actualId2);
        assertNotNull(student11.getId());
        assertEquals("Anisa C", study.getName());
        assertEquals("Ramesh Fadare", student11.getName());
        assertEquals("IE", study.getDepartament());
        assertEquals("Enginnering", student11.getDepartament());
        assertEquals(3, actualId);
        assertEquals(2, student11.getId());
        StudentNotFoundException exception = assertThrows(StudentNotFoundException.class, () -> {
            studentService.addStudent(student2);
        });
    }

    @Test
    public void getAllStudentsTestUsingAssertFalse() {
        Student student = new Student(4, "Ram Fadare", "Data Science");
        Student student1 = new Student(5, "Ram1 Fadare", "Data Science");
        studentService.addStudent(student);
        studentService.addStudent(student1);
        List<Student> listOfStudents = studentService.getAllStudents();

        boolean actualResult = listOfStudents.isEmpty();
        assertFalse(actualResult);
        assertFalse(() -> actualResult, () -> "The list is not empty");
        assertFalse(actualResult, "List is not empty!!");
        assertFalse(actualResult, () -> "List of Students is never EMPTY!");
        assertFalse(() -> actualResult, "ListOfStudents is not Empty!");
    }

    @Test
    public void getAllStudentsTestUsingAssertTrue() {
        List<Student> listOfStudents = studentService.getAllStudents();
        boolean actualResult = listOfStudents.isEmpty();
        assertTrue(actualResult);
        assertTrue(() -> actualResult, () -> "The list is  empty");
        assertTrue(actualResult, "List is  empty!!");
        assertTrue(actualResult, () -> "List of Students is  EMPTY!");
        assertTrue(() -> actualResult, "ListOfStudents is  Empty!");
    }

    @Test
    public void getStudentsIdTestEquals() {
        Student student = new Student(6, "Anisa Cela", "Finance");
        var studenttt = studentService.addStudent(student); //, student.getId());
        Student student1 = new Student(7, "Anisa Cela", "Bussiness");
        var studenttt1 = studentService.addStudent(student1);//, student1.getId();
        Student student2 = new Student(8, "Anisa Cela", "Bussiness1");
        var studenttt2 = studentService.addStudent(student2);//, student2.getId());
        Integer actualStudent = studenttt.getId();
        Integer actualStudent1 = studenttt1.getId();
        Integer actualStudent2 = studenttt2.getId();
        assertNotNull(actualStudent);
        assertNotNull(actualStudent1);
        assertNotNull(actualStudent2);
        Student actStudent = studentService.getStudentById(6);
        assertEquals(6, actStudent.getId(), "student is found!");
    }

    @Test
    public void getStudentIdTestNotEquals() {
        Student student = new Student(10, "Anisa Cela", "Finance");
        studentService.addStudent(student);
        Student student1 = new Student(11, "Anisa Cela", "Bussiness");
        studentService.addStudent(student1);
        Student student2 = new Student(12, "Anisa Cela", "Bussiness1");
        studentService.addStudent(student2);
        Student actStudent = studentService.getStudentById(10);
        Student actStudent1 = studentService.getStudentById(11);
        Student actStudent2 = studentService.getStudentById(12);
        assertEquals(student, actStudent, "student is found!");
        assertNotEquals(6, actStudent1.getId(), "student is found!");
        assertNotEquals(6, actStudent2.getId(), "student is found!");
    }

    @Test
    public void getStudentIdTESTUsingAssertNull() {
        Student student = new Student(1, "Ramesh H", "Operations");
        studentService.addStudent(student);
        Student actualStudent = studentService.getStudentById(2);
        assertNull(actualStudent, "The student does not exist!!!");
        assertNull(actualStudent);
        assertNull(actualStudent, () -> "The student does not exist...!");
    }

    @Test
    public void getStudentIdTestUsingAssertNotNULL() {
        Student student = new Student(1, "Ramesh H", "Operations");
        studentService.addStudent(student);
        Student actualStudent = studentService.getStudentById(1);
        assertNull(actualStudent, "The student exists!!!");
        assertNull(actualStudent);
        assertNull(actualStudent, () -> "The student exists...!");
    }

    @Test
    public void getStudentsNameByDepartamentByUsingAssertArrayEquals() {
        Student student = new Student(2, "Arina L", "Arts and Science");
        studentService.addStudent(student);
        Student student1 = new Student(7, "Tom FO", "Data Science");
        studentService.addStudent(student1);
        Student student2 = new Student(4, "Ania P", "Data Science");
        studentService.addStudent(student2);
        Student student3 = new Student(6, "Alma B", "Data Science");
        studentService.addStudent(student3);
        Student student4 = new Student(9, "Ilia K", "Informatics");
        studentService.addStudent(student4);
        String[] actualValues = studentService.getStudentNameByDepartment("Data Science");
        String[] expectedValues = {"Tom FO", "Ania P", "Alma B"};
        assertArrayEquals(expectedValues, actualValues, "Arrays are EQUALS!!!");
        assertArrayEquals(expectedValues, actualValues);
        assertArrayEquals(expectedValues, actualValues, () -> "These arrays are EQUAL.");

    }

    @Test
    public void getStudentNameListByDepartamentTestUsingAssertIterableEquals() {
        Student student = new Student(2, "Arina L", "Arts and Science");
        studentService.addStudent(student);
        Student student1 = new Student(7, "Tom FO", "Data Science");
        studentService.addStudent(student1);
        Student student2 = new Student(4, "Ania P", "Data Science");
        studentService.addStudent(student2);
        Student student3 = new Student(6, "Alma B", "Data Science");
        studentService.addStudent(student3);
        Student student4 = new Student(9, "Ilia K", "Informatics");
        studentService.addStudent(student4);
        List<String> actualValues = studentService.getStudentNameListByDepartament("Data Science");
        List<String> expectedValues = Arrays.asList("Tom FO", "Ania P", "Alma B");
        assertIterableEquals(expectedValues, actualValues, "ArrayLists are EQUALS!!!");

        List<String> actualNames = studentService.getStudentNameListByDepartament("Informatics");
        List<String> expectedNames = Arrays.asList("Ilia K");
        assertIterableEquals(expectedNames, actualNames);
        List<String> actualNames1 = studentService.getStudentNameListByDepartament("Arts and Science");
        List<String> expectedNames1 = Arrays.asList("Arina L");
        assertIterableEquals(expectedNames1, actualNames1, () -> "Lists are equal!!!");
    }

    @DisplayName("Generate an array with studentsId grouped by Departament")
    @RepeatedTest(value = 3, name = RepeatedTest.LONG_DISPLAY_NAME)
    public void getStudentIdByDepartamentTestUsingAssertArrayEquals() {
        Student student = new Student(2, "Arina L", "Arts and Science");
        studentService.addStudent(student);
        Student student1 = new Student(7, "Tom FO", "Data Science");
        studentService.addStudent(student1);
        Student student2 = new Student(4, "Ania P", "Data Science");
        studentService.addStudent(student2);
        Student student3 = new Student(6, "Alma B", "Data Science");
        studentService.addStudent(student3);
        Student student4 = new Student(9, "Ilia K", "Informatics");
        studentService.addStudent(student4);
        Integer[] actualStudentId = studentService.getStudentIdByDepartament("Data Science");
        Integer[] exceptedStudentsId = {7, 4, 6};
        assertArrayEquals(exceptedStudentsId, actualStudentId, () -> "Arrays are Equals!!!");
        Integer[] actualStdId = studentService.getStudentIdByDepartament("Arts and Science");
        Integer[] exceptedStdId = {2};
        assertArrayEquals(exceptedStdId, actualStdId, "Arrays are Equals!!!");
        Integer[] actStdId = studentService.getStudentIdByDepartament("Informatics");
        Integer[] exceptStdId = {9};
        assertArrayEquals(exceptStdId, actStdId, "Arrays are Equals!!!");
    }

    @Test
    public void getStudentIdListByDepartamentTestUsingAssertIterableEquals() {
        Student student = new Student(2, "Arina L", "Arts and Science");
        studentService.addStudent(student);
        Student student1 = new Student(7, "Tom FO", "Data Science");
        studentService.addStudent(student1);
        Student student2 = new Student(4, "Ania P", "Data Science");
        studentService.addStudent(student2);
        Student student3 = new Student(6, "Alma B", "Data Science");
        studentService.addStudent(student3);
        Student student4 = new Student(9, "Ilia K", "Informatics");
        studentService.addStudent(student4);
        List<Integer> actualStudentsId = studentService.getStudentIdListByDepartament("Data Science");
        List<Integer> exceptedStudentsId = Arrays.asList(7, 4, 6);
        assertIterableEquals(exceptedStudentsId, actualStudentsId, "Lists with StudentsId for the same department are equal!");

        List<Integer> actStudentsId = studentService.getStudentIdListByDepartament("Arts and Science");
        List<Integer> exceptStudentsId = Arrays.asList(2);
        assertIterableEquals(exceptStudentsId, actStudentsId, "Lists with StudentsId for the same department are equal!");

        List<Integer> actualStudentsId1 = studentService.getStudentIdListByDepartament("Informatics");
        List<Integer> exceptedStudentsId1 = Arrays.asList(9);
        assertIterableEquals(exceptedStudentsId1, actualStudentsId1, "Lists with StudentsId for the same department are equal!");


    }

    @Test
    public void getStudentByNameTestUsingAssertEqual() {
        Student student = new Student(2, "Anisa", "Informatics");
        Student student1 = new Student(3, "Arnisa", "Informatics");
        Student student2 = new Student(4, "Alnisa", "Informatics");
        Student student3 = new Student(5, "Anisa", "Informatics");
        Student student4 = new Student(6, "Anisa", "Informatics");
        Student student5 = new Student(7, "Nisa", "Informatics");
        Student student6 = new Student(8, "Anisa", "Informatics");
        var student11 = studentService.addStudent(student);
        var student12 = studentService.addStudent(student1);
        var student13 = studentService.addStudent(student2);
        var student14 = studentService.addStudent(student3);
        var student15 = studentService.addStudent(student4);
        var student16 = studentService.addStudent(student5);
        var student17 = studentService.addStudent(student6);
        Student stud = studentService.getStudentByName(student11.getName());
        assertEquals("Anisa", stud.getName());
        Student stud1 = studentService.getStudentByName(student12.getName());
        assertNotEquals("Anisa", stud1.getName());
        Student stud2 = studentService.getStudentByName(student13.getName());
        assertNotEquals("Anisa", stud2.getName());
        Student stud3 = studentService.getStudentByName(student14.getName());
        assertEquals("Anisa", stud3.getName());
        Student stud4 = studentService.getStudentByName(student15.getName());
        assertEquals("Anisa", stud4.getName());
        Student stud5 = studentService.getStudentByName(student16.getName());
        assertNotEquals("Anisa", stud5.getName());
        Student stud6 = studentService.getStudentByName(student17.getName());
        assertEquals("Anisa", stud6.getName());
    }


    @Test
    public void getStudentByNameTestUsingAssertThrows() {
        Student student = new Student(2, "Arnisa", "Informatics");
        Student student1 = new Student(3, "Arnisa", "Informatics");
        Student student2 = new Student(4, "Arnisa", "Informatics");
        Student student3 = new Student(5, "Arnisa", "Informatics");
        Student student4 = new Student(6, "Arnisa", "Informatics");
        Student student5 = new Student(7, "Arnisa", "Informatics");
        Student student6 = new Student(8, "Arnisa", "Informatics");
        studentService.addStudent(student);
        studentService.addStudent(student1);
        studentService.addStudent(student2);
        studentService.addStudent(student3);
        studentService.addStudent(student4);
        studentService.addStudent(student5);
        studentService.addStudent(student6);
        Student std = studentService.getStudentByName("Arnisa");
        assertEquals("Arnisa", std.getName());
       // StudentNotFoundException exception1 =
                assertThrows(StudentNotFoundException.class, () -> {
            studentService.getStudentByName("Anisa");
        });
       // assertEquals("Student not found.", exception1.getMessage());
    }

    @Test
    public void getStudentsByNameTestByUsingAssertThrowsExactly() {
        Student student = new Student(2, "Anisa", "Informatics");
        Student student1 = new Student(3, "Arnisa", "Informatics");
        Student student2 = new Student(4, "Arnisa", "Informatics");
        Student student3 = new Student(5, "Arnisa", "Informatics");
        Student student4 = new Student(6, "Alnisa", "Informatics");
        Student student5 = new Student(7, "Arnisa", "Informatics");
        Student student6 = new Student(8, "Anisa", "Informatics");
        studentService.addStudent(student);
        studentService.addStudent(student1);
        studentService.addStudent(student2);
        studentService.addStudent(student3);
        studentService.addStudent(student4);
        studentService.addStudent(student5);
        studentService.addStudent(student6);
        Student std = studentService.getStudentByName("Arnisa");
        assertEquals("Arnisa", std.getName());

        assertThrowsExactly(StudentNotFoundException.class, () -> {
            studentService.getStudentByName("Adisa");
        });
        assertThrowsExactly(StudentNotFoundException.class, () -> {
            studentService.getStudentByName("Aisa");
        });

//The test does not passes!
        //  StudentNotFoundException exception2 = assertThrowsExactly(StudentNotFoundException.class, () -> {
        //     studentService.getStudentByName("Arnisa");
        // });
        // assertEquals("Student not found",exception1.getMessage());
        // assertEquals("Student not found",exception2.getMessage());
    }

}
