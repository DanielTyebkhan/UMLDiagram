package Filemanagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Document.Storage;
/**
 * @author Lawson Wheatley
 */
public class DataSerializerFactory{
	public DataSerializerFactory(){
	}
	public DataSerializer createDataSerializer(dtype Ftype) {
		return multiplexer(Ftype);
	}
	public DataSerializer multiplexer(dtype Ftype){
		switch(Ftype){
		case cg:
			return CG();
		}
		return CG();
	}
	private CGSerializer CG(){
		return new CGSerializer();
	}
}