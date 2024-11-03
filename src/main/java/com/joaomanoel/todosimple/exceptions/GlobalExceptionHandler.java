package com.joaomanoel.todosimple.exceptions;

import com.joaomanoel.todosimple.exceptions.customer.CustomerNotEmptyIdException;
import com.joaomanoel.todosimple.exceptions.customer.CustomerNotFoundException;
import com.joaomanoel.todosimple.exceptions.customer.DeleteCustomerException;
import com.joaomanoel.todosimple.exceptions.task.DeleteTaskException;
import com.joaomanoel.todosimple.exceptions.task.TaskNotEmptyIdException;
import com.joaomanoel.todosimple.exceptions.task.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<Map<String, Object>> exceptionResponseBuilder(String message, HttpStatus status, String error){
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("status", status.value());
        response.put("error", error);

        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Map<String,Object>>handleCustomerNotFound(CustomerNotFoundException ex) {
        String error = "Customer Not Found";
        return exceptionResponseBuilder(ex.getMessage(),HttpStatus.NOT_FOUND, error);
    }

    @ExceptionHandler(CustomerNotEmptyIdException.class)
    public ResponseEntity<Map<String,Object>>handleCustomerNotEmptyId(CustomerNotEmptyIdException ex) {
        String error = "Customer id not empty";
        return exceptionResponseBuilder(ex.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY, error);
    }

    @ExceptionHandler(DeleteCustomerException.class)
    public ResponseEntity<Map<String,Object>>handleDeleteCustomer(DeleteCustomerException ex) {
        String error = "Unable to delete the customer.";
        return exceptionResponseBuilder(ex.getMessage(),HttpStatus.BAD_REQUEST, error);
    }

    @ExceptionHandler(DeleteTaskException.class)
    public ResponseEntity<Map<String,Object>>handleDeleteTask(DeleteTaskException ex) {
        String error = "Unable to delete the task.";
        return exceptionResponseBuilder(ex.getMessage(),HttpStatus.BAD_REQUEST, error);
    }

    @ExceptionHandler(TaskNotEmptyIdException.class)
    public ResponseEntity<Map<String,Object>>handleTaskNotEmptyId(TaskNotEmptyIdException ex) {
        String error = "Task id not empty";
        return exceptionResponseBuilder(ex.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY, error);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<Map<String,Object>>handleTaskNotFound(TaskNotFoundException ex) {
        String error = "Customer Not Found";
        return exceptionResponseBuilder(ex.getMessage(),HttpStatus.NOT_FOUND, error);
    }
}
