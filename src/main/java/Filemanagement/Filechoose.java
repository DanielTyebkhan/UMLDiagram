package Filemanagement;

import java.io.File; 
import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.lang.ClassNotFoundException;
import javax.swing.filechooser.FileNameExtensionFilter;
import Document.Storage;
/**
 * @author Lawson Wheatley
 */
public class Filechoose{
	FileManager fmanager;
	JFileChooser fileChooser;
	public Filechoose() {
		fmanager = new FileManager();
	}
	public void SaveFile(){
		JFrame frame = new JFrame();
		fileChooser=new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");  
		FileNameExtensionFilter extFilter = new FileNameExtensionFilter("Class Graph files (*.cg)", "*.cg");
		fileChooser.setFileFilter(extFilter);
		int userSelection = fileChooser.showSaveDialog(frame);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
    			File fileToSave = fileChooser.getSelectedFile();
   			fmanager.SaveData(fileToSave.getAbsolutePath());
		}
	}
	public void ExportImg(JPanel panel){
		JFrame frame = new JFrame();
		fileChooser=new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");  
		FileNameExtensionFilter extFilter = new FileNameExtensionFilter("Image Files (*.png) (*.jpeg)", "*.png", "*.jpeg");
		fileChooser.setFileFilter(extFilter);
		int userSelection = fileChooser.showSaveDialog(frame);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
    			File fileToSave = fileChooser.getSelectedFile();
   			fmanager.ExportImage(fileToSave.getAbsolutePath(), panel);
		}
	}
	public void LoadFile(){
		JFrame frame = new JFrame();
		fileChooser=new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to open");  
		FileNameExtensionFilter extFilter = new FileNameExtensionFilter("Class Graph Files (*.cg)", "*.cg");
		fileChooser.setFileFilter(extFilter);
		int userSelection = fileChooser.showOpenDialog(frame);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
    			File fileToSave = fileChooser.getSelectedFile();
   			fmanager.LoadData(fileToSave.getAbsolutePath());
		}
	}
}
