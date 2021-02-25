package Filemanagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import Document.Storage;
import Document.ObjectClass;
import General.Observer;

/**
* Class that manages files for the program
* @author Lawson Wheatley
*/
public class FileManager {

	DataSerializer dataserializer;
	DataSerializerFactory dfactory = new DataSerializerFactory();
	ImageFactory imgfactory = new ImageFactory();
	dtype type;

	/**
	* FileManager constructor
	*/
	public FileManager() {
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
			dataserializer = dfactory.createDataSerializer(type);
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
			dataserializer = dfactory.createDataSerializer(type);
			Storage temp = dataserializer.DeserializeObject(f);
			temp.setObservers(new ArrayList<Observer>());
			Storage.instance.setStorage(temp.getObjects(), temp.getArrows());

			f.close();
		} catch(IOException i) {
		}
	}

	/**
	* Ouputs dtype from Fname file extension 
	* @param String File Name
	* @return dtype Datatype
	*/
	private dtype dt(String Fname){
		System.out.println("Fname" + Fname);
		String a = Fname.substring(Fname.indexOf("."));
		if(a==".cg"){
			return dtype.cg;
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
		}
		return imgtype.jpeg;
	}
}
