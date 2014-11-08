/**
 * Created by Stuart on 11/6/14.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Options extends JPanel
{
    private int countLeft, countRight, countCenter;
    private int score;
    private JButton buttonLeft;
    private JButton buttonRight;
    private JButton buttonCenter;
    private JLabel text;
    private String message;
    boolean needResponse;

    public Options(){
        countRight =0;
        countLeft = 0;
        countCenter = 0;

        buttonLeft = new JButton("");
        buttonRight = new JButton("");
        buttonCenter = new JButton("");
        buttonLeft.addActionListener(new ButtonListener());
        buttonRight.addActionListener(new ButtonListener());
        buttonCenter.addActionListener(new ButtonListener());
        text = new JLabel("");

        add(text);
        add(buttonLeft);
        add(buttonCenter);
        add(buttonRight);

        setPreferredSize(new Dimension(1500,40));
        setBackground(Color.yellow);


        needResponse = false;
    }

    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            needResponse = false;
            if(event.getSource() == buttonLeft){
                //buttonLeft.setEnabled(false);
                countLeft ++;
                System.out.println("button 1 pressed");
            }
            if(event.getSource() == buttonRight){
                countRight ++;
                System.out.println("button 3 pressed");
            }
            if(event.getSource() == buttonCenter){
                System.out.println("button 2 pressed");
                countCenter++;
            }
        }
    }
    public int[] getButtonResults(){
        int array[] = {countLeft, countCenter, countRight};
        countLeft = 0;
        countRight = 0;
        countCenter = 0;
        return array;
    }
    public void setOptions(String one, String two, String three){
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

    }
//hello


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
}