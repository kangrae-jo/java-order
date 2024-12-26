package order.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderMaker {

    public OrderMaker(){
    }

    public List<String> toOrders(String input) {
        return splitInput(input);
    }

    private List<String> splitInput(String input) {
        String regex = "\\s*,\\s*";
        String[] orders = input.split(regex);

        return new ArrayList<>(Arrays.asList(orders));
    }

}
