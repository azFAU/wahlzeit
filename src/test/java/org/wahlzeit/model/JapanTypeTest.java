package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertSame;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class JapanTypeTest {
    private JapanType superType;
    private JapanType subOne;
    private JapanType subTwo;
    private JapanType subThree;
    private JapanType subFour;

    @Before
    public void before() {
        superType = new JapanType("Type1");
        subOne = new JapanType("Sub1");
        subTwo = new JapanType("Sub2");
        subThree = new JapanType("Sub3");
        subFour = new JapanType("Sub4");
    }

    @Test
    public void testBaseConstructor() {
        String type = "Prefecture";
        String prefecture = "Kanto";
        boolean isIsland = false;

        JapanType japanType = new JapanType(type, prefecture, isIsland);

        assertEquals(type, japanType.getName());
        assertEquals(prefecture, japanType.getPrefecture());
        assertEquals(isIsland, japanType.isIsland());
    }

    @Test
    public void testSuperTypeConstructor() {
        String type = "Prefecture";
        String prefecture = "Kanto";
        boolean isIsland = false;

        JapanType japanType = new JapanType(type, prefecture, isIsland);
        japanType.setSuperType(superType);

        assertEquals(superType, japanType.getSuperType());
    }

    @Test
    public void testHasSuperType() {
        JapanType japanType = new JapanType("Something");
        assertFalse(japanType.hasSuperType());

        japanType.setSuperType(superType);
        assertTrue(japanType.hasSuperType());
    }

    @Test
    public void testGetSubTypes() {
    	subOne.setSuperType(superType);
    	subTwo.setSuperType(superType);
    	subThree.setSuperType(superType);
    	subFour.setSuperType(subThree);
    	
        Set<JapanType> subTypes = superType.getSubTypes();

        assertEquals(3, subTypes.size());
        assertTrue(subTypes.contains(subOne));
        assertTrue(subTypes.contains(subTwo));
        assertTrue(subTypes.contains(subThree));
        assertFalse(subTypes.contains(subFour));
    }
}
