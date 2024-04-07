import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        System.out.println("--- Welcome to Blackjack ---");

        Deck deck = new Deck();
        deck.createDeck();
        deck.shuffleDeck();

        Deck playerHand = new Deck();
        Deck dealerHand = new Deck();

        int playerChips = 100;

        Scanner userInput = new Scanner(System.in);

        //Game Loop
        while (playerChips > 0){
            System.out.println("You have " + playerChips + " chips\nHow many would you like to bet?");
            int playerBet = userInput.nextInt();
            if (playerBet > playerChips){
                System.out.println("You do not have enough chips!");
                break;
            }
            boolean endRound = false;

            playerHand.draw(deck);
            playerHand.draw(deck);
            dealerHand.draw(deck);
            dealerHand.draw(deck);

            while(true){
                System.out.print("PLAYER'S cards: ");
                System.out.println(playerHand);
                System.out.println("Total value of cards: " + playerHand.cardsValue());
                whiteSpace(1);

                System.out.println("DEALER'S hand: " + dealerHand.getCard(0).toString() + " + [Hidden Card]");
                whiteSpace(1);

                System.out.println("1. Hit 2. Stand");
                int selectedAction = userInput.nextInt();
                if (selectedAction == 1){
                    playerHand.draw(deck);
                    System.out.println("Player draws: " + playerHand.getCard(playerHand.deckSize() - 1).toString());
                    whiteSpace(1);
                    if (playerHand.cardsValue() > 21){
                        System.out.println("Bust!, Value of your cards: " +  playerHand.cardsValue());
                        whiteSpace(1);
                        playerChips -= playerBet;
                        endRound = true;
                        break;
                    }
                }
                if (selectedAction == 2){
                    break;
                }
            }
            System.out.println("DEALER'S cards: " + dealerHand);
            if (dealerHand.cardsValue() > playerHand.cardsValue() && !endRound){
                System.out.println("Dealer wins!");
                playerChips -= playerBet;
                endRound = true;
            }
            while (dealerHand.cardsValue() < 17 && !endRound){
                dealerHand.draw(deck);
                System.out.println("Dealer draws: " + dealerHand.getCard(dealerHand.deckSize() - 1).toString());
            }
            System.out.println("Dealer's hand total value: " + dealerHand.cardsValue());
            whiteSpace(1);
            if(dealerHand.cardsValue() > 21 && !endRound){
                System.out.println("Dealer busts, you win!");
                playerChips += playerBet;
                endRound = true;
            }
            if (playerHand.cardsValue() == dealerHand.cardsValue() && !endRound){
                System.out.println("Push, no chips exchanged hands.");
                endRound = true;
            }
            if (playerHand.cardsValue() > dealerHand.cardsValue() && !endRound){
                System.out.println("You win the hand!");
                playerChips += playerBet;
            }
             else if (!endRound){
                System.out.println("Dealer wins!");
                playerChips -= playerBet;
            }

            playerHand.resetHand(deck);
            dealerHand.resetHand(deck);
            System.out.println("End of hand");
            whiteSpace(1);
        }
        System.out.println("You have run out of chips, GAME OVER, THE HOUSE WINNNNNNNNNS!");
    }

    public static void whiteSpace(int amountOfLines){
        for (int i = 0; i < amountOfLines; i++){
            System.out.println(" ");
        }
    }
}
