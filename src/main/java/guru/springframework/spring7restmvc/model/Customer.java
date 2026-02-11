package guru.springframework.spring7restmvc.model;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class Customer {
    private UUID id;
    private String name;
    private int version;
    private Instant createdDate;
    private Instant updatedDate;
}
