package order.view;

import order.model.Order;
import order.model.Orders;

public class OutputView {

    public void printOrderList(Orders orders, int totalPrice, int deliveryPrice) {
        System.out.println("[주문 내역]");
        for (Order order : orders.getOrders()) {
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
