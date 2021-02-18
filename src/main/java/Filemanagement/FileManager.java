package Filemanagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Document.Storage;

public class FileManager {
	DataSerializer dataserializer;
	public FileManager() {
		
	}
	public void ExportImage() {
		
	}
	public void SaveData(Storage stor, String Fname) {
		Fname=FnameCheck(Fname);
		try {
			FileOutputStream f = new FileOutputStream(Fname);
			dataserializer = new DataSerializer();
			dataserializer.SerializeObject(stor, f);
			f.close();
		} catch(IOException i) {
			return;
		}
		
	}
	public Storage LoadData(String Fname) {
		Fname=FnameCheck(Fname);
		try {
			FileInputStream f = new FileInputStream(Fname);
			dataserializer = new DataSerializer();
			Storage ret = dataserializer.DeserializeObject(f);
			f.close();
			return ret;
		} catch(IOException i) {
			return new Storage();
		}
	}
	private String FnameCheck(String Fname) {
		if(Fname.contains(".")) {
			if(!Fname.contains(".cg")) {
				Fname+=".cg";
			}
			else {
				//Display window stating incorrect file type, then break
				Fname= Fname.substring(0, Fname.indexOf("."))+".cg";
			}
		}
		return Fname;
	}
}
