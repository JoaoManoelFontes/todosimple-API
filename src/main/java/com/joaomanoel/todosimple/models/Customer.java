package com.joaomanoel.todosimple.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = Customer.TABLE_NAME)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {
    public interface CreateCustomer {
    }

    public interface UpdateCustomer {
    }

    public static final String TABLE_NAME = "customer";

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true)
    private UUID id;

    @Column()
    @NotBlank(groups = {CreateCustomer.class, UpdateCustomer.class}, message = "O username não deve ser vazio.")
    @Min(value = 4, groups = {CreateCustomer.class, UpdateCustomer.class}, message = "O username deve ter no mínimo 4 caractéres.")
    @Max(value = 50, groups = {CreateCustomer.class, UpdateCustomer.class}, message = "O username deve ter no máximo 50 caractéres.")
    private String username;

    @Column(unique = true)
    @Email(groups = {CreateCustomer.class}, message = "O Email deve ser válido.")
    private String email;

    @Column()
    @NotBlank(groups = {CreateCustomer.class, UpdateCustomer.class}, message = "A senha não deve ser vazia.")
    @Min(value = 8, groups = {CreateCustomer.class, UpdateCustomer.class}, message = "A senha deve ter no mínimo 4 caractéres.")
    @Max(value = 50, groups = {CreateCustomer.class, UpdateCustomer.class}, message = "A senha deve ter no máximo 50 caractéres.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(id, customer.id) && Objects.equals(username, customer.username) && Objects.equals(email, customer.email) && Objects.equals(password, customer.password);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
