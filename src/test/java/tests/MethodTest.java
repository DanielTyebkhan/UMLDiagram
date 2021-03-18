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

}



