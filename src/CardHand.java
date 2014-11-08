/**
 * Created by lucaswebb on 11/3/14.
 */
public class CardHand
{
    // instance variables - replace the example below with your own
    boolean isDealer;
    int potentialCards = 10;
    private CardCard hand[] = new CardCard[potentialCards];

    public CardHand(boolean b){
        isDealer = b;
    }

    public boolean addCard(CardCard addMe){

        boolean added = false;
        for(int i = 0; i < hand.length; i ++){
            if(hand[i] == null && !added){
                added = true;
                hand[i] = addMe;
                //WARNING: This code could cause problems later because it
                // will make any card added into the second position face down
                if(i == 1 && isDealer){
                    hand[i].setFaceUp(false);
                }
            }
        }
        //returns true if the card has been successfully added
        return added;
    }

    public CardCard[] removeCards(){
        int count = 0;
        for(CardCard foo: hand){
            if(foo != null){
                count ++;
            }
        }
        CardCard[] array = new CardCard[count];
        for(int i = 0; i < count; i ++){
            boolean needsToAdd = true;
            for(int m = 0; m < hand.length; m ++){
                if(hand[m] != null && needsToAdd){
                    array[i] = hand[m];
                    needsToAdd = false;
                }
            }
        }
        for(int i = 0; i < hand.length; i ++){
            hand[i] = null;
        }
        return array;
    }

    public CardCard[] getCards(){
        return hand;
    }

    public int getSum(){
        int sum= 0;
        int aceCount = 0;
        for(CardCard card:hand){
            if(card != null)
                switch(card.getNumber()){
                    case 2:
                        sum += 11;
                        aceCount ++;
                        break;
                    case 11:
                        sum += 10;
                        break;
                    case 12:
                        sum += 10;
                        break;
                    case 13:
                        sum += 10;
                        break;
                    default:
                        sum += card.getNumber();
                }
        }
        while(sum > 21 && aceCount > 0){
            aceCount --;
            sum -= 10;
        }
        return sum;
    }

    public void faceUp(){
        hand[1].setFaceUp(true);
    }


}