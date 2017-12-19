package components;

import processing.core.PVector;

public class RandomPlayer extends Player{
	
	private int playTimer = 0;
	private int timeToPlay = 5000;
	
	public RandomPlayer(Deck deck,PVector hand_position,PVector hand_size,PVector kingdom_position,PVector kingdom_size) {
		super(deck,hand_position,hand_size,kingdom_position,kingdom_size);
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
