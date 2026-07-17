package com.palak.demo.StudentServer.Controller;

import com.palak.demo.StudentServer.Entity.Student;
import com.palak.demo.StudentServer.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {


    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> storeStudent(@RequestBody Student student) {
        Student  result = studentService.studentValidate(student);
        if(result == null){
            return ResponseEntity.status(400).body(result);
        }
        return ResponseEntity.status(201).body(result);
    }

    //get data by id
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getStudent(@PathVariable int id){
        Student student =  studentService.getStudentById(id);
        return ResponseEntity.status(200).body(student);

    }

    //update data of id
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id,
                                           @RequestBody Student student) {

        Student updatedStudent = studentService.updateStudent(id, student);

        if (updatedStudent == null) {
            return ResponseEntity.status(404).body("Student Not Found");
        }

        return ResponseEntity.ok(updatedStudent);
    }
}
