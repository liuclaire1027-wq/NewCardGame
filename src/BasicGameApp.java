//Basic Game Application
// Basic Object, Image, Movement
// Threaded

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Scanner;

//*******************************************************************************

public class BasicGameApp implements Runnable {

    //Variable Definition Section
    //Declare the variables used in the program
    //You can set their initial values too

    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 700;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;

    Card[] deck;
    Image cards = Toolkit.getDefaultToolkit().getImage("Card.png");
    Player player;
    Player player2;
    Player dealer;
    int tempCards=0;
    Scanner sc;

    // Main method definition
    // This is the code that runs first and automatically
    public static void main(String[] args) {
        BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
        new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method
    }


    // This section is the setup portion of the program
    // Initialize your variables and construct your program objects here.
    public BasicGameApp() { // BasicGameApp constructor
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
        System.out.println("------------START GAME--------------");
        System.out.println("Player 1's Cards are");
        for(int i = 0; i < player.numCard; ++i){
            player.hand[i].printCard();
        }
        player.valueCards();

        System.out.println("-----------------");
        System.out.println("Player 2's Cards are");
        for(int i = 0; i < player2.numCard; ++i){
            player2.hand[i].printCard();
        }
        player2.valueCards();
        System.out.println("-----------------");
        playersTurn(player);



        setUpGraphics();



    } // end BasicGameApp constructor


//*******************************************************************************
//User Method Section
// put your code to do things here.

    // main thread
    // this is the code that plays the game after you set things up
    public void run() {
        //for the moment we will loop things forever.
        while (true) {
            moveThings();  //move all the game objects
            render();  // paint the graphics
            pause(30); // sleep for 10 ms
        }
    }

    public void moveThings() {
        astro.move();
    }

    //Paints things on the screen using bufferStrategy
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);
        //draw the image
        for(int i = 0; i < 2; ++i){
            if(i == 0) {
                for (int j = 0; j < player.numCard; ++j) {
                    Card thisCard = player.hand[j];
                    g.drawImage(cards, 250 + i *50, 350 + i *150, 311 + i*50, 445 + i*150, 61* thisCard.value, 95*thisCard.suitnum,, 61 * thisCard.value+61, 95 * thisCard.suitnum+95);
                }
            }
        }
        /* for loop(every player e.g. i < 2)
                for(loop the number of cards)
                    Card thisCard = the current card of this player hand[j]
                    g.drawImage (image, destination x1: 250 + i*50, dy1:350 + i *150, dx2: 311 + i*50, dy2445 + i *150
                    sx1: 61 * thisCard.value, sy1: 95 * thisCard.suit, sx2: 61 * thisCard.value+61, sy2: 95 * thisCard.suit + 95)

         */

        g.dispose();
        bufferStrategy.show();
    }

    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time ) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    //Graphics setup method
    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }

}
