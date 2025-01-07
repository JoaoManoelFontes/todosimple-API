package com.joaomanoel.todosimple.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = JPATask.TABLE_NAME)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JPATask {
    public static final String TABLE_NAME = "task";

    @Column(unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, updatable = false)
    private JPACustomer customer;

    @Column
    private String title;

    @Column
    private String description;

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

