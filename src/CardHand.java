/**
 * Created by lucaswebb on 11/3/14.
 */
public class CardHand
{
        // instance variables - replace the example below with your own
        int potentialCards = 10;
        private CardCard hand[] = new CardCard[potentialCards];

        public CardHand(){    }

        public void removeCard(int index){
            hand[index-1] = null;
        }
        public void removeCard(int suite, int number){
            for(int i= 0; i < hand.length; i ++){
                if(suite ==hand[i].getSuite() && hand[i].getNumber() == number){
                    hand[i] = null;
                }
            }
        }
        public boolean addCard(CardCard addMe){

            boolean added = false;
            for(int i = 0; i < hand.length; i ++){
                if(hand[i] == null && !added){
                    added = true;
                    hand[i] = addMe;
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
            for(CardCard card:hand){
                if(card != null)
                    sum+= card.getNumber();
            }
            return sum;
        }

}