package dev.razafindratelo;

import dev.razafindratelo.customer.Customer;
import dev.razafindratelo.map.Map;
import dev.razafindratelo.places.hotel.Hotel;
import dev.razafindratelo.places.hotel.Room;
import dev.razafindratelo.places.park.Park;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer Yangus = new Customer(
                "Yangus",
                "",
                "yangus@gmail.com",
                "15235"
        );

        Park park1 = new Park(
                "PARK 1",
                10.00,
                16.5,
                "First Park",
                null
        );

        Park park2 = new Park(
                "PARK 1",
                28.00,
                18.5,
                "First Park",
                null
        );

        Room room = new Room("R1", 150.0d);
        Room room2 = new Room("R2", 160.0d);
        Room room3 = new Room("R3", 170.0d);
        Room room4 = new Room("R4", 180.0d);
        Room room5 = new Room("R5", 190.0d);
        Room room6 = new Room("R6", 200.0d);

        Hotel hotel = new Hotel(
                "HOTEL 1",
                10.00,
                16.5,
                "First hotel",
                "phoneNUmber",
                "email@email.com",
                List.of(room, room2),
                List.of(park1, park2)
        );

        Hotel hotel2 = new Hotel(
                "HOTEL 2",
                15.25,
                12.2,
                "Second hotel",
                "phoneNumber",
                "email@email.com",
                List.of(room3, room4),
                List.of(park1)
        );

        Hotel hotel3 = new Hotel(
                "HOTEL 3",
                15.25,
                12.2,
                "Third hotel",
                "phoneNumber",
                "email@email.com",
                List.of(room5, room6),
                List.of(park2)
        );

        Map map = new Map(List.of(hotel, hotel2, hotel3, park1, park2));

        System.out.println(Yangus
                .getAllPlacesInside(15.25, 29, 12, 13, map));
        System.out.println(Yangus.getAllReviewedItems(map) + " --");
        System.out.println(Yangus.findBestHotel(map) + " best hotel");
        System.out.println(Yangus.findCheapestHotelPrice(List.of(park1, park2)) + " cheapest price--");
    }
}