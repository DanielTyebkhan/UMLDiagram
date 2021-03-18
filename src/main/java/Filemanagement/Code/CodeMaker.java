package Filemanagement.Code;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import Document.Storage;

/**
* Interface for DataSerialization
* @author Lawson Wheatley
*/
public interface CodeMaker {

	/**
	* Serialize Object
	* @param FileOutputStream filestream to ouput
	*/
	public void ExportCode(String Fname);

	/**
	* Serialize Object
	* @return FileInputStream filestream to input
	*/
	public Storage ImportCode(String Fname);
}
