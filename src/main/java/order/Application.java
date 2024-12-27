package order;

import order.controller.Store;
import order.view.InputView;
import order.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Store store = new Store(new InputView(), new OutputView());
        // 1. 메뉴 받기
        store.getOrders();

        // 2. 주문 내역 출력

        // 3. 서비스 출력

        // 4. 최종 금액 출력

    }
}
