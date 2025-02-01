package bibleofjava.syntax;

public class TenderService {
    private final DiscountPolicy discountService;
    private int data;
    public TenderService(DiscountPolicy discountService) {
        this.discountService = discountService;
    }

    public boolean processTender(TenderService this, int price) {

        int tenderPrice = discountService.getDiscount(price);
        // 결제 처리 코드

        return true;
    }
}


class TenderController {
    public static void main(String[] args) {
        TenderService tenderService = new TenderService(new DiscountService());
    }
}