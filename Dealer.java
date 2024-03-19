public class Dealer {

    Player player = new Player();

    private boolean playerWins;
    private boolean dealerUpCard;
    private int tablePot;
    int valueOfPlayedCardsDealer;


    private static void dealCard(String target){

    }

    private void takeBets(int playerBetAmount){

        player.numberOfChips = player.numberOfChips - playerBetAmount;
        tablePot = tablePot + playerBetAmount;
    }

    private void adjustChips(){
        if (playerWins){
            player.numberOfChips = player.numberOfChips + (tablePot * 2);
        } else {
            tablePot = 0;
        }
    }

    public void playerHit(){
        dealCard("Player");
    }

    public void playerStay(){
        while(valueOfPlayedCardsDealer < 17){
            dealCard("Dealer");
        }
    }

    public void playerSplit(){
        if(player.playerHasIdenticalValueCards){
            if(player.numberOfChips - tablePot > 0){
                takeBets(tablePot);
                player.splitHand.add(player.mainHand.get(1));
                player.mainHand.remove(1);
            }
        }
    }

    public void playerDoubleDown(){

    }
}
