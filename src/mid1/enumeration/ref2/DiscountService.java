package mid1.enumeration.ref2;

public class DiscountService {

    public int discount(Grade grade, int price) {

        return (int) (price * grade.getDiscountPercent() / 100);
    }
}
