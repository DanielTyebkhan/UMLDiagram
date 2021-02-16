package filemanagement;


public class ObjectClass {
	private String name;
	private String[] instancevariables;
	private String[] stereotypes;
	private String[] methods;
	private int[] pdata;
	private String[] children;
	
	public ObjectClass(String nm, int[] data) {
		name=nm;
		instancevariables= new String[] {};
		stereotypes=new String[] {};
		methods=new String[] {};
		pdata=data;
		children=new String[] {};
	}

	public void setName(String nm) {
		name=nm;
	}

	public String getName() {
		return name;
	}

	public void setInstanceVariables(String[] instancev) {
		instancevariables=instancev;
	}

	public String[] getInstanceVariables() {
		return instancevariables;
	}

	public void setStereotypes(String[] stereo) {
		stereotypes=stereo;
	}

	public String[] getStereotypes() {
		return stereotypes;
	}

	public void setMethods(String[] metho) {
		methods=metho;
	}

	public String[] getMethods() {
		return methods;
	}

	public void setPosition(int[] data) {
		pdata=data;
	}

	public int[] getPosition() {
		return pdata;
	}

	public void setChildren(String[] data) {
		children=data;
	}

	public String[] getChildren() {
		return children;
	}
}
