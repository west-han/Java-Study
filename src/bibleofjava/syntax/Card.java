package bibleofjava.syntax;

public class Card {
    static final int KIND_MAX = 4;
    static final int NUM_MAX = 13;
    static final String[] NUMBERS = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private final CardTypes cardType;
    private final String number;

    Card(CardTypes cardType, int number) {
        this.cardType = cardType;
        this.number = NUMBERS[number];
    }

    Card() {
        this(CardTypes.SPADE, 1);
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardType=" + cardType.name() +
                ", number=" + this.number +
                '}';
    }
}
