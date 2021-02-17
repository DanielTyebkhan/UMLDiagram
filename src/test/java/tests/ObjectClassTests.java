package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import Document.ObjectClass;

@RunWith(JUnit4.class)
public class ObjectClassTests {
    private ObjectClass testObj;

    @Before
    public void setUp() {
        testObj = new ObjectClass("test", new int[] {0, 1});
    }

    @Test
    public void getName() {
        assertEquals("Constructor should initialize name", testObj.getName(), "test");
    }
}


