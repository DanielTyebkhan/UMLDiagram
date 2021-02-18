package Document;

import java.util.ArrayList;
import java.util.List;

import General.Subject;
import General.Observer;

public class ObjectClass implements Subject {
	private String name;
	private ArrayList<String> instanceVariables;
	private ArrayList<String> stereotypes;
	private ArrayList<String> methods;
	private int[] pdata;
	private ArrayList<ObjectClass> children;
    private ArrayList<Observer> observers;
	
	public ObjectClass(String nm, int[] position) {
		name = nm;
        instanceVariables = new ArrayList<String>();
        stereotypes = new ArrayList<String>();
        methods = new ArrayList<String>();
        children = new ArrayList<ObjectClass>();
        pdata = position;
	}

	public void setName(String nm) {
		name = nm;
        notifyObservers();
	}

	public String getName() {
		return name;
	}

	public void addInstanceVariable(String variable) {
        instanceVariables.add(variable);
        notifyObservers();
    }

    public void setInstanceVariables(List<String> vars) {
        instanceVariables = new ArrayList<String>(vars);
        notifyObservers();
    }

	public List<String> getInstanceVariables() {
		return new ArrayList<String>(instanceVariables);
	}

	public void addStereotype(String stereotype) {
        stereotypes.add(stereotype);
        notifyObservers();
	}

    public void setStereotypes(List<String> stereotypes) {
        stereotypes = new ArrayList<String>(stereotypes);
        notifyObservers();
    }
    
	public List<String> getStereotypes() {
		return new ArrayList<String>(stereotypes);
	}

	public void addMethod(String method) {
        methods.add(method);
        notifyObservers();
	}

    public void setMethods(List<String> methods) {
        methods = new ArrayList<String>(methods);
        notifyObservers();
    }

	public List<String> getMethods() {
        return new ArrayList<String>(methods);
	}

	public void setPosition(int[] data) {
		pdata = data;
        notifyObservers();
	}

	public int[] getPosition() {
		return pdata;
	}

	public void setChildren(List<ObjectClass> children) {
		children = children;
        notifyObservers();
	}

    public void addChild(ObjectClass child) {
        children.add(child);
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
