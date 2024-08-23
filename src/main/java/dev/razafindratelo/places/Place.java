package dev.razafindratelo.places;


import lombok.Data;

import java.awt.geom.Point2D;

@Data
public abstract class Place {
    private String name;
    private Point2D coordinates;
    private String description;

    public Place(String name, double latitude, double longitude,String description) {
        this.name = name;
        this.coordinates = new Point2D.Double(latitude, longitude);
        this.description = description;
    }
}
