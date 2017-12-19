package components;
import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;

public class Elf extends Card {

    public Elf()
    {
    	image_name = "Elf";
    }
    
    /**
     * Copy a random card from our kingdom and uses its power
     * @param hand
     * @param opponentHand
     * @param kingdom
     * @param opponentKingdom
     * @param deck
     */
    // Est ce que ca fait une copie la carte ou pas ?
    @Override
    public void Power(Hand hand,Hand opponentHand,Kingdom kingdom,Kingdom opponentKingdom,Deck deck) {
    	if (kingdom.getCards().size() <= 0)
    		return;
    	
		int rand = (int) ((Math.random() - 0.00001)* (kingdom.getCards().size()));
        Card randomCard = kingdom.getCards().get(rand);
        if(!(randomCard instanceof Elf))
        {
	        randomCard.Power(hand,opponentHand,kingdom,opponentKingdom,deck);
	        kingdom.Add(randomCard);
        }
    }
    
    @Override
	public String toString() {
		return "Elf";
	}
}
