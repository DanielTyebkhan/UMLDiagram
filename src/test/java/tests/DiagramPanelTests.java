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

    private DiagramPanel diagram;
    private ObjectClass testObj;
    private Notable testNble;
    private Storage storage;

    @Mock
    private ObjectComponent mockObject;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        diagram = new DiagramPanel();
        testObj = new ObjectClass("test", new Point(0,0));
        
        mockObject = mock(ObjectComponent.class);
    }

    @Test
    public void testDiagramUpdate() {

        // ObjectComponent objComp = new ObjectComponent(mockDig, testObj);
        // storage = objComp.getDiagramPanel().getStorage();
        // assertEquals(storage, diagram.getStorage());

        // List<Arrow> list= storage.getArrows();
        DiagramPanel spyDig = spy(new DiagramPanel());
        // when(mockDig.getStorage()).thenReturn(storage);

        Storage storage = spyDig.getStorage();
        // assertEquals(storage, obtainedStorage);

        // mockDig.getStorage().addObject(testObj);
        // when(mockDig.getStorage()).thenCallRealMethod();
        // storage = mockDig.getStorage();
        // System.out.println(storage == null);
        storage.addObject(testObj);
        spyDig.update();
        verify(spyDig, verify(1)).repaint();
    }

}

