package Filemanagement;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import Document.Storage;
import Document.ObjectClass;
import Document.Arrow;
import java.util.List;
import java.util.ArrayList;
/**
 * @author Lawson Wheatley
 */
public class StorageContainer{
	public List<ObjectClass> objects;
	public List<Arrow> arrows;
	public StorageContainer(List<ObjectClass> objec, List<Arrow> arro) {
		objects=objec;
		arrows=arro;
	}
	public StorageContainer() {
		objects=new ArrayList<ObjectClass>();
		arrows=new ArrayList<Arrow>();
	}
}
