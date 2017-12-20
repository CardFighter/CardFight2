package components;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Game {
	
	private Deck deck;
	private Player player1;
	private Player player2;
	private int turnPlayerId = 0;
	private int prev_time;
	Player currentPlayer;
	Player currentOpponent;
	PImage background;
	
	public Game()
	{
		deck = new Deck(25);
		player1 = new HumanPlayer(deck,new PVector(0.0f,650.0f),new PVector(600f * Main.size_factor,150f * Main.size_factor),new PVector(550f,430f),new PVector(90f * Main.size_factor,110f * Main.size_factor));
		player2 = new RandomPlayer(deck,new PVector(0.0f,00.0f),new PVector(600f * Main.size_factor,150f * Main.size_factor),new PVector(550f,260f),new PVector(90f * Main.size_factor,110f * Main.size_factor));
		currentPlayer = player1;
		currentOpponent = player2;
		
		background = Main.mainApplet.loadImage("backgroundV2.png");
		prev_time = 0;
	}
	
	public void update(PApplet parent)
	{
		if (currentPlayer.getHand().getCards().isEmpty())
	    	return;
		
		int delta_time = parent.millis() - prev_time;
		prev_time = parent.millis();
		
		Card cardToPlay = currentPlayer.pickCard(delta_time);
		if(cardToPlay == null)
			return;
		cardToPlay.Power(currentPlayer.getHand(), currentOpponent.getHand(), currentPlayer.getKingdom(), currentOpponent.getKingdom(), deck);
	    currentPlayer.kingdom.Add(cardToPlay);
	    
	    changeTurn();
	}
	
	public void changeTurn()
	{
		turnPlayerId = (turnPlayerId + 1) % 2;
		
		currentPlayer = turnPlayerId == 0 ? player1 : player2;
		currentOpponent = turnPlayerId == 0 ? player2 : player1;
		startTurn();
	}
	
	public void startTurn()
	{
		currentPlayer.Draw();
	}
	
	public void draw(PApplet parent)
	{
		parent.image(background,0,0, 1200, 900);
		player1.getHand().draw(parent);
		player2.getHand().draw(parent);
		player1.getKingdom().draw(parent);
		player2.getKingdom().draw(parent);
		player1.draw_score(new PVector(10f,650f));
		player2.draw_score(new PVector(10f,200f));
	}
}
