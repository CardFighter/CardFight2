package components;

import processing.core.PVector;

public class HumanPlayer extends Player{

	public HumanPlayer(Deck deck,PVector position,PVector size) {
		super(deck,position,size);
	}
	@Override
	public Card pickCard(int delta_time) {
		if(Main.mainApplet.mousePressed)
		{
			
		}
		return null;
	}

}
