package com.joaomanoel.todosimple.http.DTOS.task;

import com.joaomanoel.todosimple.domain.models.Customer;
import com.joaomanoel.todosimple.http.DTOS.customer.ResponseCustomerDTO;
import com.joaomanoel.todosimple.persistence.entities.JPACustomer;
import com.joaomanoel.todosimple.domain.models.Task;
import com.joaomanoel.todosimple.utils.CustomerMapper;

public record ResponseTaskDTO(
        Long id,
        String title,
        String description,
        ResponseCustomerDTO customer
) {
    public ResponseTaskDTO(Task task){
        this(task.getId(), task.getTitle(), task.getDescription(), new ResponseCustomerDTO(task.getCustomer()));
    }
}
