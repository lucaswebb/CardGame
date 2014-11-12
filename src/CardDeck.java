/**
 * Created by lucaswebb on 11/4/14.
 */
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
public class CardDeck
{
    private ArrayList<CardCard> deckQue= new ArrayList<CardCard>();//Creates an arraylist to hold a deck of cards

    public CardDeck()
    {
        //adds all cards (of each suit and number) to deck que
        for(int suite = 0; suite < 4; suite ++){
            for(int number = 1; number <=13; number++){
                        CardCard c = new CardCard(suite, number);
                        deckQue.add(c);
                    }
                }
            }


//java's shuffle method for lists, shuffles the deck:
    public void shuffle(){
        Collections.shuffle(deckQue);
    }
//removes a card from the deck, which goes to the user's hand
    public CardCard removeCard(){
        CardCard holder = deckQue.get(0);
        deckQue.remove(0);
        return holder;
    }
//adds an array of cards to the deck:
    public void addCard(CardCard array[]){
        for(CardCard card : array) {
            deckQue.add(card);
        }
        shuffle();
    }
//converts arraylist to an array for use in other classes:
    public CardCard[] getCards(){
        CardCard deckQue2[] = new CardCard[52];
        for(int index = 0; index < deckQue.size(); index++){
            deckQue2[index] = deckQue.get(index);
        }
        return deckQue2;
    }

}