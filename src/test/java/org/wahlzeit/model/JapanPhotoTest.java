/*
 * JapanPhoto
 *
 * Version 1.0
 *
 * 12.11.2017
 *
 * Copyright (c) 2107 by Kai Amann, https://github.com/kaiamann
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.model;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.Before;

public class JapanPhotoTest {

	JapanPhoto p1;
	@Before
	public void setUp() throws Exception {
		p1 = new JapanPhoto();	
	}
	
	@Test
	public void testGetPrefecture() {
		p1.setprefecture("Kanto");
		assertNotNull(p1.getPrefecture());;
		assertEquals(p1.getPrefecture(), "Kanto");

		p1.setprefecture("Okinawa");
		assertNotNull(p1.getPrefecture());;
		assertEquals(p1.getPrefecture(), "Okinawa");
	}
	
	@Test
	public void testGetPOI() {
		p1.setPOI("Kinkakuji");
		assertNotNull(p1.getPOI());;
		assertEquals(p1.getPOI(), "Kinkakuji");

		p1.setPOI("Inari Taisha");
		assertNotNull(p1.getPOI());;
		assertEquals(p1.getPOI(), "Inari Taisha");
	}

}
