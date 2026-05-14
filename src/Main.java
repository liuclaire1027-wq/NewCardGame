import java.util.Scanner;

public class Main {

    public Card[] deck;
    Player player;
    Player player2;
    Player dealer;
    int tempCards=0;
    Scanner sc;

    public static void main(String[] args) {
        Main blackjack = new Main();


    }

    public Main(){
        sc = new Scanner(System.in);
        player = new Player(1);
        player2 = new Player(2);
        dealer = new Player(0);
        deck = new Card[52];
        for (int i = 0; i < deck.length; ++i){
                if( i /13 ==0) {
                    deck[i] = new Card(i, "spades", false);
                } else if(i/13==1){
                    deck[i] = new Card(i%13, "diamonds", false);
                } else if (i/13==2){
                    deck[i] = new Card(i%13, "hearts", false);
                } else if (i/13==3){
                    deck[i] = new Card(i%13, "clubs", false);
                }
                //if i ==14, i%14=1 --> the card number we want
        }
        shuffle();
        //adding the cards to the deck of cards --> numCards track # of cards each player has
        dealer.addCard(deck[tempCards]);
        tempCards++;
        dealer.addCard(deck[tempCards]);
        tempCards++;
        for(int i = 0; i < dealer.numCard; ++i){
            if(i == 0){
                dealer.hand[i].isUp = true;
            }
            else{
                dealer.hand[i].isUp = false;
            }
        }

        player.addCard(deck[tempCards]);
        tempCards++;
        player.addCard(deck[tempCards]);
        tempCards++;

        player2.addCard(deck[tempCards]);
        tempCards++;
        player2.addCard(deck[tempCards]);
        tempCards++;
        valuePrintCards();
        //waiting for input
        System.out.println("-----------------");
        System.out.println("Player 1's Cards are");
        for(int i = 0; i < player.numCard; ++i){
            player.hand[i].printCard();
        }

        System.out.println("-----------------");
        playersTurn(player);
        System.out.println("-----------------");
        System.out.println("Player 2's Cards are");
        for(int i = 0; i < player2.numCard; ++i){
            player2.hand[i].printCard();
        }
        System.out.println("-----------------");
        playersTurn(player2);




    }
    public void valuePrintCards(){
        System.out.println("-----Dealer Cards-----");
        for(int i = 0; i < dealer.numCard; ++i){
            if(dealer.hand[i].isUp){
                dealer.hand[i].printCard();
            }else{
                System.out.println("*hidden card*");
            }
        }
        dealer.valueCardsnotPrint();

        System.out.println("-----Player 1's Cards-----");
        for(int i = 0; i < player.numCard; ++i){
            player.hand[i].printCard();
        }
        player.valueCards();
        System.out.println("-----Player 2's Cards-----");
        for(int i = 0; i < player2.numCard; ++i){
            player2.hand[i].printCard();
        }
        player2.valueCards();
    }
    public void restartGame(){
        tempCards = 0;
        for(int i = 0; i<player.numCard;++i){
            player.hand[i] = null;
        }
        player.value = 0;
        player.numCard =0;
        for(int i = 0; i< player2.numCard; ++i){
            player2.hand[i] = null;
        }
        player2.value = 0;
        player2.numCard = 0;
        for(int i = 0; i < dealer.numCard; ++i){
            dealer.hand[i] = null;
        }
        dealer.value = 0;
        dealer.numCard =0;
        shuffle();
        //adding the cards to the deck of cards --> numCards track # of cards each player has
        dealer.addCard(deck[tempCards]);
        tempCards++;
        dealer.addCard(deck[tempCards]);
        tempCards++;
        for(int i = 0; i < dealer.numCard; ++i){
            if(i == 0){
                dealer.hand[i].isUp = true;
            }
            else{
                dealer.hand[i].isUp = false;
            }
        }

        player.addCard(deck[tempCards]);
        tempCards++;
        player.addCard(deck[tempCards]);
        tempCards++;

        player2.addCard(deck[tempCards]);
        tempCards++;
        player2.addCard(deck[tempCards]);
        tempCards++;
        System.out.println("-----------NEW GAME-----------");
        valuePrintCards();
        //waiting for input
        System.out.println("-----------------");
        System.out.println("Player 1's Cards are");
        for(int i = 0; i < player.numCard; ++i){
            player.hand[i].printCard();
        }

        System.out.println("-----------------");
        playersTurn(player);
        System.out.println("-----------------");
        System.out.println("Player 2's Cards are");
        for(int i = 0; i < player2.numCard; ++i){
            player2.hand[i].printCard();
        }
        System.out.println("-----------------");
        playersTurn(player2);


    }



    public void shuffle(){
        for(int i = 0; i < deck.length; ++i){
            int randNum = (int)(Math.random() * 52);
            Card holdCard = deck[randNum];
            //place the card at the random place into a hold card
            deck[randNum] = deck[i];
            //place the chosen card at the position of the prev randomcard
            deck[i] = holdCard;
            //place the held(prev randcard)card in pos of prev chosen card

        }
    }
    public void playersTurn(Player pplayer){

        if(pplayer==player) {
            System.out.println("Do you want to [h]it or [s]tand?");
            String input = sc.nextLine();
            if (input.equals("h")) {
                player.hit = true;
                player.addCard(deck[tempCards]);
                tempCards++;
                player.value = 0;
                System.out.println("The card you drawed was:");
                player.hand[player.numCard-1].printCard();
                System.out.println("The total value of your cards is now:");
                player.valueCards();

                if (player.value == 21) {
                    System.out.println("You win!");
                }
                if (player.value > 21) {
                    player.busted();
                } else {
                    playersTurn(player);
                }
            }
            if (input.equals("s")) {
                dealersTurn(player);
            }
        }if(pplayer==player2) {

            for(int i = 0; i < dealer.numCard; i++){
                dealer.hand[i] = null;
            }
            dealer.numCard = 0;
            dealer.value = 0;
            dealer.addCard(deck[tempCards]);
            tempCards++;
            dealer.addCard(deck[tempCards]);
            tempCards++;
            for(int i = 0; i < dealer.numCard; ++i){
                if(i == 0){
                    dealer.hand[i].isUp = true;
                }
                else{
                    dealer.hand[i].isUp = false;
                }
            }
            System.out.println("-----New Dealer Cards-----");
            for(int i = 0; i < dealer.numCard; ++i){
                if(dealer.hand[i].isUp){
                    dealer.hand[i].printCard();
                }else{
                    System.out.println("*hidden card*");
                }
            }
            System.out.println("Do you want to [h]it or [s]tand?");
            String input = sc.nextLine();
            if (input.equals("h")) {
                player2.hit = true;
                player2.addCard(deck[tempCards]);
                tempCards++;
                player2.value = 0;
                System.out.println("The card you drawed was:");
                player2.hand[player2.numCard-1].printCard();
                System.out.println("The total value of your cards is now:");
                player2.valueCards();

                if (player2.value == 21) {
                    System.out.println("You win!");
                    System.out.println("Press r to restart");
                    String restart = sc.nextLine();
                    if(restart.equals("r")){
                        restartGame();
                    }
                }
                if (player2.value > 21) {
                    player2.busted();
                    System.out.println("Press r to restart");
                    String restart = sc.nextLine();
                    if(restart.equals("r")){
                        restartGame();
                    }
                } else {
                    playersTurn(player2);
                }
            }
            if (input.equals("s")) {
                dealersTurn(player2);
            }
        }


    }

    public void dealersTurn(Player compare){
        if(dealer.value < 16) {
            dealer.addCard(deck[dealer.numCard]);
            dealer.value=0;
            dealer.valueCardsnotPrint();

        }
        if (dealer.value == 21) {
            System.out.println("Dealer wins!");
        }
        if (dealer.value > 21){
            dealer.dealerBusted();
        }if(compare == player) {
            System.out.println("-----Player 1's results-----");
            if (player.value > dealer.value) {
                System.out.println("Player 1 wins!");
            }
            if (player.value < dealer.value) {
                System.out.println("Dealer wins!");
            }
            if (player.value == dealer.value) {
                System.out.println("Player 1 and Dealer tied!");

            }
            System.out.println("Dealer had " + dealer.value + " value in cards");
        }

        if(compare == player2) {
            System.out.println("-----Player 2's results-----");
            if (player2.value > dealer.value) {
                System.out.println("Player 2 wins!");
            }
            if (player2.value < dealer.value) {
                System.out.println("Dealer wins!");
            }
            if (player2.value == dealer.value) {
                System.out.println("Player 2 and Dealer tied!");
            }
            System.out.println("The value of the dealers cards was " + dealer.value);
            System.out.println("Press r to restart");
            String input = sc.nextLine();
            if(input.equals("r")){
                restartGame();
            }

        }


    }


}
