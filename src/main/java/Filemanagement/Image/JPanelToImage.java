package Filemanagement.Image;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * Class that converts JPanels to Images
 * @author Lawson Wheatley
 */
public class JPanelToImage{

	/**
	* JPanelToImage Constructor
	*/
	public JPanelToImage() {
		
	}

	/**
	* Gets an BufferedImage from a Jpanel
	* @param JPanel panel to convert to image
	* @return BufferedImage
	*/
	public BufferedImage getImage(JPanel panel){
		BufferedImage bufimage = new BufferedImage(panel.getSize().width, panel.getSize().height, BufferedImage.TYPE_INT_RGB);
		Graphics g = bufimage.createGraphics();
		panel.paint(g);
		g.dispose();
		return bufimage;
	}
}
