package dev.razafindratelo.places.hotel;

import dev.razafindratelo.reviews.RoomReview;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Room {
    private String roomId;
    private double pricePerNight;
    private List<RoomReview> roomReviews;

    public Room(String roomId, double pricePerNight) {
        this.roomId = roomId;
        this.pricePerNight = pricePerNight;
        this.roomReviews = new ArrayList<>();
    }
}
