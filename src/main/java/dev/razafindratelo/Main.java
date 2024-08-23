package dev.razafindratelo;

import dev.razafindratelo.places.hotel.Hotel;
import dev.razafindratelo.places.park.Park;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel(
                "HOTEL 1",
                15.25,
                158.2,
                "First hotel",
                "phoneNUmber",
                "email@email.com",
                null,
                null
        );
        Park park = new Park(
                "PARK 1",
                100.00,
                1536.5,
                "First Park",
                null
        );
    }
}