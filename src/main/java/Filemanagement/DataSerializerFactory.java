package Filemanagement;

/**
 * Factory class for all DataSerialization
 * @author Lawson Wheatley
 */
public class DataSerializerFactory{

	/**
	* Constructor
	*/
	public DataSerializerFactory(){
	}
	
	/**
	* Creates a DataSerializer
	* @param dtype Ftype
	* @return DataSerializer from multiple different dtypes
	*/
	public DataSerializer createDataSerializer(dtype Ftype) {
		return multiplexer(Ftype);
	}

	/**
	* Creates a DataSerializer
	* @param dtype Ftype
	* @return DataSerializer from multiple different dtypes
	*/
	private DataSerializer multiplexer(dtype Ftype){
		switch(Ftype){
		case cg:
			return CG();
		}
		return CG();
	}

	/**
	* Creates a CGSerializer
	* @return CGSerializer for factory
	*/
	private CGSerializer CG(){
		return new CGSerializer();
	}
}