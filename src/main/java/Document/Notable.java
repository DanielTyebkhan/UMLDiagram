package Document;
import java.io.Serializable;
import java.util.ArrayList;

import General.Observer;
import General.Subject; 

/**
 * Represents an object with a name and an attachable note
 * @author Daniel Tyebkhan
 */
public class Notable implements Serializable, Subject {
    String name,
           note;

    private ArrayList<Observer> observers = new ArrayList<>();

    /**
     * Constructs a notable with a name and note
     * @param name the name
     * @param note the note
     */
    public Notable(String name, String note) {
        this.name = name;
        this.note = note;
    }

    /**
     * Constructs a notable with a name
     * @param name the name 
     */
    public Notable(String name) {
        this.name = name;
    }

    /**
     * Gets the name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the note
     * @param note the new note
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Gets the note
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * Checks if two notables are equal
     * Notables are equal if they have the same name and note
     * @param other the object to compare to
     * @return true if this equals other else false
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Notable) {
            Notable oNot = (Notable) other;
            if (getNote() != null)
                return getName().equals(oNot.getName()) && getNote().equals(oNot.getNote());
            return getName().equals(oNot.getName()) && oNot.getNote() == null;
        }
        return false;
    }
    /**
    * Defines String representation for Notable object
    * @return the string representation
    */
    @Override
    public String toString() {
        return getName();
    }


    /**
     * Attaches an observer     
     * @param obs the observer to attach
     */
    @Override
    public void attachObserver(Observer obs) {
        observers.add(obs);
    }

    /**
     * Detaches an observer
     * @param obs the observer to detach
     */
    @Override
    public void detachObserver(Observer obs) {
        observers.remove(obs);
    }

    /**
     * Notifies observers of a change
     */
    @Override
    public void notifyObservers() {
        for (Observer obs : observers) 
            obs.update();
    }
}
