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

    public List<Order> getOrders() {
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

}
