package Filemanagement;

import java.io.File; 
import java.io.IOException;
import java.lang.ClassNotFoundException;

import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Robot;

import Document.Storage;
import View.DiagramPanel;

/**
 * GUI for choosing files
 * @author Lawson Wheatley
 */
public class Filechoose{

	FileManager fmanager;
	JFileChooser fileChooser;

	/**
	* Constructor Method
	*/
	public Filechoose(DiagramPanel panel) {
		fmanager = new FileManager(panel);
	}

	/**
	* Saves a File
	*/
	public void SaveFile(){
		JFrame frame = new JFrame();
		fileChooser=new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");  
		FileNameExtensionFilter extFilter = new FileNameExtensionFilter("Class Graph Files (*.cg), JSon Files (*.json)", "*.cg","*.json");
		fileChooser.setFileFilter(extFilter);
		int userSelection = fileChooser.showSaveDialog(frame);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
    			File fileToSave = fileChooser.getSelectedFile();
   			fmanager.SaveData(fileToSave.getAbsolutePath());
		}
	}
	
	/**
	* Exports an Image from a JPanel
	* @param JPanel panel
	*/
	public void ExportImg(JPanel panel){
		JFrame frame = new JFrame();
		fileChooser=new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");  
		FileNameExtensionFilter extFilter = new FileNameExtensionFilter("Image Files (*.png), (*.jpeg), (*.webmp), (*.bmp), (*.gif)", "*.png", "*.jpeg", "*.webmp", "*.bmp", "*.gif");
		fileChooser.setFileFilter(extFilter);
		int userSelection = fileChooser.showSaveDialog(frame);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
    			File fileToSave = fileChooser.getSelectedFile();
   			fmanager.ExportImage(fileToSave.getAbsolutePath(), panel);
		}
	}

	/**
	* Loads a file to the program
	*/
	public void LoadFile(){
		JFrame frame = new JFrame();
		fileChooser=new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to open");  
		FileNameExtensionFilter extFilter = new FileNameExtensionFilter("Class Graph Files (*.cg), JSon Files (*.json)", "*.cg","*.json");
		fileChooser.setFileFilter(extFilter);
		int userSelection = fileChooser.showOpenDialog(frame);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
    			File fileToSave = fileChooser.getSelectedFile();
   			fmanager.LoadData(fileToSave.getAbsolutePath());
		}
	}

	/*
	* Exports Code Files
	*/
	public void exportCode(){
		JFrame frame = new JFrame();
		fileChooser=new JFileChooser();
		fileChooser.setDialogTitle("Specify a folder to save python files to");  
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int userSelection = fileChooser.showSaveDialog(frame);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
    			File fileToSave = fileChooser.getSelectedFile();
   			fmanager.exportCode(fileToSave.getAbsolutePath());
		}
	}
}
