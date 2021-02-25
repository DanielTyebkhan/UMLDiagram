package Filemanagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import Document.Storage;

public class FileManager {
	DataSerializer dataserializer;
	DataSerializerFactory dfactory = new DataSerializerFactory();
	ImageFactory imgfactory = new ImageFactory();
	dtype type;

	public FileManager() {
	}

	public void ExportImage(String Fname, JPanel panel) {
		imgfactory.createImage(imgt(Fname), panel, Fname);
	}
	public void SaveData(String Fname) {
		try {
			FileOutputStream f = new FileOutputStream(Fname);
			dataserializer = dfactory.createDataSerializer(type);
			dataserializer.SerializeObject(f);
			f.close();
		} catch(IOException i) {
			return;
		}
		
	}
	public void LoadData(String Fname) {
		try {
			FileInputStream f = new FileInputStream(Fname);
			dataserializer = dfactory.createDataSerializer(type);
			Storage.instance = dataserializer.DeserializeObject(f);
			f.close();
		} catch(IOException i) {
		}
	}
	private dtype dt(String Fname){
		String a = Fname.substring(Fname.indexOf("."));
		if(a==".cg"){
			return dtype.cg;
		}
		return null;
	}
	private imgtype imgt(String Fname){
		String a = Fname.substring(Fname.indexOf("."));
		if(a==".jpeg"){
			return imgtype.jpeg;
		} else if (a==".png"){
			return imgtype.png;
		}
		return null;
	}
}
