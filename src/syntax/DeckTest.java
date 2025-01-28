package syntax;

public class DeckTest {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Card c = deck.pick(0);
        System.out.println(c);

        deck.shuffle();
        c = deck.pick(0);
        System.out.println(c);
    }
}
