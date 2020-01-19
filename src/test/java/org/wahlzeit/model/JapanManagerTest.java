package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JapanManagerTest {

	JapanManager manager;
	JapanType gifu;
	JapanType nagano;
	JapanType tokushima;
	
	@Before
	public void setUp() {
		manager =  JapanManager.getInstance();
	}

	@Test
	public void testGetInstance() {
		assertNotEquals(manager,null);
	}
	
}
