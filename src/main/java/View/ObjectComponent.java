package View;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import Document.ObjectClass;
import Document.Notable;

public class ObjectComponent extends JPanel {
	private static final int HEIGHT = 100;
	private static final int WIDTH  = 50;
	private ObjectClass obj;

	public ObjectComponent(ObjectClass obj) {
	 	 this.obj = obj;
	 }

	public void paintComponent(Graphics g) {
		Graphics2D box = (Graphics2D) g;
		drawShape(box);
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
		obj = null;
	}
	public void ObjectClassInstances() {

	}

	public void shapeType() {


	}
	public void drawShape(Graphics2D box) {
		box.drawRect(WIDTH*2, HEIGHT*2 , WIDTH, HEIGHT);
		box.setColor(Color.WHITE);
		box.drawString(obj.getName(), WIDTH-(1/2)*WIDTH, HEIGHT-(1/2)*WIDTH);
	}

}
