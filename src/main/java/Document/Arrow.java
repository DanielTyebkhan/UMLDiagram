package Document;

import Document.Notable;

/**
 * @author Daniel Tyebkhan
 */
public class Arrow {
    private Notable from;
    private Notable to;

    public Arrow(Notable from, Notable to) {
        this.from = from;
        this.to = to;
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
