package order.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderMaker {

    public List<Order> toOrders(String input) throws IllegalArgumentException {
        OrderValidator validator = new OrderValidator();
        List<String> inputs = splitInput(input);

        return inputs.stream()
                .map(temp -> {
                    Order order = new Order(temp);
                    validator.validate(order);
                    return order;
                })
                .toList();
    }

    private List<String> splitInput(String input) {
        String[] inputs = input.split(", ");

        return new ArrayList<>(Arrays.asList(inputs));
    }

}
