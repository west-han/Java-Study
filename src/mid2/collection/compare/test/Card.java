package mid2.collection.compare.test;

import org.jetbrains.annotations.NotNull;

public class Card implements Comparable<Card> {
    private Suit suit;
    private int number;

    public Card(Suit suit, int number) {
        this.suit = suit;
        this.number = number;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(@NotNull Card o) {
        if (this.number != o.number) {
            return this.number - o.number;
        } else {
            return this.suit.compareTo(o.suit);
        }
    }

    @Override
    public String toString() {
        return number + "(" + suit.getIcon() + ")";
    }
}
