package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.awt.Point;
import Document.ObjectClass;
import Document.Notable;
import General.Observer;

/**
 * Tests fo the ObjectClass class
 * @author Daniel Tyebkhan and Sai Lyon Ho
 */
@RunWith(JUnit4.class)
public class ObjectClassTests {
    private ObjectClass testObj;

    @Before
    public void setUp() {
        testObj = new ObjectClass("test", new Point(0,0));
    }

    @Test
    public void getName() {
        assertEquals("Constructor should initialize name", testObj.getName(), "test");
    }

    @Test
    public void addChild() {
        ObjectClass child = new ObjectClass("child", new Point(0,0));
        testObj.addChild(new ObjectClass("child", new Point(0,0)));
        assertTrue("Adding a child should add it", testObj.getChildren().contains(child));
    }

    @Test
    public void setName() {
        testObj.setName("TestName");
        assertEquals("Setting name should change name", "TestName", testObj.getName());
    }

    @Test
    public void addInstanceVariable() {
        Notable notable = new Notable("variable", "new");
        testObj.addInstanceVariable(notable);
        ObjectClass objClass = new ObjectClass("TestName", new Point(0,0));
        objClass.addInstanceVariable(notable);
        assertEquals("", testObj.getInstanceVariables(), objClass.getInstanceVariables());
    }

    @Test
    public void removeInstanceVariable() {
        Notable notable = new Notable("variable", "new");
        testObj.addInstanceVariable(notable);
        testObj.removeInstanceVariable(notable);        
        assertTrue("", testObj.getInstanceVariables().isEmpty());
    }

    @Test
    public void addStereotype() {
        Notable notable = new Notable("stereotype", "new");
        testObj.addStereotype(notable);
        ObjectClass objClass = new ObjectClass("TestName", new Point(0,0));
        objClass.addStereotype(notable);
        assertEquals("", testObj.getStereotypes(), objClass.getStereotypes());
    }

    @Test
    public void removeStereotype() {
        Notable notable = new Notable("variable", "new");
        testObj.addStereotype(notable);
        testObj.removeStereotype(notable);        
        assertTrue("", testObj.getStereotypes().isEmpty());
    }

    @Test
    public void addMethod() {
        Notable notable = new Notable("method", "new");
        testObj.addMethod(notable);
        ObjectClass objClass = new ObjectClass("TestName", new Point(0,0));
        objClass.addMethod(notable);
        assertEquals("", testObj.getMethods(), objClass.getMethods());
    }

    @Test
    public void removeMethod() {
        Notable notable = new Notable("variable", "new");
        testObj.addMethod(notable);
        testObj.removeMethod(notable);        
        assertTrue("", testObj.getMethods().isEmpty());
    }

    @Test
    public void equals() {
        Notable notable = new Notable("method", "new");
        testObj.addMethod(notable);
        ObjectClass objClass = new ObjectClass("test", new Point(0,0));
        objClass.addMethod(notable);
        assertTrue("", testObj.equals(objClass));
    }
}


