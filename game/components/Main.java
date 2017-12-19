package components;
import processing.core.PApplet;

public class Main extends PApplet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Game game;
	public static PApplet mainApplet;
	public boolean mouseGotPressed = false;
	
	public static void main(String[] args)
	{
		PApplet.main("components.Main");
	}
	

    public void setup(){
    	mainApplet = this;
    	
    	size(800,600);
        fill(120,50,240);
        game = new Game();
    }

    public void draw(){
    	game.update(this);
    	this.mouseGotPressed = false;
    	this.clear();
    	game.draw(this);
    }
    
    public void mouseClicked()
    {
    	mouseGotPressed = true;
    }
}
