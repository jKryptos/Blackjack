import java.util.Arrays;


public class Main {

    public static void main(String[] args) {

        //Dealer dealer = new Dealer();
        //Player player = new Player();
        Deck deck = new Deck();

        deck.createDeck();
        deck.shuffleDeck();

        System.out.println(deck);

    }
}
