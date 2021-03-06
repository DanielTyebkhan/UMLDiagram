package Document;

import java.util.ArrayList;
import java.util.List;
import java.awt.Point;

import General.Observer;

/**
 * Represents an object in a class diagram
 * @author Daniel Tyebkhan
 */
public class ObjectClass extends Notable implements Observer {
	private ArrayList<Notable> instanceVariables;
	private ArrayList<Notable> stereotypes;
	private ArrayList<Method> methods;
	private Point pdata;
	private ArrayList<ObjectClass> children;
    private ArrayList<Observer> observers;
	
    /**
     * Constructs an ObjectClass with position
     * @param nm the name of the class
     * @param position the position of the class
     */
	public ObjectClass(String nm, Point position) {
        super(nm);
        instanceVariables = new ArrayList<Notable>();
        stereotypes = new ArrayList<Notable>();
        methods = new ArrayList<Method>();
        children = new ArrayList<ObjectClass>();
        pdata = position;
        observers = new ArrayList<Observer>();
	}

    /**
     * Sets the name of the class
     * @param nm the new name
     */
	public void setName(String nm) {
        super.setName(nm);
        notifyObservers();
	}

    private void attachAndNotify(Notable notable) {
        notable.attachObserver(this);
        notifyObservers();
    }

    /**
     * Adds an instance variable
     * @param variable the name of variable to add
     */
	public void addInstanceVariable(Notable variable) {
        instanceVariables.add(variable);
        attachAndNotify(variable);
    }

    /**
     * Removes an instance variable
     * @param variable the variable to remove
     */
    public void removeInstanceVariable(Notable variable) {
        instanceVariables.remove(variable);
        notifyObservers();
    }

    /**
     * Gets all instance variables
     * @return all of the instance variables
     */
	public List<Notable> getInstanceVariables() {
		return new ArrayList<Notable>(instanceVariables);
	}

    /**
     * Adds a stereotype
     * @param stereotype the stereotype to add
     */
	public void addStereotype(Notable stereotype) {
        stereotypes.add(stereotype);
        attachAndNotify(stereotype);
	}

    /**
     * Removes a stereotype
     * @param stereotype the stereotype to remove
     */
    public void removeStereotype(Notable stereotype) {
        stereotypes.remove(stereotype);
        notifyObservers();
    }

    /**
     * Gets all stereotypes
     * @return all stereotypes
     */
	public List<Notable> getStereotypes() {
		return new ArrayList<Notable>(stereotypes);
	}

    /**
     * Adds aa method
     * @param method the method to add
     */
	public void addMethod(Method method) {
        methods.add(method);
        attachAndNotify(method);
	}

    /**
     * Gets all methods
     * @return all methods
     */
	public List<Method> getMethods() {
        return new ArrayList<Method>(methods);
	}
    
    /**
     * Removes a method
     * @param method the method to return
     */
    public void removeMethod(Method method) {
        methods.remove(method);
        notifyObservers();
    }

    /**
     * Sets the position
     * @param position the new position
     */
	public void setPosition(Point position) {
		pdata = position;
        notifyObservers();
	}

    /**
     * Gets the position
     * @return the position
     */
	public Point getPosition() {
		return pdata;
	}

    /**
     * Adds a subtype
     * @param child the subtype to add
     */
    public void addChild(ObjectClass child) {
        children.add(child);
        notifyObservers();
    }

    /**
     * Removes a subtype
     * @param child the subtype to remove
     */
    public void removeChild(ObjectClass child) {
        children.remove(child);
        notifyObservers();
    }

    /**
     * Gets all subtypes
     * @return all subtypes
     */
	public List<ObjectClass> getChildren() {
		return new ArrayList<ObjectClass>(children);
	}

    /**
     * Checks if two ObjectClasses are equal
     * Two object classes are equal if they have the same name, stereotypes, instance variables, methods, and subtypes
     * @param other the object to compare to
     * @return true if this equals other else false
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof ObjectClass) {
            ObjectClass obj = (ObjectClass) other;
            if (getName() == obj.getName() &&
                getChildren().equals(obj.getChildren()) &&
                getMethods().equals(obj.getMethods())  &&
                getStereotypes().equals(obj.getStereotypes()) &&
                getInstanceVariables().equals(obj.getInstanceVariables()))
                return true;
        }
        return false;
    }

    /**
     * Attaches an observer
     * @param obs the observer to attach
     */
    public void attachObserver(Observer obs) {
        observers.add(obs);
    }

    /**
     * Detaches an observer
     * @param obs the observer to remove
     */
    public void detachObserver(Observer obs) {
        observers.remove(obs);
    }

    /**
     * Notifies observers of changes
     */
    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update();
        }
    }
    /**
    * Defines String represenation of ObjectClass
    */
    public String toString() {
        return getName();
    }

    /**
     * Updates observers when a property changes
     */
    @Override
    public void update() {
        notifyObservers();
    }
}
