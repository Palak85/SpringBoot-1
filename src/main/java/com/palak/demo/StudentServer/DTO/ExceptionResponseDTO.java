package com.palak.demo.StudentServer.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionResponseDTO {
    private LocalDateTime timestamp;
    private int statusCode;
    private String error;
    private String message;
    private String path;

//    public ExceptionResponseDTO(LocalDateTime timestamp, int statusCode, String error, String message, String path) {
//        this.timestamp = timestamp;
//        this.statusCode = statusCode;
//        this.error = error;
//        this.message = message;
//        this.path = path;
//    }
}
