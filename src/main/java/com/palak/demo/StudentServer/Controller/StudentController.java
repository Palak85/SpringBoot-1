//package com.palak.demo.StudentServer.Controller;
//
//import com.palak.demo.StudentServer.Entity.Student;
//import com.palak.demo.StudentServer.Service.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.palak.demo.StudentServer.DTO.CreateStudentRequestDTO;
//import com.palak.demo.StudentServer.DTO.CreateStudentResponseDTO;
//
//@RestController
//public class StudentController {
//
//
//    StudentService studentService;
//
//    @Autowired
//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }
//
//    @PostMapping("/create")
////    public ResponseEntity<Student> storeStudent(@RequestBody Student student) {
////        Student  result = studentService.studentValidate(student);
//    public ResponseEntity<?> storeStudent(@RequestBody CreateStudentRequestDTO createStudentRequestDTO) {
//        CreateStudentResponseDTO result = studentService.studentValidate(createStudentRequestDTO);
//        if(result == null){
//            return ResponseEntity.status(400).body(result);
//        }
//        return ResponseEntity.status(201).body(result);
//    }
//
//    //get data by id
//    @GetMapping("/get/{id}")
//    public ResponseEntity<?> getStudent(@PathVariable int id){
//        Student student =  studentService.getStudentById(id);
//        return ResponseEntity.status(200).body(student);
//
//    }
//
//    //update data of id
//    @PutMapping("/update/{id}")
//    public ResponseEntity<?> updateStudent(@PathVariable int id,
//                                           @RequestBody Student student) {
//
//        Student updatedStudent = studentService.updateStudent(id, student);
//
//        if (updatedStudent == null) {
//            return ResponseEntity.status(404).body("Student Not Found");
//        }
//
//        return ResponseEntity.ok(updatedStudent);
//    }
//
//    //delete data
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
//
//        boolean deleted = studentService.deleteStudent(id);
//
//        if (!deleted) {
//            return ResponseEntity.status(404).body("Student Not Found");
//        }
//
//        return ResponseEntity.ok("Student Deleted Successfully");
//    }
//}


package com.palak.demo.StudentServer.Controller;

import com.palak.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.palak.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.palak.demo.StudentServer.Entity.Student;
import com.palak.demo.StudentServer.Service.StudentService;
import jakarta.validation.Valid;
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
    public ResponseEntity<?> storeStudent(
            @Valid @RequestBody CreateStudentRequestDTO createStudentRequestDTO) {
        CreateStudentResponseDTO result = studentService.studentValidate(createStudentRequestDTO);

        if(result == null)
        {
            return ResponseEntity.status(400).body("Invalid input");
        }
        return  ResponseEntity.status(201).body(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id){

        Student student = studentService.getStudentById(id);

//        if(student == null){
//            return ResponseEntity.status(404).body("Student not found");
//        }

        return ResponseEntity.ok(student);
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody Student student){
//        Student result = studentService.studentUpdate(id, student);
//        if(result == null)
//        {
//            return ResponseEntity.status(400).body("Invalid input");
//        }
//        return ResponseEntity.status(200).body(result);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteStudent(@PathVariable int id){
//        Student student = studentService.deleteStudent(id);
//        if(student == null) {
//            return ResponseEntity.status(400).body("Invalid input");
//        }
//        return ResponseEntity.status(200).body("Student deleted");
//    }
}