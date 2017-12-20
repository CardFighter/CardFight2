package components;
public class Goblin extends Card {


    public Goblin()
    {
    	image_name = "Goblin";
    }
    
    /**
     * Methods
     */
    
    /**
     * Switch the hand of the two players
     * @param hand
     * @param opponentHand
     * @param kingdom
     * @param opponentKingdom
     * @param deck
     */
    @Override
    public void Power(Hand hand,Hand opponentHand,Kingdom kingdom,Kingdom opponentKingdom,Deck deck) {
        hand.Swap(opponentHand);
    }
    
    @Override
	public String toString() {
		return "Goblin";
	}
}
