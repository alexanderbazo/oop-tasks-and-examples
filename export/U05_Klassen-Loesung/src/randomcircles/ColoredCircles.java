package randomcircles;

import de.ur.mi.graphicsapp.GraphicsApp;
import de.ur.mi.graphics.*;
import de.ur.mi.geom.*;
import de.ur.mi.util.*;

/**
 * @author Alexander Bazo
 * @version 1.0
 * 
 * This program draws 100 colored circles onto the canvas. The circles
 * are drawn on startup. Do not use the draw-loop for this assignment.
 */
@SuppressWarnings("serial")
public class ColoredCircles extends GraphicsApp {

	private static final int WIDTH = 800;
	private static final int HEIGHT = 800;
	private static final Color BACKGROUNDCOLOR = Color.WHITE;
	private static final int MAX_CIRCLES = 100;
	private static final int MIN_CIRCLE_WIDTH = 5;
	private static final int MAX_CIRCLE_WIDTH = 50;

	private RandomGenerator random;

	public void setup() {
		setupApplication();
		drawCircles();
	}

	private void setupApplication() {
		size(WIDTH, HEIGHT);
		background(BACKGROUNDCOLOR);
		random = RandomGenerator.getInstance();
	}

	private void drawCircles() {
		for (int i = 0; i < MAX_CIRCLES; i++) {
			drawCircle();
		}
	}

	/**
	 * Draws a single circle using random values, generated by getNextColor(), getNextDiameter() and getNextPoint()
	 */
	private void drawCircle() {
		Color color = getNextColor();
		int diameter = getNextDiameter();
		Point center = getNextPoint(diameter);

		Ellipse circle = new Ellipse(center, diameter, diameter, color);
		circle.draw();
	}

	/**
	 * Returns a random color for a new circle
	 * @return A random color (Color), generated by using the RandomGenerator instance
	 */
	private Color getNextColor() {
		return random.nextColor();
	}

	/**
	 * Returns a random diameter for a new circle
	 * @return A random diameter (int),  generated by using the RandomGenerator instance and 
	 * MIN_CIRCLE_WIDTH and MAX_CIRCLE_WIDTH as lower and upper limits
	 */
	private int getNextDiameter() {
		return random.nextInt(MIN_CIRCLE_WIDTH, MAX_CIRCLE_WIDTH);
	}

	/**
	 * Returns a random center point for a new circle
	 * @param diameter Diameter of the new circle, used to generate a random position within the canvas boundaries 
	 * @return A random position (Point) within the canvas
	 */
	private Point getNextPoint(int diameter) {
		int lowerX = diameter / 2;
		int upperX = WIDTH - (diameter / 2);
		int lowerY = diameter / 2;
		int upperY = HEIGHT - (diameter / 2);

		int x = random.nextInt(lowerX, upperX);
		int y = random.nextInt(lowerY, upperY);
		return new Point(x, y);
	}

}
