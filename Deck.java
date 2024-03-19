import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deckOfCards;

    final int MAX_CARDS_EACH_SUIT = 13;
    final int MAX_NUM_OF_SUIT = 4;

    public Deck(){

        this.deckOfCards = new ArrayList<Card>();
    }

    public void createDeck(){

        for(int i = 0; i < MAX_CARDS_EACH_SUIT; i++) {
            CardValue value = CardValue.values()[i];

            for (int s = 0; s < MAX_NUM_OF_SUIT; s++) {
                Card card = new Card(value, Suit.values()[s]);
                this.deckOfCards.add(card);
            }
        }
    }

    public void shuffleDeck(){

        Collections.shuffle(deckOfCards);
    }

    public String toString(){
        String fullDeck = "";
        int i = 0;

        for (Card card : deckOfCards){
           fullDeck += "\n" + i + " " + card.toString();
           i++;
        }
        return fullDeck;
    }
}
