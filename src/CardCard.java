/**
 * Created by lucaswebb on 11/3/14.
 */
public class CardCard
{
    //Initialize instance variables
    boolean faceUp;
    private int suite;
    private int number;

    //Create card object
    public CardCard(int newSuite, int newNumber){
        suite = newSuite;
        number = newNumber;
        faceUp = true;
    }

    //Getter methods
    public int getSuite(){
        return suite;
    }
    public int getNumber(){
        return number;
    }

    //Method to get suite in a string
    public String getSuiteString(){
        String suiteNames[] = {"clubs","spades","hearts","diamonds"};
        return suiteNames[suite];
    }

    //Method to get string of card value
    public String getNumberString(){
        String str = "";
        switch(number){
            case 1:
                str = "Ace";
                break;
            case 11:
                str =  "Jack";
                break;
            case 12:
                str = "Queen";
                break;
            case 13:
                str =  "King";
                break;
            default:
                str = Integer.toString(number);
                break;
        }
        return str;
    }
    //To string method
    public String toString(){
        return this.getNumberString() + " of " + this.getSuiteString();
    }

    //Methods to set face up and to getFaceup
    public void setFaceUp(boolean b){
        faceUp = b;
    }
    public boolean getFaceUp(){
        return faceUp;
    }
}