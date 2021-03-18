package Filemanagement.Code;

import Document.Storage;

/**
 * Factory class for all CodeMaking
 * @author Lawson Wheatley
 */
public class CodeFactory{
	Storage storage;

	/**
	* Constructor
	* @param Storage storage file
	*/
	public CodeFactory(Storage storage){
		this.storage = storage;
	}
	
	/**
	* Creates a CodeMaker
	* @param ctype Ftype
	* @return CodeMaker from multiple different ctypes
	*/
	public CodeMaker createCodeMaker(ctype Ftype) {
		return multiplexer(Ftype);
	}

	/**
	* Creates a CodeMaker
	* @param ctype Ftype
	* @return CodeMaker from multiple different ctypes
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
	private PythonMaker Python(){
		return new PythonMaker(storage);
	}
}