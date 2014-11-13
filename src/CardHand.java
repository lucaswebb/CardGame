/**
 * Created by lucaswebb on 11/3/14.
 */
public class CardHand
{
    // instance variables - replace the example below with your own
    boolean isDealer;
    int potentialCards = 10;
    private CardCard hand[] = new CardCard[potentialCards];

    boolean isSoft;//refers to whether the ace counts as a 11 or 17


    public CardHand(boolean b){
        isDealer = b;
        isSoft = false;
    }
    //Adds a card to the user's hand:
    public boolean addCard(CardCard addMe){
        boolean added = false;
        for(int i = 0; i < hand.length; i ++){
            if(hand[i] == null && !added){
                added = true; //sets card as added, then adds it to the hand
                hand[i] = addMe;
                if(i == 1 && isDealer){
                    hand[i].setFaceUp(false);
                }
            }
        }
        //returns true if the card has been successfully added
        return added;
    }
    //clears user's hand:
    public CardCard[] removeCards(){
        int count = 0;
        isSoft = false;
        for(CardCard foo: hand){
            if(foo != null){
                count ++; //counts number of cards in the user's hand
            }
        }
        CardCard[] array;
        array = new CardCard[count];
        //makes each card in the hand null -> hand is cleared
        for(int i = 0; i < count; i ++){
            boolean needsToAdd = true;
            for(int m = 0; m < hand.length; m ++){
                if(hand[m] != null && needsToAdd){
                    array[i] = hand[m];
                    hand[m] = null;
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
    //Finds sum of hand, and sees if it is <= 21. Also accounts for ace having a value of 1 or 11.
    public int getSum(){
        int sum= 0;
        int aceCount = 0;
        for(CardCard card:hand){
            if(card != null)
                switch(card.getNumber()){
                    case 1:
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
            isSoft = true;
            aceCount --;
            sum -= 10;
        }
        return sum;
    }
    //Determines end result of round:
    public void faceUp(){
        hand[1].setFaceUp(true);
    }
    public boolean getIsSoft(){
        return isSoft;
    }
    public boolean getBlackJack(){
        boolean hasAce = false;
        boolean has10 = false;
        for(CardCard c: hand) {
            if (c != null) {
                if (c.getNumber() == 1)
                    hasAce = !hasAce;
                if (c.getNumber() >= 10) {
                    has10 = true;
                }
            }
        }

        return this.getSum() == 21 && has10 && hasAce;
    }

    public boolean getBust(){
        return this.getSum() > 21;
    }


}