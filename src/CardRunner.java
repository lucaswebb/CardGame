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
        CardDisplay player1Display = new CardDisplay(Player1Hand,Dealer, "Player 1");




        player1Display.printBig("welcome to BlackJack");

        boolean keepPlaying = true;
        boolean firstTimeThroughLoop = true;
        while(keepPlaying) {
            player1Display.printSmall("Would you like to Play?");
            int dec;
            if(firstTimeThroughLoop)
                dec = player1Display.getDecision("play", "exit", "");
            else
                dec = player1Display.getDecision("play again", "exit", "");
            deck.addCard(Dealer.removeCards());
            deck.addCard(Player1Hand.removeCards());
            player1Display.refreshHand(Player1Hand,Dealer);
            deck.shuffle();

            if (dec == 2) {
                player1Display.printBig("Exiting game...");
                player1Display.printSmall("");
                keepPlaying = false;

                System.out.println("exiting game");
            } else {
                Player1Hand.addCard( deck.removeCard());
                Player1Hand.addCard(deck.removeCard());
                Dealer.addCard(deck.removeCard());
                Dealer.addCard(deck.removeCard());
                player1Display.refreshHand(Player1Hand,Dealer);
                player1Display.printSmall("make a decision");
                player1Display.printBig("");


                //lets the user keep adding cards
                boolean playerTurn = true;
                while (Player1Hand.getSum() < 21 && playerTurn) {

                    player1Display.printSmall("make a decision...");
                    int i = player1Display.getDecision("Hit", "Stand", "");
                    if (i == 1) {
                        Player1Hand.addCard(deck.removeCard());
                    }
                    if (i == 2) {
                        playerTurn = false;
                    }

                    //leave at the end of loop
                    player1Display.refreshHand(Player1Hand, Dealer);
                }


                //Dealer goes until done. Hits on soft 17s
                Dealer.faceUp();

                if (!Player1Hand.getBlackJack() && !Player1Hand.getBust()) {
                    while (Dealer.getSum() < 17 || (Dealer.getIsSoft() && Dealer.getSum() == 17)) {
                        player1Display.sleep(1500);
                        Dealer.addCard(deck.removeCard());

                        player1Display.refreshHand(Player1Hand, Dealer);
                    }
                }


                //decide who wins
                if(keepPlaying) {
                    if (Player1Hand.getBust()) {
                        player1Display.printBig("You lose... Bust");
                    } else if (Player1Hand.getBlackJack()) {
                        player1Display.printBig("You win... BlackJack");
                    } else if (Dealer.getBust()) {
                        player1Display.printBig("you win... Dealer busts");
                    } else if (Dealer.getBlackJack()) {
                        player1Display.printBig("you lost... Dealer gets Blackjack");
                    } else if (Dealer.getSum() == Player1Hand.getSum()) {
                        player1Display.printBig("Tie... both scores: " + Dealer.getSum());
                    } else if (Dealer.getSum() > Player1Hand.getSum()) {
                        player1Display.printBig("Dealer wins with " + Dealer.getSum() + " points");
                    } else if (Dealer.getSum() < Player1Hand.getSum()) {
                        player1Display.printBig("You win with " + Player1Hand.getSum() + " points");
                    }
                }
            }
            firstTimeThroughLoop = false;
        }



    }
}