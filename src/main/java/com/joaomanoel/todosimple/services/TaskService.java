package com.joaomanoel.todosimple.services;

import com.joaomanoel.todosimple.exceptions.task.DeleteTaskException;
import com.joaomanoel.todosimple.exceptions.task.TaskNotEmptyIdException;
import com.joaomanoel.todosimple.exceptions.task.TaskNotFoundException;
import com.joaomanoel.todosimple.models.Customer;
import com.joaomanoel.todosimple.models.Task;
import com.joaomanoel.todosimple.repositories.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final CustomerService customerService;

    public TaskService(TaskRepository taskRepository, CustomerService customerService) {
        this.taskRepository = taskRepository;
        this.customerService = customerService;
    }

    public Task findById(Long id){
        Optional<Task> task = this.taskRepository.findById(id);
        return task.orElseThrow(() -> new TaskNotFoundException(id));
    }

    @Transactional
    public Long register(Task task){
        Customer customer = this.customerService.findById(task.getCustomer().getId());
        if (task.getId() != null){
            throw new TaskNotEmptyIdException(task);
        }
        task.setCustomer(customer);
        return this.taskRepository.save(task).getId();
    }

    @Transactional
    public Long update(Task newTask){
        Task task = this.taskRepository.findById(newTask.getId()).orElseThrow(() -> new TaskNotFoundException(newTask.getId()));
        task.setTitle(newTask.getTitle());
        task.setDescription(newTask.getDescription());
        return this.taskRepository.save(task).getId();
    }

    public void delete(Long id){
        Task task = this.taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        try {
            this.taskRepository.delete(task);
        }catch (Exception e){
            throw new DeleteTaskException(task, e);
        }
    }

}
