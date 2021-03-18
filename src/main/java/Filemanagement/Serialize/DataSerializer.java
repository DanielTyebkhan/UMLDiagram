package Filemanagement.Serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import Document.Storage;

/**
* Interface for DataSerialization
* @author Lawson Wheatley
*/
public interface DataSerializer {

	/**
	* Serialize Object
	* @param FileOutputStream filestream to ouput
	*/
	public void SerializeObject(FileOutputStream f);

	/**
	* Deserializes Object
	* @param FileInputStream filestream to input
	*/
	public Storage DeserializeObject(FileInputStream f);
}
