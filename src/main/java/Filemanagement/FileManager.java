package Filemanagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import Document.Storage;
import General.Observer;
import View.DiagramPanel;

import Filemanagement.Image.*;
import Filemanagement.Code.*;
import Filemanagement.Serialize.*;


/**
* Class that manages files for the program
* @author Lawson Wheatley
*/
public class FileManager {
	DiagramPanel diagramPanel;
	DataSerializerFactory dfactory; 
	ImageFactory imgfactory;
	CodeFactory cfactory;
	dtype type;

	/**
	* FileManager constructor
	*/
	public FileManager(DiagramPanel panel) {
		this.diagramPanel = panel;
		dfactory = new DataSerializerFactory(diagramPanel.getStorage());
		cfactory = new CodeFactory(diagramPanel.getStorage());
		imgfactory = new ImageFactory();
	}

	/**
	* Exports an Image
	* @param String File Name
	* @param JPanel panel
	*/
	public void ExportImage(String Fname, JPanel panel) {
		imgfactory.createImage(imgt(Fname), panel, Fname);
	}

	/**
	* Saves Data
	* @param String File Name
	*/
	public void SaveData(String Fname) {
		try {
			type=dt(Fname);
			FileOutputStream f = new FileOutputStream(Fname);
			DataSerializer dataserializer = dfactory.createDataSerializer(type);
			dataserializer.SerializeObject(f);
			f.close();
		} catch(IOException i) {
			return;
		}
		
	}

	/**
	* Loads Data
	* @param String File Name
	*/
	public void LoadData(String Fname) {
		try {
			type=dt(Fname);
			FileInputStream f = new FileInputStream(Fname);
			DataSerializer dataserializer = dfactory.createDataSerializer(type);
			Storage temp = dataserializer.DeserializeObject(f);
			temp.setObservers(new ArrayList<Observer>());
			diagramPanel.getStorage().setStorage(temp.getObjects(), temp.getArrows());

			f.close();
		} catch(IOException i) {
		}
	}

	/**
	* Exports code
	* @param String File Path
	*/
	public void exportCode(String Fpath) {
		CodeMaker cmaker = cfactory.createCodeMaker(ctype.python);
		cmaker.ExportCode(Fpath);	
	}

	/**
	* Ouputs dtype from Fname file extension 
	* @param String File Name
	* @return dtype Datatype
	*/
	private dtype dt(String Fname){
		String a = Fname.substring(Fname.indexOf("."));
		if(a==".cg"){
			return dtype.cg;
		}else if(a==".json"){
			return dtype.json;
		}
		return dtype.cg;
	}

	/**
	* Ouputs imgtype from Fname file extension 
	* @param String File Name
	* @return imgtype Image type
	*/
	private imgtype imgt(String Fname){
		String a = Fname.substring(Fname.indexOf("."));
		if(a==".jpeg"){
			return imgtype.jpeg;
		} else if (a==".png"){
			return imgtype.png;
		} else if (a==".webmp"){
			return imgtype.webmp;
		} else if (a==".bmp"){
			return imgtype.bmp;
		} else if (a==".gif"){
			return imgtype.gif;
		}
		return imgtype.jpeg;
	}
}
