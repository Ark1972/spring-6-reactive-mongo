package guru.springframework.reactivemongo.mappers;

import guru.springframework.reactivemongo.domain.Customer;
import guru.springframework.reactivemongo.model.CustomerDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * Maps between Customer entity and CustomerDTO.
 */
@Mapper
@Component

public interface CustomerMapper {

    // Map CustomerDTO to Customer entity
    Customer customerDtoToCustomer(CustomerDTO customerDTO);

    // Map Customer entity to CustomerDTO
    CustomerDTO customerToCustomerDto(Customer customer);
}