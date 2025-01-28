package syntax;

public class DiscountService implements DiscountPolicy {
    @Override
    public int getDiscount(int price) {
        return (int) (price * 0.9);
    }
}
