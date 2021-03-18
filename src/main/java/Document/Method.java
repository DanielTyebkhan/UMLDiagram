package Document;

import java.util.ArrayList;

/**
 * Represents a method
 * @author Daniel Tyebkhan
 */
public class Method extends Notable {
	private ArrayList<Notable> parameters;

	/**
	 * Constructs a method with a name and list of parameters
	 * @param name the method name
	 * @param parameters the parameters
	 */
	public Method(String name, ArrayList<Notable> parameters) {
		super(name);
		this.parameters = new ArrayList<Notable>(parameters);
	}

	/**
	 * Constructs a method with a name
	 * @param name the method name
	 */
	public Method(String name) {
		super(name);
		parameters = new ArrayList<>();
	}

	/**
	 * Gets the method's parameters
	 * @return the parameters
	 */
	public ArrayList<Notable> getParameters() {
		return new ArrayList<Notable>(parameters);
	}

	/**
	 * Adds a parameter
	 * @param param the parameter to add
	 */
	public void addParameter(Notable param) {
		parameters.add(param);
		notifyObservers();
	}

	/**
	 * Removes a parameter
	 * @param param the parameter to remove
	 */
	public void removeParameter(Notable param) {
		parameters.remove(param);
		notifyObservers();
	}

	/**
	 * Checks if two Methods are equal
	 * Methods are equal if they have the same name and parameters
	 * @param other the method to compare to
	 * @return true if the methods are equal else false
	 */
	@Override
	public boolean equals(Object other) {
		if (other instanceof Method) {
			Method otherM = (Method) other;
			return otherM.getName().equals(getName()) && otherM.getParameters().equals(getParameters());
		}
		return false;
	}
}