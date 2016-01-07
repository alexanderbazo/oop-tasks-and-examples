import java.awt.event.KeyEvent;

import de.ur.mi.graphics.Color;
import de.ur.mi.graphicsapp.GraphicsApp;
import de.ur.mi.util.RandomGenerator;

/**
 * A simple demo application showing the use of key events
 * @author Alexander Bazo
 *
 */
@SuppressWarnings("serial")
public class KeyApp extends GraphicsApp {

	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;

	private RandomGenerator random;
	private Color backGroundColor;

	public void setup() {
		setupCanvas();
		setupComponents();
	}

	private void setupCanvas() {
		size(WIDTH, HEIGHT);
		backGroundColor = Color.WHITE;
	}

	private void setupComponents() {
		random = RandomGenerator.getInstance();
	}

	public void draw() {
		background(backGroundColor);
	}
	

	/*
	 * This method processes the keyboard events generated by the user.
	 * GraphicsApp already implements the KeyListener interfaces. Therefore our
	 * SnakeApp - extending the GraphicsApp - may override the interface methods
	 * to implement a reaction to the keyboard events. The keyPressed method is called 
	 * when the any key is pressed by the user. On each keyEvent the value of 
	 * backgroundColor (a instance variable) is changed to a random value. That value is 
	 * used in draw() to paint the canvases background.
	 * 
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		backGroundColor = random.nextColor();
		super.keyPressed(e);
	}

}
