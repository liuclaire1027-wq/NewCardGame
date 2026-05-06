public class Player {
    boolean stand;
    boolean bust;
    boolean hit;
    String name;
    Card[] hand;
    ;

    public Player(String pname){
        name = pname;
        hand = new Card[2];


    }

}
