package View;

import java.awt.Graphics;
import java.awt.Polygon;

import Document.Arrow;

/**
 * A class which draws subtype arrows
 * @author Daniel Tyebkhan
 */
public class SubtypeArrow extends ArrowDrawer {

    /**
     * Constructs a SubtypeArrow
     * @param arrow the arrow to be drawn
     */
    public SubtypeArrow(Arrow arrow) {
        super(arrow);
    }

    /**
     * Draws a subtype arrowhead
     * @param panel the panel to draw the arrowhead on
     */
    @Override
    public void drawHead(Graphics g) {
        int toX = (int) getToPosition().getX();
        int toY = (int) getToPosition().getY();
        int halfHeight = (int)(HEIGHT / 2);
        Polygon head = new Polygon(new int[] {toX-WIDTH, toX-WIDTH, toX}, new int[] {toY+halfHeight, toY-halfHeight, toY}, 3);
        g.drawPolygon(head);
    }
}
