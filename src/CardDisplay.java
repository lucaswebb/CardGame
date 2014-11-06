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

        GraphicsPanel panel1 = new GraphicsPanel(CardsToDisplay);
        Options panel2 = new Options();

        JPanel primary = new JPanel();
        primary.setBackground(Color.green);
        primary.add(panel2);
        primary.add(panel1);


        frame.getContentPane().add(primary);

        frame.pack();
        frame.setVisible(true);

    }
}