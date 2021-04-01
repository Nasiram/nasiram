package com.ul.api.service.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ProjectNotFoundErrorHandler {

    @ExceptionHandler(ProjectsNotFound.class)
    public ResponseEntity<Object> errorProjectsNotFound(Exception ex, WebRequest request){
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setTimeStamp(new Date());
        errorMessage.setMessage("Projects not Found!");
        errorMessage.setDescription(request.getDescription(false));
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.NO_CONTENT);

    }
}
