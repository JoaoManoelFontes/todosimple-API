package com.joaomanoel.todosimple.services;

import com.joaomanoel.todosimple.domain.repositories.TaskRepository;
import com.joaomanoel.todosimple.domain.usecases.CustomerUseCases;
import com.joaomanoel.todosimple.domain.usecases.TaskUseCases;
import com.joaomanoel.todosimple.domain.exceptions.task.DeleteTaskException;
import com.joaomanoel.todosimple.domain.exceptions.task.TaskNotEmptyIdException;
import com.joaomanoel.todosimple.domain.exceptions.task.TaskNotFoundException;
import com.joaomanoel.todosimple.domain.models.Customer;
import com.joaomanoel.todosimple.domain.models.Task;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService implements TaskUseCases {
    private final TaskRepository taskRepository;
    private final CustomerUseCases customerUseCases;

    public TaskService(TaskRepository taskRepository, CustomerUseCases customerUseCases) {
        this.taskRepository = taskRepository;
        this.customerUseCases = customerUseCases;
    }

    public Task findById(Long id){
        Optional<Task> task = this.taskRepository.findById(id);
        return task.orElseThrow(() -> new TaskNotFoundException(id));
    }

    public List<Task> findAllByCustomerId(UUID customerId){
        return this.taskRepository.findAllByCustomer_Id(customerId);
    }

    @Transactional
    public Long register(Task task){
        Customer customer = this.customerUseCases.findById(task.getCustomer().getId());
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
