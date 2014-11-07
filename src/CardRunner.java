/**
 * Created by lucaswebb on 11/3/14.
 */
public class CardRunner
{
    public static void main(String[] args){
        
    
        
        CardDeck deck = new CardDeck();
        deck.shuffle();
        
        CardHand Player1Hand = new CardHand();
        Player1Hand.addCard( deck.removeCard());
        Player1Hand.addCard(deck.removeCard());
        CardDisplay player1Display = new CardDisplay(Player1Hand, "Player 1");


        player1Display.getDecision("Show","Off","");


      /*The following extremely simple black jack game  exemplifies the getDecision method
      which can be used to prompt the user
        to select some buttons.
        It returns a number 1 through 3 based on which button is clicked*/

       boolean keepPlaying = true;
       System.out.println(Player1Hand.getSum());
        while(Player1Hand.getSum() < 22 && keepPlaying){

           int i = player1Display.getDecision("Hit","Stand","");
            if(i == 1){
                Player1Hand.addCard(deck.removeCard());
            }
            if(i == 2){
                keepPlaying = false;
            }

           //leave at the end of loop
           player1Display.refreshHand(Player1Hand);
        }

        System.out.println("You're final score is " + Player1Hand.getSum());



    }
}