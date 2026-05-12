import java.util.Scanner;

public class Main {

    public Card[] deck;
    Player player;
    Player dealer;

    Scanner sc;

    public static void main(String[] args) {
        Main blackjack = new Main();


    }

    public Main(){
        sc = new Scanner(System.in);
        player = new Player(1);
        dealer = new Player(2);
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
        dealer.addCard(deck[dealer.numCard]);
        dealer.addCard(deck[dealer.numCard]);
        for(int i = 0; i < dealer.numCard; ++i){
            if(i == 0){
                dealer.hand[i].isUp = true;
            }
            else{
                dealer.hand[i].isUp = false;
            }
        }
        shuffle();
        player.addCard(deck[player.numCard]);
        player.addCard(deck[player.numCard]);
        valueCards();
        //waiting for input
        System.out.println("-----------------");
        System.out.println("Player 1's Cards are");
        for(int i = 0; i < player.numCard; ++i){
            player.hand[i].printCard();
        }
        playersTurn();




    }
    public void valueCards(){
        System.out.println("-----Dealer Cards-----");
        for(int i = 0; i < dealer.numCard; ++i){
            if(dealer.hand[i].isUp){
                dealer.hand[i].printCard();
            }else{
                System.out.println("*hidden card*");
            }
        }
        dealer.valueCards();

        System.out.println("-----Player Cards-----");
        for(int i = 0; i < player.numCard; ++i){


            player.hand[i].printCard();

        }
        player.valueCards();
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
    public void playersTurn(){
        System.out.println("Do you want to [h]it or [s]tand?");
        String input = sc.nextLine();
        if(input.equals("h")){
            player.hit = true;
            player.addCard(deck[player.numPlayer]);

            if(player.value < 21){
                dealersTurn();
            }
            if(player.value == 21){
                System.out.println("You win!");
            }
            if(player.value > 21){
                player.busted();
            }
        }


    }

    public void dealersTurn(){
        System.out.println("hi");
    }


}
