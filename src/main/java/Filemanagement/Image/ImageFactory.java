package Filemanagement.Image;

import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.lang.ClassNotFoundException;

/**
 * Factory method for creating an image
 * @author Lawson Wheatley
 */
public class ImageFactory{

	/**
	* Constructor Method
	*/
	public ImageFactory(){

	}
	
	/**
	* Creates an Image
	* @param enum imgtype Imagetype
	* @param JPanel panel to export to Image
	* @param String Fname Filename to export
	*/
	public void createImage(imgtype img, JPanel panel, String Fname){
		JPanelToImage j = new JPanelToImage();
		ImageMaker image = new PNGMaker();
		switch(img){
			case png:
				new PNGMaker();
			case jpeg:
				new JPegMaker();
		}
		image.exportImage(j.getImage(panel), Fname);
		
	}
	
}
