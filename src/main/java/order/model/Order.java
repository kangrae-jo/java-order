package order.model;

import order.constant.Menu;

public class Order {

    private final String name;
    private final int quantity;

    public Order(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
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

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("%s(%d개): %,d원", name, quantity, getPrice());
    }
}