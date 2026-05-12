public class Main {

    public Card[] deck;
    Player player;
    Player dealer;
    int valuePlayer = 0;
    int valueDealer = 0;

    public static void main(String[] args) {
        Main blackjack = new Main();


    }

    public Main(){
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


        dealer.addCard(deck[dealer.numCard]);
        dealer.hand[0].isUp = true;
        dealer.addCard(deck[dealer.numCard]);
        for(int i = 0; i < dealer.numCard; ++i){
            valueDealer += dealer.hand[i].value + 1;
        }
        shuffle();
        player.addCard(deck[player.numCard]);
        player.addCard(deck[player.numCard]);
        for(int i = 0; i < player.numCard; ++i){
            valuePlayer += player.hand[i].value + 1;
        }


        for(int i = 0; i < dealer.numCard; ++i) {
            if(dealer.hand[i].isUp == true) {
                dealer.hand[i].printCard();
            }
        }
        player.printPlayer();
        System.out.println(valuePlayer);







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

}
