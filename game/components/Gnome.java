package components;
public class Gnome extends Card {

    public Gnome()
    {
    	image_name = "Gnome";
    }

    /**
     * Methods
     */
    
    /**
     * The power of Gnome draws two cards from the deck and place them in Hand
     * @param hand
     * @param opponentHand
     * @param kingdom
     * @param opponentKingdom
     * @param deck
     */
    @Override
    public void Power(Hand hand,Hand opponentHand,Kingdom kingdom,Kingdom opponentKingdom,Deck deck) {
        hand.Draw(deck);
        hand.Draw(deck);
    }
    
    @Override
	public String toString() {
		return "Gnome";
	}
}
