package Document;

import Document.Notable;
import Document.ArrowType;

/**
 * @author Daniel Tyebkhan
 */
public class Arrow {
    private Notable from;
    private Notable to;
    private ArrowType type;

    public Arrow(ArrowType type, Notable from, Notable to) {
        this.from = from;
        this.to = to;
        this.type = type;
    }

    public ArrowType getType() {
        return type;
    }

    public Notable getFrom() {
        return from;
    }

    public Notable getTo() {
        return to;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Arrow) {
            Arrow oArr = (Arrow) other;
            return oArr.getFrom().equals(getFrom()) && oArr.getTo().equals(getTo());
        }
        return false;
    }
}
