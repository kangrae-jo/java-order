package order.constant;

import static order.constant.MenuType.DRINK;
import static order.constant.MenuType.MAIN;
import static order.constant.MenuType.SIDE;

import java.util.Arrays;

public enum Menu {
    // 메인
    PIZZA("피자", 25_000, MAIN),
    HAMBURGER("햄버거", 10_000, MAIN),
    CHICKEN("치킨", 23_000, MAIN),

    // 사이드
    FRENCH_FRIES("감자튀김", 5_000, SIDE),
    CHEESE_STICK("치즈스틱", 7_000, SIDE),
    SALAD("샐러드", 8_000, SIDE),

    // 음료
    COLA("콜라", 2_000, DRINK),
    ZERO_COLA("제로 콜라", 2_500, DRINK),
    ORANGE_JUICE("오렌지 주스", 3_000, DRINK);

    private final String name;
    private final int price;
    private final MenuType menuType;

    Menu(final String name, final int price, final MenuType menuType) {
        this.name = name;
        this.price = price;
        this.menuType = menuType;
    }

    public static boolean isMenuName(String name) {
        return Arrays.stream(Menu.values())
                .anyMatch(menu -> menu.name.equals(name));
    }

    public static int getPriceByName(String name) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다."))
                .price;
    }

    public boolean matchesName(String menuName) {
        return this.name.equals(menuName);
    }

    public boolean isDrink() {
        return this.menuType == MenuType.DRINK;
    }

    public static boolean isDrink(String menuName) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.matchesName(menuName))
                .anyMatch(Menu::isDrink);
    }

    public static Menu getMenuByName(String name) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다."));
    }

    public boolean isMain() {
        return this.menuType == MenuType.MAIN;
    }

}
