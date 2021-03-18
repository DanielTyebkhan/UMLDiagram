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
	* PNGMaker Constructor and writer method
	* @param BufferedImage image to write to PNG
	* @param String Filename
	*/
	public PNGMaker() {
	}

	public void exportImage(BufferedImage I, String Fname){
		try{
			File outputfile = new File(Fname);
			ImageIO.write(I, "png", outputfile);
		} catch(IOException i){}
	}
}