public class Player {
    boolean isDealer = false;
    public int numPlayer;
    boolean hit = false;
    //String name;
    Card[] hand;
    public int numCard;
    boolean bust = false;
    int value = 0;
    int tempCards=0;



    public Player(int pnumplayer) {
        numPlayer = pnumplayer;
        //name = pname;
        hand = new Card[12];
        numCard = 0;

    }
    public int valueCards(){
        value = 0;
        boolean isAce = false;
        for (int i = 0; i < numCard; ++i){
            if(hand[i].value == 0){
                isAce = true;
            }
            else if(hand[i].value >= 10){
                value += 10;

            }else{
                value += hand[i].value + 1;
            }

        }if(value + 10 < 21 && isAce){
            value += 10;
        }

        System.out.println("The total value is " + value);
        return value;
    }
    public void valueCardsnotPrint(){
        value = 0;
        boolean isAce = false;
        for (int i = 0; i < numCard; ++i){
            if(hand[i].value == 0){
                isAce = true;
            }
            else if(hand[i].value >= 10){
                value += 10;

            }else{
                value += hand[i].value + 1;
            }

        }if(value + 10 < 21 && isAce){
            value += 10;
        }
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
        System.out.println("You lose!");

    }
    public void dealerBusted(){
        System.out.println("Dealer was busted!");
    }








}
