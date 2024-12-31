package order.model;

public class DeliveryFeeCalculator {

    private static final int TOTAL_PRICE_UNDER_50_000 = 2_000;
    private static final int TOTAL_PRICE_UNDER_100_000 = 1_000;
    private static final int TOTAL_PRICE_OVER_100_000 = 0;

    public int calculateDeliveryFee(int totalPrice) {
        if (totalPrice < 50_000) {
            return TOTAL_PRICE_UNDER_50_000;
        }
        if (totalPrice < 100_000) {
            return TOTAL_PRICE_UNDER_100_000;
        }
        return TOTAL_PRICE_OVER_100_000;
    }
}
