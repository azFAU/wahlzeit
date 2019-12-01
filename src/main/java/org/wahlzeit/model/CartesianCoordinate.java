package org.wahlzeit.model;

import java.lang.Math;

/*
 * This class specifies specific cartesian coordinates x, y, z
 */
public class CartesianCoordinate extends AbstractCoordinate {
	protected double x;
	protected double y;
	protected double z;

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
	public void setXValue(double x) {		
		//Preconditions
		assertClassInvariants();
		
		this.x = x;
	}	

	/**
	 * @methodtype set
	 */
	public void setYValue(double y) {
		//Preconditions
		assertClassInvariants();
		
		this.y = y;
	}	

	/**
	 * @methodtype set
	 */
	public void setZValue(double z) {
		//Preconditions
		assertClassInvariants();
		
		this.z = z;
	}

	/*
	 * Compares all 3 values of the two coordinate objects
	 * returns true if all values are the same
	 */
	public boolean isEqual(CartesianCoordinate coordinates) {
		return this.equals(coordinates);
	}

	/*
	 * Gets distance between two coordinate objects
	 */
	public double getDistance(CartesianCoordinate coordinates) {
		//Preconditions
		assertClassInvariants();
		assertNotNull(coordinates);

		double distance = 0;

		//Get distance between every single coordinate
		double distance_x = this.x - coordinates.getXValue();
		double distance_y = this.y - coordinates.getYValue();
		double distance_z = this.z - coordinates.getZValue();

		//Get distance through Pythagorean Theorem
		CartesianCoordinate distanceCoordinate = new CartesianCoordinate(distance_x, distance_y, distance_z);
		distance = distanceCoordinate.calculatePythagorianTheorem();
		

		//Postconditions
		assertClassInvariants();

		return distance;
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
	public CartesianCoordinate asCartesianCoordinate() {
		//Preconditions
		assertClassInvariants();
		assertNotNull(this);
		
		return this;
	}

	@Override
	public double doGetCartesianDistance(CartesianCoordinate coordinates) {
		return getDistance(coordinates);
	}

	@Override
	public SphericalCoordinate asSphericalCoordinate() {
		//Preconditions
		assertClassInvariants();
		assertNotNull(this);

		double radius = this.calculatePythagorianTheorem();
		double phi = Math.acos(this.getZValue() / radius);
		double theta = Math.atan(this.getYValue() / this.getXValue());

		SphericalCoordinate spherCoor = new SphericalCoordinate(phi, theta, radius);
		
		//Postconditions
		assertClassInvariants();
		
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
			throw new IllegalStateException("y is NaN!");
		}
		if(Double.isNaN(this.y)) {
			throw new IllegalStateException("y is NaN!");
		}
		if(Double.isNaN(this.z)) {
			throw new IllegalStateException("z is NaN!");
		}
		
	}
}