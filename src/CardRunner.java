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
        CardHand Dealer = new CardHand(true);//True because dealer
        CardDisplay player1Display = new CardDisplay(Player1Hand, Dealer, "Player 1");


        //Start the keep playing loop
        //Keeps track of whether the player wants to play again
        boolean playAgain = true;

        while (playAgain) {
            //Set money and bet amounts and print welcome message
            player1Display.printBig("Welcome to BlackJack");
            int money = 100;
            int betAmount = 0;
            boolean keepPlaying = true;
            boolean firstTimeThroughLoop = true;
            deck.shuffle();
            int dec1;


            while (keepPlaying) {
                player1Display.printMedium("Your Current Money is " + money);
                player1Display.printSmall("Would You Like to Play?");

                //Enable slider and reads players option to play or exit
                player1Display.enableSlider();
                int dec;
                if (firstTimeThroughLoop)
                    dec = player1Display.getDecision("Play", "Exit", "", "", "");
                else
                    dec = player1Display.getDecision("Play Again", "Exit", "", "", "");

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
                    player1Display.printBig("Exiting Game...");
                    player1Display.printSmall("");
                    keepPlaying = false;
                    playAgain = false;

                    System.out.println("Exiting Game");
                    //Option to keep playing
                    //Deals more cards and refreshes
                } else {
                    Player1Hand.addCard(deck.removeCard());
                    Player1Hand.addCard(deck.removeCard());
                    Dealer.addCard(deck.removeCard());
                    Dealer.addCard(deck.removeCard());
                    player1Display.refreshHand(Player1Hand, Dealer);
                    player1Display.printSmall("Make a Decision");
                    player1Display.printBig("");

                    boolean surrendered = false;

                    //lets the user keep adding cards
                    boolean playerTurn = true;
                    while (Player1Hand.getSum() < 21 && playerTurn) {

                        //Reads players decision
                        player1Display.printSmall("Make a Decision...");
                        int i = player1Display.getDecision("Hit", "Stand", "Double", "Split", "Surrender");
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
                            if(money >= betAmount * 2) {
                                betAmount = betAmount * 2;
                                Player1Hand.addCard(deck.removeCard());
                                player1Display.updateBet(betAmount);
                                playerTurn = false;
                            } else {
                                continue;
                            }
                        }
                        if (i == 4) {
                            continue;
                        }
                        //Option to surrender
                        if (dec == 5) {
                            betAmount = betAmount / 2;
                            surrendered = true;
                            player1Display.updateBet(betAmount);
                            playerTurn = false;
                        } else {
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
                                player1Display.printBig("You Surrender");
                                money -= betAmount;
                            } else if (Player1Hand.getBlackJack() && Dealer.getBlackJack()) {
                                player1Display.printBig("Tie: Double BlackJack");
                            } else if (Dealer.getBust()) {
                                player1Display.printBig("You win... Dealer Busts");
                                money += betAmount;
                            } else if (Dealer.getBlackJack()) {
                                player1Display.printBig("You lost... Dealer got Blackjack");
                                money -= 2 * betAmount;
                            } else if (Dealer.getSum() == Player1Hand.getSum()) {
                                player1Display.printBig("Tie... Both scores: " + Dealer.getSum());
                            } else if (Dealer.getSum() > Player1Hand.getSum()) {
                                player1Display.printBig("Dealer wins with " + Dealer.getSum() + " points");
                                money -= betAmount;
                            } else if (Dealer.getSum() < Player1Hand.getSum()) {
                                player1Display.printBig("You win with " + Player1Hand.getSum() + " points");
                                money += betAmount;
                            }
                        }
                    }
                    //Ability to Lose
                    if (money <= 0) {
                        keepPlaying = false;
                        player1Display.printBig("You Lose");
                        betAmount = 0;
                        player1Display.updateBet(betAmount);

                        player1Display.printMedium("Your Current Money is 0");
                        CardHand blank = new CardHand(false);
                        player1Display.refreshHand(blank, blank);

                        dec1 = player1Display.getDecision("New Game", "Exit", "", "", "");
                        if (dec1 == 1) {
                            playAgain = true;
                            player1Display.refreshHand(Player1Hand, Dealer);
                        } else {
                            playAgain = false;
                        }
                    } else {
                        keepPlaying = true;
                    }
                    firstTimeThroughLoop = false;
                }
            }
        }
    }
}
