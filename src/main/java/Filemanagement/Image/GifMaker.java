package Filemanagement.Image;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * A class that creates a Jpeg from a bufferedImage
 * @author Lawson Wheatley
 */
public class GifMaker implements ImageMaker{

	/**
	* JPEGMaker Constructor

	*/
	public GifMaker() {
	}
	/* 
	* Exports an image to a gif file
	* @param BufferedImage image to write to gif
	* @param String Filename
	*/
	public void exportImage(BufferedImage I, String Fname){
		try{
		File outputfile = new File(Fname);
		ImageIO.write(I, "gif", outputfile);
		} catch(IOException i){}
	}
}
