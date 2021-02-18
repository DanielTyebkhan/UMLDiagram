package General;

import General.Observer;
import java.util.List;

public interface Subject {
    public void attachObserver(Observer obs);

    public void detachObserver(Observer obs);

    public void notifyObservers();
}
