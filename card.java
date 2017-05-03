/**
 * Daneil Hall
 * Card generator
 * May 2, 2017
 */

import java.util.Random;


public class Card {

    
    private Random objRandom = new Random();
    
    private int intCardValue = 0;

    /**
     * Default card maker
     */
    public Card()
    {
        this.intCardValue = objRandom.nextInt(52) + 1;
    }

    /**
     * generates cards 1 thru 52
     * 
     */
    public Card(int pintCard)
    {
        if ((pintCard < 1) || (pintCard > 52)) {
            pintCard = 1;
            System.err.println("Can't do that! Imma set card value to 1 instead.");
        }
        this.intCardValue = pintCard;
    }

  
    public int getFace() {
        return ((intCardValue - 1) % 13) + 1;
    }

  
    public int getFaceValue() {
        int intFaceValue = getFace();
        
        //Face value of card
        if(intFaceValue > 10) {
            intFaceValue = 10;
        }

        return intFaceValue;
    }

 
    public String getFaceString() {
        String strReturn = "";
        int intFace = this.getFace();
        switch(intFace)
        {
            case 1:
                strReturn += "Ace";
                break;
            case 11:
                strReturn += "Jack";
                break;
            case 12:
                strReturn += "Queen";
                break;
            case 13:
                strReturn += "King";
                break;
            default:
                strReturn += intFace;
        }

        return strReturn;
    }


    public int getSuite() {
        return (intCardValue - 1) / 13;
    }


    public String getSuiteString() {
        String strReturn = "";
        int intSuite = this.getSuite();
        if(intSuite == 0) {
            strReturn += "Club";
        } else if (intSuite == 1) {
            strReturn += "Diamonds";
        } else if (intSuite == 2) {
            strReturn += "Hearts";
        } else if (intSuite == 3) {
            strReturn += "Spades";
        }
        return strReturn;
    }

    public String toString() {
        String strReturn = "";
        strReturn += this.getFaceString();
        strReturn += " of ";
        strReturn += this.getSuiteString();
        return strReturn;
    }

//finds the name of card
    public static void main(String [] strArgs) {
        //Variables
        Card objCard = new Card();
        System.out.println(objCard);
    }

}
