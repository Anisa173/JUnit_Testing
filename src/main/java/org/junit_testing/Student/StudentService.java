package org.junit_testing.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {

    private final List<Student> students = new ArrayList<>();

    public Student addStudent(Student student) {
        // Student student1 = new Student(2,"Hose Fashik","Data Science");
        students.add(student);
        //students.add(student1);
        //   if (student.getId().equals(studId)) {
        //     throw new StudentNotFoundException("There are not two or more students with the same Id1");

        return student;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(Integer StudentId) {
        return students.stream().filter((student) -> student.getId().equals(StudentId)).findFirst().orElseThrow(() -> new StudentNotFoundException("The StudentId does not exist!!!"));
    }

    public String[] getStudentNameByDepartment(String departament) {
        return students.stream().filter(student -> student.getDepartament().equals(departament)).map(Student::getName).toArray(String[]::new);
    }

    public List<String> getStudentNameListByDepartament(String Dept) {
        return students.stream().filter(student -> student.getDepartament().equals(Dept)).map(student -> student.getName()).collect(Collectors.toList());
    }

    public Integer[] getStudentIdByDepartament(String departament) {
        return students.stream().filter((student) -> student.getDepartament().equals(departament)).map(student -> student.getId()).toArray(Integer[]::new);
    }

    public List<Integer> getStudentIdListByDepartament(String Depart) {

        return students.stream().filter(student -> student.getDepartament().equals(Depart)).map(student -> student.getId()).collect(Collectors.toList());
    }

    public Student getStudentByName(String studentName) {
        return students.stream().filter(student -> student.getName().equals(studentName)).findFirst().orElseThrow(() -> new StudentNotFoundException("Student with the name:" + studentName + " is not found!!!"));
    }


}


