package dev.razafindratelo.places.hotel;

import dev.razafindratelo.reviews.Review;
import dev.razafindratelo.places.Place;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Hotel extends Place {
    private String phoneNumber;
    private String email;
    private long score;
    private List<Review> reviews;

    public Hotel(
            String name,
            double latitude,
            double longitude,
            String description
    ) {
        super(name, latitude, longitude, description);
    }

}
