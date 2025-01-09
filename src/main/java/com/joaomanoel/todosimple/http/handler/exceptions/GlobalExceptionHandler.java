package com.joaomanoel.todosimple.http.handler.exceptions;

import com.joaomanoel.todosimple.domain.exceptions.auth.InvalidCredentialsException;
import com.joaomanoel.todosimple.domain.exceptions.customer.CustomerNotEmptyIdException;
import com.joaomanoel.todosimple.domain.exceptions.customer.CustomerNotFoundException;
import com.joaomanoel.todosimple.domain.exceptions.customer.DeleteCustomerException;
import com.joaomanoel.todosimple.domain.exceptions.task.DeleteTaskException;
import com.joaomanoel.todosimple.domain.exceptions.task.TaskNotEmptyIdException;
import com.joaomanoel.todosimple.domain.exceptions.task.TaskNotFoundException;
import com.joaomanoel.todosimple.http.DTOS.ResponseBuilderDTO;
import com.joaomanoel.todosimple.http.handler.responses.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ResponseBuilderDTO<String>>handleCustomerNotFound(CustomerNotFoundException ex) {
        String error = "Customer Not Found";
        return ResponseBuilder.build(error,HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ResponseBuilderDTO<String>>handleInvalidCredentials(InvalidCredentialsException ex) {
        String error = "Invalid Credentials";
        return ResponseBuilder.build(error,HttpStatus.UNAUTHORIZED                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          , ex.getMessage());
    }

    @ExceptionHandler(CustomerNotEmptyIdException.class)
    public ResponseEntity<ResponseBuilderDTO<String>>handleCustomerNotEmptyId(CustomerNotEmptyIdException ex) {
        String error = "Customer id not empty";
        return ResponseBuilder.build(error,HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
    }

    @ExceptionHandler(DeleteCustomerException.class)
    public ResponseEntity<ResponseBuilderDTO<String>>handleDeleteCustomer(DeleteCustomerException ex) {
        String error = "Unable to delete the customer.";
        return ResponseBuilder.build(error,HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(DeleteTaskException.class)
    public ResponseEntity<ResponseBuilderDTO<String>>handleDeleteTask(DeleteTaskException ex) {
        String error = "Unable to delete the task.";
        return ResponseBuilder.build(error,HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(TaskNotEmptyIdException.class)
    public ResponseEntity<ResponseBuilderDTO<String>>handleTaskNotEmptyId(TaskNotEmptyIdException ex) {
        String error = "Task id not empty";
        return ResponseBuilder.build(error,HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ResponseBuilderDTO<String>>handleTaskNotFound(TaskNotFoundException ex) {
        String error = "Task Not Found";
        return ResponseBuilder.build(error,HttpStatus.NOT_FOUND, ex.getMessage());
    }
}
