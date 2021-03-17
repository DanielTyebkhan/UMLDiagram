package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.MockitoAnnotations;

import java.util.List;

import java.awt.Point;
import javax.swing.JPanel;
import Document.ObjectClass;
import Document.Notable;
import View.DiagramPanel;
import View.ObjectComponent;
import View.Arrows.ArrowDrawer;


/**
 * Tests for the Diagram Panel class
 * @author Anhad Gande
 */

public class DiagramPanelTests {

    private DiagramPanel diagram;
    private ObjectClass testObj;
    private ObjectClass testObj2;
    private Notable testNble;

    @Mock
    private ObjectComponent mockObject;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        diagram = new DiagramPanel();
        testObj = new ObjectClass("test", new Point(0,0));
        mockObject = new ObjectComponent(diagram, testObj);
    }

    @Test
    public void tryTests() {
        JPanel panel = new JPanel();
        List<ArrowDrawer> list= new List<>(); 
        verify(mockObject, times(1).drawShape(panel, list));
    }

}

