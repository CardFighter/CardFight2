package components;

import processing.core.PFont;
import processing.core.PVector;

public abstract class Player {
	/**
     * Attributes
     */
	protected Hand hand;
	protected Kingdom kingdom;
	protected int points;
	protected Deck deck;
	
	/**
     * Constructor with no initial parameters
     */
	public Player() {
		
	}
	
	public Player(Deck deck,PVector hand_position,PVector hand_size,PVector kingdom_position,PVector kingdom_size) {
		this.deck = deck;
		this.hand = new Hand(deck,hand_position,hand_size);
		this.kingdom = new Kingdom(kingdom_position,kingdom_size);
		this.points = 0;
	}
	
	
	
	/**
     * Getters and setters
     */
	public Hand getHand() {
		return hand;
	}
	public void setHand(Hand hand) {
		this.hand = hand;
	}
	public Kingdom getKingdom() {
		return kingdom;
	}
	public void setKingdom(Kingdom kingdom) {
		this.kingdom = kingdom;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public Deck getDeck() {
		return deck;
	}
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	/**
     * Methods 
     */
	
	/*
	 * Draw from deck function
	 */
	
	public void Draw()
	{
		this.Draw(1);
	} 

	public void Draw(int nb)
	{
		for (int i = 0; i < nb; i++) {
			hand.Add(deck.Draw());
		}
	}
	
	public void draw_score(PVector position)
	{
		PFont f = Main.mainApplet.createFont("Arial",16,true);
		Main.mainApplet.textFont(f,16);
		Main.mainApplet.text("Score : " + this.kingdom.CountPoints(), position.x, position.y);
	}
	
	public abstract Card pickCard(int delta_time);
}
