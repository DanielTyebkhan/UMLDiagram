package Filemanagement;

import Document.Storage;

/**
 * Factory class for all DataSerialization
 * @author Lawson Wheatley
 */
public class CodeFactory{
	Storage storage;

	/**
	* Constructor
	*/
	public CodeFactory(Storage storage){
		this.storage = storage;
	}
	
	/**
	* Creates a DataSerializer
	* @param dtype Ftype
	* @return DataSerializer from multiple different dtypes
	*/
	public CodeMaker createDataSerializer(ctype Ftype) {
		return multiplexer(Ftype);
	}

	/**
	* Creates a DataSerializer
	* @param dtype Ftype
	* @return DataSerializer from multiple different dtypes
	*/
	private CodeMaker multiplexer(ctype Ftype){
		switch(Ftype){
		case python:
			return Python();
		}
		return Python();
	}

	/**
	* Creates a CGSerializer
	* @return CGSerializer for factory
	*/
	private PythonSerializer Python(){
		return new PythonSerializer(storage);
	}
}