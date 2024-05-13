package service;

import dto.*;

import java.util.*;

public class DeliveryRouteService {
    Haversine haversine = new Haversine();

    private static final double AVERAGE_SPEED = 20;


    private double calculateTime(GeoLocation location1, GeoLocation location2) {
        return (haversine.haversine(location1, location2) / AVERAGE_SPEED) * 60;   //Time in minute
    }

    public String findRoute(DeliveryPartner deliveryPartner) {
        List<Order> orderList = deliveryPartner.getOrders();
        StringBuilder path = new StringBuilder();
        int orderSize = orderList.size();

        while (!orderList.isEmpty()) {
            Order nearestOrder = findNearestOrder(deliveryPartner, orderList);
            double minTime = calculateTime(deliveryPartner.getPartnerLocation(), nearestOrder.getRestaurant().getRestaurantLocation())
                    + nearestOrder.getPrepTime();



            path.append(nearestOrder.getRestaurant().getName()).append(" -> ")
                    .append(nearestOrder.getCustomer().getName());

            if(orderSize-- > 1) {
                path.append(" -> ");
            }

            deliveryPartner.setPartnerLocation(nearestOrder.getCustomer().getCustomerLocation());
            orderList.remove(nearestOrder);

            for (Order order : orderList) {
                double time = calculateTime(deliveryPartner.getPartnerLocation(), order.getRestaurant().getRestaurantLocation())
                        + order.getPrepTime() - minTime;


                if (time < minTime) {
                    minTime = time;
                    order.setPrepTime(minTime);
                }
            }
        }

        return path.toString();
    }

    private Order findNearestOrder(DeliveryPartner deliveryPartner, List<Order> orderList) {
        double minTime = Double.MAX_VALUE;
        Order orderWithMinTime = null;

        for (Order order : orderList) {
            double time = calculateTime(deliveryPartner.getPartnerLocation(), order.getRestaurant().getRestaurantLocation()) + order.getPrepTime();
            if (time < minTime) {
                minTime = time;
                orderWithMinTime = order;
            }
        }

        return orderWithMinTime;
    }


}
