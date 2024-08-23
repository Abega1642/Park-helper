package dev.razafindratelo.reviews;

import dev.razafindratelo.customer.Customer;
import dev.razafindratelo.places.Place;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PlaceReview extends Review {
    private Place commentedPlace;

    public PlaceReview(String content, Customer author, Place commentedPlace) {
        super(content, author);
        this.commentedPlace = commentedPlace;
    }
}
