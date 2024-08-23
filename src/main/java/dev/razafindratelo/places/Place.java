package dev.razafindratelo.places;


import dev.razafindratelo.reviews.PlaceReview;
import lombok.Data;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;


@Data
public abstract class Place {
    private String name;
    private Point2D coordinates;
    private String description;
    private long score;
    private List<PlaceReview> reviews;

    public Place(String name, double latitude, double longitude,String description) {
        this.name = name;
        this.coordinates = new Point2D.Double(latitude, longitude);
        this.description = description;
        this.score = 0;
        this.reviews = new ArrayList<>();
    }
}
