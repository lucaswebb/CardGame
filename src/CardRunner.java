/**
 * Created by lucaswebb on 11/3/14.
 */
public class CardRunner {
    public static void main(String[] args) {

        //Create a deck and shuffle it
        CardDeck deck = new CardDeck();
        deck.shuffle();

        //Create hands and initialize display
        CardHand Player1Hand = new CardHand(false);//input indicates whether the hand is a dealer
        CardHand Dealer = new CardHand(true);
        CardDisplay player1Display = new CardDisplay(Player1Hand, Dealer, "Player 1");


        //Set money and bet amounts and print welcome message
        player1Display.printBig("welcome to BlackJack");
        int money = 100;
        int betAmount = 0;

        //Start the keep playing loop
        //Keeps track of whether the player wants to play again
        boolean keepPlaying = true;
        boolean firstTimeThroughLoop = true;
        while (keepPlaying) {
            player1Display.printMedium("Your current money is " + money);
            player1Display.printSmall("Would you like to Play?");

            //Enable slider and reads players option to play or exit
            player1Display.enableSlider();
            int dec;
            if (firstTimeThroughLoop)
                dec = player1Display.getDecision("play", "exit", "", "", "");
            else
                dec = player1Display.getDecision("play again", "exit", "", "", "");


            //Checks to make sure bet is not greater than money
            if (player1Display.getBet() <= money) {
                betAmount = player1Display.getBet();
            } else {
                betAmount = money;
                player1Display.updateBet(betAmount);
            }

            deck.addCard(Dealer.removeCards());
            deck.addCard(Player1Hand.removeCards());
            player1Display.refreshHand(Player1Hand, Dealer);
            deck.shuffle();

            //Option to exit
            if (dec == 2) {
                player1Display.printBig("Exiting game...");
                player1Display.printSmall("");
                keepPlaying = false;

                System.out.println("exiting game");
                //Option to keep playing
                //Deals more cards and refreshes
            } else {
                Player1Hand.addCard(deck.removeCard());
                Player1Hand.addCard(deck.removeCard());
                Dealer.addCard(deck.removeCard());
                Dealer.addCard(deck.removeCard());
                player1Display.refreshHand(Player1Hand, Dealer);
                player1Display.printSmall("make a decision");
                player1Display.printBig("");

                boolean surrendered = false;

                //lets the user keep adding cards
                boolean playerTurn = true;
                while (Player1Hand.getSum() < 21 && playerTurn) {

                    //Reads players decision
                    player1Display.printSmall("make a decision...");
                    int i = player1Display.getDecision("Hit", "Stand", "Double", "Split", "surrender");
                    //Option to hit
                    if (i == 1) {
                        Player1Hand.addCard(deck.removeCard());
                    }
                    //Option to stand
                    if (i == 2) {
                        playerTurn = false;
                    }
                    //Option to double
                    if (i == 3) {
                        betAmount = betAmount * 2;
                        Player1Hand.addCard(deck.removeCard());
                        player1Display.updateBet(betAmount);
                        playerTurn = false;
                    }
                    if (i == 4) {

                    }
                    //Option to surrender
                    if (dec == 5) {
                        betAmount = betAmount / 2;
                        surrendered = true;
                        player1Display.updateBet(betAmount);
                        playerTurn = false;
                        }

                    //leave at the end of loop
                    player1Display.refreshHand(Player1Hand, Dealer);

                    //Dealer goes until done. Hits on soft 17s
                    Dealer.faceUp();

                    //Processes turn for the dealer
                    if (!Player1Hand.getBlackJack() && !Player1Hand.getBust()) {
                        while (Dealer.getSum() < 17 || (Dealer.getIsSoft() && Dealer.getSum() == 17)) {
                            player1Display.sleep(1500);
                            Dealer.addCard(deck.removeCard());

                            player1Display.refreshHand(Player1Hand, Dealer);
                        }
                    }


                    //Decides who wins
                    if (keepPlaying) {
                        if (Player1Hand.getBust()) {
                            player1Display.printBig("You lose... Bust");
                            money -= betAmount;
                        } else if (Player1Hand.getBlackJack() && !Dealer.getBlackJack()) {
                            player1Display.printBig("You win... BlackJack");
                            money += 2 * betAmount;
                        } else if (surrendered) {
                            player1Display.printBig("You surrender");
                            money -= betAmount;
                        } else if (Player1Hand.getBlackJack() && Dealer.getBlackJack()) {
                            player1Display.printBig("Tie: Double BlackJack");
                        } else if (Dealer.getBust()) {
                            player1Display.printBig("you win... Dealer busts");
                            money += betAmount;
                        } else if (Dealer.getBlackJack()) {
                            player1Display.printBig("you lost... Dealer gets Blackjack");
                            money -= 2 * betAmount;
                        } else if (Dealer.getSum() == Player1Hand.getSum()) {
                            player1Display.printBig("Tie... both scores: " + Dealer.getSum());
                        } else if (Dealer.getSum() > Player1Hand.getSum()) {
                            player1Display.printBig("Dealer wins with " + Dealer.getSum() + " points");
                            money -= betAmount;
                        } else if (Dealer.getSum() < Player1Hand.getSum()) {
                            player1Display.printBig("You win with " + Player1Hand.getSum() + " points");
                            money += betAmount;
                        }
                    }
                }
                firstTimeThroughLoop = false;
            }
        }
    }
}