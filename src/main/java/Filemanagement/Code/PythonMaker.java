package Filemanagement.Code;

import java.io.File;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.List;

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
	* Initializes PythonMaker
	* @param Storage storage
	*/
	public PythonMaker(Storage stor) {
		storage=stor;
	}
	
	/**
	* Serializes each Object as a .python file
	* @param String File path
	*/
	public void ExportCode(String Fpath) {

		List<Arrow> arrows = storage.getArrows();
		for(ObjectClass obj: storage.getObjects()){
			try {
				System.out.println(Fpath.substring(0, Fpath.lastIndexOf("/")+1));
				FileWriter f = new FileWriter(Fpath.substring(0, Fpath.lastIndexOf("/")+1)+obj.getName()+".py");
				String outstr="";
				String parent="";
				for(Arrow arrow: arrows){
					if(arrow.getTo().getName()==obj.getName()){
						parent=arrow.getFrom().getName();
					}
				}
				outstr+="class "+obj.getName()+"(" + parent+ "):\n";
				for(Notable instancevar: obj.getInstanceVariables()){
					outstr+="	self."+instancevar.toString();
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
	* Deserializes all python files
	* @param String FilePath
	* @return Storage
	*/
	public Storage ImportCode(String FPath) {
		/*try{ 
			
		} catch (IOException i){
			
		} catch (ClassNotFoundException c){
			
		}*/
		return null;
	}

	/**
	* Converts Notables (within method arguments) to string
	* @param ArrayList<Notable> parameters
	* @return String arguments separated by comma
	*/
	private String argumentsToString(ArrayList<Notable> Notes){
		String ret="";
		for(Notable note: Notes){
			ret+=note.toString() + ", ";
		}
		ret=ret.substring(0,ret.length()-2);
		return ret;
	}
}
