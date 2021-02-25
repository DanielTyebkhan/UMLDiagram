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
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.lang.ClassNotFoundException;
import java.io.File;
import Document.Storage;
/**
 * @author Lawson Wheatley
 */
public class JPegMaker{
	public JPegMaker(BufferedImage I, String Fname) {
		try{
		File outputfile = new File(Fname);
		ImageIO.write(I, "png", outputfile);
		} catch(IOException i){}
	}
}
