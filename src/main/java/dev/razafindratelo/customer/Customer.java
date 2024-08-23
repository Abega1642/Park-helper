package dev.razafindratelo.customer;

import dev.razafindratelo.places.Place;
import dev.razafindratelo.places.hotel.Hotel;
import dev.razafindratelo.places.hotel.Room;
import dev.razafindratelo.reviews.PlaceReview;
import dev.razafindratelo.reviews.Review;
import dev.razafindratelo.reviews.RoomReview;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;


    /**
     * Here is the implementation of the addReview Methods for all of its signatures
     */


    // addReview with a predefined review for a place (might be a hotel or a park)

    public Review addReview(PlaceReview review) {
        List<PlaceReview> placeReviews = review.getCommentedPlace().getReviews();
        placeReviews.add(review);
        review.getCommentedPlace().setReviews(placeReviews);
        return review;
    }

    // addReview to a precised place (might be a hotel or a park) by the description of the review

    public Review addReview(String description, Place place) {
        List<PlaceReview> reviewsList = place.getReviews();
        PlaceReview review = new PlaceReview(description, this, place);
        reviewsList.add(review);
        place.setReviews(reviewsList);
        return review;
    }

    // addReview to a room of a hotel with a predefined RoomReview

    public Review addReview(Hotel hotel, RoomReview roomReview) {
        List<RoomReview> roomReviews = roomReview.getCommentedRoom().getRoomReviews();
        roomReviews.add(roomReview);
        roomReview.getCommentedRoom().setRoomReviews(roomReviews);
        return roomReview;
    }

    // addReview to a room of a hotel by the description.

    public Review addReview(String description, Hotel hotel, Room room) {
        List<RoomReview> roomReviews = room.getRoomReviews();
        RoomReview review = new RoomReview(description, this, room);
        roomReviews.add(review);
        room.setRoomReviews(roomReviews);
        return review;
    }

    /**
     *  Here is the implementation of the getAllReviews method
     */

    public List<Review> getAllReviews() {
        List<Review> reviews = new ArrayList<>();
        return null;
    }

}
