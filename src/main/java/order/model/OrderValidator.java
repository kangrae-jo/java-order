package order.model;

public class OrderValidator {

    public void validate(Order order) throws IllegalArgumentException {
        if (!isExistMenu(order)) {
            throw new IllegalArgumentException("존재하지 않는 메뉴입니다.");
        }
        if (!isLessThanTen(order)) {
            throw new IllegalArgumentException("한 번에 0 ~ 10개만 주문가능합니다.");
        }
        if (!isValidAmount(order)) {
            throw new IllegalArgumentException("최소 주문 금액은 30,000원 입니다.");
        }
        if (!isIncludeMenu(order)) {
            throw new IllegalArgumentException("음료만으로는 주문할 수 없습니다.");
        }
    }

    private boolean isExistMenu(Order order) {
        // 메뉴가 존재하는지 확인하는 로직
        return true;
    }

    private boolean isLessThanTen(Order order) {
        // 수량이 10 이하인지 확인하는 로직
        return true;
    }

    private boolean isValidAmount(Order order) {
        // 최소 주문 금액이 유효한지 확인하는 로직
        return true;
    }

    private boolean isIncludeMenu(Order order) {
        // 필수 메뉴가 포함되어 있는지 확인하는 로직
        return true;
    }
}
