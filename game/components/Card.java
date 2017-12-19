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
	protected PVector position = new PVector(0f,0f);
	protected PVector size = new PVector(0f,0f);
	
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
    
    public void draw(PApplet parent)
    {
    	if(image == null)
    		image = parent.loadImage(this.toString() + ".png");
    	parent.image(image, position.x, position.y,size.x,size.y);
    }
    
    public void setSize(PVector size)
    {
    	this.size = size;
    }
    
    public void setPosition(PVector position)
    {
    	this.position = position;	
    }
    
    public boolean positionOnCard(PVector position)
    {
    	if(this.position.x < position.x && this.position.x + this.size.x > position.x)
    	{
    		if(this.position.y < position.y && this.position.y + this.size.y > position.y)
    		{
    			return true;
    		}
    	}
    	return false;
    }
    
}
