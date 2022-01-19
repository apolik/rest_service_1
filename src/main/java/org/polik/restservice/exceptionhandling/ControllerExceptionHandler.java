package org.polik.restservice.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler
    private ResponseEntity<EmployeeIncorrectData> handleException(EmployeeNotFoundException exception) {
        EmployeeIncorrectData data = new EmployeeIncorrectData(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<EmployeeIncorrectData> handleException(Exception exception) {
        EmployeeIncorrectData data = new EmployeeIncorrectData(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
