package dev.razafindratelo.map;

import dev.razafindratelo.places.Place;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Data
@ToString
public class Map {
    private List<Place> places;
}
