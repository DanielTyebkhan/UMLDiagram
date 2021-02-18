package Document;

import java.util.List;
import java.util.ArrayList;
import Document.ObjectClass;
import General.Observer;
import General.Subject;

/**
 * Tracks the state of all objects in a diagram
 * @author Daniel Tyebkhan
 */
public class Storage implements Subject, Observer {
    private ArrayList<ObjectClass> objects;
    private ArrayList<Observer> observers;

    public void update() {
        notifyObservers();
    }

    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    public void detachObserver(Observer obs) {
        return;
    }

    public void notifyObservers() {
        for (Observer observer : observers)
            observer.update();
    }

    public void attachObserver(Observer obs) {
        observers.add(obs);
    }

    public List<ObjectClass> getObjects() {
        return new ArrayList<ObjectClass>(objects);
    }

    public int numObjects() {
        return objects.size();
    }

    public void addObject(ObjectClass object) {
        objects.add(object);
        notifyObservers();
    }

    public boolean removeObject(ObjectClass object) {
        int toRemove = -1;
        int index = 0;
        while (index < numObjects()) {
            if (getObjects().get(index).equals(object))
                toRemove = index;
        }
        if (toRemove > -1) {
            objects.remove(toRemove);
            notifyObservers();
            return true;
        }
        return false;
    }
}
