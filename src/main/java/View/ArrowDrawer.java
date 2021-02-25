package View;

import java.awt.Point;
import java.awt.Polygon;
import javax.swing.JPanel;
import java.awt.Graphics;

import Document.Arrow;

/**
 * @author Daniel Tyebkhan
 */
public abstract class ArrowDrawer {
    protected static final int HEIGHT = 10;
    protected static final int WIDTH = 10;
    private Arrow arrow;
    private Point fromPos;
    private Point toPos;

    public ArrowDrawer(Arrow arrow) {
        this.arrow = arrow;
    }

    public Arrow getArrow() {
        return arrow;
    }

    public void setFromPosition(Point from) {
        fromPos = from;
    }

    public void setToPosition(Point to) {
        toPos = to;
    }

    public Point getFromPosition() {
        return fromPos;
    }

    public Point getToPosition() {
        return toPos;
    }

    private void drawBody(Graphics g) {
        Point from = getFromPosition();
        Point to = getToPosition();
        if (from != null && to != null)
            g.drawLine((int)from.getX(), (int)from.getY(), (int)to.getX()-WIDTH, (int)to.getY());
    }

    public void drawArrow(Graphics g) {
        drawBody(g);
        drawHead(g);
    }

    protected void drawHead(Graphics g) {
        int toX = (int) getToPosition().getX();
        int toY = (int) getToPosition().getY();
        int halfHeight = (int)(HEIGHT / 2);
        Polygon head = new Polygon(new int[] {toX-WIDTH, toX-WIDTH, toX}, new int[] {toY+halfHeight, toY-halfHeight, toY}, 3);
        g.drawPolygon(head);
        g.fillPolygon(head);
    }

}
