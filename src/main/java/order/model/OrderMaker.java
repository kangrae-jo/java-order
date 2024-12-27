package order.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderMaker {

    public List<Order> toOrders(String input) throws IllegalArgumentException {
        OrderValidator validator = new OrderValidator();

        List<Order> orders = splitInput(input).stream()
                .map(Order::new)
                .toList();

        validator.ordersCheck(orders);
        return orders;
    }

    private List<String> splitInput(String input) {
        String[] inputs = input.split(", ");

        return new ArrayList<>(Arrays.asList(inputs));
    }

}
