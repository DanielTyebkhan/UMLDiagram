package Filemanagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
			byte[] strToBytes = ret.getBytes();
			f.write(strToBytes);
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
			List<Byte> strToBytes = new ArrayList<Byte>();
			int b=0;
			while((b=f.read())!=-1){
				
				strToBytes.add((byte) b);
			}
			toSerialize=gson.fromJson(new String(strToBytes.toArray()), Storage.class);
			f.close();
		} catch (IOException i){
			System.out.println(i);
			return null;
		} catch (ClassNotFoundException c){
			System.out.println(c);
			return null;
		}
	}
}
