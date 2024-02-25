import dto.*;
import service.DeliveryRouteService;

import java.util.ArrayList;
import java.util.List;

public class Path {
    public static void main(String[] args) {

        DeliveryRouteService tc = new DeliveryRouteService();

        Customer c1 = new Customer(1, "C1", new GeoLocation(1,2));
        Customer c2 = new Customer(2, "C2", new GeoLocation(2,2));

        Restaurant r1 = new Restaurant(1, "R1", new GeoLocation(2, 3));
        Restaurant r2 = new Restaurant(2, "R2", new GeoLocation(8, 7));

        Order o1 = new Order(1, "O1",  c1, r1, 10);
        Order o2 = new Order(2, "O2",  c2, r2, 80);

        List<Order> orders = new ArrayList<>();
        orders.add(o1);
        orders.add(o2);

        DeliveryPartner aman = new DeliveryPartner(1, "Aman", new GeoLocation(0, 0), orders);



        String path = tc.findRoute(aman);

        System.out.print(path);
    }
}
