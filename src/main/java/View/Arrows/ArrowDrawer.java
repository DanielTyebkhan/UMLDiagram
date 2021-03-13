package View.Arrows;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Graphics;

import Document.Arrow;
import View.ThemeObject;

/**
 * A class which draws arrows
 * @author Daniel Tyebkhan
 */
public abstract class ArrowDrawer {
    protected static final int HEIGHT = 10;
    protected static final int WIDTH = 10;
    private Arrow arrow;
    private Point fromPos;
    private Point toPos;

    /**
     * Construct an ArrowDrawer
     * @param arrow the arrow to draw
     */
    public ArrowDrawer(Arrow arrow) {
        this.arrow = arrow;
    }

    /**
     * Gets the associated arrow
     * @return the arrow
     */
    public Arrow getArrow() {
        return arrow;
    }

    /**
     * Sets the location to start drawing the arrow
     * @param from the start point
     */
    public void setFromPosition(Point from) {
        fromPos = from;
    }

    /**
     * Sets the location to terminate the arrow drawing
     * @param to the termination point
     */
    public void setToPosition(Point to) {
        toPos = to;
    }

    /**
     * Gets the start position
     * @return the start position of the arrow
     */
    public Point getFromPosition() {
        return fromPos;
    }

    /**
     * Gets the termination point
     * @return the termination point
     */
    public Point getToPosition() {
        return toPos;
    }

    /**
     * Draws the arrow's body
     * @param g the graphics object to draw with
     */
    private void drawBody(Graphics g) {
        Point from = getFromPosition();
        Point to = getToPosition();
        if (from != null && to != null)
            g.drawLine((int)from.getX(), (int)from.getY(), (int)to.getX()-WIDTH, (int)to.getY());
    }

    /**
     * Draws the arrow
     * @param g the graphics to draw with
     */
    public void drawArrow(Graphics g) {
        g.setColor(ThemeObject.theme.getArrowColor());
        drawBody(g);
        drawHead(g);
    }

    /**
     * Draws the head of the arrow
     * @param g the graphics to draw with
     */
    protected void drawHead(Graphics g) {
        int toX = (int) getToPosition().getX();
        int toY = (int) getToPosition().getY();
        int halfHeight = (int)(HEIGHT / 2);
        Polygon head = new Polygon(new int[] {toX-WIDTH, toX-WIDTH, toX}, new int[] {toY+halfHeight, toY-halfHeight, toY}, 3);
        g.drawPolygon(head);
        g.fillPolygon(head);
    }

}
