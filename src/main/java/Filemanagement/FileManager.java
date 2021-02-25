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
	dtype type;
	DataSerializerFactory dfactory;
	public FileManager() {
		type=dtype.cg;
		dfactory= new DataSerializerFactory();
		
	}
	public void ExportImage(String Fname, JPanel panel) {
		
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
}
