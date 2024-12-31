package order.model;

import java.util.List;

public class Orders {

    private final static int MIN_ORDER_AMOUNT = 30_000;
    private final List<Order> orders;

    public Orders(List<Order> orders) {
        this.orders = orders;
        validateOrders();
    }

    public int countMainMenu() {
        return (int) orders.stream()
                .filter(Order::isMain)
                .mapToLong(Order::getQuantity)
                .sum();
    }

    public long getTotalPrice() {
        return orders.stream()
                .mapToLong(Order::getPrice)
                .sum();
    }

    public List<Order> getOrders() {
        return orders;
    }

    private void validateOrders() {
        for (Order order : orders) {
            if (!isExistMenu(order)) {
                throw new IllegalArgumentException("존재하지 않는 메뉴입니다.");
            }
            if (!isLessThanTen(order)) {
                throw new IllegalArgumentException("한 번에 0 ~ 10개만 주문 가능합니다.");
            }
        }
        if (!isValidAmount()) {
            throw new IllegalArgumentException("주문 최소 금액을 만족하지 못했습니다.");
        }
        if (isOnlyDrink()) {
            throw new IllegalArgumentException("음료만으로는 주문할 수 없습니다.");
        }
    }

    private boolean isExistMenu(Order order) {
        return order.isExistMenu();
    }

    private boolean isLessThanTen(Order order) {
        return order.isLessThanTen();
    }

    private boolean isValidAmount() {
        return getTotalPrice() >= MIN_ORDER_AMOUNT;
    }

    private boolean isOnlyDrink() {
        return orders.stream().allMatch(Order::isDrink);
    }
}
