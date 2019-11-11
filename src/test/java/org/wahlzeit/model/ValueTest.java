/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
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

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Test cases for a variety of value object classes.
 */
public class ValueTest {

	/**
	 *
	 */
	@Test
	public void testUserStatus() {
		assertTrue(UserStatus.CREATED == UserStatus.getFromInt(0));
		assertTrue(UserStatus.CONFIRMED == UserStatus.getFromInt(1));
		assertTrue(UserStatus.DISABLED == UserStatus.getFromInt(2));

		UserStatus us = UserStatus.CREATED;
		assertTrue(us.asInt() == 0);
		assertTrue(!us.isConfirmed());

		UserStatus us2 = us.asConfirmed();
		assertTrue(us != us2);
		assertTrue(us2.isConfirmed());

		UserStatus us3 = us2.asDisabled();
		assertTrue(us2 != us3);
		assertTrue(us3.isCreated());
		assertTrue(us3.isConfirmed());
		assertTrue(us3.isDisabled());

		UserStatus us4 = us.asDisabled();
		assertTrue(us4.isDisabled());
		assertTrue(us3 != us4);

		us3 = us3.asEnabled();
		assertTrue(us3.isConfirmed());
		assertTrue(!us3.isDisabled());

		us4 = us4.asEnabled();
		assertTrue(!us4.isConfirmed());
		assertTrue(!us4.isDisabled());

		us4 = us4.asConfirmed();
		assertTrue(us3 == us4);
	}

	/**
	 *
	 */
	@Test
	public void testPhotoStatus() {
		assert (PhotoStatus.VISIBLE == PhotoStatus.getFromInt(0));
		assert (PhotoStatus.INVISIBLE == PhotoStatus.getFromInt(1));
		assert (PhotoStatus.FLAGGED2 == PhotoStatus.getFromInt(3));
		assert (PhotoStatus.MODERATED == PhotoStatus.getFromInt(4));
		assert (PhotoStatus.MODERATED3 == PhotoStatus.getFromInt(6));

		PhotoStatus ps = PhotoStatus.VISIBLE;
		assert (ps.asInt() == 0);

		PhotoStatus ps2 = ps.asInvisible(true);
		assert (ps != ps2);
		assert (ps2.isInvisible());
		assert (!ps2.isFlagged());
		assert (!ps2.isModerated());
		assert (!ps2.isDisplayable());

		PhotoStatus ps3 = ps2.asFlagged(true);
		assert (ps2 != ps3);
		assert (ps3.isInvisible());
		assert (ps3.isFlagged());
		assert (!ps3.isModerated());
		assert (!ps3.isDisplayable());

		PhotoStatus ps3b = PhotoStatus.FLAGGED;
		assert (ps3 != ps3b);
		assert (!ps3b.isInvisible());
		assert (ps3.isFlagged());
		assert (!ps3.isModerated());
		assert (!ps3.isDisplayable());

		PhotoStatus ps2b = ps3b.asInvisible(true);
		assert (ps2b != ps3b);

		PhotoStatus ps4 = ps3.asModerated(true);
		assert (ps4.isInvisible());
		assert (ps4.isFlagged());
		assert (ps4.isModerated());
		assert (!ps4.isDisplayable());
	}

	/**
	 *
	 */
	@Test
	public void testObjectId() {
		PhotoId test = PhotoId.getNextId();

		int testInt = test.asInt();
		assert (test == PhotoId.getIdFromInt(testInt));

		String testString = test.asString();
		assert (test == PhotoId.getIdFromString(testString));
	}
	
	/**
	 * Checks distance between two points
	 */
	@Test
	public void testCartesianDistanceNotZero() {
		CartesianCoordinate coordinates = new CartesianCoordinate(1,1,1);
		Location locationOne = new Location(); //Coordinates are 0,0,0
		Location locationTwo = new Location(coordinates); //Coordinates are 1,1,1
	
		assert(locationOne.getCoordinate().getCartesianDistance(locationTwo.getCoordinate()) == Math.sqrt(3));
	}
	
	/**
	 * Checks distance between two points for distance = 0
	 */
	@Test
	public void testCartesianDistanceZero() {
		Location locationOne = new Location(); //Coordinates are 0,0,0
		Location locationTwo = new Location(); //Coordinates are 0,0,0
	
		assert(locationOne.getCoordinate().getCartesianDistance(locationTwo.getCoordinate()) == 0);
	}
	
	/**
	 * Checks distance isEqual for case: true
	 */
	@Test
	public void testIsEqualCartesianTrue() {
		CartesianCoordinate coordinates = new CartesianCoordinate(23,45,56);
		Location locationOne = new Location(coordinates); //Coordinates are 23,45,56
		Location locationTwo = new Location(coordinates); //Coordinates are 23,45,56
	
		assert(locationOne.getCoordinate().isEqual(locationTwo.getCoordinate()));
	}
	
	/**
	 * Checks distance isEqual for case: false
	 */
	@Test
	public void testIsEqualCartesianFalse() {
		CartesianCoordinate coordinatesOne = new CartesianCoordinate(23,45,56);
		CartesianCoordinate coordinatesTwo = new CartesianCoordinate(56,45,23);
		Location locationOne = new Location(coordinatesOne); //Coordinates are 23,45,56
		Location locationTwo = new Location(coordinatesTwo); //Coordinates are 56,45,23
	
		assert(!locationOne.getCoordinate().isEqual(locationTwo.getCoordinate()));
	}
	
	/**
	 * Checks distance between two points
	 */
	@Test
	public void testSphericalDistanceNotZero() {
		SphericalCoordinate coordinatesOne = new SphericalCoordinate(0, 0, 0);
		SphericalCoordinate coordinatesTwo = new SphericalCoordinate(0, 0, 0);
	
		assert(coordinatesOne.asCartesianCoordinate().getCartesianDistance(coordinatesTwo) == 0);
	}
	
	/**
	 * Checks distance between two points for distance = 0
	 */
	@Test
	public void testSphericalDistanceZero() {
		SphericalCoordinate coordinatesOne = new SphericalCoordinate(0, 0, 0);
		SphericalCoordinate coordinatesTwo = new SphericalCoordinate(0, 0, 0);
	
		assert(coordinatesOne.asCartesianCoordinate().getCartesianDistance(coordinatesTwo) == 0);
	}
	
	/**
	 * Checks distance isEqual for case: true
	 */
	@Test
	public void testIsEqualSphericalTrue() {
		SphericalCoordinate coordinatesOne = new SphericalCoordinate(0, 0, 0);
		SphericalCoordinate coordinatesTwo = new SphericalCoordinate(0, 0, 0);
	
		assert(coordinatesOne.isEqual(coordinatesTwo));
	}
	
	/**
	 * Checks distance isEqual for case: false
	 */
	@Test
	public void testIsEqualSphericalFalse() {
		SphericalCoordinate coordinatesOne = new SphericalCoordinate(0, 0, 0);
		SphericalCoordinate coordinatesTwo = new SphericalCoordinate(0, 1, 0);
	
		assert(!coordinatesOne.isEqual(coordinatesTwo));
	}
	
	/**
	 * Checks Conversion from Cartesian to Spherical
	 */
	@Test
	public void testCartesianSphericalConversion() {

		CartesianCoordinate coordinatesOne = new CartesianCoordinate(0,0,0);
		SphericalCoordinate coordinatesTwo = coordinatesOne.asSphericalCoordinate();
		assert(coordinatesTwo.isEqual(coordinatesOne));

		CartesianCoordinate coordinatesThree = new CartesianCoordinate(1,2,3);
		SphericalCoordinate coordinatesFour = coordinatesThree.asSphericalCoordinate();
		assert(coordinatesFour.isEqual(coordinatesThree));
	}
	
	/**
	 * Checks conversion from Spherical to Cartesian
	 */
	@Test
	public void testSphericalCartesianConversion() {

		SphericalCoordinate coordinatesOne = new SphericalCoordinate(0,0,0);
		CartesianCoordinate coordinatesTwo = coordinatesOne.asCartesianCoordinate();
		assert(coordinatesTwo.isEqual(coordinatesOne));

		SphericalCoordinate coordinatesThree = new SphericalCoordinate(4,5,6);
		CartesianCoordinate coordinatesFour = coordinatesThree.asCartesianCoordinate();
		assert(coordinatesFour.isEqual(coordinatesThree));
	}

	/**
	 * Checks distance converting from Cartesian to Spherical
	 */
	@Test
	public void testCartesianSphericalDistance() {
		SphericalCoordinate coordinatesOne = new SphericalCoordinate(0,0,0);
		CartesianCoordinate coordinatesTwo = new CartesianCoordinate(0,2,0);
		assert(coordinatesTwo.getCartesianDistance(coordinatesOne) == 2);
	}

	/**
	 * Checks distance converting from Spherical to Cartesian
	 */
	@Test
	public void testSphericalCartesianDistance() {
		SphericalCoordinate coordinatesOne = new SphericalCoordinate(0,0,1);
		CartesianCoordinate coordinatesTwo = new CartesianCoordinate(0,0,0);
		assert(coordinatesOne.getCartesianDistance(coordinatesTwo) == 1);
	}
}
