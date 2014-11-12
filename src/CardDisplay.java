/**
 * Created by lucaswebb on 11/3/14.
 */
import java.awt.*;
import javax.swing.*;

/* In general this class's purpose is to create a jframe and take commands that pertain to the GUI
and allocate it between the two panels, one for buttons, sliders, etc and one for animation
 */
public class CardDisplay
{
    // instance variables
    private CardHand CardsToDisplay,Dealer;
    private String name;
    Options panel2;
    GraphicsPanel panel1;


    //initializer takes the name of the Jframe, and two hands of cards
    public CardDisplay(CardHand NewCardsToDisplay, CardHand NewDealer,String NewName){
        CardsToDisplay = NewCardsToDisplay;
        Dealer = NewDealer;
        name = NewName;

        JFrame frame = new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel1 = new GraphicsPanel(CardsToDisplay, Dealer);
        panel2 = new Options();

        JPanel primary = new JPanel();
        primary.setBackground(Color.green);
        primary.add(panel2);
        primary.add(panel1);


        frame.getContentPane().add(primary);

        frame.pack();
        frame.setVisible(true);
    }




    //sends a command to the graphics panel to update the card animation
    public void refreshHand(CardHand hand,CardHand newDealer){
        panel1.sethand(hand, newDealer);
    }

    //takes the name of all the buttons and then waits until one of the buttons is pressed
    public int getDecision(String option1, String option2, String option3, String option4, String option5){
        String opt[] = {option1,option2,option3,option4,option5};
        panel2.setOptions(opt);
        panel2.setNeedsResponse(true);
        while(panel2.getNeedsResponse()){
            try{Thread.sleep(10);}
            catch(Exception e){}
        }
        int result = 0;
        int array[] = panel2.getButtonResults();

        // any of the buttons are pressed than return the index of that button
        for(int i = 0; i < 5;i ++){
            if(array[i] > 0){
                result = i + 1;

            }
        }
        panel2.setNeedsResponse(false);
        for(int i = 1; i < 5; i ++) {
            panel2.disableButton(i);
        }
        return result;
    }

    public void printBig(String a){
        panel1.setBigText(a);
    }
    public void printMedium(String a){panel1.setMediumText(a);}
    public void printSmall(String a){
        panel2.setMessage(a);
    }

    //lets the main method sleep
    public void sleep(int millis){
        try{Thread.sleep(millis);}
        catch(Exception e){}
    }

    //updates the gui for the bet amount and returns it to the main method.
    public int getBet(){
        panel1.setBet(panel2.getBet());
        return panel2.getBet();
    }

    //sends command to options panel to enable slider
    public void enableSlider(){
        panel2.enableSlider();
    }

    //sends command to Graphics panel to update the bet animation
    public void updateBet(int betNew){
        panel1.setBet(betNew);
        panel2.setBet(betNew);
    }
}