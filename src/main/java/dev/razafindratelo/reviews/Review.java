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

    public Review(String content, Customer author, int score) {
        this.content = content;
        this.author = author;
        if (score < 0 || score > 5) {
            throw new IllegalArgumentException("Score must be between 0 and 5");
        } else {
            this.score = score;
        }
        this.reviews = new ArrayList<>();
    }
}
