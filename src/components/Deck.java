package components;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
	
	/**
     * Attributes
     */
    private List<Card> cards;
    private Random rand = new Random();
    /**
     * Constructor 
     * @param nbr_set
     */
    
    public Deck() {
    	cards = new ArrayList<Card>();
    }
        
    public Deck(int nbr_set)
    {
    	cards = new ArrayList<Card>(); 
        for(int i = 0; i < nbr_set; i++)
        {
        	cards.add(getRndCard());
        }
    }
    
    /**
     * Getters and setters
     */

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	/**
     * Methods
     */
	
	public void Add(Card card) {
		cards.add(card);
	}
	
	/**
     * Method Draw draws a card from the deck
     * @return drawn card
     */
	@SuppressWarnings("unchecked")
	private static final Class<? extends Card>[] types = new Class[]{Elf.class , Dryad.class, Gnome.class, Goblin.class, Korrigan.class, Troll.class};
    public Card getRndCard()
    {
    	try {
			return ((types[rand.nextInt(types.length)]).newInstance());
		} catch (Exception e) {return null;}
    }
    
	public Card Draw() {
		if(cards.size() >= 1)
        {
            return cards.remove(0);
        }
        return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String toPrint = "";
		
		if (cards != null) {
			for (int i = 0; i < cards.size(); i++) {
				toPrint += cards.get(i).toString() + " ";
			}
		}
		
		return toPrint;
	}
}
