package guru.springframework.reactivemongo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Customer entity representing the customer table in the database.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Customer {

    @Id
    private String id; // Primary Key with Auto-Increment

    private String firstName; // First name of the customer
    private String secondName; // Second name of the customer

    @CreatedDate
    private LocalDateTime createdDate; // Timestamp when the customer was created

    @LastModifiedDate
    private LocalDateTime lastModifiedDate; // Timestamp when the customer was last updated
}