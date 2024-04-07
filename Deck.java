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
        for (Card card : deckOfCards){
           fullDeck += "\n" + card.toString();
        }
        return fullDeck;
    }
    public void removeCard(int i){
        this.deckOfCards.remove(i);
    }

    public void resetHand(Deck handToReset){
        int thisDeckSize = this.deckOfCards.size();
        for (int i = 0; i < thisDeckSize; i++){
            handToReset.addCard(this.getCard(i));
        }
        for (int i = 0; i < thisDeckSize; i++){
            this.removeCard(0);
        }
    }

    public Card getCard(int i){
        return this.deckOfCards.get(i);
    }

    public void addCard(Card addCard){
        this.deckOfCards.add(addCard);
    }

    public void draw(Deck deckToDrawFrom){
        this.deckOfCards.add(deckToDrawFrom.getCard(0));
        deckToDrawFrom.removeCard(0);
    }

    public int deckSize(){
        return this.deckOfCards.size();
    }

    public int cardsValue(){
        int totalValueOfCards = 0;
        int acesInHand = 0;

        for (Card aCard : this.deckOfCards){
            switch(aCard.getCardValue()){
                case TWO:
                    totalValueOfCards += 2;
                    break;
                case THREE:
                    totalValueOfCards += 3;
                    break;
                case FOUR:
                    totalValueOfCards += 4;
                    break;
                case FIVE:
                    totalValueOfCards += 5;
                    break;
                case SIX:
                    totalValueOfCards += 6;
                    break;
                case SEVEN:
                    totalValueOfCards += 7;
                    break;
                case EIGHT:
                    totalValueOfCards += 8;
                    break;
                case NINE:
                    totalValueOfCards += 9;
                    break;
                case TEN, JACK, QUEEN, KING:
                    totalValueOfCards += 10;
                    break;
                case ACE:
                    acesInHand += 1;
                    break;
            }
        }
        for (int i = 0; i < acesInHand;i++){
            if (totalValueOfCards > 10){
                totalValueOfCards += 1;
            } else {
                totalValueOfCards += 11;
            }
        }
        return totalValueOfCards;
    }
}
