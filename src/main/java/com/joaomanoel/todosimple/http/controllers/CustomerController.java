package com.joaomanoel.todosimple.http.controllers;

import com.joaomanoel.todosimple.http.DTOS.ResponseBuilderDTO;
import com.joaomanoel.todosimple.http.DTOS.customer.RequestRegisterCustomerDTO;
import com.joaomanoel.todosimple.http.DTOS.customer.RequestUpdateCustomerDTO;
import com.joaomanoel.todosimple.http.DTOS.customer.ResponseCustomerDTO;
import com.joaomanoel.todosimple.http.DTOS.customer.ResponseRegisterCustomerDTO;
import com.joaomanoel.todosimple.domain.usecases.CustomerUseCases;
import com.joaomanoel.todosimple.http.handler.responses.ResponseBuilder;
import com.joaomanoel.todosimple.domain.models.Customer;
import com.joaomanoel.todosimple.utils.CustomerMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customer")
@Validated
public class CustomerController {
    private final CustomerUseCases customerUseCases;
    private final CustomerMapper customerMapper;

    public CustomerController(CustomerUseCases customerUseCases, CustomerMapper customerMapper) {
        this.customerUseCases = customerUseCases;
        this.customerMapper = customerMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBuilderDTO<ResponseCustomerDTO>> findById(@PathVariable UUID id){
        Customer customer = this.customerUseCases.findById(id);
        return ResponseBuilder.build("Customer found successfully", HttpStatus.OK, new ResponseCustomerDTO(customer));
    }

    @PostMapping("/")
    public ResponseEntity<ResponseBuilderDTO<ResponseRegisterCustomerDTO>> register(@Valid @RequestBody RequestRegisterCustomerDTO body) {
        Customer customer = this.customerMapper.RegisterDTOToDomain(body);
        ResponseRegisterCustomerDTO registerCustomerDTO = new ResponseRegisterCustomerDTO(this.customerUseCases.register(customer));
        return ResponseBuilder.build("Customer created successfully", HttpStatus.CREATED, registerCustomerDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBuilderDTO<ResponseRegisterCustomerDTO>> update(@Valid @RequestBody RequestUpdateCustomerDTO body, @PathVariable UUID id) {
        Customer customer = this.customerMapper.UpdateDTOToDomain(body);
        customer.setId(id);
        ResponseRegisterCustomerDTO registerCustomerDTO = new ResponseRegisterCustomerDTO(this.customerUseCases.update(customer));
        return ResponseBuilder.build("Customer updated successfully", HttpStatus.OK, registerCustomerDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBuilderDTO<Void>> delete(@PathVariable UUID id) {
        this.customerUseCases.delete(id);
        return ResponseBuilder.build("Customer deleted successfully", HttpStatus.NO_CONTENT, null);
    }
}
