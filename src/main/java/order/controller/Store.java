package order.controller;

import java.util.List;
import order.model.DeliveryFeeCalculator;
import order.model.Order;
import order.model.OrderMaker;
import order.model.Orders;
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
        Orders orders = getOrders();
        int service = orders.countMainMenu();
        long totalPrice = orders.getTotalPrice();
        int deliveryFee = getDeliveryFee(totalPrice);

        printBills(orders, deliveryFee, service, totalPrice);
    }

    private Orders getOrders() {
        String input = inputView.readInput();

        OrderMaker orderMaker = new OrderMaker();
        List<Order> orders = orderMaker.toOrders(input);

        return new Orders(orders);
    }

    private int getDeliveryFee(long totalPrice) {
        DeliveryFeeCalculator deliveryFeeCalculator = new DeliveryFeeCalculator();

        return deliveryFeeCalculator.calculateDeliveryFee(totalPrice);
    }

    private void printBills(Orders orders, int deliveryFee, int service, long totalPrice) {
        outputView.printOrderList(orders, totalPrice, deliveryFee);
        outputView.printService(service);
        outputView.printTotalPrice(totalPrice + deliveryFee);
    }
}
