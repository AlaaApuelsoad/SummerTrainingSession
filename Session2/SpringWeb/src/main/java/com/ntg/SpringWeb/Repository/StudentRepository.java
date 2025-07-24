package com.ntg.SpringWeb.Repository;

import com.ntg.SpringWeb.Model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentRepository {

    private List<Student> studentList = new ArrayList<>(Arrays.asList(
            new Student(1,"Alaa",26),
            new Student(2,"Mohamed",27),
            new Student(3,"Ali",28)
    ));


    public List<Student> findAll(){
        return studentList;
    }


    public List<Student> save(Student student) {
        studentList.add(student);
        return studentList;
    }

    public Student findById(int id) {
        Student student = studentList.stream().filter(s -> s.getId() == id).findFirst().orElseThrow(
                ()-> new RuntimeException("student not found")
        );
        return student;
    }

    public List<Student> deleteById(int id) {
        Student s = findById(id);
        studentList.remove(s);
        return studentList;
    }

    public List<Student> update(Student student) {
        int id = student.getId();
        Student student1 = findById(id);
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        return studentList;
    }

    public List<Student> findByAge(int age) {
        List<Student> students = studentList.stream().filter(s -> s.getAge() < age).toList();
        return students;
    }
}
