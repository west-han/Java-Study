package mid1.review.lang;

class MutableObj {
    private int value;
    public MutableObj(int value) {
        this.value = value;
    }
    public int addValue(int value) {
        this.value += value;
        return value;
    }

    public int getValue() {
        return value;
    }
}

class ImmutableObj {
    private final int value;

    public ImmutableObj(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public ImmutableObj addValue(int value) {
        return new ImmutableObj(this.value + value);
    }
}

public class Immutable {
    public static void main(String[] args) {
        MutableObj m1 = new MutableObj(1);
        MutableObj m2 = m1;
        System.out.println("m1 = " + m1.getValue());
        System.out.println("m2 = " + m2.getValue());
        m1.addValue(2);
        System.out.println("m1 = " + m1.getValue());
        System.out.println("m2 = " + m2.getValue());

        ImmutableObj i1 = new ImmutableObj(1);
        ImmutableObj i2 = i1;
        System.out.println("i1 = " + i1.getValue());
        System.out.println("i2 = " + i2.getValue());
        i1 = i1.addValue(2);
        System.out.println("i1 = " + i1.getValue());
        System.out.println("i2 = " + i2.getValue());
    }
}
