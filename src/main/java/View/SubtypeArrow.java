package View;

import javax.swing.JPanel;

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
    public void drawHead(JPanel panel) {
    }
}
