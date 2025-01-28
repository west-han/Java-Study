package syntax;

public class Deck {
    final int CARD_NUM = 52;
    Card[] cardArr = new Card[CARD_NUM];

    public Deck() {
        int i = 0;

        for (CardTypes cardType : CardTypes.values()) {
            for (int k = 0; k < Card.NUM_MAX; k++) {
                cardArr[i++] = new Card(cardType, k+1);
            }
        }
    }

    Card pick(int index) {
        return cardArr[index];
    }

    Card pick() {
        return pick((int) (Math.random() * CARD_NUM));
    }

    void shuffle() {
        for (int i = 0; i < cardArr.length; i++) {
            int r = (int) (Math.random() * CARD_NUM);
            Card temp = cardArr[i];
            cardArr[i] = cardArr[r];
            cardArr[r] = temp;
        }
    }
}
