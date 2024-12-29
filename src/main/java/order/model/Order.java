package order.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import order.constant.Menu;

public class Order {

    private static final String MENU_AND_QUANTITY_REGEX = "([가-힣\\s]+)\\((\\d+)개\\)";
    
    private final String name;
    private final int quantity;

    public Order(String order) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(MENU_AND_QUANTITY_REGEX);
        Matcher matcher = pattern.matcher(order);

        if (matcher.matches()) {
            this.name = matcher.group(1);
            this.quantity = Integer.parseInt(matcher.group(2));
        } else {
            throw new IllegalArgumentException("올바르지않은 주문입니다.");
        }
    }

    public boolean isLessThanTen() {
        return quantity <= 10;
    }

    public boolean isDrink() {
        return Menu.isDrink(name);
    }

    public boolean isMain() {
        return Menu.getMenuByName(name).isMain();
    }

    public int getPrice() {
        return Menu.getPriceByName(name) * quantity;
    }

    @Override
    public String toString() {
        return String.format("%s(%d개): %,d원", name, quantity, getPrice());
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
