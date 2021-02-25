package Filemanagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import Document.Storage;

public interface DataSerializer {
	public void SerializeObject(FileOutputStream f);
	public StorageContainer DeserializeObject(FileInputStream f);
}
