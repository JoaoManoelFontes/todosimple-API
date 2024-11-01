package com.joaomanoel.todosimple.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = Task.TABLE_NAME)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Task {
    public static final String TABLE_NAME = "task";

    @Column(unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, updatable = false)
    private Customer customer;

    @Column
    @Size(min = 4, max = 50, message = "O título deve ter entre 4 e 50 caracteres.")
    @NotNull
    private String title;

    @Column
    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres.")
    @NotNull
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return Objects.equals(id, task.id) && Objects.equals(customer, task.customer) && Objects.equals(title, task.title) && Objects.equals(description, task.description);
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
