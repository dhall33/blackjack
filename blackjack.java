/**
 * 
 * Daniel Hall
 * Final project, blackjack game
 * May 2, 2017
 */
package blackjack;
import java.util.ArrayList;

public class BlackJack {


    public static void main(String [] strArgs) {
        BlackJack objGame = new BlackJack();
        objGame.playRound();
    }

   
    public Player dealerLogic(Player objDealer, Deck objDeck) {
        return dealerLogic(objDealer, objDeck, 16);
    }


    public Player dealerLogic(Player objDealer, Deck objDeck, int intStop) {
        while(objDealer.getTotalFaceValue() <= intStop &&
            objDealer.getNumberOfCards() < 4) {
            objDealer.addCard(objDeck.getCard());        
        }
        return objDealer;
    }

    /**
     * Incomplete concept of how you might play one round of blackjack.
     */
    public void playRound() {
        //TODO: Gut this logic and add your own function calls to play your own version of BlackJack.

        Deck objDeck = new Deck();
        objDeck.shuffle();

        ArrayList<Player> aryPlayers = new ArrayList<Player>();
        aryPlayers.add(new Player());
        aryPlayers.add(new Player());
        Player objDealer = new Player("Dealer");
        objDealer.setMoney(0);
        aryPlayers.add(objDealer);

        int intCurrentPlayer = 0;

        int intCounter = 0;
        while(intCounter < 2) {
            intCurrentPlayer = 0;
            while(intCurrentPlayer < aryPlayers.size()) {
                aryPlayers.get(intCurrentPlayer).addCard(objDeck.getCard());
                intCurrentPlayer++;
            }
            intCounter++;
        }

        intCurrentPlayer = 0;
        while(intCurrentPlayer < aryPlayers.size()) {
            if(aryPlayers.get(intCurrentPlayer).hasMoney()) {
                System.out.println(objDealer);
                aryPlayers.get(intCurrentPlayer).inputBet();
            }
            intCurrentPlayer++;
        }

        this.dealerLogic(objDealer, objDeck);

        System.out.println(aryPlayers);

        if(objDeck.shouldShuffle()) {
            objDeck.shuffle();
        }

        /*
        objPlayer1.addCard(objDeck.getCard());
        objPlayer1.addCard(objDeck.getCard());
        objPlayer1.addCard(objDeck.getCard());
        objPlayer1.addCard(objDeck.getCard());
        objPlayer1.printHand();
        */
    }
}
