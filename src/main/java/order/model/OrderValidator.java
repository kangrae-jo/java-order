package order.model;

import java.util.List;
import order.constant.Menu;

public class OrderValidator {

    public void ordersCheck(List<Order> orders) throws IllegalArgumentException {
        for (Order order : orders) {
            if (!isExistMenu(order)) {
                throw new IllegalArgumentException("존재하지 않는 메뉴입니다.");
            }
            if (!isLessThanTen(order)) {
                throw new IllegalArgumentException("한 번에 0 ~ 10개만 주문 가능합니다.");
            }
        }
        if (!isValidAmount(orders)) {
            throw new IllegalArgumentException("주문 최소 금액은 30,000원 입니다.");
        }
        if (isOnlyDrink(orders)) {
            throw new IllegalArgumentException("음료만으로는 주문할 수 없습니다.");
        }
    }

    private boolean isExistMenu(Order order) {
        return Menu.isMenuName(order.getName());
    }

    private boolean isLessThanTen(Order order) {
        return order.isLessThanTen();
    }

    private boolean isValidAmount(List<Order> orders) {
        int totalAmount = orders.stream()
                .mapToInt(order -> Menu.getPriceByName(order.getName()) * order.getQuantity())
                .sum();
        return totalAmount >= 30_000;
    }

    private boolean isOnlyDrink(List<Order> orders) {
        return orders.stream()
                .allMatch(Order::isDrink);
    }
}
