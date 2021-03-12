package Document;

import Document.Notable;
import Document.ArrowType;
import java.io.Serializable; 

/**
 * Represents an arrow
 * @author Daniel Tyebkhan
 */
public class Arrow extends Notable {
    private static final String TO = "to";

    private Notable from;
    private Notable to;
    private ArrowType type;

    /**
     * Constructs an arrow with a type, origin, and destination
     * @param type The type 
     * @param from the origin
     * @param to the destination
     */
    public Arrow(ArrowType type, Notable from, Notable to) {
        super(from.getName() + TO + to.getName());
        this.from = from;
        this.to = to;
        this.type = type;
    }

    /**
     * Gets the type of the arrow
     * @return the type
     */
    public ArrowType getType() {
        return type;
    }

    /**
     * Gets the origin
     * @return the origin
     */
    public Notable getFrom() {
        return from;
    }

    /**
     * Gets the destination
     * @return the destination
     */
    public Notable getTo() {
        return to;
    }

    /**
     * Checks if two arrows are equal
     * Two arrows are equal if they have the same type source and destination
     * @param other the object to compare to
     * @return true if this equals other else false
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Arrow) {
            Arrow oArr = (Arrow) other;
            return oArr.getType().equals(getType()) && oArr.getFrom().equals(getFrom()) && oArr.getTo().equals(getTo());
        }
        return false;
    }
}
