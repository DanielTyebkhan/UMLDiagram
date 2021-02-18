package General;

import General.Observer;
import java.util.List;

/**
 * Subject interface for the observer pattern
 * @author Daniel Tyebkhan
 */
public interface Subject {
    public void attachObserver(Observer obs);

    public void detachObserver(Observer obs);

    public void notifyObservers();
}
