package mid1.enumeration.ref1;

public class DiscountService {

    public int discount(ClassGrade grade, int price) {
        return (int) (price * grade.getDiscountPercent() / 100);
    }
}
