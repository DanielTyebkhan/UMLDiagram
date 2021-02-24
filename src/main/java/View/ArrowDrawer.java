package View;

import java.awt.Point;
import javax.swing.JPanel;

import Document.Arrow;

public abstract class ArrowDrawer {
    private Arrow arrow;
    private Point fromPos;
    private Point toPos;

    public ArrowDrawer(Arrow arrow) {
        this.arrow = arrow;
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

    abstract void drawArrow(JPanel panel);

}
