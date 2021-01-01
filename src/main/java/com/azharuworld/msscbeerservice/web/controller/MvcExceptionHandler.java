package com.azharuworld.msscbeerservice.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * * Created by AzSyed on 1/2/2021
 */

@ControllerAdvice
public class MvcExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException ex){
        List<String> errorList = new ArrayList<>(ex.getConstraintViolations().size());
        ex.getConstraintViolations().forEach(e->errorList.add(e.toString()));

        return  new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
    }
}
