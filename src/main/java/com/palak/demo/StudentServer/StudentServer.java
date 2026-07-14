package com.palak.demo.StudentServer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentServer {
    // 1. Store the Student - post http method
    @PostMapping("/create")
    public String storeStudent(){
        return """
                id : 1,
                name : Palak,
                Departmnet : CSE,
                age : 20
                """;
    }

    // 2. Read the student with id - get method


    // 3. Update the student information - put , patch http method

    //4. delete the student information - delete



}
