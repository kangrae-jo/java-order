package order.view;

import java.util.List;
import order.model.Order;

public class OutputView {

    public void printOrderList(List<Order> orders) {
        System.out.println("[주문 내역]");
        for (Order order : orders) {
            System.out.println(order.toString());
        }
        System.out.println("총 주문 금액: ");
        System.out.println("배달비: ");
        System.out.println();
    }

    public void printService(int service) {
        System.out.println("[서비스]");
        System.out.println("서비스 만두 (" + service + "개)");
        System.out.println();
    }

    public void printTotalPrice(int totalPrice) {
        System.out.println("최종 결제 금액");
        System.out.println(totalPrice + "원");
        System.out.println();
    }

}
