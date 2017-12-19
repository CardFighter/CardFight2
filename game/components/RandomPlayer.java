package components;

import processing.core.PVector;

public class RandomPlayer extends Player{
	
	private int playTimer = 0;
	private int timeToPlay = 1000;
	
	public RandomPlayer(Deck deck,PVector position,PVector size) {
		super(deck,position,size);
	}

	public Card pickCard(int delta_time)
	{
		playTimer += delta_time;
		if(playTimer < timeToPlay)
			return null;
		playTimer = 0;
		return hand.RandomRemove();
	}
}
