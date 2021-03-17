package Document;

import java.util.ArrayList;

public class Method extends Notable {
	private ArrayList<Notable> parameters;

	public Method(String name, ArrayList<Notable> parameters) {
		super(name);
		this.parameters = new ArrayList<Notable>(parameters);
	}

	public Method(String name) {
		super(name);
		parameters = new ArrayList<>();
	}

	public ArrayList<Notable> getParameters() {
		return new ArrayList<Notable>(parameters);
	}

	public void addParameter(Notable param) {
		parameters.add(param);
		notifyObservers();
	}

	public void removeParameter(Notable param) {
		parameters.remove(param);
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Method) {
			Method otherM = (Method) other;
			return otherM.getName().equals(getName()) && otherM.getParameters().equals(getParameters());
		}
		return false;
	}
}