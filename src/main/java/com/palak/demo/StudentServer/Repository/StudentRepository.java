package com.palak.demo.StudentServer.Repository;

import com.palak.demo.StudentServer.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository

public interface StudentRepository extends JpaRepository<Student, Integer> {

    //JpaRepository :- is an interface and it have methods and we need to implements its methods which will be done by spring-data-jpa


//    public Student save(Student student){
//        System.out.println("Student Information saved");
//        return student;
//    }


}
