package com.joaomanoel.todosimple.domain.models;

import com.joaomanoel.todosimple.persistence.entities.JPACustomer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

public class Task {
    private Long id;
    private Customer customer;
    private String title;

    private String description;

    public Task(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Task(Long id, Customer customer, String title, String description) {
        this.id = id;
        this.customer = customer;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", customerId=" + customer.getId() +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
