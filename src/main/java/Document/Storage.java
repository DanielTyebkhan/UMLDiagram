package Document;

import java.util.List;
import java.util.ArrayList;
import Document.ObjectClass;
import Document.Arrow;
import General.Observer;
import General.Subject;

/**
 * Tracks the state of all objects in a diagram
 * Storage is a singleton and should be accessed via Storage.instance
 * @author Daniel Tyebkhan
 */
public class Storage implements Subject, Observer {
    public static Storage instance = new Storage();

    private ArrayList<ObjectClass> objects;
    private ArrayList<Arrow> arrows;
    private ArrayList<Observer> observers;

    /**
     * Constructs a new storage object
     */
    private Storage() {
        objects = new ArrayList<ObjectClass>();
        observers = new ArrayList<Observer>();
        arrows = new ArrayList<Arrow>();
    }

    /**
     * Notifies all objects observing the storage
     */
    public void update() {
        notifyObservers();
    }

    /**
     * Removes an observer
     */
    public void detachObserver(Observer obs) {
        return;
    }

    /**
     * Notifies observers
     */
    public void notifyObservers() {
        for (Observer observer : observers)
            observer.update();
    }


    /**
     * Attaches an observer
     */
    public void attachObserver(Observer obs) {
        observers.add(obs);
    }

    /**
     * Gets all present objects
     * @return present objects
     */
    public List<ObjectClass> getObjects() {
        return new ArrayList<ObjectClass>(objects);
    }

    /**
     * Gets the number of present objects
     * @return the number of present objects
     */
    public int numObjects() {
        return objects.size();
    }

    /**
     * Adds an object
     * @param object the object to be added
     */
    public void addObject(ObjectClass object) {
        object.attachObserver(this);
        objects.add(object);
        notifyObservers();
    }

    /**
     * Removes an object 
     * @param object the object to remove
     */
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

    /**
     * Adds an arrow
     * @param arrow the arrow to add
     */
    public void addArrow(Arrow arrow) {
        arrows.add(arrow);
        notifyObservers();
    }

    /**
     * Removes an arrow
     * @param arrow the arrow to remove
     */
    public void removeArrow(Arrow arrow) {
        arrows.remove(arrow);
        notifyObservers();
    }

    /**
     * Gets all present arrows
     * @return the arrows
     */
    public List<Arrow> getArrows() {
        return new ArrayList<Arrow>(arrows);
    }
}
