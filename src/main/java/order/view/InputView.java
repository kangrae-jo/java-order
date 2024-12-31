package order.view;

import order.utill.Console;

public class InputView {

    public String readInput() {
        System.out.println("주문하실 메뉴와 수량을 입력해 주세요. ex) 피자(2개), 감자튀김(1개), 콜라(3개)");
        String input = Console.readLine();
        if (!validateInput(input)) {
            throw new IllegalArgumentException("주문 형식이 잘못되었습니다.");
        }
        Console.close();
        return input;
    }

    private boolean validateInput(String input) {
        String regex = "^([가-힣\\s]+\\(\\d+개\\))(, [가-힣\\s]+\\(\\d+개\\))*$";

        return input.matches(regex);
    }
}
