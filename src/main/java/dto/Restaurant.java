package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Restaurant {
    private int id;
    private String Name;
    private GeoLocation restaurantLocation;
}
