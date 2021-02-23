package View;


import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import Document.ObjectClass;

public class ObjectComponent extends JPanel {
	private static final int HEIGHT = 300;
	private static final int WIDTH  = 100;
	private ObjectClass obj;

	public ObjectComponent(ObjectClass obj) {
	 	 this.obj = obj;
	 }

	public void paintComponent(Graphics g) {
		drawShape()
	}
	/**
	* Adds a class name to the class diagram
	*/
	public void addName(String name) {
		obj.setName(name);
	}
	/**
	* Adds a method to the class diagram
	*/
	public void addMethod(String method) {
		obj.addMethod(method);
	}
	/**
	* Removes a method from the class diagram
	*/
	public void removeMethod(String method) {
	}
	public void ObjectClassInstances() {

	}

	public void shapeType() {


	}
	public void drawShape() {
		StringBuilder text = new StringBuilder();
        text.append(obj.getName() + "\n");
        for (Notable variable : obj.getInstanceVariables()) 
            text.append(variable.getName() + "\n");
        JTextArea current = new JTextArea(text.toString());
        current.setHorizontalAlignment(JTextField.CENTER);
        current.setBorder(lowered);
        current.setPreferredSize(new Dimension(300, 100));
	}
}