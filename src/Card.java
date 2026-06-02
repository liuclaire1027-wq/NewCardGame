public class Card {
    public int value;
    public String suit;
    public boolean isUp;
    public int suitnum;



    public Card(int pvalue, String psuit, boolean pisUp){
        value = pvalue;
        suit = psuit;
        isUp = pisUp;
        printCard();
        if(suit == "clubs"){
            suitnum = 0;
        }if (suit == "diamonds"){
            suitnum = 1;
        }if (suit == "spades"){
            suitnum = 2;
        }if( suit == "hearts"){
            suitnum = 3;
        }
    }

    public void printCard(){
        if(value == 0) {
            System.out.println("Ace of " + suit);
        } else if (value == 10){
            System.out.println("Jack of " + suit);
        } else if (value == 11){
            System.out.println("Queen of " + suit);
        } else if (value == 12){
            System.out.println("King of " + suit);
        } else{
            System.out.println((value + 1) + " of " + suit);
        }
    }


}
