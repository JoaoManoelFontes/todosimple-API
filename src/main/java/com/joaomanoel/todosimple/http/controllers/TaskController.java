package com.joaomanoel.todosimple.http.controllers;

import com.joaomanoel.todosimple.domain.usecases.CustomerUseCases;
import com.joaomanoel.todosimple.domain.usecases.TaskUseCases;
import com.joaomanoel.todosimple.http.DTOS.ResponseBuilderDTO;
import com.joaomanoel.todosimple.http.DTOS.task.RequestRegisterTaskDTO;
import com.joaomanoel.todosimple.http.DTOS.task.ResponseRegisterTaskDTO;
import com.joaomanoel.todosimple.http.DTOS.task.ResponseTaskDTO;
import com.joaomanoel.todosimple.domain.models.Task;
import com.joaomanoel.todosimple.http.DTOS.task.ResponseTasksByCustomerDTO;
import com.joaomanoel.todosimple.http.handler.responses.ResponseBuilder;
import com.joaomanoel.todosimple.utils.TaskMappers;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
@Validated
public class TaskController {

    private final TaskUseCases taskUseCases;
    private final CustomerUseCases customerUseCases;
    private final TaskMappers taskMappers;

    public TaskController(TaskUseCases taskUseCases, CustomerUseCases customerUseCases, TaskMappers taskMappers) {
        this.taskUseCases = taskUseCases;
        this.customerUseCases = customerUseCases;
        this.taskMappers = taskMappers;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBuilderDTO<ResponseTaskDTO>> findById(@PathVariable Long id) {
        ResponseTaskDTO responseTaskDTO = new ResponseTaskDTO(this.taskUseCases.findById(id));
        return ResponseBuilder.build("Task found successfully", HttpStatus.OK, responseTaskDTO);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<ResponseBuilderDTO<List<ResponseTasksByCustomerDTO>>> findAllByCustomerId(@PathVariable UUID customerId) {
        customerUseCases.findById(customerId);
        List<Task> tasks = this.taskUseCases.findAllByCustomerId(customerId);
        List<ResponseTasksByCustomerDTO> taskDTO = tasks.stream().map(ResponseTasksByCustomerDTO::new).toList();
        return ResponseBuilder.build("Customer and tasks found successfully", HttpStatus.OK, taskDTO);
    }

    @PostMapping("/")
    @Validated
    public ResponseEntity<ResponseBuilderDTO<ResponseRegisterTaskDTO>> register(@Valid @RequestBody RequestRegisterTaskDTO body) {
        Task task = this.taskMappers.DTOToDomain(body);
        ResponseRegisterTaskDTO registerTaskDTO = new ResponseRegisterTaskDTO(this.taskUseCases.register(task));
        return ResponseBuilder.build("Task created successfully", HttpStatus.CREATED, registerTaskDTO);
    }

    @PutMapping("/{id}")
    @Validated
    public ResponseEntity<ResponseBuilderDTO<ResponseRegisterTaskDTO>> update(@Valid @RequestBody RequestRegisterTaskDTO body, @PathVariable Long id) {
        Task task = this.taskMappers.DTOToDomain(body);
        task.setId(id);
        ResponseRegisterTaskDTO updateTaskDTO = new ResponseRegisterTaskDTO(this.taskUseCases.update(task));
        return ResponseBuilder.build("Task updated successfully", HttpStatus.OK, updateTaskDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBuilderDTO<Void>> delete(@PathVariable Long id) {
        this.taskUseCases.delete(id);
        return ResponseBuilder.build("Task deleted successfully", HttpStatus.NO_CONTENT, null);
    }

}
