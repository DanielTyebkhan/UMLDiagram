package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.ArrayList;

import java.awt.Point;
import java.awt.Graphics;
import javax.swing.JPanel;
import Document.ObjectClass;
import Document.Notable;
import Document.Arrow;
import View.DiagramPanel;
import View.ObjectComponent;
import View.Arrows.ArrowDrawer;
import Document.Storage;


/**
 * Tests for the Diagram Panel class
 * @author Anhad Gande
 */

public class DiagramPanelTests {

    private ObjectClass testObj;
    private Notable testNble;
    private Storage storage;
    private DiagramPanel spyDig;

    // @Mock
    // private ObjectComponent mockObject;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        testObj = new ObjectClass("test", new Point(0,0));
        spyDig = spy(new DiagramPanel());
        
        // mockObject = mock(ObjectComponent.class);
    }

    @Test
    public void testDiagramUpdate() {
        DiagramPanel spyDig = spy(new DiagramPanel());
        spyDig.update();
        verify(spyDig, times(1)).repaint();
    }

    @Test
    public void testDiagramNoUpdate() {
        DiagramPanel spyDig = spy(new DiagramPanel());
        verify(spyDig, times(0)).repaint();
    }

    @Test
    public void testDiagramAddObject() {
        // ObjectComponent objComp = new ObjectComponent(mockDig, testObj);
        // storage = objComp.getDiagramPanel().getStorage();
        // assertEquals(storage, diagram.getStorage());

        // List<Arrow> list= storage.getArrows();
        DiagramPanel spyDig = spy(new DiagramPanel());
        // when(mockDig.getStorage()).thenReturn(storage);

        // assertEquals(storage, obtainedStorage);

        // mockDig.getStorage().addObject(testObj);
        // when(mockDig.getStorage()).thenCallRealMethod();
        // storage = mockDig.getStorage();
        // System.out.println(storage == null);
        // when(spyDig.getStorage()).thenCallRealMethod();
        Storage storage = spy(spyDig.getStorage());
        storage.addObject(testObj);
        
        verify(storage, times(1)).notifyObservers();

        //NOTE: I have tried veryfing if update is called
        //when I do spyDig.getStorage().addObject(testObj)
        //however, the spy stops tracking it then.
        //Update indeed gets called yet the spy doens't track it.
        //This is possibly because spyDig.getStorage() returns a new object.
        //Hence, I also spy on the storage object and verify if it notifies
        //observers which in turn updates DiagramPanel.
    }

    @Test
    public void testUpdateWithObjectComponent() {

        ObjectComponent objComp = new ObjectComponent(spyDig, testObj);
        // Creating an ObjectComponent does not repaint DiagramPanel
        verify(spyDig, times(0)).repaint();
    }

}

