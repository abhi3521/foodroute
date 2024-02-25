package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Customer {
    private int id;
    private String name;
    private GeoLocation customerLocation;
}
