package Document;

import java.util.ArrayList;

public class Method extends Notable {
	private ArrayList<String> parameters;

	public Method(String name, ArrayList<String> parameters) {
		super(name);
		this.parameters = new ArrayList<String>(parameters);
	} 

	public ArrayList<String> getParameters() {
		return new ArrayList<String>(parameters);
	}

	public void addParameter(String name, int index) {
		parameters.add(index, name);
	}

	public void removeParameter(int index) {
		parameters.remove(index);
	}

	public void renameParameter(String newName, int index) {
		parameters.set(index, newName);
	}
}