package Filemanagement;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ClassNotFoundException;

import Document.Storage;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson; 
import com.google.gson.GsonBuilder;  

/**
 * Serializes data to the custom CG style file
 * @author Lawson Wheatley
 */
public class JSonSerializer implements DataSerializer{	
	Storage toSerialize;

	/**
	* Initializes JSonSerializer()
	*/
	public JSonSerializer(Storage toSerialize) {
		this.toSerialize = toSerialize;
	}
	
	/**
	* Serializes an Object as a .cg file
	* @param File
	*/
	public void SerializeObject(FileOutputStream f) {
		try {
			Gson gson = new Gson();
			String ret = gson.toJson(toSerialize, Storage.class);
			f.write(ret.getBytes());
			f.close();
		} catch(IOException i){
            		System.out.println(i);
		}
	}

	/**
	* Serialize Object
	* @return FileInputStream filestream to input
	*/
	public Storage DeserializeObject(FileInputStream f) {
		try{ 
			Gson gson = new Gson();
			InputStream in = f;
			StringBuilder sbuild = new StringBuilder();
			if(in!=null){
				InputStreamReader inread = new InputStreamReader(in);
				BufferedReader buffered = new BufferedReader(inread);
				String sReceive ="";
				while((sReceive=buffered.readLine())!=null){
					sbuild.append(sReceive);
				}
				in.close();
			}
			toSerialize=gson.fromJson(sbuild.toString(), Storage.class);
			f.close();
			return null;
		} catch (IOException i){
			System.out.println(i);
			return null;
		}/* catch (ClassNotFoundException c){
			System.out.println(c);
			return null;
		}*/
	}
}
