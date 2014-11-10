/**
 * Created by Stuart on 11/6/14.
 */
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.ColorConvertOp;
import java.util.Random;
public class GraphicsPanel extends JPanel
{
    // instance variables - replace the example below with your own
    CardHand hand;
    CardHand dealer;
    private String bigText, mediumText;
    private int bet[] = {0,0,0};



    public GraphicsPanel(CardHand newHand, CardHand newDealer)
    {
        setBackground(Color.orange);
        setPreferredSize(new Dimension(400,600));

        bigText = "";
        mediumText = "";
        hand = newHand;
        dealer = newDealer;


    }



    public void paintComponent(Graphics page) {
        super.paintComponent(page);

        Font b = new Font("Dialog", Font.PLAIN, 20);
        page.setFont(b);
        page.drawString(bigText, 20, 30);

        Font m = new Font("Dialog", Font.PLAIN, 12);
        page.setFont(m);
        page.drawString(mediumText,20,550);
        page.setFont(b);

        drawStack(page, 300, 100);


        drawBet(page,bet[0],Color.green,Color.white, 50,275, 25);
        drawBet(page,bet[1],Color.red, Color.white, 110,275, 5);
        drawBet(page,bet[2],Color.white,Color.black, 170,275, 1);

        //make all cards for user
        int X_Initial = 100;
        int Y_Initial = 375;
        for (int i = 0; i < hand.getCards().length; i++) {
            if (hand.getCards()[i] != null) {
                drawCard(page, hand.getCards()[i], X_Initial, Y_Initial);
                X_Initial += 30;
                Y_Initial += 5;
            }
        }

        //make all cards for dealer
        int Xdealer = 100;
        int YDealer = 150;
        for (int i = 0; i < dealer.getCards().length; i++) {
            if (dealer.getCards()[i] != null) {
                if (dealer.getCards()[i].getFaceUp()) {
                    drawCard(page, dealer.getCards()[i], Xdealer, YDealer);
                } else {
                    drawStack(page, Xdealer, YDealer);
                }
                Xdealer += 30;
                YDealer += 5;
            }
        }
    }




    public void drawCard(Graphics page,CardCard card,int X_Initial,int Y_Initial){
        if(card != null) {
            page.setColor(Color.black);
            page.fillRect(X_Initial, Y_Initial, 75, 100);
            page.setColor(Color.white);
            page.fillRect(X_Initial + 2, Y_Initial + 2, 71, 96);
            if (card.getSuite() < 2)
                page.setColor(Color.black);
            else
                page.setColor(Color.red);
            page.drawString(card.getNumberString(), X_Initial + 10, Y_Initial + 30);
            //if clubs
            if (card.getSuite() == 0) {
                page.fillOval(X_Initial + 5, Y_Initial + 45, 10, 10);
                page.fillOval(X_Initial + 15, Y_Initial + 45, 10, 10);
                page.fillOval(X_Initial + 10, Y_Initial + 37, 10, 12);
                page.fillRect(X_Initial + 13, Y_Initial + 45, 5, 13);
            }
            if (card.getSuite() == 1) {
                page.fillOval(X_Initial + 5, Y_Initial + 45, 10, 10);
                page.fillOval(X_Initial + 15, Y_Initial + 45, 10, 10);
                int x1[] = {X_Initial + 5, X_Initial + 25, X_Initial + 15};
                int y1[] = {Y_Initial + 50, Y_Initial + 50, Y_Initial + 37};
                page.fillPolygon(x1, y1, 3);
                int x2[] = {X_Initial + 15, X_Initial + 13, X_Initial + 17};
                int y2[] = {Y_Initial + 48, Y_Initial + 58, Y_Initial + 58};
                page.fillPolygon(x2, y2, 3);
            }
            if (card.getSuite() == 2) {
                page.fillOval(X_Initial + 5, Y_Initial + 45, 10, 10);
                page.fillOval(X_Initial + 15, Y_Initial + 45, 10, 10);
                int x1[] = {X_Initial + 5, X_Initial + 25, X_Initial + 15};
                int y1[] = {Y_Initial + 50, Y_Initial + 50, Y_Initial + 63};
                page.fillPolygon(x1, y1, 3);
            }
            if (card.getSuite() == 3) {

                int x1[] = {X_Initial + 5, X_Initial + 15, X_Initial + 25, X_Initial + 15};
                int y1[] = {Y_Initial + 50, Y_Initial + 37, Y_Initial + 50, Y_Initial + 63};
                page.fillPolygon(x1, y1, 4);
            }
        }
    }

    public void drawStack(Graphics page, int X, int Y){
        page.setColor(Color.black);
        int height = 100;
        int width = 75;
        page.fillRect(X, Y, width, height);
        page.setColor(Color.white);
        page.fillRect(X + 2, Y + 2, width - 4, height - 4);
        for(int y = Y + 4; y < Y + height; y += 20){
            page.setColor(Color.red);
            page.fillRect(X + 2, y, width - 4,10);
        }
        page.fillRect(X + 10, Y + 2, 10,height - 4);
        page.fillRect(X + 30, Y + 2, 10,height - 4);
        page.fillRect(X + 50, Y + 2, 10,height - 4);
    }



    public void sethand(CardHand newHand, CardHand newDealer){
        hand = newHand;
        dealer = newDealer;
        repaint();
    }
    public void setBigText(String a){
        bigText = a;
        repaint();
    }
    public void setMediumText(String a){
        mediumText = a;
        repaint();
    }
    public void setBet(int b){
        bet[0] = (b - b % 25)/25;
        b -= bet[0] * 25;
        bet[1] = (b - b % 5)/5;
        b -= bet[1] * 5;
        bet[2] = (b - b % 1)/1;
        repaint();
    }
    public void drawBet(Graphics page, int number, Color c , Color a,int x, int y, int value){

        for(int i = 0; i < number; i ++){
            page.setColor(a);
            page.fillOval(x-2,y-2,54,54);
            page.setColor(c);
            page.fillOval(x,y,50,50);
            page.setColor(a);
            page.drawString(Integer.toString(value), x + 13, y + 32);
            y += 5;
        }

    }

}

