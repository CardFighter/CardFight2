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
		player1 = new RandomPlayer(deck,new PVector(0.0f,420.0f),new PVector(600f,50f));
		player2 = new RandomPlayer(deck,new PVector(0.0f,30.0f),new PVector(600f,50f));
		currentPlayer = player1;
		currentOpponent = player2;
		
		background = Main.mainApplet.loadImage("background.png");
		prev_time = 0;
	}
	
	public void update(PApplet parent)
	{
		if (deck.getCards().isEmpty())
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
		parent.image(background,0,0, 800, 600);
		player1.getHand().draw(parent);
		player2.getHand().draw(parent);
		player1.getKingdom().draw(parent, new PVector(360f,290), new PVector(80f,120f));
		player2.getKingdom().draw(parent, new PVector(360f,170), new PVector(80f,120f));
	}
}
