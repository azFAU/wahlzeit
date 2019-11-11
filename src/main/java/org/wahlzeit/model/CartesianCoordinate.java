package org.wahlzeit.model;

import java.lang.Math;

/*
 * This class specifies specific cartesian coordinates x, y, z
 */
public class CartesianCoordinate implements ICoordinate {
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
		return this.x;
	}	
	
	/**
	 * @methodtype get
	 */
	public double getYValue() {
		return this.y;
	}	
	
	/**
	 * @methodtype get
	 */
	public double getZValue() {
		return this.z;
	}
	
	/**
	 * @methodtype set
	 */
	public void setXValue(double x) {
		this.x = x;
	}	
	
	/**
	 * @methodtype set
	 */
	public void setYValue(double y) {
		this.y = y;
	}	
	
	/**
	 * @methodtype set
	 */
	public void setZValue(double z) {
		this.z = z;
	}
	
	public double getCartesianDistance(ICoordinate coordinates) {
		CartesianCoordinate cartesianCoordinates = coordinates.asCartesianCoordinate();
		return doGetCartesianDistance(cartesianCoordinates);	
	}
	
	public double getCentralAngle(ICoordinate coordinates) {
		return doGetCentralAngle(coordinates);
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

		double distance = 0;
		
		//Get distance between every single coordinate
		double distance_x = this.x - coordinates.getXValue();
		double distance_y = this.y - coordinates.getYValue();
		double distance_z = this.z - coordinates.getZValue();
		
		//Get distance through Pythagorean Theorem
		CartesianCoordinate distanceCoordinate = new CartesianCoordinate(distance_x, distance_y, distance_z);
		distance = distanceCoordinate.calculatePythagorianTheorem();
		
		return distance;
	}
	
	public double calculatePythagorianTheorem() {
		double distance = 0;
		
		distance = this.getXValue() * this.getXValue() + this.getYValue() * this.getYValue() + this.getZValue() * this.getZValue();
		distance = Math.sqrt(distance);
		
		return distance;
	}
	
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}

	public double doGetCartesianDistance(CartesianCoordinate coordinates) {
		return getDistance(coordinates);
	}

	@Override
	public SphericalCoordinate asSphericalCoordinate() {
		
		double radius = this.calculatePythagorianTheorem();
		double phi = Math.acos(this.getZValue() / radius);
		double theta = Math.atan(this.getYValue() / this.getXValue());
		
		return new SphericalCoordinate(phi, theta, radius);
	}

	public double doGetCentralAngle(ICoordinate coordinates) {
		
		double cartesianSubtraction = this.doGetCartesianDistance(coordinates.asCartesianCoordinate());
		double centralAngle = 2 * Math.asin(cartesianSubtraction / 2);
		
		return centralAngle;
	}

	@Override
	public boolean isEqual(ICoordinate coordinates) {
		return equals(coordinates.asCartesianCoordinate());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
}
