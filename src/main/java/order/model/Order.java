package order.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Order {

    private static final String MENU_AND_QUANTITY_REGEX = "^(\\S+)\\((\\d+)개\\)$";

    private final String menu;
    private int quantity;

    public Order(String order) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(MENU_AND_QUANTITY_REGEX);
        Matcher matcher = pattern.matcher(order);

        if (matcher.matches()) {
            this.menu = matcher.group(1);
            this.quantity = Integer.parseInt(matcher.group(2));
        } else {
            throw new IllegalArgumentException("올바르지않은 주문입니다.");
        }
    }

}