package Filemanagement.Image;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * A class that creates a BMP from a bufferedImage
 * @author Lawson Wheatley
 */
public class BmpMaker implements ImageMaker{

	/**
	* JPEGMaker Constructor

	*/
	public BmpMaker() {
	}
	/* 
	* Exports an image to a bmp file
	* @param BufferedImage image to write to bmp
	* @param String Filename
	*/
	public void exportImage(BufferedImage I, String Fname){
		try{
		File outputfile = new File(Fname);
		ImageIO.write(I, "bmp", outputfile);
		} catch(IOException i){}
	}
}
