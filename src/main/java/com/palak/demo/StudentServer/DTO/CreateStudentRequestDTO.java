package com.palak.demo.StudentServer.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateStudentRequestDTO {
    @NotBlank(message = "Name is required")
    private String name;
    @Positive(message = "Age must be greater than 0")
    private int age;
    @NotBlank(message = "Department is required")
    private String department;
}