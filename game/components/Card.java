package components;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public abstract class Card {
	/**
     * Constructor 
     */
	
	private PImage image = null;
	protected String image_name = "";
	public PVector position;
	public PVector size;
	
    public Card()
    {
    }

    /**
     * Methods
     */
    
    /**
     * Method Power applies the power of the card
     * @param hand
     * @param opponentHand
     * @param kingdom
     * @param opponentKingdom
     * @param deck
     */
    public void Power(Hand hand,Hand opponentHand,Kingdom kingdom,Kingdom opponentKingdom,Deck deck)
    {
    }
    
    public void draw(PApplet parent,PVector position,PVector size)
    {
    	if(image == null)
    		image = parent.loadImage(this.toString() + ".png");
    	parent.image(image, position.x, position.y,size.x,size.y);
    }
    
    public void setPosition(PVector new_position)
    {
    	
    }
}
