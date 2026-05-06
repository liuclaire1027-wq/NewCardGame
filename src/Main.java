public class Main {

    public Card[] deck;

    public static void main(String[] args) {
        Main blackjack = new Main();


    }

    public Main(){
        deck = new Card[52];
        for (int i = 4; i < deck.length; ++i){
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
