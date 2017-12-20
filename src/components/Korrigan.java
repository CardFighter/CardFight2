package components;
public class Korrigan extends Card  {

    public Korrigan()
    {
    	image_name = "Korrigan";
    }
    
    
    /**
     * The power of the Korrigan makes the current player draw twice in the opponent hand.
     * Drawing is random
     * @param hand
     * @param opponentHand
     * @param kingdom
     * @param opponentKingdom
     * @param deck
     */
    @Override
    public void Power(Hand hand,Hand opponentHand,Kingdom kingdom,Kingdom opponentKingdom,Deck deck) {
        hand.getCards().add(opponentHand.RandomRemove());
        hand.getCards().add(opponentHand.RandomRemove());
    }
    
    @Override
	public String toString() {
		return "Korrigan";
	}
}
