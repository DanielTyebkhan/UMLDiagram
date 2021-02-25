package Filemanagement;

import java.util.List;
import java.util.ArrayList;

import Document.Storage;
import Document.ObjectClass;
import Document.Arrow;
/**
 * A class that exports relevant values to load to the Storage.instance
 * @author Lawson Wheatley
 */
public class StorageContainer{
	public List<ObjectClass> objects;
	public List<Arrow> arrows;

	/**
	* Constructor for the StorageContainer
	* @param List<ObjectClass> ObjectClass list
	* @param List<Arrow>	Object
	*/
	public StorageContainer(List<ObjectClass> objec, List<Arrow> arro) {
		objects=objec;
		arrows=arro;
	}

	/**
	* Override constructor for the StorageContainer
	*/
	public StorageContainer() {
		objects=new ArrayList<ObjectClass>();
		arrows=new ArrayList<Arrow>();
	}
}
