package Filemanagement.Code;

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
public class PythonMaker implements CodeMaker{
	Storage storage;
	/**
	* Initializes PythonSerializer()
	*/
	public PythonMaker(Storage stor) {
		storage=stor;
	}
	
	/**
	* Serializes each Object as a .python file
	* @param File
	*/
	public void ExportCode(String Fpath) {

			
		for(ObjectClass obj: storage.getObjects()){
			try {
				System.out.println(Fpath.substring(0, Fpath.lastIndexOf("/")+1));
				FileWriter f = new FileWriter(Fpath.substring(0, Fpath.lastIndexOf("/")+1)+obj.getName()+".py");
				String outstr="";
				outstr+="def "+obj.getName()+"():\n";
				for(Notable instancevar: obj.getInstanceVariables()){
					outstr+="	"+instancevar.toString();
				}
				for(Method method: obj.getMethods()){
					outstr+="	def "+method.toString()+"("+
						argumentsToString(method.getParameters())+")" + ":\n";
					outstr+="	";
				}
				System.out.println("OutStr");
				System.out.println(outstr);
				f.write(outstr);
				f.flush();
				f.close();
			} catch(IOException i){
            			System.out.println(i);
			}
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
