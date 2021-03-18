package Filemanagement;

import java.io.File;
import java.io.FileWriter;

import java.util.ArrayList;

import java.io.IOException;
import java.lang.ClassNotFoundException;

import Document.*;

/**
 * Exports to Python File
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
	public void ExportCode(String Fpath) {
		try {
			
			for(ObjectClass obj: storage.getObjects()){
				FileWriter f = new FileWriter(Fpath+obj.getName()+".python");
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
				f.write(outstr);
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
		/*try{ 
			
		} catch (IOException i){
			
		} catch (ClassNotFoundException c){
			
		}*/
		return null;
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
