package dev.razafindratelo.comments;


import dev.razafindratelo.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class Comment {
    private String content;
    private Customer author;
}
