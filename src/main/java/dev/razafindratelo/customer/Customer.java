package dev.razafindratelo.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

}
