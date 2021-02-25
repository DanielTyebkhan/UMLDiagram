package Document;

import java.util.List;
import java.util.ArrayList;
import Document.ObjectClass;
import Document.Arrow;
import General.Observer;
import General.Subject;
import Filemanagement.StorageContainer;
import java.io.Serializable; 

/**
 * Tracks the state of all objects in a diagram
 * Storage is a singleton and should be accessed via Storage.instance
 * @author Daniel Tyebkhan
 */
public class Storage implements Subject, Observer, Serializable {
    public static Storage instance = new Storage();

    private ArrayList<ObjectClass> objects;
    private ArrayList<Arrow> arrows;
    private transient ArrayList<Observer> observers;

    /**
     * Constructs a new storage object
     */
    private Storage() {
        objects = new ArrayList<ObjectClass>();
        observers = new ArrayList<Observer>();
        arrows = new ArrayList<Arrow>();
    }

    public void setStorage(StorageContainer storage) {
        for (ObjectClass obj : storage.objects)
            instance.addObject(obj);
        for (Arrow arr : storage.arrows)
            instance.addArrow(arr);
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
        observers.remove(obs);
    }

    /**
     * Notifies observers
     */
    public void notifyObservers() {
        for (Observer observer : observers)
            observer.update();
    }

    public void clear() {
        objects.clear();
        arrows.clear();
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
    public void removeObject(Notable object) {
        objects.remove(object);
        ArrayList<Arrow> toRemove = new ArrayList<Arrow>();
        for (Arrow arrow : arrows) {
            if (arrow.getFrom().equals(object) || arrow.getTo().equals(object))
                toRemove.add(arrow);
        }
        for (Arrow arrow : toRemove) 
            removeArrow(arrow);
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
