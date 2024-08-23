package dev.razafindratelo.customer;

import dev.razafindratelo.map.Map;
import dev.razafindratelo.places.Place;
import dev.razafindratelo.places.hotel.Hotel;
import dev.razafindratelo.places.hotel.Room;
import dev.razafindratelo.places.park.Park;
import dev.razafindratelo.reviews.PlaceReview;
import dev.razafindratelo.reviews.Review;
import dev.razafindratelo.reviews.RoomReview;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.ArrayList;
import java.util.Comparator;
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

        review.getCommentedPlace()
                .setScore(review.getCommentedPlace().getScore() + review.getScore());

        review.getCommentedPlace().setReviews(placeReviews);
        return review;
    }

    // addReview to a precised place (might be a hotel or a park) by the description of the review

    public Review addReview(String description,  int score, Place place) {
        List<PlaceReview> reviewsList = place.getReviews();
        PlaceReview review = new PlaceReview(description, this, place);
        reviewsList.add(review);

        place.setScore(place.getScore() + score);

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

    public Review addReview(String description, int score, Hotel hotel, String roomId) {
        Room room = hotel.getRooms().stream().filter(r -> r.getRoomId() == roomId).findFirst().get();

        List<RoomReview> roomReviews = room.getRoomReviews();

        RoomReview review = new RoomReview(description, this, room);
        room.setScore(room.getScore() + score);
        roomReviews.add(review);
        room.setRoomReviews(roomReviews);
        return review;
    }

    /**
     *  Here is the implementation of the getAllReviews method
     */

    public List<Review> getAllReviews(Map map) {
        List<Review> reviews = new ArrayList<>();
        for (Place place : map.getPlaces()) {
            reviews.addAll(place.getReviews());
            if (place instanceof Hotel hotel) {

                List<RoomReview> roomReviews = new ArrayList<>();
                List<List<RoomReview>> roomReviewsList = hotel.getRooms()
                        .stream().map(Room::getRoomReviews)
                        .toList();
                roomReviewsList.forEach(roomReviews::addAll);
                reviews.addAll(roomReviews);
            }
        }
        return reviews;
    }

    /**
     *  Here is the implementation of the findBestHotel method
     */

    public Hotel findBestHotel(Map map) {
        List<Hotel> hotels = new ArrayList<>();

        for (Place place : map.getPlaces()) {
            if (place instanceof Hotel hotel) {
                hotels.add(hotel);
            }
        }

        hotels.sort(Comparator.comparing(hotel -> hotel.getParksAround().size()));
        return hotels.getLast();
    }

    /**
     *  Here is the implementation of the getAllPlacesInside method
     */

    public List<Place> getAllPlacesInside(
            double minLongitude,
            double maxLongitude,
            double minLatitude,
            double maxLatitude,
            Map map
    ) {
        List<Place> places = new ArrayList<>();

        for (Place place : map.getPlaces()) {
            if ( (place.getCoordinates().getX() >= minLongitude
                    && place.getCoordinates().getX() <= maxLongitude)
                && (place.getCoordinates().getY() >= minLatitude
                    && place.getCoordinates().getY() <= maxLatitude)
            ) {
                places.add(place);
            }
        }
        return places;
    }

    /**
     *  Here is the implementation of the findCheapestHotelPrice
     */

    public double findCheapestHotelPrice(List<Park> parks) {
        List<Hotel> hotels = new ArrayList<>();
        List<List<Hotel>> hotelsList = parks
                .stream()
                .map(Park::getHotels)
                .toList();

        hotelsList.forEach(hotels::addAll);

        hotels.sort(
                Comparator.comparingDouble(
                        hotel -> getTheCheapestRoom(hotel)
                                .getPricePerNight())
        );

        return getTheCheapestRoom(hotels.getFirst()).getPricePerNight();
    }

    // this static method gets the cheapest room in a hotel
    private static Room getTheCheapestRoom(Hotel hotels) {
        List<Room> rooms = hotels.getRooms();
        rooms.sort(Comparator.comparingDouble(Room::getPricePerNight));
        return rooms.getFirst();
    }

    /**
     *  Here is the implementation of the getAllReviewedItems method
     */

    public List<Object> getAllReviewedItems (Map map) {
        List<Object> reviewedItems = new ArrayList<>();
        List<Place> places = map.getPlaces()
                .stream()
                .filter(place -> !place.getReviews().isEmpty())
                .toList();
        List<Room> rooms = new ArrayList<>();
        for (Place place : places) {
            if (place instanceof Hotel hotel) {
                List<Room> roomsReviewedByEachHotel = hotel.getRooms()
                        .stream()
                        .filter(room -> !room.getRoomReviews().isEmpty())
                        .toList();
                rooms.addAll(roomsReviewedByEachHotel);
            }
        }
        reviewedItems.addAll(rooms);
        reviewedItems.addAll(places);

        return reviewedItems;
    }
}
