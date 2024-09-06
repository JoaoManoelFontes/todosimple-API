package com.joaomanoel.todosimple.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
    @Min(value = 1, message = "O título deve ter no mínimo 1 caractére")
    @Max(value = 50, message = "O título deve ter no máximo 50 caractére")
    private String title;

    @Column
    @Max(value = 255, message = "A descrição deve ter no máximo 255 caractéres")
    @NotNull
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return Objects.equals(id, task.id) && Objects.equals(customer, task.customer) && Objects.equals(title, task.title) && Objects.equals(description, task.description);
    }
}
