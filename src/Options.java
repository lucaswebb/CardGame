/**
 * Created by Stuart on 11/6/14.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Options extends JPanel
{
    //Initializes buttons and slider and creates variables
    private int[] buttonCount = new int[5];
    private int score;
    private JButton[] buttons = new JButton[5];
    private JLabel text, sliderInfo;
    private JSlider slider;
    boolean needResponse;
    int bet;


    public Options(){
        //Create slider
        slider = new JSlider(JSlider.HORIZONTAL,5,50,10);
        text = new JLabel("");
        sliderInfo = new JLabel("Your Bet: " + Integer.toString(slider.getValue()));
        sliderInfo.setForeground(Color.WHITE);
        slider.setEnabled(false);

        slider.addChangeListener(new SliderListener());

        //Creates buttons in array
        for(int i = 0; i < 5; i ++){
            buttons[i] = new JButton("");
            buttons[i].addActionListener(new ButtonListener());
            add(buttons[i]);
            buttonCount[i] = 0;
        }
        add(slider);
        add(sliderInfo);

        setPreferredSize(new Dimension(1500,40));
        setBackground(new Color(204, 31, 27));


        needResponse = false;
    }

    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            needResponse = false;
            for(int i = 0; i < 5; i ++){
                if(event.getSource() == buttons[i]){
                    buttonCount[i] ++;
                }
            }
        }
    }
    //Method to get results of button
    public int[] getButtonResults(){
        int array[] = new int[5];

        for(int i = 0; i < 5; i ++){
            array[i] = buttonCount[i];
            buttonCount[i] = 0;
        }
        return array;
    }

    //Method to set options of the buttons using an array
    public void setOptions(String opt[]){
        for(int i = 0; i < 5; i ++){
            try{
                if(!opt[i].equals("")){
                    buttons[i].setEnabled(true);
                    buttons[i].setText(opt[i]);
                    buttons[i].setVisible(true);
                }else{
                    buttons[i].setVisible(false);
                    buttons[i].setEnabled(false);
                    buttons[i].setText("");
                }
           }catch(Exception e){
                buttons[i].setEnabled(true);
                buttons[i].setText(opt[i]);
                buttons[i].setVisible(true);
            }
        }
    }

    //Disables button
    public void disableButton(int disableMe){
        buttons[disableMe].setText("");
        buttons[disableMe].setEnabled(false);
    }


    public boolean getNeedsResponse(){
        return needResponse;
    }
    public void setNeedsResponse(boolean b){
        needResponse = b;
    }

    //Sets message
    public void setMessage(String a)
    {
        text.setText(a);
    }

    //Updates value of the slider
    public class SliderListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider)e.getSource();
                sliderInfo.setText("Your Bet: " + Integer.toString(slider.getValue()));

        }
    }

    //Method to return the value of the slider, or the bet value
    public int getBet(){
        slider.setEnabled(false);
        return (int) slider.getValue();
    }

    //Method to set the bet value, also updates slider value
    public void setBet(int b){
        bet = b;
        sliderInfo.setText("Your Bet: " + b);
    }

    //Set Slider Value
    public void setSlider(int v){
    slider.setValue(v);
    sliderInfo.setText("Your Bet: " + Integer.toString(v));
}
    //Enables slider
    public void enableSlider(){
        slider.setEnabled(true);
    }
}