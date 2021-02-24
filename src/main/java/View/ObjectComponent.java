package View;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;

import Document.ObjectClass;
import Document.Notable;
import View.Listeners.AddClassListener;


public class ObjectComponent implements ListSelectionListener{
	private static final int HEIGHT = 30;
	private static final int WIDTH  = 10;
	private ObjectClass obj;
	private JList list;
	private DefaultListModel listModel;
	private JScrollPane listScrollPane;
	JPopupMenu rcmenu;
	JMenuItem newMethod;
	JMenuItem newVariable;

	public ObjectComponent(ObjectClass obj) {
	 	 this.obj = obj;
	 	 rcmenu = new JPopupMenu();
	 	 newMethod = new JMenuItem("New Method");
	 	 newVariable = new JMenuItem("New Variable");
         // newMethod.addMouseListener(new AddClassListener());
         // newVariable.addMouseListener(new AddClassListener());
         rcmenu.add(newMethod);
         rcmenu.add(newVariable);
         listModel = new DefaultListModel();
         listModel.addElement(obj.getName());
         list = new JList(listModel);

         list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         list.setSelectedIndex(0);
         list.addListSelectionListener(new SharedListSelectionHandler());
         list.setVisibleRowCount(10);
         listScrollPane = new JScrollPane(list);
         list.addMouseListener(new MouseAdapter()
	     {
	        public void mousePressed(MouseEvent e)
	        {
	            if ( SwingUtilities.isRightMouseButton(e) )
	            {
	                rcmenu.show(list, e.getX(), e.getY());
	            }
	        }
	     }); 
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

	public void drawShape(JPanel panel) {
		for (Notable method : obj.getMethods()) {
			listModel.addElement(method.getName());
		}
		for (Notable variable : obj.getInstanceVariables()) {
			listModel.addElement(variable.getName());
		}
		list = new JList(listModel);
		panel.add(list);
		// reference.add(listScrollPane, BorderLayout.CENTER);

	}
	// public void mouseClicked(MouseEvent e) {
	// 	if(e.getButton() == MouseEvent.BUTTON3) {
	// 		rcmenu.show(list, e.getX(), e.getY());
	// 	}
	// }
	// public void mouseEntered(MouseEvent e) {

	// }

	// public void mouseExited(MouseEvent e) {

	// }
	// public void mousePressed(MouseEvent e) {

	// }
	// public void mouseReleased(MouseEvent e) {

	// }
	public void valueChanged(ListSelectionEvent e) {
			
		}
	class SharedListSelectionHandler implements ListSelectionListener { 
		public void valueChanged(ListSelectionEvent e) {

		}
	}
}
