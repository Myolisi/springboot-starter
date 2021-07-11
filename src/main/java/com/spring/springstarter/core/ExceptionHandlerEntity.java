package com.spring.springstarter.core;

import com.spring.springstarter.core.classes.ErrorMessageClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// handle exceptions and format the response
//for all controllers we can also make it partial

@ControllerAdvice
@ResponseStatus //Include status code
public class ExceptionHandlerEntity extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundExeption.class)
    public ResponseEntity<ErrorMessageClass> DepartmentNotFoundException (DepartmentNotFoundExeption exception){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessageClass(HttpStatus.NOT_FOUND.value(), exception.getMessage()));
            // alternative to -> new ResponseEntity<String>(new ErrorMessageClass(HttpStatus.NOT_FOUND, exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
