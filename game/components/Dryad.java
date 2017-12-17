package components;
import java.util.Random;

public class Dryad extends Card {

	private static Random rand = new Random();
	
    public Dryad()
    {
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
        kingdom.Add(StealCard(opponentKingdom));
    }
    
    /**
     * Method StealCard steals a card from the opponent kingdom which is robbed
     * @param robbedKingdom
     * @return stolenCard
     */
    public Card StealCard(Kingdom robbedKingdom) {
    	
    	int r = rand.nextInt(robbedKingdom.Length());
    	
    	Card stolenCard = robbedKingdom.getCards().get(r);
    	robbedKingdom.Remove(stolenCard);
    	
    	return stolenCard;
    }
    
    @Override
	public String toString() {
		return "Dryad";
	}
}
