package View;

import Document.ArrowType;
import Document.Arrow;

/**
 * @author Daniel Tyebkhan
 */
public class ArrowFactory {
    public static ArrowDrawer makeArrow(Arrow arrow) {
        switch (arrow.getType()) {
            case SUBTYPE:
                return new SubtypeArrow(arrow);
        }
    }
}
