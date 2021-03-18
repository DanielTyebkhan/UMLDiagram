package Filemanagement.Image;

import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.lang.ClassNotFoundException;

/**
 * Interface for making images
 * @author Lawson Wheatley
 */
public interface ImageMaker{

	
	/**
	* Creates an Image
	* @param enum imgtype Imagetype
	* @param JPanel panel to export to Image
	* @param String Fname Filename to export
	*/
	public void exportImage(BufferedImage I, String Fname);
}
