package mid1.enumeration.ref2;

public enum Grade {
    BASIC(10), GOLD(20), DIAMOND(30); //생성자 호출 new 키워드, 참조값 할당 연산 등 생략

    private final int discountPercent;

    Grade(int discountPercent) { // private 생략
        this.discountPercent = discountPercent;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }
}
