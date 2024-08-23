package dev.razafindratelo.reviews;


import dev.razafindratelo.customer.Customer;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public abstract class Review {
    private String content;
    private Customer author;
    private int score;
    private List<PlaceReview> reviews;

    public Review(String content, Customer author) {
        this.content = content;
        this.author = author;
        this.score = 0;
        this.reviews = new ArrayList<>();
    }
}
