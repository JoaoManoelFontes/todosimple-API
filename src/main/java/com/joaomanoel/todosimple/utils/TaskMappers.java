package com.joaomanoel.todosimple.utils;

import com.joaomanoel.todosimple.domain.models.Customer;
import com.joaomanoel.todosimple.domain.models.Task;
import com.joaomanoel.todosimple.http.DTOS.task.RequestRegisterTaskDTO;
import com.joaomanoel.todosimple.persistence.entities.JPATask;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class})
public interface TaskMappers {
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "customer", target = "customer"),
        @Mapping(source = "title", target = "title"),
        @Mapping(source = "description", target = "description")
    })
    Task entityToDomain(JPATask jpaTask);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "customer", target = "customer"),
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "description", target = "description")
    })
    JPATask domainToEntity(Task task);

    @Mappings({
            @Mapping(source = "customerId", target = "customer", qualifiedByName = "mapCustomerIdToCustomer"),
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "description", target = "description")
    })
    Task DTOToDomain(RequestRegisterTaskDTO taskDTO);

    @Named("mapCustomerIdToCustomer")
    default Customer mapCustomerIdToCustomer(UUID customerId) {
        Customer customer = new Customer();
        customer.setId(customerId);
        return customer;
    }
}
