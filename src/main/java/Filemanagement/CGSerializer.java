package Filemanagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.lang.ClassNotFoundException;
import Document.Storage;
/**
 * @author Lawson Wheatley
 */
public class CGSerializer implements DataSerializer{
	public CGSerializer() {
		
	}
	public void SerializeObject(FileOutputStream f) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(f);
			out.writeObject(Storage.instance);
			out.close();
		} catch(IOException i){
			return;
		}
	}
	public Storage DeserializeObject(FileInputStream f) {
		try{ 
			ObjectInputStream in = new ObjectInputStream(f);
			Storage ret = (Storage) in.readObject();
			in.close();
			return ret;
		} catch (IOException i){
			Storage ret = Storage.instance;
			return ret;
		} catch (ClassNotFoundException c){
			Storage ret = Storage.instance;
			return ret;
		}
	}
}
