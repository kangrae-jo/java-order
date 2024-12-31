package order.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderMaker {

    private static final String MENU_NAME_AND_QUANTITY_REGEX = "([가-힣\\s]+)\\((\\d+)개\\)";

    public List<Order> toOrders(String input) {
        return splitInput(input).stream()
                .map(this::createOrder)
                .toList();
    }

    private List<String> splitInput(String input) {
        String[] inputs = input.split(", ");
        return new ArrayList<>(Arrays.asList(inputs));
    }

    // 문자열을 Order 객체로 변환
    private Order createOrder(String orderStr) {
        Pattern pattern = Pattern.compile(MENU_NAME_AND_QUANTITY_REGEX);
        Matcher matcher = pattern.matcher(orderStr);

        if (matcher.matches()) {
            return new Order(matcher.group(1), Integer.parseInt(matcher.group(2)));
        }
        throw new IllegalArgumentException("올바르지 않은 주문 형식입니다.");
    }
}
