/**
 * Created by lucaswebb on 11/3/14.
 */
public class CardHand
{
        // instance variables - replace the example below with your own
        private CardCard hand[] = new CardCard[7];

        public CardHand(){
        }

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

        public CardCard[] getCards(){
            return hand;
        }
}