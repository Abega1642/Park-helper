package dev.razafindratelo.reviews;


import dev.razafindratelo.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class Review {
    private String content;
    private Customer author;
}
