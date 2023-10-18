package com.fyr.memberproject.exceptions;

import com.fyr.memberproject.entities.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MemberExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<MemberError> exceptionHandler(MemberNotFoundException memberNotFoundException){
        MemberError error = new MemberError();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(memberNotFoundException.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<MemberError> exceptionHandler(Exception e){
        MemberError error = new MemberError();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Se till att id är korrekt för medlemmen du vill komma åt.");
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
