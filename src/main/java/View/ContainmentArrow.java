package View;

import java.awt.Graphics;

import Document.Arrow;

/**
 * A class which draws subtype arrows
 * @author Daniel Tyebkhan
 */
public class ContainmentArrow extends ArrowDrawer {

    /**
     * Constructs a SubtypeArrow
     * @param arrow the arrow to be drawn
     */
    public ContainmentArrow(Arrow arrow) {
        super(arrow);
    }

    /**
     * Draws the arrow's head
     * @param g the graphics to draw with
     */
    public void DrawHead(Graphics g) {
        int toX = (int) getToPosition().getX();
        int toY = (int) getToPosition().getY();
        int halfHeight = (int)(HEIGHT / 2);
        g.drawPolygon(new int[] {toX-WIDTH, toX-WIDTH, toX}, new int[] {toY+halfHeight, toY-halfHeight, toY}, 3);
    }
}
