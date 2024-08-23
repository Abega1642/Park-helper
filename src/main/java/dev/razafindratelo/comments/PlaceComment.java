package dev.razafindratelo.comments;

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
public class PlaceComment extends Comment {
    private Place commentedPlace;

    public PlaceComment(String content, Customer author, Place commentedPlace) {
        super(content, author);
        this.commentedPlace = commentedPlace;
    }
}
