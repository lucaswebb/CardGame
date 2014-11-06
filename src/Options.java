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

        add(buttonLeft);
        add(buttonRight);
        add(buttonCenter);

        setPreferredSize(new Dimension(300,40));
        setBackground(Color.yellow);
    }

    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(event.getSource() == buttonLeft){
                //buttonLeft.setEnabled(false);
                countLeft ++;
            }
            if(event.getSource() == buttonRight){
                countRight ++;
                //
            }
            if(event.getSource() == buttonCenter){
                //
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
        buttonLeft.setText(one);
        buttonRight.setText(three);
        buttonCenter.setText(two);
    }
//hello

}