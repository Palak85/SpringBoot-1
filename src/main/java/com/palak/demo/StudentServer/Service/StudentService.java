//package com.palak.demo.StudentServer.Service;
//
//import com.palak.demo.StudentServer.Entity.Student;
//import com.palak.demo.StudentServer.Repository.StudentRepository;
//import org.springframework.stereotype.Service;
//import com.palak.demo.StudentServer.DTO.CreateStudentRequestDTO;
//import com.palak.demo.StudentServer.DTO.CreateStudentResponseDTO;
//
//import java.time.LocalDateTime;
//
//@Service
//public class StudentService {
//
//    StudentRepository studentRepository;
//
//    public StudentService(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }
//
////    public Student studentValidate(Student student){
////        int id = student.getId();
////        String name = student.getName();
////        int age = student.getAge();
////        String department = student.getDepartment();
////
////        if(id < 0 || name == null || age < 0 || department == null){
////            return null;
////        }
////
////        studentRepository.save(student);
////        return student;
////    }
//
//    public CreateStudentResponseDTO studentValidate(CreateStudentRequestDTO createStudentRequestDTO) {
//        Student student = mapToStudent(createStudentRequestDTO);
//        return mapToResponseDTO(student);
//    }
//
//    //get data
//    public Student getStudentById(int id){
//        return studentRepository.findById(id).orElse(null);
//    }
//
//    private Student mapToStudent(CreateStudentRequestDTO createStudentRequestDTO) {
//        Student student = new Student();
//
//        student.setName(createStudentRequestDTO.getName());
//        student.setAge(createStudentRequestDTO.getAge());
//        student.setDepartment(createStudentRequestDTO.getDepartment());
//        student.setCreatedAt(LocalDateTime.now());
//        student.setUpdatedAt(LocalDateTime.now());
//
//        return student;
//    }
//
//    private CreateStudentResponseDTO mapToResponseDTO(Student student) {
//        CreateStudentResponseDTO createStudentResponseDTO = new CreateStudentResponseDTO();
//        createStudentResponseDTO.setId(student.getId());
//        createStudentResponseDTO.setName(student.getName());
//        createStudentResponseDTO.setAge(student.getAge());
//        createStudentResponseDTO.setDepartment(student.getDepartment());
//
//        return createStudentResponseDTO;
//
//    }
//
//    //update data
//    public Student updateStudent(int id, Student newStudent) {
//
//        Student student = studentRepository.findById(id).orElse(null);
//
//        if (student == null) {
//            return null;
//        }
//
//        student.setName(newStudent.getName());
//        student.setAge(newStudent.getAge());
//        student.setDepartment(newStudent.getDepartment());
//
//        return studentRepository.save(student);
//    }
//
//    //delete data
//    public boolean deleteStudent(int id) {
//
//        if (!studentRepository.existsById(id)) {
//            return false;
//        }
//
//        studentRepository.deleteById(id);
//        return true;
//    }
//}


package com.palak.demo.StudentServer.Service;

import com.palak.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.palak.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.palak.demo.StudentServer.Entity.Student;
import com.palak.demo.StudentServer.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDTO studentValidate(
            CreateStudentRequestDTO createStudentRequestDTO)
            throws Exception {

        Student existingStudent =
                studentRepository.findByEmail(
                        createStudentRequestDTO.getEmail());

        if (existingStudent != null) {
            throw new Exception("Email already exists");
        }

        Student student = mapToStudent(createStudentRequestDTO);

        student = studentRepository.save(student);

        return mapToResponseDTO(student);
    }

//    public Student getStudentById(int id) {
//        Optional<Student> student =  studentRepository.findById(id);
////        return studentRepository.findById(id).orElse(null);
//        return student.get();
//    }

        public Student getStudentById(int id) throws Exception {

            Optional<Student> student = studentRepository.findById(id);

            if (student.isEmpty()) {
                throw new Exception("Student not found");
            }

            return student.get();
        }

    public Student updateStudent(int id, Student student) {

        Student result = studentRepository.findById(id).orElse(null);

        if (result == null) {
            return null;
        }
        result.setName(student.getName());
        result.setAge(student.getAge());
        result.setDepartment(student.getDepartment());
        result.setUpdatedAt(LocalDateTime.now());

        return studentRepository.save(result);
    }

    public boolean deleteStudent(int id) {

        Student result = studentRepository.findById(id).orElse(null);

        if (result == null) {
            return false;
        }

        studentRepository.delete(result);
        return true;
    }

    private Student mapToStudent(CreateStudentRequestDTO createStudentRequestDTO) {

        Student student = new Student();

        student.setName(createStudentRequestDTO.getName());
        student.setAge(createStudentRequestDTO.getAge());
        student.setDepartment(createStudentRequestDTO.getDepartment());
        student.setEmail(createStudentRequestDTO.getEmail());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        return student;
    }

    private CreateStudentResponseDTO mapToResponseDTO(Student student) {

        CreateStudentResponseDTO createStudentResponseDTO = new CreateStudentResponseDTO();

        createStudentResponseDTO.setId(student.getId());
        createStudentResponseDTO.setName(student.getName());
        createStudentResponseDTO.setAge(student.getAge());
        createStudentResponseDTO.setDepartment(student.getDepartment());
        createStudentResponseDTO.setEmail(student.getEmail());

        return createStudentResponseDTO;
    }
}