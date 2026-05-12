public class Player {
    boolean isDealer = false;
    public int numPlayer;
    boolean hit = false;
    //String name;
    Card[] hand;
    public int numCard;
    boolean bust = false;
    int value = 0;



    public Player(int pnumplayer) {
        numPlayer = pnumplayer;
        //name = pname;
        hand = new Card[12];
        numCard = 0;

    }
    public void valueCards(){
        for (int i = 0; i < numCard; ++i){
            value += hand[i].value + 1;
        }
        System.out.println(value);
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

    public void busted(){
        if(bust == true){
            System.out.println("You lose!");
        }
    }








}
