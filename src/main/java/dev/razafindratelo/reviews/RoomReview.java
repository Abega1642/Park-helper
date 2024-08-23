package dev.razafindratelo.reviews;

import dev.razafindratelo.customer.Customer;
import dev.razafindratelo.places.hotel.Room;

public class RoomReview extends Review {
    private Room commentedRoom;
    public RoomReview(String content, Customer author, Room commentedRoom) {
        super(content, author);
        this.commentedRoom = commentedRoom;

    }
}
