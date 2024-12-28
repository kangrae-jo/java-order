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
        long service = countMainMenu(orders);
        int totalPrice = getTotalPrice(orders);
        // printBills(orders, service, totalPrice);
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

    private long countMainMenu(List<Order> orders) {
        return orders.stream()
                .filter(Order::isMain)
                .mapToLong(Order::getQuantity)
                .sum();
    }

    private int getTotalPrice(List<Order> orders) {
        return orders.stream()
                .mapToInt(Order::getAmount)
                .sum();
    }

    private void printBills(List<Order> orders, int service, int totalPrice) {
        outputView.printOrderList(orders);
        outputView.printService(service);
        outputView.printTotalPrice(totalPrice);
    }


}
