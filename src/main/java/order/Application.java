package order;

import order.controller.Store;
import order.view.InputView;
import order.view.OutputView;

public class Application {
    public static void main(String[] args) {

        Store store = new Store(new InputView(), new OutputView());
        store.getMenus();

    }
}
