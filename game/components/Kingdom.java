package components;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import processing.core.PApplet;
import processing.core.PVector;

public class Kingdom {

	/**
     * Attributes
     */
    private List<Card> cards;
    @SuppressWarnings("unchecked")
	private static final Class<? extends Card>[] types = new Class[]{Elf.class, Dryad.class, Gnome.class, Goblin.class, Korrigan.class, Troll.class};
    private PVector position;
    private PVector size;
    /**
     * Constructor with no initial parameters
     */
    public Kingdom(PVector position, PVector size) {
        this.cards = new ArrayList<Card>();
        this.position = position;
        this.size = size;
    }

    /**
     * Getters and setters
     */
    public List<Card> getCards() {
        return cards;
    }
    public void setCards(List<Card> newCards) {
        cards = newCards;
    }

    /**
     * Methods 
     */
    
    /**
     * Method CountPoints counts the point of the current kingdom
     * @return points
     */
    public int CountPoints() {
    	
    	int points = 0;
    	
    	Map<Class<? extends Card>, Integer> mapCards = new HashMap<Class<? extends Card>, Integer>();
    	
    	for(Class<? extends Card> c:types) {
    		mapCards.put(c, 0);
    	}
    	
    	for (int i = 0; i < cards.size(); i++) {
    		points++;
    		for(Class<? extends Card> c:types) {
    			if(cards.get(i).getClass() == c) {
    				mapCards.put(c, mapCards.get(c) + 1);
    			}
    		}
    	}
    	
    	int bonus = Collections.min(mapCards.values());
    	
    	points += bonus * 3;
    	
        return points;
    }

    public void Add(Card cardToAdd) {
    	cardToAdd.setSize(size);
    	cardToAdd.setPosition(position);
        cards.add(cardToAdd);
    }
    
    public void Remove(Card cardToRemove) {
    	if(cards.contains(cardToRemove))
        {
            cards.remove(cards.indexOf(cardToRemove));
        }
    }


    /**
     * Method Swap two list_cards of kingdom
     */
    public void Swap(Kingdom kingdom)
    {
        List<Card> tmp = cards;
        cards = kingdom.getCards();
        kingdom.setCards(tmp);
    }
    
    public int Length() {
    	return cards.size();
    }

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
	
	public void draw(PApplet parent)
	{
		updateCardPosition();
		for(int i = 0;i < this.cards.size();i++)
		{
			cards.get(i).draw(parent);
		}
	}
	
	public void updateCardPosition()
	{
		float step = size.x / 2;
		float pos_x = position.x + step - (step * cards.size() / 1.5f);
		for(int i = 0;i < this.cards.size();i++)
		{
			cards.get(i).setPosition(new PVector(pos_x,position.y));
			pos_x += step;
		}
	}
    
    
}