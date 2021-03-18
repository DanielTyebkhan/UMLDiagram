package Filemanagement.Image;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Class that creates a PNG from BufferedImage
 * @author Lawson Wheatley
 */
public class PNGMaker implements ImageMaker{

	/**
	* PNGMaker Constructor method
	*/
	public PNGMaker() {
	}

	/* 
	* Exports an image to a png file
	* @param BufferedImage image to write to png
	* @param String Filename
	*/
	public void exportImage(BufferedImage I, String Fname){
		try{
			File outputfile = new File(Fname);
			ImageIO.write(I, "png", outputfile);
		} catch(IOException i){}
	}
}
