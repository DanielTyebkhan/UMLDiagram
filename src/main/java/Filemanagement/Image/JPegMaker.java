package Filemanagement.Image;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * A class that creates a Jpeg from a bufferedImage
 * @author Lawson Wheatley
 */
public class JPegMaker implements ImageMaker{

	/**
	* JPEGMaker Constructor and writer method
	* @param BufferedImage image to write to Jpeg
	* @param String Filename
	*/
	public JPegMaker() {
	}
	public void exportImage(BufferedImage I, String Fname){
		try{
		File outputfile = new File(Fname);
		ImageIO.write(I, "png", outputfile);
		} catch(IOException i){}
	}
}
