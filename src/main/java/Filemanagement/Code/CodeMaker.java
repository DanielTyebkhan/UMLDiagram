package Filemanagement.Code;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import Document.Storage;

/**
* Interface for all code files
* @author Lawson Wheatley
*/
public interface CodeMaker {

	/**
	* Exports Code
	* @param String FilePath
	*/
	public void ExportCode(String FPath);

	/**
	* Imports Code
	* @return String FilePath
	*/
	public Storage ImportCode(String FPath);
}
