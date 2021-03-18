package Filemanagement.Image;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * A class that creates a WebMP from a bufferedImage
 * @author Lawson Wheatley
 */
public class WebMPMaker implements ImageMaker{

	/**
	* JPEGMaker Constructor

	*/
	public WebMPMaker() {
	}
	/* 
	* Exports an image to a WebMP file
	* @param BufferedImage image to write to WebMP
	* @param String Filename
	*/
	public void exportImage(BufferedImage I, String Fname){
		try{
		File outputfile = new File(Fname);
		ImageIO.write(I, "webmp", outputfile);
		} catch(IOException i){}
	}
}
