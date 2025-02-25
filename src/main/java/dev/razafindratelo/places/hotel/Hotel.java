package dev.razafindratelo.places.hotel;

import dev.razafindratelo.places.park.Park;
import dev.razafindratelo.reviews.Review;
import dev.razafindratelo.places.Place;
import lombok.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Hotel extends Place {
    private String phoneNumber;
    private String email;
    private List<Room> rooms;
    private List<Park> parksAround;

    public Hotel(
            String name,
            double latitude,
            double longitude,
            String description,
            String phoneNumber,
            String email,
            List<Room> rooms,
            List<Park> parksAround
    ) {
        super(name, latitude, longitude, description);
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.rooms = rooms;
        this.parksAround = parksAround;
    }

}
