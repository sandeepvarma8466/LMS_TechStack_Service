package com.blz.techstackservice.exception.exceptionHandler;

import com.blz.techstackservice.exception.TechStackNotFoundException;
import com.blz.techstackservice.util.TeckStackResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class TechStackExceptionHandler {
    @ExceptionHandler(TechStackNotFoundException.class)
    public ResponseEntity<TeckStackResponse> response(TechStackNotFoundException exception) {
        TeckStackResponse adminResponce = new TeckStackResponse();
        adminResponce.setErrorcode(400);
        adminResponce.setMessage(exception.getMessage());
        return new ResponseEntity<>(adminResponce, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<TeckStackResponse>
    defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        TeckStackResponse teckStackResponse = new TeckStackResponse();
        teckStackResponse.setErrorcode(500);
        teckStackResponse.setMessage(e.getMessage());
        return new ResponseEntity<TeckStackResponse>(teckStackResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
