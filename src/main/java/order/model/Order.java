package order.model;

import order.constant.Menu;

public class Order {

    private final static int MAX_POSSIBLE_ORDER_QUANTITY = 10;
    private final String name;
    private final int quantity;

    public Order(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public boolean isMain() {
        return Menu.getMenuByName(name).isMain();
    }

    // validate logic
    public boolean isExistMenu() {
        return Menu.isMenuName(name);
    }

    public boolean isLessThanTen() {
        return quantity <= MAX_POSSIBLE_ORDER_QUANTITY;
    }

    public int getPrice() {
        return Menu.getPriceByName(name) * quantity;
    }

    public boolean isDrink() {
        return Menu.isDrink(name);
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("%s(%d개): %,d원", name, quantity, getPrice());
    }
}
