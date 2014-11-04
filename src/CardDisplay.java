/**
 * Created by lucaswebb on 11/3/14.
 */
import java.awt.*;
import javax.swing.*;

public class CardDisplay
{
    // instance variables - replace the example below with your own
    private CardHand CardsToDisplay;
    private String name;
    private String textDisplayed;
    public CardDisplay(CardHand NewCardsToDisplay, String NewName){
        CardsToDisplay = NewCardsToDisplay;
        name = NewName;
        textDisplayed = "";
    }
    public CardDisplay(CardHand NewCardsToDisplay){
        CardsToDisplay = NewCardsToDisplay;
        name = "";
        textDisplayed = "";
    }

    public void editText(String newText){
        textDisplayed = newText;
    }

    public void makeDisplay(){
        JFrame frame = new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel primary = new JPanel();
        primary.setBackground(Color.green);

        for(CardCard thisCard: CardsToDisplay.getCards()){
            if(thisCard != null){
                JPanel cardPanel = new JPanel();
                cardPanel.setPreferredSize(new Dimension(150, 100));
                cardPanel.setBackground(Color.white);
                //later make prettier and add string names for suites, and face cards
                JLabel cardLabel = new JLabel(thisCard.getNumberString() + " of " + thisCard.getSuiteString());
                cardPanel.add(cardLabel);

                primary.add(cardPanel);
            }
        }
        frame.getContentPane().add(primary);
        frame.pack();
        frame.setVisible(true);
    }
}

