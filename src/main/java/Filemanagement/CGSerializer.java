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
			out.writeObject(Storage.instance);
			out.close();
		} catch(IOException i){
            System.out.println(i);
		}
	}
	public Storage DeserializeObject(FileInputStream f) {
		try{ 
			ObjectInputStream in = new ObjectInputStream(f);
			Storage stor = (Storage) in.readObject();
			in.close();
			return stor;
		} catch (IOException i){
			System.out.println(i);
			return null;
		} catch (ClassNotFoundException c){
			System.out.println(c);
			return null;
		}
	}
}
