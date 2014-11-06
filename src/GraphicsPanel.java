/**
 * Created by Stuart on 11/6/14.
 */
import javax.swing.JPanel;
import java.awt.*;
import java.util.Random;
public class GraphicsPanel extends JPanel
{
    // instance variables - replace the example below with your own
    CardHand hand;

    public GraphicsPanel(CardHand newHand)
    {
        setBackground(Color.green);
        setPreferredSize(new Dimension(400,300));

        hand = newHand;

    }


    public void paintComponent(Graphics page){
        super.paintComponent(page);

        Font f = new Font("Dialog", Font.PLAIN, 20);
        page.setFont(f);
        int X_Initial = 100;
        int Y_Initial = 150;
        //make all cards
        for(int i = 0; i < hand.getCards().length; i ++){
            if(hand.getCards()[i] != null){
                page.setColor(Color.black);
                page.fillRect(X_Initial,Y_Initial, 75, 100);
                page.setColor(Color.white);
                page.fillRect(X_Initial + 2,Y_Initial + 2, 71, 96);
                if(hand.getCards()[i].getSuite() < 2)
                    page.setColor(Color.black);
                else
                    page.setColor(Color.red);
                page.drawString(hand.getCards()[i].getNumberString(), X_Initial + 10,Y_Initial + 30);
                //if clubs
                if(hand.getCards()[i].getSuite() == 0){
                    page.fillOval(X_Initial + 5,Y_Initial + 45, 10,10);
                    page.fillOval(X_Initial + 15,Y_Initial + 45, 10,10);
                    page.fillOval(X_Initial + 10,Y_Initial + 37, 10,12);
                    page.fillRect(X_Initial + 13,Y_Initial + 45, 5, 13);
                }
                if(hand.getCards()[i].getSuite() == 1){
                    page.fillOval(X_Initial + 5,Y_Initial + 45, 10,10);
                    page.fillOval(X_Initial + 15,Y_Initial + 45, 10,10);
                    int x1[] = {X_Initial + 5,X_Initial + 25, X_Initial + 15};
                    int y1[] = {Y_Initial + 50,Y_Initial + 50,Y_Initial + 37};
                    page.fillPolygon(x1,y1,3);
                    int x2[] = {X_Initial + 15,X_Initial + 13,X_Initial + 17};
                    int y2[] = {Y_Initial + 48, Y_Initial + 58,Y_Initial + 58};
                    page.fillPolygon(x2,y2,3);
                }
                if(hand.getCards()[i].getSuite() == 2){
                    page.fillOval(X_Initial + 5,Y_Initial + 45, 10,10);
                    page.fillOval(X_Initial + 15,Y_Initial + 45, 10,10);
                    int x1[] = {X_Initial + 5,X_Initial + 25, X_Initial + 15};
                    int y1[] = {Y_Initial + 50,Y_Initial + 50,Y_Initial + 63};
                    page.fillPolygon(x1,y1,3);
                }
                if(hand.getCards()[i].getSuite() == 3){

                    int x1[] = {X_Initial + 5,X_Initial + 15,X_Initial + 25, X_Initial + 15};
                    int y1[] = {Y_Initial + 50,Y_Initial + 37,Y_Initial + 50,Y_Initial + 63};
                    page.fillPolygon(x1,y1,4);
                }


                X_Initial += 30;
                Y_Initial += 5;
            }
        }

    }
}
