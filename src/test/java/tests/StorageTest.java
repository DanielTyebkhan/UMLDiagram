package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.awt.Point;
import Document.ObjectClass;
import Document.Notable;
import Document.Arrow;
import Document.Storage;
import Document.ArrowType;
import General.Observer;

/**
 * Tests for the Storage class
 * @author Daniel Tyebkhan 
 */
@RunWith(JUnit4.class)
public class StorageTest {
    private ObjectClass testObj;
    private ObjectClass testObj2;
    private Arrow testArr;
    private Notable testNble;

    private void addAll() {
        testObj.addMethod(testNble);
        Storage.instance.addObject(testObj);
        Storage.instance.addObject(testObj2);
        Storage.instance.addArrow(testArr);
    }

    @Before
    public void setUp() {
        testObj = new ObjectClass("object", new Point(0,0));
        testObj2 = new ObjectClass("object2", new Point(0,0));
        testNble = new Notable("notable");
        testArr = new Arrow(ArrowType.CONTAINMENT, testObj, testNble);
        Storage.instance.clear();
    }
    
    @Test
    public void addArrow() {
        addAll();
        assertTrue("Adding arrow adds it to storage", Storage.instance.getArrows().contains(testArr));
    }

    @Test 
    public void addObject() {
        addAll();
        assertTrue("Adding object adds it to storage", Storage.instance.getObjects().contains(testObj));
    }

    @Test
    public void removeArrow() {
        addAll();
        Storage.instance.removeArrow(testArr);
        assertFalse("Removing an arrow removes it from storage", Storage.instance.getArrows().contains(testArr));
    }

    @Test
    public void removeObject() {
        addAll();
        Storage.instance.removeObject(testObj);
        assertFalse("Removing an object removes it from storage", Storage.instance.getObjects().contains(testObj));
        assertFalse("Removing an object removes associated arrows", Storage.instance.getArrows().contains(testArr));
    }
    
}


