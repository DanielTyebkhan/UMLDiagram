package Document;

import java.util.ArrayList;
import java.util.List;
import java.awt.Point;

import General.Subject;
import General.Observer;

import Document.Notable;

/**
 * Represents an object in a class diagram
 * @author Daniel Tyebkhan
 */
public class ObjectClass extends Notable implements Subject {
	private ArrayList<Notable> instanceVariables;
	private ArrayList<Notable> stereotypes;
	private ArrayList<Notable> methods;
	private Point pdata;
	private ArrayList<ObjectClass> children;
    private ArrayList<Observer> observers;
	
	public ObjectClass(String nm, Point position) {
        super(nm);
        instanceVariables = new ArrayList<Notable>();
        stereotypes = new ArrayList<Notable>();
        methods = new ArrayList<Notable>();
        children = new ArrayList<ObjectClass>();
        pdata = position;
        observers = new ArrayList<Observer>();
	}

	public void setName(String nm) {
        super.setName(nm);
        notifyObservers();
	}

	public void addInstanceVariable(Notable variable) {
        instanceVariables.add(variable);
        notifyObservers();
    }

    public void removeInstanceVariable(Notable variable) {
        instanceVariables.remove(variable);
        notifyObservers();
    }

	public List<Notable> getInstanceVariables() {
		return new ArrayList<Notable>(instanceVariables);
	}

	public void addStereotype(Notable stereotype) {
        stereotypes.add(stereotype);
        notifyObservers();
	}

    public void removeStereotype(Notable stereotype) {
        stereotypes.remove(stereotype);
        notifyObservers();
    }

	public List<Notable> getStereotypes() {
		return new ArrayList<Notable>(stereotypes);
	}

	public void addMethod(Notable method) {
        methods.add(method);
        notifyObservers();
	}

	public List<Notable> getMethods() {
        return new ArrayList<Notable>(methods);
	}
    
    public void removeMethod(Notable method) {
        methods.remove(method);
        notifyObservers();
    }

	public void setPosition(Point position) {
		pdata = position;
        notifyObservers();
	}

	public Point getPosition() {
		return pdata;
	}

    public void addChild(ObjectClass child) {
        children.add(child);
        notifyObservers();
    }

    public void removeChild(ObjectClass child) {
        children.remove(child);
        notifyObservers();
    }

	public List<ObjectClass> getChildren() {
		return new ArrayList<ObjectClass>(children);
	}

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

    public void attachObserver(Observer obs) {
        observers.add(obs);
    }

    public void detachObserver(Observer obs) {
        return;
    }

    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update();
        }
    }
}
