package components;
public class Player {
	/**
     * Attributes
     */
	private Hand hand;
	private Kingdom kingdom;
	private int points;
	
	/**
     * Constructor with no initial parameters
     */
	public Player() {
		
	}
	public Player(Hand hand, Kingdom kingdom, int points) {
		super();
		this.hand = hand;
		this.kingdom = kingdom;
		this.points = points;
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
	
	/**
     * Methods 
     */
	
	public int CountPoints() {
		return kingdom.CountPoints();
	}
}
