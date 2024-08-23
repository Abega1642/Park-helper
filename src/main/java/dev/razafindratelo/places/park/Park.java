package dev.razafindratelo.places.park;

import dev.razafindratelo.places.Place;
import dev.razafindratelo.places.hotel.Hotel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;


@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Park extends Place {
    private List<Hotel> hotels;

    public Park(
            String name,
            double latitude,
            double longitude,
            String description,
            List<Hotel> hotels
    ) {
        super(name, latitude, longitude, description);
        this.hotels = hotels;
    }
}
