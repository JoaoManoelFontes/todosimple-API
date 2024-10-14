package com.joaomanoel.todosimple.controllers;

import com.joaomanoel.todosimple.DTOS.customer.ResponseCustomerDTO;
import com.joaomanoel.todosimple.DTOS.customer.ResponseRegisterCustomerDTO;
import com.joaomanoel.todosimple.models.Customer;
import com.joaomanoel.todosimple.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
@Validated
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseCustomerDTO> findById(@PathVariable UUID id){
        Customer customer = this.customerService.findById(id);
        return ResponseEntity.ok().body(new ResponseCustomerDTO(customer));
    }

    @PostMapping("/")
    @Validated(Customer.CreateCustomer.class)
    public ResponseEntity<ResponseRegisterCustomerDTO> register(@Valid @RequestBody Customer customer) {
        // Redirecionar para a rota de detalhar usuário:
        //URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            //.path("/{id}").buildAndExpand(this.customerService.register(customer)).toUri();
        return ResponseEntity.ok().body(new ResponseRegisterCustomerDTO(this.customerService.register(customer)));
    }

    @PutMapping("/{id}")
    @Validated(Customer.UpdateCustomer.class)
    public ResponseEntity<ResponseRegisterCustomerDTO> update(@Valid @PathVariable UUID id, @RequestBody Customer customer) {
        customer.setId(id);
        return ResponseEntity.ok().body(new ResponseRegisterCustomerDTO(this.customerService.update(customer)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        this.customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
