package components;

import processing.core.PVector;

public class HumanPlayer extends Player{

	public HumanPlayer(Deck deck,PVector hand_position,PVector hand_size,PVector kingdom_position,PVector kingdom_size) {
		super(deck,hand_position,hand_size,kingdom_position,kingdom_size);
	}
	
	@Override
	public Card pickCard(int delta_time) {
		if(Main.mainApplet.mousePressed)
		{
			for(int i = 0;i < getHand().getCards().size();i++)
			{
				if(getHand().getCards().get(i).positionOnCard(new PVector(Main.mainApplet.mouseX,Main.mainApplet.mouseY)))
				{
					return getHand().Remove(getHand().getCards().get(i));
				}
			}
		}
		return null;
	}

}
