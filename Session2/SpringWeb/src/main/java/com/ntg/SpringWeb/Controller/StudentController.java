package com.ntg.SpringWeb.Controller;

import com.ntg.SpringWeb.Service.StudentService;
import com.ntg.SpringWeb.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudent();
    }


    @PostMapping
    public List<Student> addStudents(@RequestBody Student student) {
        return studentService.addNewStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/delete/{id}")
    public List<Student> deleteStudents(@PathVariable int id) {
        return studentService.deleteStudentById(id);
    }

    @PutMapping
    public List<Student> updateStudents(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }


    @GetMapping("/byAge")
    public List<Student> getStudentByAge(@RequestParam(name = "studentAge",defaultValue = "27") int age) {
        return studentService.getStudentByAge(age);
    }


}
