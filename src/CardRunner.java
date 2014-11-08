/**
 * Created by lucaswebb on 11/3/14.
 */
public class CardRunner
{
    public static void main(String[] args){



        CardDeck deck = new CardDeck();
        deck.shuffle();

        CardHand Player1Hand = new CardHand(false);
        CardHand Dealer = new CardHand(true);
        Player1Hand.addCard( deck.removeCard());
        Player1Hand.addCard(deck.removeCard());
        Dealer.addCard(deck.removeCard());
        Dealer.addCard(deck.removeCard());
        CardDisplay player1Display = new CardDisplay(Player1Hand,Dealer, "Player 1");




      /*The following extremely simple black jack game  exemplifies the getDecision method
      which can be used to prompt the user
        to select some buttons.
        It returns a number 1 through 3 based on which button is clicked*/

        boolean keepPlaying = true;
        System.out.println(Player1Hand.getSum());
        while(Player1Hand.getSum() < 22 && keepPlaying){

            player1Display.printSmall("make a decision...");
            int i = player1Display.getDecision("Hit","Stand","");
            if(i == 1){
                Player1Hand.addCard(deck.removeCard());
            }
            if(i == 2){
                keepPlaying = false;
            }

            //leave at the end of loop
            player1Display.refreshHand(Player1Hand,Dealer);
        }
        //turn the second card right side up for the dealer
        Dealer.faceUp();

        //prints big text in the center of the screen.
        player1Display.printBig("Your score: " + Player1Hand.getSum() +
                ", Dealer score: " + Dealer.getSum());



    }
}