package components;
public class Troll extends Card {

    public Troll()
    {
    	image_name = "Troll";
    }
    
    
    /**
     * Switch the kingdom of the two players
     * @param hand
     * @param opponentHand
     * @param kingdom
     * @param opponentKingdom
     * @param deck
     */
    @Override
    public void Power(Hand hand,Hand opponentHand,Kingdom kingdom,Kingdom opponentKingdom,Deck deck) {
        kingdom.Swap(opponentKingdom);
    }
    
    @Override
	public String toString() {
		return "Troll";
	}
}
