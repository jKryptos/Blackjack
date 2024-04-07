public class Card {

    private Suit suit;
    private CardValue cardValue;

    public Card(CardValue cardValue, Suit suit){
        this.suit = suit;
        this.cardValue = cardValue;
    }
    public Suit getSuit(){
        return suit;
    }
    public CardValue getCardValue() {
        return cardValue;
    }
    public String toString(){
        return this.cardValue.toString() + " of " + this.suit.toString();
    }
}
