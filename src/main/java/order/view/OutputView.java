package order.view;

import java.util.List;
import order.model.Order;

public class OutputView {

    public void printOrderList(List<Order> orders, int totalPrice, int deliveryPrice) {
        System.out.println("[주문 내역]");
        for (Order order : orders) {
            System.out.println(order.toString());
        }
        System.out.printf("총 주문 금액: %,d원\n", totalPrice);
        System.out.printf("배달비: %,d원\n", deliveryPrice);
        System.out.println();
    }

    public void printService(int service) {
        System.out.println("[서비스]");
        System.out.println("서비스 만두(" + service + "개)");
        System.out.println();
    }

    public void printTotalPrice(int totalPrice) {
        System.out.println("[최종 결제 금액]");
        System.out.printf("%,d원\n", totalPrice);
        System.out.println();
    }

}
