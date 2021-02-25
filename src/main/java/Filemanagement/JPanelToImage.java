package Filemanagement;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Robot;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;

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
