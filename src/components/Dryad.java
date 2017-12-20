package components;
import java.util.Random;

public class Dryad extends Card {
	
    public Dryad()
    {
    	image_name = "Dryad";
    }
    
    
    /**
     * Method Power applies the power of the card
     * The Dryad's power steals an opponent card from its kingdom and places
     * it into our kingdom. It doesn't apply the power of the card stolen
     * @param hand
     * @param opponentHand
     * @kingdom
     * @opponentKingdom
     * @deck
     */
    @Override
    public void Power(Hand hand,Hand opponentHand,Kingdom kingdom,Kingdom opponentKingdom,Deck deck) {
    	Card stolen_card = StealCard(opponentKingdom); 
    	if (stolen_card != null)
    		kingdom.Add(stolen_card);
    }
    
    /**
     * Method StealCard steals a card from the opponent kingdom which is robbed
     * @param robbedKingdom
     * @return stolenCard
     */
    public Card StealCard(Kingdom robbedKingdom) {
    	if(robbedKingdom.getCards().size() >=1) {
			int rand = (int) ((Math.random() - 0.00001)* (robbedKingdom.getCards().size()));
			return robbedKingdom.getCards().remove(rand);
		}
		return null;
    	/*
    	int r = rand.nextInt(robbedKingdom.Length());
    	
    	Card stolenCard = robbedKingdom.getCards().get(r);
    	robbedKingdom.Remove(stolenCard);
    	
    	return stolenCard;
    	*/
    }
    
    @Override
	public String toString() {
		return "Dryad";
	}
}
