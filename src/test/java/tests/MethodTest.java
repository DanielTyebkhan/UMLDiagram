package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;


import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import Document.Method;
import Document.Notable;

/**
 * Tests fo the Method class
 * @author Daniel Tyebkhan
 */
@RunWith(JUnit4.class)
public class MethodTest {
    private Method method; 
    @Before
    public void setUp() {
        method = new Method("testmethod");
    }

    @Test
    public void getName() {
        assertEquals("Method should use constructed name", "testmethod", method.getName());
    }

    @Test
    public void getParameters() {
        assertEquals("New method should have no parameters", new ArrayList<Notable>(), method.getParameters());
    }

    @Test
    public void addParameter() {
        Notable param = new Notable("param");
        Notable paramCompare = new Notable("param");
        ArrayList<Notable> expected = new ArrayList<Notable>(); 
        expected.add(paramCompare);
        method.addParameter(param);
        assertEquals("Adding parameter should add it", expected, method.getParameters());
    }

    @Test
    public void removeParameter() {
        Notable param = new Notable("param");
        Notable paramCompare = new Notable("param");
        method.addParameter(param);
        method.removeParameter(paramCompare);
        assertEquals("Adding parameter should add it", new ArrayList<Notable>(), method.getParameters());
    }
}



