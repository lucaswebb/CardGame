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
        player1Display.makeDisplay();
  //hello
    }
}
