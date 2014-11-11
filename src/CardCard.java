/**
 * Created by lucaswebb on 11/3/14.
 */
public class CardCard
{
    // instance variables - replace the example below with your own
    boolean faceUp;
    private int suite;
    private int number;

    public CardCard(int newSuite, int newNumber){
        suite = newSuite;
        number = newNumber;
        faceUp = true;
    }

    public int getSuite(){
        return suite;
    }
    public int getNumber(){
        return number;
    }
    public String getSuiteString(){
        String suiteNames[] = {"clubs","spades","hearts","diamonds"};
        return suiteNames[suite];
    }
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
    public String toString(){
        return this.getNumberString() + " of " + this.getSuiteString();
    }
    public void setFaceUp(boolean b){
        faceUp = b;
    }
    public boolean getFaceUp(){
        return faceUp;
    }
}