package View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import Document.ObjectClass;

public class ObjectComponent extends JPanel {
	private static final int HEIGHT = 100;
	private static final int WIDTH  = 50;
	private ObjectClass obj;
	int[] position;

	public ObjectComponent(String name, int[] position) {
	 	 obj = new ObjectClass(name, position);
	 	 this.position = position;
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
		obj.addMethod(method);
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
		box.drawRect(position[0], position[1], WIDTH, HEIGHT);
		box.setColor(Color.WHITE);
	}

}