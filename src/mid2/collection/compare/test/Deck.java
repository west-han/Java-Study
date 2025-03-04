package mid2.collection.compare.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private static final List<Card> cards = new ArrayList<>(52);
    private static final Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    public Deck() {
        initCard();
        shuffle();
    }

    private void shuffle() {
        Collections.shuffle(cards);
    }

    private void initCard() {
        for (Suit suit : Suit.values()) {
            for (Integer number : numbers) {
                cards.add(new Card(suit, number));
            }
        }
    }

    public Card draw() {
        return cards.removeFirst();
    }
}
