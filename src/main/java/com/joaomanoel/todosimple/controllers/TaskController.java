package com.joaomanoel.todosimple.controllers;

import com.joaomanoel.todosimple.DTOS.task.ResponseRegisterTaskDTO;
import com.joaomanoel.todosimple.DTOS.task.ResponseTaskDTO;
import com.joaomanoel.todosimple.models.Task;
import com.joaomanoel.todosimple.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
@Validated
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseTaskDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(new ResponseTaskDTO(this.taskService.findById(id)));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<ResponseTaskDTO>> findAllByCustomerId(@PathVariable UUID customerId) {
        List<Task>tasks = this.taskService.findAllByCustomerId(customerId);
        return ResponseEntity.ok().body(tasks.stream().map(ResponseTaskDTO::new).toList());
    }

    @PostMapping("/")
    @Validated
    public ResponseEntity<ResponseRegisterTaskDTO> register(@Valid @RequestBody Task task) {
        System.out.println(task);
        return ResponseEntity.created(null).body(new ResponseRegisterTaskDTO(this.taskService.register(task)));
    }

    @PutMapping("/{id}")
    @Validated
    public ResponseEntity<ResponseRegisterTaskDTO> update(@Valid @RequestBody Task task, @PathVariable Long id) {
        task.setId(id);
        return ResponseEntity.ok().body(new ResponseRegisterTaskDTO(this.taskService.update(task)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
