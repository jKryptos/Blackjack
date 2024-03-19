import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    ArrayList<Card> mainHand;
    ArrayList<Card> splitHand;
    Dealer dealer = new Dealer();
    Scanner scanner = new Scanner(System.in);

    int numberOfChips;
    int cardsPlayed;
    int valueOfPlayedCardsPlayer;
    Boolean playerHasIdenticalValueCards;

    public int betChips(int playerBetAmount){

        return playerBetAmount;
    }

    public void playerAction(String playerAction){

        System.out.println("Which action would you like to take?: Hit, Stay, Split or Double Down");
        playerAction = scanner.nextLine();

        switch (playerAction){

            case "Hit":
                dealer.playerHit();
                break;

            case "Stay":
                dealer.playerStay();
                break;

            case "Split":
                dealer.playerSplit();
                break;

            case "Double Down":
                dealer.playerDoubleDown();
                break;

        }
    }

}
