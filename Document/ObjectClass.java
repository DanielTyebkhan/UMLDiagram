package Document;

import java.util.ArrayList;
import java.util.List;

public class ObjectClass {
	private String name;
	private ArrayList<String> instanceVariables;
	private ArrayList<String> stereotypes;
	private ArrayList<String> methods;
	private int[] pdata;
	private ArrayList<ObjectClass> children;
	
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
	}

	public String getName() {
		return name;
	}

	public void addInstanceVariable(String variable) {
        instanceVariables.add(variable);
    }

    public void setInstanceVariables(List<String> vars) {
        instanceVariables = new ArrayList<String>(vars);
    }

	public List<String> getInstanceVariables() {
		return new ArrayList<String>(instanceVariables);
	}

	public void addStereotype(String stereotype) {
        stereotypes.add(stereotype);
	}

    public void setStereotypes(List<String> stereotypes) {
        stereotypes = new ArrayList<String>(stereotypes);
    }
    
	public List<String> getStereotypes() {
		return new ArrayList<String>(stereotypes);
	}

	public void addMethod(String method) {
        methods.add(method);
	}

    public void setMethods(List<String> methods) {
        methods = new ArrayList<String>(methods);
    }

	public List<String> getMethods() {
        return new ArrayList<String>(methods);
	}

	public void setPosition(int[] data) {
		pdata = data;
	}

	public int[] getPosition() {
		return pdata;
	}

	public void setChildren(List<ObjectClass> children) {
		children = children;
	}

    public void addChild(ObjectClass child) {
        children.add(child);
    }

	public List<ObjectClass> getChildren() {
		return new ArrayList<ObjectClass>(children);
	}
}
