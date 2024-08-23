package dev.razafindratelo.comments;

import dev.razafindratelo.customer.Customer;
import dev.razafindratelo.places.hotel.Room;

public class RoomComment extends Comment {
    private Room commentedRoom;
    public RoomComment(String content, Customer author, Room commentedRoom) {
        super(content, author);
        this.commentedRoom = commentedRoom;

    }
}
