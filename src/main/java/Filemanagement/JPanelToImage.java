package Filemanagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Robot;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.lang.ClassNotFoundException;
import Document.Storage;
/**
 * @author Lawson Wheatley
 */
public class JPanelToImage{
	public JPanelToImage() {
		
	}
	public BufferedImage getImage(JPanel panel){
		BufferedImage bufimage = new BufferedImage(panel.getSize().width, panel.getSize().height, BufferedImage.TYPE_INT_RGB);
		Graphics g = bufimage.createGraphics();
		panel.paint(g);
		g.dispose();
		return bufimage;
	}
}
