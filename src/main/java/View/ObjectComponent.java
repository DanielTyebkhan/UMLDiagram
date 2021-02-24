package View;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;
import java.util.List;

import Document.ObjectClass;
import Document.Notable;
import View.Listeners.AddClassListener;
import View.ArrowDrawer;
import Document.Arrow;


public class ObjectComponent implements MouseListener {
	private static final int HEIGHT = 30;
	private static final int WIDTH  = 10;
	private ObjectClass obj;
	private JPanel panel;
	JPopupMenu rcmenu;
	JMenuItem newMethod;
	JMenuItem newVariable;

	public ObjectComponent(ObjectClass obj) {
	 	 this.obj = obj;
	 	 panel = new JPanel();
	 	 panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
	 	 JLabel name = new JLabel(obj.getName());
	 	 panel.add(name);
	 	 panel.add(new JLabel("obj.getName()"));
	 	 panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	 	 // panel.addMouseListener(new NewPanelListener());


	 	 rcmenu = new JPopupMenu();
	 	 newMethod = new JMenuItem("New Method");
	 	 newVariable = new JMenuItem("New Variable");
         newMethod.addMouseListener(new MethodAddListener(this));
         newVariable.addMouseListener(new VarAddListener(this));
         rcmenu.add(newMethod);
         rcmenu.add(newVariable);
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
	public void addVariable(String var) {
		obj.addInstanceVariable(new Notable(var));
	}
	public void removeVariable(String var) {
		obj.removeInstanceVariable(new Notable(var));
	}

	public void drawShape(JPanel reference, List<ArrowDrawer> arrows) {
		Dimension dimension = panel.getSize();
		System.out.println(dimension);
		for (Notable method : obj.getMethods()) {
			panel.add(new JLabel(method.getName()));
			for (ArrowDrawer arrow : arrows) {
				if ( arrow.getArrow().getFrom().equals(method)) {
				// arrow.setFromPosition(point);
				}
			}
		}
		for (Notable variable : obj.getInstanceVariables()) {
			panel.add(new JLabel(variable.getName()));
			for (ArrowDrawer arrow : arrows) {
				if ( arrow.getArrow().getFrom().equals(variable)) {
				// arrow.setFromPosition(point);
				}
			}
		}
		reference.add(panel);
		// reference.add(listScrollPane, BorderLayout.CENTER);

	}
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON3) {
			rcmenu.show(panel, e.getX(), e.getY());
		}
	}
	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}
	public void mousePressed(MouseEvent e) {

	}
	public void mouseReleased(MouseEvent e) {

	}
    class VarAddListener implements MouseListener {
        private ObjectComponent instance;
        JPopupMenu varMenu;
        JMenuItem varItem;
        
        public VarAddListener(ObjectComponent obj) {
            instance = obj;
        }

        public void mouseClicked(MouseEvent e)
        {
            String newVar = JOptionPane.showInputDialog(panel, "Enter new variable name");
            instance.addVariable(newVar);
        }
        public void mouseEntered(MouseEvent e)
        {

        }
        public void mouseExited(MouseEvent e)
        {

        }
        public void mousePressed(MouseEvent e)
        {

        }

        public void mouseReleased(MouseEvent e)
        {

        }
    }
    class MethodAddListener implements MouseListener {
        private ObjectComponent instance;
        JPopupMenu varMenu;
        JMenuItem varItem;
        
        public MethodAddListener(ObjectComponent obj) {
            instance = obj;
        }

        public void mouseClicked(MouseEvent e)
        {
            String newMethod = JOptionPane.showInputDialog(panel, "Enter new method name");
            instance.addMethod(newMethod);
        }
        public void mouseEntered(MouseEvent e)
        {

        }
        public void mouseExited(MouseEvent e)
        {

        }
        public void mousePressed(MouseEvent e)
        {

        }

        public void mouseReleased(MouseEvent e)
        {

        }
    }
}
