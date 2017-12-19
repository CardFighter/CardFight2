package components;

import processing.core.PVector;

public abstract class Player {
	/**
     * Attributes
     */
	protected Hand hand;
	protected Kingdom kingdom;
	protected int points;
	protected Deck deck;
	protected PVector position;
	protected PVector size;
	
	/**
     * Constructor with no initial parameters
     */
	public Player() {
		
	}
	
	public Player(Deck deck,PVector position,PVector size) {
		this.deck = deck;
		this.hand = new Hand(deck,position,size);
		this.kingdom = new Kingdom();
		this.points = 0;
		this.position = position;
		this.size = size;
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
	
	public abstract Card pickCard(int delta_time);
}
