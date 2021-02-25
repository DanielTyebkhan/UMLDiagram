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

/**
 * Tests fo the ObjectClass class
 * @author Daniel Tyebkhan
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

    // @Test
    // public void addInstanceVariable() {
    //     Notable notable = new Notable("variable", "new");
    //     testObj.addInstanceVariable(notable);
    //     ObjectClass objClass = new ObjectClass("TestName", new Point(0,0));
    //     objClass.addInstanceVariable(notable);
    //     assertEquals("", testObj.getInstanceVariables(), objClass.getInstanceVariables());
    // }

    // @Test
    // public void removeInstanceVariable() {
    //     Notable notable = new Notable("variable", "new");
    //     testObj.addInstanceVariable(notable);
    //     testObj.removeInstanceVariable(notable);        
    //     assertTrue("", testObj.getInstanceVariables().isEmpty());
    // }

    // @Test
    // public void addStereotype() {
    //     Notable notable = new Notable("stereotype", "new");
    //     testObj.addStereotype(notable);
    //     ObjectClass objClass = new ObjectClass("TestName", new Point(0,0));
    //     objClass.addInstanceVariable(notable);
    //     assertEquals("", testObj.getInstanceVariables(), objClass.getInstanceVariables());
    // }

}


