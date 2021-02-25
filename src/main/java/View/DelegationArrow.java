package View;

import java.awt.Graphics;

import Document.Arrow;

/**
 * A class which draws subtype arrows
 * @author Daniel Tyebkhan
 */
public class DelegationArrow extends ArrowDrawer {

    /**
     * Constructs a SubtypeArrow
     * @param arrow the arrow to be drawn
     */
    public DelegationArrow(Arrow arrow) {
        super(arrow);
    }

    /**
     * Draws a subtype arrowhead
     * @param panel the panel to draw the arrowhead on
     */
    @Override
    public void drawHead(Graphics g) {
        g.drawPolygon(new int[] {10, 20, 30}, new int[] {100, 20, 100}, 3);
    }
}
