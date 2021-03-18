package Filemanagement.Serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.IOException;
import java.lang.ClassNotFoundException;

import Document.Storage;

/**
 * Serializes data to the custom CG style file
 * @author Lawson Wheatley
 */
public class CGSerializer implements DataSerializer{	
	Storage toSerialize;

	/**
	* Initializes CGSerializer()
	*/
	public CGSerializer(Storage toSerialize) {
		this.toSerialize = toSerialize;
	}
	
	/**
	* Serializes an Object as a .cg file
	* @param File
	*/
	public void SerializeObject(FileOutputStream f) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(f);
			out.writeObject(toSerialize);
			out.close();
		} catch(IOException i){
            		System.out.println(i);
		}
	}

	/**
	* Serialize Object
	* @param FileInputStream filestream to input
	* @return Storage to export
	*/
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
