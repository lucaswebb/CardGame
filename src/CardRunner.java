public class CardRunner
{
    public static void main(String[] args){
        CardCard JackofSpades = new CardCard(3,5);
        CardCard otherCard = new CardCard(2,4);
        CardHand Player1Hand = new CardHand();
        Player1Hand.addCard(JackofSpades);
        Player1Hand.addCard(otherCard);
        CardDisplay player1Display = new CardDisplay(Player1Hand, "Player 1");
        player1Display.makeDisplay();
    }
}
