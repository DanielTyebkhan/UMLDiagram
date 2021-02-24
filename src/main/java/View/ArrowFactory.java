package View;

import Document.ArrowType;
import Document.Arrow;

/**
 * A factory for ArrowDrawers
 * @author Daniel Tyebkhan
 */
public class ArrowFactory {

    /**
     * Constructs an ArrowDrawer based on the type of arrow
     * @return the ArrowDrawer
     */
    public static ArrowDrawer makeArrow(Arrow arrow) {
        switch (arrow.getType()) {
            case SUBTYPE:
                return new SubtypeArrow(arrow);
            default:
                return new SubtypeArrow(arrow);
        }
    }
}
