package View;

import java.awt.Point;
import javax.swing.JPanel;
import java.awt.Graphics;

import Document.Arrow;

/**
 * @author Daniel Tyebkhan
 */
public abstract class ArrowDrawer {
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
            g.drawLine((int)from.getX(), (int)from.getY(), (int)to.getX(), (int)to.getY());
    }

    public void drawArrow(JPanel panel) {
        drawBody(panel.getGraphics());
        drawHead(panel);
    }

    abstract void drawHead(JPanel panel);

}
