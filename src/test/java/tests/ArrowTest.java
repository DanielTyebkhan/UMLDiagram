package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import Document.Arrow;
import Document.ArrowType;
import Document.Notable;

/**
 * Tests fo the ObjectClass class
 * @author Sai Lyon Ho
 */
@RunWith(JUnit4.class)
public class ArrowTest {
    private Arrow testArrow;
    private ArrowType type;
    private Notable from;
    private Notable to;

    @Before
    public void setUp() {
        this.type = ArrowType.SUBTYPE;
        this.from = new Notable("Arrow1", "Note");
        this.to = new Notable("Arrow2", "Note");
        this.testArrow = new Arrow(type, from, to);
    }

    @Test
    public void getType() {
        assertEquals("Constructor should create subtype arrow", testArrow.getType(), ArrowType.SUBTYPE);
    }

    @Test
    public void getFrom() {
        Notable testFrom = new Notable("Arrow1", "Note");
        assertTrue("Constructor should create the arrow pointing from", 
            testArrow.getFrom().equals(testFrom));
    }

    @Test
    public void getTo() {
        Notable testTo = new Notable("Arrow2", "Note");
        assertTrue("Constructor should create the arrow pointing to", 
            testArrow.getTo().equals(testTo));
    }

    @Test 
    public void equalsFalse() {
        Arrow testDifferentArrow = new Arrow(ArrowType.SUBTYPE, 
            new Notable("Arrow3", "Note"), new Notable("Arrow4", "Note"));
        assertFalse("testArrow and testDifferentArrow SHOULD NOT BE equal", 
            testArrow.equals(testDifferentArrow));
    }
    
    @Test 
    public void equalsTrue() {
        Arrow testDifferentArrow = new Arrow(ArrowType.SUBTYPE, 
            new Notable("Arrow1", "Note"), new Notable("Arrow2", "Note"));
        assertTrue("testArrow and testDifferentArrow SHOULD BE equal", 
            testArrow.equals(testDifferentArrow));
    }


}


