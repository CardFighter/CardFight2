package components;
import java.util.Random;

public class Elf extends Card {

    private static Random rand = new Random();

    public Elf()
    {
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

        int r = rand.nextInt(kingdom.Length());

        Card randomCard = kingdom.getCards().get(r);
        randomCard.Power(hand,opponentHand,kingdom,opponentKingdom,deck);
        kingdom.Add(randomCard);
    }
    
    @Override
	public String toString() {
		return "Elf";
	}
}
