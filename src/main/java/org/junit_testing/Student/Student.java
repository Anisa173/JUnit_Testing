package org.junit_testing.Student;

public class Student {
    private Integer id;
    private String name;
    private String departament;

    public Student() {
        id = 173;
        name = "Anisa Cela";
        departament = "SIZ";
    }

    public Student(Integer id, String name, String departament) {
        this.id = id;
        this.name = name;
        this.departament = departament;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departament='" + departament + '\'' +
                '}';
    }
}
