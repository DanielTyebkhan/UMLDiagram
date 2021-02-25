package Filemanagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.lang.ClassNotFoundException;
import Document.Storage;
import Document.ObjectClass;
import Document.Arrow;
import java.util.List;
import java.util.ArrayList;
/**
 * @author Lawson Wheatley
 */
public class CGSerializer implements DataSerializer{
	public CGSerializer() {
		
	}
	public void SerializeObject(FileOutputStream f) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(f);
			out.writeObject(Storage.instance.getObjects());
			out.writeObject(Storage.instance.getArrows());
			out.close();
		} catch(IOException i){
            System.out.println(i);
		}
	}
	public StorageContainer DeserializeObject(FileInputStream f) {
		try{ 
			ObjectInputStream in = new ObjectInputStream(f);
			List<ObjectClass> a = (ArrayList<ObjectClass>)in.readObject();
			List<Arrow> b = (ArrayList<Arrow>)in.readObject();
			in.close();
			return new StorageContainer(a,b);
		} catch (IOException i){
			return new StorageContainer();
		} catch (ClassNotFoundException c){
			return new StorageContainer();
		}
	}
}
