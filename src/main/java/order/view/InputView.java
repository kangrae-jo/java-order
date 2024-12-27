package order.view;

import order.utill.Console;

public class InputView {

    public String readInput() {
        System.out.println("주문하실 메뉴와 수량을 입력해 주세요. ex) 피자(2개), 감자튀김(1개), 콜라(3개)");
        String input;
        while (true) {
            input = Console.readLine();
            try {
                validateInput(input);
                break;
            } catch (Exception e) {
                System.out.println("[ERROR]: " + e.getMessage());
            }
        }
        return input;
    }

    private boolean validateInput(String input) throws IllegalArgumentException {
        String regex = "^(\\S+\\(\\d+개\\))(, \\S+\\(\\d+개\\))*$";
        if (input.matches(regex)) {
            return true;
        } else {
            throw new IllegalArgumentException("주문 형식이 잘못되었습니다.");
        }
    }
}
