package Filemanagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
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
public class ImageFactory{
	public ImageFactory(){}
	public void createImage(imgtype img, JPanel panel, String Fname){
		JPanelToImage j = new JPanelToImage();
		switch(img){
			case png:
				new PNGMaker(j.getImage(panel), Fname);
			case jpeg:
				new JPegMaker(j.getImage(panel), Fname);
		}
	}
	
}
