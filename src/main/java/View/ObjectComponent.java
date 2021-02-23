package View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import Document.ObjectClass;
import Document.Notable;


public class ObjectComponent extends JComponent{
	private static final int HEIGHT = 30;
	private static final int WIDTH  = 10;
	private ObjectClass obj;

	public ObjectComponent(ObjectClass obj) {
	 	 this.obj = obj;
	 }

	public void paintComponent(Graphics g) {
		drawShape();
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
		obj.addMethod(new Notable(method));
	}
	/**
	* Removes a method from the class diagram
	*/
	public void removeMethod(String method) {
		obj.removeMethod(new Notable(method));
	}

	public void drawShape() {
		StringBuilder text = new StringBuilder();
        text.append(obj.getName() + "\n");
        for (Notable methods : obj.getMethods()) 
            text.append(methods.getName() + "()\n");
        for (Notable variable : obj.getInstanceVariables())
            text.append(variable.getName() + "\n");
        // Border border = BorderFactory.createLineBorder(Color.BLACK);
        JTextArea current = new JTextArea(text.toString());
        // current.setBorder(BorderFactory.createCompoundBorder(border, 
        // 	BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        // current.addMouseListener(new VarAddListener(obj));
	}
}
