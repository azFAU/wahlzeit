package org.wahlzeit.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.lang.Math;

/*
 * This class specifies specific cartesian coordinates x, y, z
 */
public class CartesianCoordinate extends AbstractCoordinate {
	protected final double x;
	protected final double y;
	protected final double z;

	/*
	 * Constructor of coordinate object
	 * - No values given means all coordinates are set to 0
	 */
	public CartesianCoordinate () {
		x = 0;
		y = 0;
		z = 0;
	}

	/*
	 * Constructor of coordinate object with given coordinates
	 */
	public CartesianCoordinate (double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public static CartesianCoordinate getCartesianCoordinate(double x, double y, double z) {
		CartesianCoordinate newCoor = new CartesianCoordinate(x, y, z);
		CartesianCoordinate check;
		
		Iterator<AbstractCoordinate> coordinatesIterator = AbstractCoordinate.listOfCoordinates.iterator();
		while(coordinatesIterator.hasNext()) {
			check = coordinatesIterator.next().asCartesianCoordinate();
			if (newCoor.isEqual(check))
					return check;
		}

		AbstractCoordinate.listOfCoordinates.add(newCoor);
		return newCoor;
	}

	/**
	 * @methodtype get
	 */
	public double getXValue() {
		//Preconditions
		assertClassInvariants();
		
		return this.x;
	}	

	/**
	 * @methodtype get
	 */
	public double getYValue() {		
		//Preconditions
		assertClassInvariants();
		
		return this.y;
	}	

	/**
	 * @methodtype get
	 */
	public double getZValue() {
		//Preconditions
		assertClassInvariants();
		
		return this.z;
	}

	/**
	 * @methodtype set
	 */
	public CartesianCoordinate setXValue(double x) {		
		//Preconditions
		assertClassInvariants();
		
		CartesianCoordinate newCoor = new CartesianCoordinate(x, this.y, this.z);
		
		//Postconditions
		newCoor.assertClassInvariants();
		
		return newCoor;
	}	

	/**
	 * @methodtype set
	 */
	public CartesianCoordinate setYValue(double y) {
		//Preconditions
		assertClassInvariants();
		
		CartesianCoordinate newCoor = new CartesianCoordinate(this.x, y, this.z);
		
		//Postconditions
		newCoor.assertClassInvariants();
		
		return newCoor;
	}	

	/**
	 * @methodtype set
	 */
	public CartesianCoordinate setZValue(double z) {
		//Preconditions
		assertClassInvariants();
		
		CartesianCoordinate newCoor = new CartesianCoordinate(this.x, this.y, z);
		
		//Postconditions
		newCoor.assertClassInvariants();
		
		return newCoor;
	}

	/*
	 * Compares all 3 values of the two coordinate objects
	 * returns true if all values are the same
	 */
	public boolean isEqual(CartesianCoordinate coordinates) {
		return this.equals(coordinates);
	}

	public double calculatePythagorianTheorem() {
		//Preconditions
		assertClassInvariants();
		
		double distance = 0;

		distance = this.getXValue() * this.getXValue() + this.getYValue() * this.getYValue() + this.getZValue() * this.getZValue();
		distance = Math.sqrt(distance);
		
		//Preconditions
		assertClassInvariants();

		return distance;
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() throws IllegalCoordinateException {
		try {
			//Preconditions
			assertClassInvariants();
			assertNotNull(this);
			
			return this;
		} catch (IllegalCoordinateException e) {
			throw new IllegalCoordinateException("Error in asCartesianCoordinate", e.getInvalidClass(), e.getInvalidValue());
		}
	}

	@Override
	protected double doGetCartesianDistance(CartesianCoordinate coordinates) {
		try {
			double distance = 0;

			//Get distance between every single coordinate
			double distance_x = this.x - coordinates.getXValue();
			double distance_y = this.y - coordinates.getYValue();
			double distance_z = this.z - coordinates.getZValue();

			//Get distance through Pythagorean Theorem
			CartesianCoordinate distanceCoordinate = new CartesianCoordinate(distance_x, distance_y, distance_z);
			distance = distanceCoordinate.calculatePythagorianTheorem();
			
			return distance;
		} catch (IllegalCoordinateException e) {
			throw new IllegalCoordinateException("Error in doGetCartesianDistance", e.getInvalidClass(), e.getInvalidValue());
		}
	}

	@Override
	public SphericalCoordinate asSphericalCoordinate() throws IllegalCoordinateException {
		try {
			//Preconditions
			assertClassInvariants();
			assertNotNull(this);
	
			SphericalCoordinate spherCoor = doAsSphericalCoordinate();
			
			//Postconditions
			assertClassInvariants();
			
			return spherCoor;
		} catch (IllegalCoordinateException e) {
			throw new IllegalCoordinateException(" Error in asSphericalCoordinate", e.getInvalidClass(), e.getInvalidValue());
		}
	}
	
	protected SphericalCoordinate doAsSphericalCoordinate() {
		double radius = this.calculatePythagorianTheorem();
		double phi = Math.acos(this.getZValue() / radius);
		double theta = Math.atan(this.getYValue() / this.getXValue());

		SphericalCoordinate spherCoor = new SphericalCoordinate(phi, theta, radius);
		
		return spherCoor;
	}

	@Override
	public double doGetCentralAngle(ICoordinate coordinates) {

		double cartesianSubtraction = this.doGetCartesianDistance(coordinates.asCartesianCoordinate());
		double centralAngle = 2 * Math.asin(cartesianSubtraction / 2);

		return centralAngle;
	}

	@Override
	public boolean isEqual(ICoordinate coordinates) {
		//Preconditions
		assertClassInvariants();
		
		boolean equal = equals(coordinates.asCartesianCoordinate());
		
		//Postconditions
		assertClassInvariants();
		
		return equal;
	}

	@Override
	public int hashCode() {

		//Preconditions
		assertClassInvariants();
		
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		
		//Postonditions
		assertClassInvariants();
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartesianCoordinate other = (CartesianCoordinate) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}
	
	@Override
	protected void assertClassInvariants() {
		
		assertNotNull(this.x);
		assertNotNull(this.y);
		assertNotNull(this.z);
		
		
		if(Double.isNaN(this.x)) {
			throw new IllegalCoordinateException(" Error in assertClassInvariants", CartesianCoordinate.class.getName(), this.x);
		}
		if(Double.isNaN(this.y)) {
			throw new IllegalCoordinateException(" Error in assertClassInvariants", CartesianCoordinate.class.getName(), this.y);
		}
		if(Double.isNaN(this.z)) {
			throw new IllegalCoordinateException(" Error in assertClassInvariants", CartesianCoordinate.class.getName(), this.y);
		}
		
	}
}