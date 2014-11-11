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
    private int countLeft, countRight, countCenter, countRightr;
    private int score;
    private JButton buttonLeft;
    private JButton buttonRight;
    private JButton buttonCenter;
    private JButton buttonRightr;
    private JLabel text, sliderInfo;
    private JSlider slider;
    boolean needResponse;


    public Options(){
        countRight =0;
        countLeft = 0;
        countCenter = 0;
        countRightr = 0;

        buttonLeft = new JButton("");
        buttonRight = new JButton("");
        buttonCenter = new JButton("");
        buttonRightr = new JButton("");
        slider = new JSlider(JSlider.HORIZONTAL,5,50,10);
        text = new JLabel("");
        sliderInfo = new JLabel("Your bet: " + Integer.toString(slider.getValue()));
        slider.setEnabled(false);

        slider.addChangeListener(new SliderListener());
        buttonLeft.addActionListener(new ButtonListener());
        buttonRight.addActionListener(new ButtonListener());
        buttonCenter.addActionListener(new ButtonListener());
        buttonRightr.addActionListener(new ButtonListener());


        add(text);
        add(buttonLeft);
        add(buttonCenter);
        add(buttonRight);
        add(buttonRightr);
        add(slider);
        add(sliderInfo);

        setPreferredSize(new Dimension(1500,40));
        setBackground(Color.yellow);


        needResponse = false;
    }

    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            needResponse = false;
            if(event.getSource() == buttonLeft){
                countLeft ++;
            }
            if(event.getSource() == buttonRight){
                countRight ++;
            }
            if(event.getSource() == buttonCenter){
                countCenter++;
            }
            if(event.getSource() == buttonRightr){
                countRightr++;
            }
        }
    }
    public int[] getButtonResults(){
        int array[] = {countLeft, countCenter, countRight, countRightr};
        countLeft = 0;
        countRight = 0;
        countCenter = 0;
        countRightr = 0;
        return array;
    }
    public void setOptions(String one, String two, String three, String four){
        if(!one.equals("")) {
            buttonLeft.setEnabled(true);
            buttonLeft.setText(one);
        }
        if(!two.equals("")) {
            buttonCenter.setEnabled(true);
            buttonCenter.setText(two);
        }
        if(!three.equals("")) {
            buttonRight.setEnabled(true);
            buttonRight.setText(three);
        }
        if(!four.equals("")){
            buttonRightr.setEnabled(true);
            buttonRightr.setText(four);
        }
    }
    public void disableButton(int disableMe){
        if(disableMe == 1){
            buttonLeft.setText("");
            buttonLeft.setEnabled(false);
        }
        else if(disableMe == 2){
            buttonCenter.setText("");
            buttonCenter.setEnabled(false);
        }
        else if(disableMe == 3) {
            buttonRight.setText("");
            buttonRight.setEnabled(false);
        }
        else if(disableMe == 4){
            buttonRightr.setText("");
            buttonRightr.setEnabled(false);
        }

    }


    public boolean getNeedsResponse(){
        return needResponse;
    }
    public void setNeedsResponse(boolean b){
        needResponse = b;
    }


    public void setMessage(String a)
    {
        text.setText(a);
    }


    public class SliderListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider)e.getSource();
            if (!source.getValueIsAdjusting()) {
                sliderInfo.setText("your bet: " + Integer.toString(slider.getValue()));
            }
        }
    }

    public int getBet(){
        slider.setEnabled(false);
        return (int) slider.getValue();
    }
    public void enableSlider(){
        slider.setEnabled(true);
    }
}