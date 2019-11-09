package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JapanPhotoFactoryTest {
	
	JapanPhotoFactory instance;
	@Before
	public void setUp() {
		instance =  JapanPhotoFactory.getInstance();
	}

	@Test
	public void testGetInstance() {
		assertNotEquals(instance,null);
	}

	@Test(expected = IllegalStateException.class)
	public void testDoubleInstantiation() {
		JapanPhotoFactory.setInstance(new JapanPhotoFactory());
	}

	@Test
	public void testCreatePhoto() {
		assertNotEquals(instance.createPhoto(),null);
	}
	
	@Test
	public void testCreatePhoto2() {
		PhotoId id = new PhotoId(1337);
		Photo expected = new JapanPhoto(id);
		Photo got = instance.createPhoto(id);
		assertTrue(expected.getId().isEqual(got.getId()));
	}

}
