package com.ntg.SpringWeb.Service;

import com.ntg.SpringWeb.Repository.StudentRepository;
import com.ntg.SpringWeb.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public List<Student> addNewStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public List<Student> deleteStudentById(int id) {
        return studentRepository.deleteById(id);
    }

    public List<Student> updateStudent(Student student) {
        return studentRepository.update(student);
    }

    public List<Student> getStudentByAge(int age) {
        return studentRepository.findByAge(age);
    }
}
