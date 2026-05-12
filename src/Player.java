public class Player {
    boolean isDealer = false;
    public int numPlayer;
    boolean hit;
    //String name;
    Card[] hand;
    public int numCard;


    public Player(int pnumplayer){
        numPlayer = pnumplayer;
        //name = pname;
        hand = new Card[12];
        numCard = 0;


    }

    public void printPlayer(){
        for(int i = 0; i < numCard; ++i){
            hand[i].printCard();
        }

    }
    public void addCard(Card newcard){
        hand[numCard] = newcard;
        numCard++;
    }



}
