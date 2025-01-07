package com.joaomanoel.todosimple.utils;

import com.joaomanoel.todosimple.domain.models.Customer;
import com.joaomanoel.todosimple.domain.models.Task;
import com.joaomanoel.todosimple.http.DTOS.customer.RequestRegisterCustomerDTO;
import com.joaomanoel.todosimple.http.DTOS.customer.RequestUpdateCustomerDTO;
import com.joaomanoel.todosimple.http.DTOS.customer.ResponseCustomerDTO;
import com.joaomanoel.todosimple.persistence.entities.JPACustomer;
import com.joaomanoel.todosimple.persistence.entities.JPATask;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mappings({
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password")
    })
    Customer RegisterDTOToDomain(RequestRegisterCustomerDTO dto);

    @Mappings({
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "password", target = "password")
    })
    Customer UpdateDTOToDomain(RequestUpdateCustomerDTO dto);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "email", target = "email")
    })
    ResponseCustomerDTO domainToDTO(Customer customer);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "tasks", target = "tasks"),
    })
    JPACustomer DomainToEntity(Customer customer);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "tasks", target = "tasks"),
    })
    Customer EntityToDomain(JPACustomer jpaCustomer);

    @IterableMapping(qualifiedByName = "withoutCustomer")
    List<Task> jPATaskListToTaskList(List<JPATask> jpaTasks);
    @Named("withoutCustomer")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "description", target = "description"),
            @Mapping(target = "customer", ignore = true)
    })
    Task jPATaskToTask(JPATask jpaTask);
}
