package com.joaomanoel.todosimple.persistence.repositories;

import com.joaomanoel.todosimple.domain.models.Task;
import com.joaomanoel.todosimple.domain.repositories.TaskRepository;
import com.joaomanoel.todosimple.persistence.entities.JPATask;
import com.joaomanoel.todosimple.utils.TaskMappers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private final JPATaskRepository jpaTaskRepository;
    private final TaskMappers taskMappers;

    public TaskRepositoryImpl(JPATaskRepository jpaTaskRepository, TaskMappers taskMappers) {
        this.jpaTaskRepository = jpaTaskRepository;
        this.taskMappers = taskMappers;

    }


    @Override
    public Optional<Task> findById(Long id) {
        Optional<JPATask> jpaTask = this.jpaTaskRepository.findById(id);
        return jpaTask.map(this.taskMappers::entityToDomain);
    }

    @Override
    public List<Task> findAllByCustomer_Id(UUID customerId) {
        List<JPATask> jpaTasks = this.jpaTaskRepository.findAllByCustomer_Id(customerId);
        return jpaTasks.stream().map(this.taskMappers::entityToDomain).toList();
    }

    @Override
    public Task save(Task task) {
        JPATask jpaTask = this.jpaTaskRepository.save(this.taskMappers.domainToEntity(task));
        return this.taskMappers.entityToDomain(jpaTask);
    }

    @Override
    public void delete(Task task) {
        this.jpaTaskRepository.delete(this.taskMappers.domainToEntity(task));
    }
}
