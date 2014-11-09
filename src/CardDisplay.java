/**
 * Created by lucaswebb on 11/3/14.
 */
import java.awt.*;
import javax.swing.*;

public class CardDisplay
{
    // instance variables - replace the example below with your own
    private CardHand CardsToDisplay,Dealer;
    private String name;
    private String textDisplayed;
    Options panel2;
    GraphicsPanel panel1;


    public CardDisplay(CardHand NewCardsToDisplay, CardHand NewDealer,String NewName){
        CardsToDisplay = NewCardsToDisplay;
        Dealer = NewDealer;
        name = NewName;
        textDisplayed = "";

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

    public void editText(String newText){
        textDisplayed = newText;
    }



    public void refreshHand(CardHand hand,CardHand newDealer){
        panel1.sethand(hand, newDealer);
    }

    public int getDecision(String option1, String option2, String option3){
        panel2.setOptions(option1, option2, option3);
        panel2.setNeedsResponse(true);
        while(panel2.getNeedsResponse()){
            try{Thread.sleep(10);}
            catch(Exception e){}
        }
        int result = 0;
        int array[] = panel2.getButtonResults();
        for(int i = 0; i < 3;i ++){
            if(array[i] > 0){
                result = i + 1;
            }
        }
        panel2.setNeedsResponse(false);
        for(int i = 1; i < 4; i ++) {
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
    public void sleep(int millis){
        try{Thread.sleep(millis);}
        catch(Exception e){}
    }
    public int getBet(){
        return panel2.getBet();
    }
    public void enableSlider(){
        panel2.enableSlider();
    }
}