/**
 * Created by lucaswebb on 11/4/14.
 */
import java.util.Random;
public class CardDeck
{
    // instance variables - replace the example below with your own
    private CardCard deckQue[] = new CardCard[50];


    public CardDeck()
    {
        //add all cards to deck qeaue
        for(int suite = 0; suite < 4; suite ++){
            for(int number = 2; number <=13; number++){
                boolean added = false;
                for(int i = 0; i < 50; i ++){
                    if(deckQue[i] == null && !added){
                        deckQue[i] = new CardCard(suite, number);
                        added = true;
                    }
                }
            }
        }
    }

    public void shuffle()
    {
        Random rand = new Random();

        //arbitarary number of times
        for(int i = 0; i < 100000; i ++){
            CardCard holder;
            int switch1 = rand.nextInt(deckQue.length);
            int switch2 = rand.nextInt(deckQue.length);
            holder = deckQue[switch2];
            deckQue[switch2] = deckQue[switch1];
            deckQue[switch1] = holder;
        }
    }

    public CardCard removeCard(){
        shakeToBottom(20);
        CardCard holder = deckQue[0];
        deckQue[0] = null;
        return holder;
    }

    public  void shakeToBottom(int timesLeft){
        for(int i = 0; i < deckQue.length ;i ++){
            if(deckQue[i] == null){
                for(int m = i; m < deckQue.length - 1; m ++){
                    deckQue[m] = deckQue[m + 1];
                }
            }
        }
        if(timesLeft < 0){
            shakeToBottom((timesLeft - 1));
        }
    }

    public CardCard getCard(int index){
        return deckQue[index];
    }
}