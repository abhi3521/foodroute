package dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Order {
    private int id;
    private String name;
    private Customer customer;
    private Restaurant restaurant;
    private double prepTime;
}
