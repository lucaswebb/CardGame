/**
 * Created by lucaswebb on 11/4/14.
 */
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
public class CardDeck
{
    private ArrayList<CardCard> deckQue= new ArrayList<CardCard>();

    public CardDeck()
    {
        //add all cards to deck queue
        for(int suite = 0; suite < 4; suite ++){
            for(int number = 1; number <=13; number++){
                        CardCard c = new CardCard(suite, number);
                        deckQue.add(c);
                    }
                }
            }


//java's shuffle method for lists
    public void shuffle(){
        Collections.shuffle(deckQue);
    }

    public CardCard removeCard(){
        CardCard holder = deckQue.get(0);
        deckQue.remove(0);
        return holder;
    }
    public void addCard(CardCard array[]){
        for(CardCard card : array) {
            deckQue.add(card);
        }
        shuffle();
    }

    public CardCard[] getCards(){
        CardCard deckQue2[] = new CardCard[52];
        for(int index = 0; index < deckQue.size(); index++){
            deckQue2[index] = deckQue.get(index);
        }
        return deckQue2;
    }

}