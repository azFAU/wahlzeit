package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertSame;

/**
 * Test cases for the Japan class
 */
public class JapanTest {
    private JapanType superType;
    private Japan japan;

    @Before
    public void before() {
        superType = new JapanType("Super");
        japan = new Japan(superType);
    }

    @Test
    public void testBaseConstructor() {
        Japan japan = new Japan(superType);

        assertSame(superType, japan.getType());
    }
}