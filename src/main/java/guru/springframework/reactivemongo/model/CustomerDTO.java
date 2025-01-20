package guru.springframework.reactivemongo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Data Transfer Object for Customer entity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {

    private String id; // Primary Key
    private String firstName; // First name of the customer
    private String secondName; // Second name of the customer
    private LocalDateTime createdDate; // Timestamp when the customer was created
    private LocalDateTime lastModifiedDate; // Timestamp when the customer was last updated
}