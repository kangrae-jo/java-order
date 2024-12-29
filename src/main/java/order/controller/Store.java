package order.controller;

import java.util.List;
import order.model.Order;
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

    public void run() {
        List<Order> orders = getOrders();
        int service = countMainMenu(orders);
        int totalPrice = getTotalPrice(orders);
        int deliveryPrice = getDeliveryPrice(totalPrice);

        printBills(orders, deliveryPrice, service, totalPrice);
    }

    private List<Order> getOrders() {
        OrderMaker orderMaker = new OrderMaker();
        List<Order> orders;
        while (true) {
            try {
                String input = inputView.readInput();
                orders = orderMaker.toOrders(input);
                break;
            } catch (Exception e) {
                System.out.println("[ERROR]: " + e.getMessage());
            }
        }

        return orders;
    }

    private int countMainMenu(List<Order> orders) {
        return (int) orders.stream()
                .filter(Order::isMain)
                .mapToLong(Order::getQuantity)
                .sum();
    }

    private int getTotalPrice(List<Order> orders) {
        return orders.stream()
                .mapToInt(Order::getPrice)
                .sum();
    }

    private int getDeliveryPrice(int totalPrice) {
        if (totalPrice < 50_000) {
            return 2_000;
        }
        if (totalPrice < 100_000) {
            return 1_000;
        }
        return 0;
    }

    private void printBills(List<Order> orders, int deliveryPrice, int service, int totalPrice) {
        outputView.printOrderList(orders, totalPrice, deliveryPrice);
        outputView.printService(service);
        outputView.printTotalPrice(totalPrice + deliveryPrice);
    }


}
