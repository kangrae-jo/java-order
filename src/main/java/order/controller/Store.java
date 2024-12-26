package order.controller;

import java.util.List;
import order.model.OrderMaker;
import order.view.InputView;
import order.view.OutputView;

public class Store {

    private final InputView inputView;
    private final OutputView outputView;

    public Store(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    // 받은 orders 로부터 menu 객체 생성
    public void getMenus() {

    }

    // split하고 검증
    // TODO: 일급리스트 적용하기
    private List<String> getOrders() {
        OrderMaker orderMaker = new OrderMaker();
        List<String> orders;
        String input = "";

        while (true) {
            input = inputView.readInput();
            orders = orderMaker.toOrders(input);
            try {
                if (validateOrders(orders)) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return orders;
    }
    
    // TODO: 검증 로직 분리하기
    boolean validateOrders(List<String> orders) {
        // 존재하는 메뉴가 맞는지
        // 메뉴가 각각 0 ~ 10개가 맞는지
        // 최소 주문금액 30,000원 이상이 맞는지'
        // 음료만으로 주문하지 않는 것이 맞는지
        return true;
    }

}
