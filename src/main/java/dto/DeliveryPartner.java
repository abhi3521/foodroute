package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class DeliveryPartner {
    private int id;
    private String name;
    private GeoLocation partnerLocation;
    private List<Order> orders;

}
