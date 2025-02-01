package bibleofjava.syntax;

public class FixedAmountDiscountService extends DiscountService {
    @Override
    public int getDiscount(int price) {
        return price - 1000;
    }
}
