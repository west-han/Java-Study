package mid2.collection.compare.test;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Card> cards = new ArrayList<>(5);
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void drawCard(Deck deck) {
        cards.add(deck.draw());
    }

    public int rankSum() {
        return cards.stream().mapToInt(Card::getNumber).sum();
    }

    public void showHand() {
        cards.sort(null);
        System.out.println(name + ": " + cards + ", 합계: " + rankSum());
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
