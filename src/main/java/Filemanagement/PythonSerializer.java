package Filemanagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;

import java.io.IOException;
import java.lang.ClassNotFoundException;

import Document.*;

/**
 * Serializes data to the custom CG style file
 * @author Lawson Wheatley
 */
public class PythonSerializer implements CodeMaker{
	Storage storage;
	/**
	* Initializes PythonSerializer()
	*/
	public PythonSerializer(Storage stor) {
		storage=stor;
	}
	
	/**
	* Serializes each Object as a .python file
	* @param File
	*/
	public void ExportCode(String Fname) {
		try {
			
			for(ObjectClass obj: storage.getObjects()){
				String outstr="";
				outstr+="def "+obj.getName()+":\n";
				outstr+="def"+ "	"+obj.getName()+":\n";
				for(Notable instancevar: obj.getInstanceVariables()){
					outstr+="	"+instancevar.toString();
				}
				for(Method method: obj.getMethods()){
					outstr+="	def "+method.toString()+"("+
						argumentsToString(method.getParameters())+")" + ":\n";
					outstr+="	";
				}
			}
		} catch(IOException i){
            		System.out.println(i);
		}
	}
	
	/**
	* Deserialize Object
	* @return FileInputStream filestream to input
	*/
	public Storage ImportCode(String Fname) {
		try{ 
			
		} catch (IOException i){
			
		} catch (ClassNotFoundException c){
			
		}
	}
	private String argumentsToString(ArrayList<Notable> Notes){
		String ret="";
		for(Notable note: Notes){
			ret+=note.toString() + ", ";
		}
		ret=ret.substring(0,ret.length()-2);
		return ret;
	}
}
