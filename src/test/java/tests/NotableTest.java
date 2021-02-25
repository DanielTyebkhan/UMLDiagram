package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import Document.Notable;

/**
 * Tests fo the Notable class
 * @author Sai Lyon Ho
 */
@RunWith(JUnit4.class)
public class NotableTest {
    private Notable notable; 
    @Before
    public void setUp() {
        this.notable = new Notable("Arrow1", "Note");
    }

    @Test
    public void getName() {
        assertEquals("Name should be a string: Arrow1", 
            notable.getName(), "Arrow1");
    }

    @Test
    public void getNote() {
        assertEquals("Note should be a string: Note", 
            notable.getNote(), "Note");
    }


    @Test
    public void setName() {
        notable.setName("Arrow2");
        assertEquals("Notable should be changed to string: Arrow2", 
            notable.getName(), "Arrow2");
    }

    @Test
    public void setNote() {
        notable.setNote("note changed");
        assertEquals("Changed note to string: note changed", 
            notable.getNote(), "note changed");
    }

    @Test 
    public void equals() {
        Notable notable2 = new Notable("Arrow1", "Note");
        assertTrue("Objects should contain the same name and note", 
            notable.equals(notable2));
    }
}


