/**
 * Created by lucaswebb on 11/4/14.
 */
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
public class CardDeck
{
    // instance variables - replace the example below with your own
    //private CardCard deckQue[] = new CardCard[52];
    private ArrayList<CardCard> deckQue= new ArrayList<CardCard>();

    public CardDeck()
    {
        //add all cards to deck queue
        for(int suite = 0; suite < 4; suite ++){
            for(int number = 1; number <=13; number++){
                //boolean added = false;
                //for(int i = 0; i < 52; i ++){
                    //if(deckQue[i] == null && !added){
                        CardCard c = new CardCard(suite, number);
                        deckQue.add(c);
                        //added = true;
                    }
                }
            }


//java has shuffle method for lists
    public void shuffle(){
        Collections.shuffle(deckQue);
    }
    /*{
        Random rand = new Random();

        //arbitrary number of times
        for(int i = 0; i < 100000; i ++){
            CardCard holder;
            int switch1 = rand.nextInt(deckQue.length);
            int switch2 = rand.nextInt(deckQue.length);
            holder = deckQue[switch2];
            deckQue[switch2] = deckQue[switch1];
            deckQue[switch1] = holder;

        }
        shakeToBottom(50);
    }
    */

    public CardCard removeCard(){
        //shakeToBottom(20);
        CardCard holder = deckQue.get(0);
        //deckQue[0] = null;
        //return holder;
        deckQue.remove(0);
        return holder;
    }
    public void addCard(CardCard array[]){
        //shakeToBottom(1);
        for(CardCard foo : array) {
            deckQue.add(foo);
            //deckQue[49] = foo;
            //shakeToBottom(1);
        }
        shuffle();
    }

    /*public  void shakeToBottom(int timesLeft){
        for(int i = 0; i < deckQue.length ;i ++){
            //starting from the 0 index find the first card which is null
            if(deckQue[i] == null){
                for(int m = i; m < deckQue.length; m ++){
                    if(m + 1 == 50){
                        deckQue[m] = null;
                    }
                    else
                        deckQue[m] = deckQue[m + 1];
                }
            }
        }
        if(timesLeft > 0){
            shakeToBottom((timesLeft - 1));
        }
    }
*/

    public CardCard[] getCards(){
        CardCard deckQue2[] = new CardCard[52];
        for(int index = 0; index < deckQue.size(); index++){
            deckQue2[index] = deckQue.get(index);
        }
        return deckQue2;
    }

}